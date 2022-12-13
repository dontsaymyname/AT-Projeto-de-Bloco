package com.pinheiro.michael.assessmentprojetodebloco.ui.chests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import coil.transform.CircleCropTransformation
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.pinheiro.michael.assessmentprojetodebloco.databinding.FragmentChestsBinding
import com.pinheiro.michael.assessmentprojetodebloco.service.populateCard
import com.pinheiro.michael.assessmentprojetodebloco.service.toCard
import com.pinheiro.michael.assessmentprojetodebloco.ui.game.GameViewModel

class ChestsFragment : Fragment() {

    private var _binding: FragmentChestsBinding? = null
    private val binding get() = _binding!!
    private var mRewardedAd: RewardedAd? = null
    private val viewModel by viewModels<ChestsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentChestsBinding.inflate(inflater, container, false)

        loadAd()

        setAddEvents()

        binding.btnOpenAdd.setOnClickListener {
            if (mRewardedAd != null) {
                mRewardedAd?.show(requireActivity(), OnUserEarnedRewardListener { rewardItem ->
                    Toast.makeText(requireContext(), "Recompensou", Toast.LENGTH_SHORT).show()
                    viewModel.addNewCart()
                    with(binding.layoutGift) {
                        root.isVisible = true
                        cardGift.populateCard(viewModel.newCardId.toCard())
                        btnCardGiftFechar.setOnClickListener {
                            root.isVisible = false
                            viewModel.clearNewCard()
                            loadAd()
                        }
                    }
                })
                binding.tvAdLoad.isVisible = false
            } else {
                binding.tvAdLoad.isVisible = true
            }
        }


        return binding.root
    }

    private fun loadAd(){
        RewardedAd.load(
            requireContext(),
            "ca-app-pub-3940256099942544/5224354917",
            AdRequest.Builder().build(),
            object : RewardedAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    mRewardedAd = null
                }

                override fun onAdLoaded(rewardedAd: RewardedAd) {
                    mRewardedAd = rewardedAd
                }
            })
    }

    private fun setAddEvents() {
        mRewardedAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdClicked() {
                Toast.makeText(requireContext(), "AdClicked", Toast.LENGTH_SHORT).show()
            }

            override fun onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                // Set the ad reference to null so you don't show the ad a second time.
                Toast.makeText(requireContext(), "AdDismissed", Toast.LENGTH_SHORT).show()
                mRewardedAd = null
            }

            override fun onAdImpression() {
                // Called when an impression is recorded for an ad.
                Toast.makeText(requireContext(), "AdImpression", Toast.LENGTH_SHORT).show()
            }

            override fun onAdShowedFullScreenContent() {
                // Called when ad is shown.
                Toast.makeText(requireContext(), "AdShowedFullScreen", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}