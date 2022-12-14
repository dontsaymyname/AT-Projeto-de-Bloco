package com.pinheiro.michael.assessmentprojetodebloco.ui.profile

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.decode.ImageSource
import coil.load
import com.google.firebase.auth.UserProfileChangeRequest
import com.pinheiro.michael.assessmentprojetodebloco.R
import com.pinheiro.michael.assessmentprojetodebloco.databinding.FragmentProfileBinding
import com.pinheiro.michael.assessmentprojetodebloco.fragment_ext.toastFrag
import com.pinheiro.michael.assessmentprojetodebloco.loginrepository.LoginRepository
import com.pinheiro.michael.assessmentprojetodebloco.loginrepository.LoginRepository.Companion.auth
import com.pinheiro.michael.assessmentprojetodebloco.service.CardModel
import com.pinheiro.michael.assessmentprojetodebloco.service.findCards
import com.pinheiro.michael.assessmentprojetodebloco.ui.catalog.CardListener
import com.pinheiro.michael.assessmentprojetodebloco.ui.catalog.CatalogAdapter
import com.pinheiro.michael.assessmentprojetodebloco.ui.login.LoginActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class ProfileFragment : Fragment() {

    private lateinit var repository: LoginRepository

    private lateinit var dialog: AlertDialog

    private lateinit var profilePickUri: Uri

    companion object {
        private val PERMISSAO_GALERIA = android.Manifest.permission.READ_EXTERNAL_STORAGE
    }

    private val requestGaleria =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { permissao ->
            if (permissao) {
                resultGaleria.launch(
                    Intent(
                        Intent.ACTION_OPEN_DOCUMENT,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                    )
                )
            } else {
                showDialogPermissao()
            }
        }

    private val resultGaleria =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            profilePickUri = result.data?.data!!

            val bitmap: Bitmap = if (Build.VERSION.SDK_INT < 28) {
                MediaStore.Images.Media.getBitmap(
                    context?.contentResolver,
                    result.data?.data
                )
            } else {
                val source = ImageDecoder.createSource(
                    requireContext().contentResolver,
                    result.data?.data!!
                )
                ImageDecoder.decodeBitmap(source)
            }
            binding.cardProfileId.profileImage.setImageBitmap(bitmap)
        }

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CatalogAdapter
    private val viewModel by viewModels<ProfileViewModel>()
    var newDeck = mutableSetOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        repository = LoginRepository.get()

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        adapter = CatalogAdapter(object : CardListener {
            override fun clickVisualizar(card: CardModel, item: View) {
                if (binding.cardDeckEditr.root.isVisible) {
                    if (newDeck.size < 7) {
                        newDeck.add(card.id)
                        item.alpha = 0.5f
                    }
                }
            }
        })

        val playerDeck = viewModel.retrieveDeck()

        setupViews()
        atualizaRecyclerView(playerDeck, binding.recyclerDeck)

        setupClickListeners()

        return binding.root
    }

    private fun verificaPermissao(permissao: String) =
        context?.let {
            ContextCompat.checkSelfPermission(
                it,
                permissao
            )
        } == PackageManager.PERMISSION_GRANTED

    private fun verificaPermissaoGaleria() {
        val permissaoGaleriaAceita = verificaPermissao(PERMISSAO_GALERIA)

        when {
            permissaoGaleriaAceita -> {
                resultGaleria.launch(
                    Intent(
                        Intent.ACTION_OPEN_DOCUMENT,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                    )
                )
            }

            shouldShowRequestPermissionRationale(PERMISSAO_GALERIA) -> showDialogPermissao()

            else -> requestGaleria.launch(PERMISSAO_GALERIA)
        }
    }

    private fun showDialogPermissao() {
        val builder = AlertDialog.Builder(context)
            .setTitle("Atenção")
            .setMessage("Precisamos do acesso a galeria do dispositivo, deseja permitir agora?")
            .setNegativeButton("Não") { _, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("Sim") { _, _ ->
                val intent = Intent(
                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.fromParts("package", context?.packageName, null)
                )
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                dialog.dismiss()
            }
        dialog = builder.create()
        dialog.show()
    }

    private fun setupClickListeners() {
        binding.apply {
            btnLogout.setOnClickListener {
                repository.logout()
                startLoginActivity()
            }

            btnEdit.setOnClickListener {
                cardProfileId.root.isVisible = true
            }

            cardProfileId.btnConfirmar.setOnClickListener {
                updateProfile()
                cardProfileId.root.isVisible = false
            }

            cardProfileId.btnCancelar.setOnClickListener {
                cardProfileId.root.isVisible = false
            }

            cardProfileId.profileImage.setOnClickListener {
                verificaPermissaoGaleria()
            }
        }
    }

    private fun updateProfile() {
        auth.currentUser?.let { user ->
            val username = binding.cardProfileId.inputName.text.toString()

            val photoURI = profilePickUri
            val profileUpdates = UserProfileChangeRequest.Builder()
                .setDisplayName(username)
                .setPhotoUri(photoURI)
                .build()

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    user.updateProfile(profileUpdates).await()
                    withContext(Dispatchers.Main) {
                        setupViews()
                        toastFrag("Perfil atualizado com sucesso")
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun startLoginActivity() {
        startActivity(Intent(context, LoginActivity::class.java))
        activity?.finish()
    }

    private fun setupViews() {
        binding.recyclerDeck.layoutManager = GridLayoutManager(
            requireContext(),
            2
        )

        binding.fabEdit.setOnClickListener {
            openEditor()
        }

        val user = auth.currentUser
        if (user != null) {
            binding.tvEmail.text = viewModel.retrieveUserInfo().email
            binding.tvName.text = user.displayName
            if (user.photoUrl != null) {
                binding.profileImage.load(uriToPath(requireContext(), user.photoUrl))
            }
        }
    }

    private fun openEditor() {

        viewModel.updateCards()

        with(binding.cardDeckEditr) {
            recyclerDeckEditor.layoutManager = GridLayoutManager(
                requireContext(),
                2
            )
            root.isVisible = true
            tvFinalizar.setOnClickListener {
                finishEdition()
            }
            tvResetar.setOnClickListener {

            }
            btnCancelar.setOnClickListener {
                root.isVisible = false
                atualizaRecyclerView(
                    viewModel.retrieveDeck(),
                    binding.recyclerDeck
                )
            }

            atualizaRecyclerView(
                viewModel.cards.value!!,
                recyclerDeckEditor
            )
        }
    }

    private fun finishEdition() {
        if (newDeck.size == 7) {
            viewModel.updateDeck(newDeck.toList())
            binding.cardDeckEditr.root.isVisible = false
            atualizaRecyclerView(newDeck.toList().findCards(), binding.recyclerDeck)
        } else {
            Toast.makeText(requireContext(), "Escolha 7 cartas", Toast.LENGTH_SHORT).show()
        }
    }

    fun atualizaRecyclerView(lista: List<CardModel>, recyclerView: RecyclerView) {
        adapter.submitList(lista)
        recyclerView.adapter = adapter
    }

    fun uriToPath(context: Context, uri: Uri?): String? {
        var filePath = ""
        val wholeID = DocumentsContract.getDocumentId(uri)

        val id = wholeID.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
        val column = arrayOf(MediaStore.Images.Media.DATA)

        val sel = MediaStore.Images.Media._ID + "=?"
        val cursor: Cursor = context.contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            column, sel, arrayOf(id), null
        )!!
        val columnIndex: Int = cursor.getColumnIndex(column[0])
        if (cursor.moveToFirst()) {
            filePath = cursor.getString(columnIndex)
        }
        cursor.close()
        return filePath
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}