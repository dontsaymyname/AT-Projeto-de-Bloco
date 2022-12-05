package com.pinheiro.michael.assessmentprojetodebloco.ui.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import coil.load
import com.pinheiro.michael.assessmentprojetodebloco.R
import com.pinheiro.michael.assessmentprojetodebloco.databinding.ActivityInGameBinding
import com.pinheiro.michael.assessmentprojetodebloco.databinding.ItemCardBinding
import com.pinheiro.michael.assessmentprojetodebloco.service.CardModel
import com.pinheiro.michael.assessmentprojetodebloco.service.Rarity
import kotlin.random.Random

class InGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInGameBinding
    private lateinit var playerCards: List<CardModel>
    private lateinit var enemyCards: List<CardModel>
    private var playerScore = 0
    private var enemyScore = 0
    private var cardIndex = 0
    private var isPlayerRound = false
    private var resultDetail = ""
    private var isControlGame = false
    private var currentMatchResult = MatchResults.DRAW

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        isPlayerRound = Random.nextBoolean()

        playerCards = listOf(
            CardModel(
                id = 0,
                name = "Arkilon",
                sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
                atk = 5000,
                def = 4500,
                magic = 1500,
                rarity = Rarity.LEGENDARY
            ),
            CardModel(
                id = 1,
                name = "Grungkin",
                sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
                atk = 3000,
                def = 2000,
                magic = 1500,
                rarity = Rarity.RARE
            ),
            CardModel(
                id = 0,
                name = "Arkilon, o goblin",
                sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
                atk = 5000,
                def = 4500,
                magic = 1500,
                rarity = Rarity.LEGENDARY
            ),
            CardModel(
                id = 0,
                name = "Arkilon, o goblin",
                sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
                atk = 4000,
                def = 5500,
                magic = 2500,
                rarity = Rarity.NORMAL
            ),
            CardModel(
                id = 1,
                name = "Grungkin",
                sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
                atk = 2000,
                def = 1000,
                magic = 3500,
                rarity = Rarity.NORMAL
            ),
            CardModel(
                id = 0,
                name = "Arkilon, o goblin",
                sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
                atk = 6000,
                def = 3500,
                magic = 2500,
                rarity = Rarity.RARE
            ),
            CardModel(
                id = 1,
                name = "Grungkin",
                sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
                atk = 3000,
                def = 2000,
                magic = 1500,
                rarity = Rarity.LEGENDARY
            )
        )

        enemyCards = listOf(
            CardModel(
                id = 0,
                name = "Arkilon, o goblin",
                sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
                atk = 4000,
                def = 5500,
                magic = 2500,
                rarity = Rarity.RARE
            ),
            CardModel(
                id = 1,
                name = "Grungkin",
                sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
                atk = 2000,
                def = 1000,
                magic = 3500,
                rarity = Rarity.NORMAL
            ),
            CardModel(
                id = 0,
                name = "Arkilon, o goblin",
                sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
                atk = 6000,
                def = 3500,
                magic = 2500,
                rarity = Rarity.LEGENDARY
            ),
            CardModel(
                id = 0,
                name = "Arkilon, o goblin",
                sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
                atk = 5000,
                def = 4500,
                magic = 1500,
                rarity = Rarity.RARE
            ),
            CardModel(
                id = 1,
                name = "Grungkin",
                sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
                atk = 3000,
                def = 2000,
                magic = 1500,
                rarity = Rarity.NORMAL
            ),
            CardModel(
                id = 0,
                name = "Arkilon, o goblin",
                sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
                atk = 5000,
                def = 4500,
                magic = 1500,
                rarity = Rarity.LEGENDARY
            ),
            CardModel(
                id = 0,
                name = "Arkilon, o goblin",
                sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
                atk = 5000,
                def = 4500,
                magic = 1500,
                rarity = Rarity.LEGENDARY
            )
        )

        binding.btnContinue.setOnClickListener { controlGame() }
        binding.layoutResult.btnIngameResultBack.setOnClickListener { finish() }
        setupCardsRound()

    }

    private fun controlGame(){
        if(!isControlGame){
            isControlGame = true
            with(binding.layoutFight){
                tvPlayerAttribute.isVisible = false
                tvEnemyAttribute.isVisible = false
                tvVsText.text = when(currentMatchResult){
                    MatchResults.WIN -> "Round Vencido"
                    MatchResults.DEFEAT -> "Round Perdido"
                    MatchResults.DRAW -> "Round Empatado"
                }
            }
        } else {
            if(cardIndex < 7){
                setupCardsRound()
            } else {
                showResult()
            }
        }

    }

    private fun showResult() {
        binding.layoutFight.root.isVisible = false
        binding.btnContinue.isVisible = false
        with(binding.layoutResult){
            root.isVisible = true
            tvIngameResultDetails.text = resultDetail
            tvIngameResultText.text = "$playerScore X $enemyScore"
            tvResultTitle.text = if(playerScore > enemyScore){
                "Você venceu"
            } else if(playerScore < enemyScore){
                "Você perdeu"
            } else {
                "Empate"
            }
        }

    }

    private fun setupCardsRound(){

        val playerCard = playerCards[cardIndex]
        val enemyCard = enemyCards[cardIndex]
        isControlGame = false

        binding.layoutFight.root.isVisible = true
        binding.layoutFight.cardPlayer.populateCard(playerCard)
        binding.layoutFight.cardEnemy.populateCard(enemyCard)

        if(isPlayerRound){
            definePlayerRound(playerCard, enemyCard)
        } else {
           defineEnemyRound(playerCard, enemyCard)
            binding.btnContinue.isVisible = true
        }

        isPlayerRound = !isPlayerRound
        cardIndex++

    }

    private fun definePlayerRound(playerCard: CardModel, enemyCard: CardModel){
        binding.layoutFight.root.isVisible = false
        binding.btnContinue.isVisible = false
        setPlayerChoice(playerCard, enemyCard)
    }

    private fun defineEnemyRound(playerCard: CardModel, enemyCard: CardModel) {
        val enemyAttribute = setEnemyAttribute()
        val atttributeText = when(enemyAttribute){
            CardAttributes.ATK -> "ATK"
            CardAttributes.DEF -> "DEF"
            CardAttributes.MAGIC -> "MAGIC"
        }
        binding.layoutFight.tvEscolhaAtributo.text = "Oponente escolheu\n$atttributeText"
        setFight(enemyAttribute, playerCard, enemyCard)
    }

    private fun updateScore(results: MatchResults){
        when (results){
            MatchResults.WIN -> playerScore++
            MatchResults.DEFEAT -> enemyScore ++
            MatchResults.DRAW -> playerScore += 0
        }
        currentMatchResult = results
        binding.btnContinue.isVisible = true
    }

    private fun setEnemyAttribute(): CardAttributes{
        val random = (1..3).random()
        return when(random){
            1 -> CardAttributes.ATK
            2 -> CardAttributes.DEF
            else -> CardAttributes.MAGIC
        }
    }

    private fun setPlayerChoice(playerCard: CardModel, enemyCard: CardModel) {
        with(binding.layoutAttributeChoice) {
            root.isVisible = true
            cardPlayer.populateCard(playerCard)
            btnChoiceAttack.setOnClickListener { setFight(CardAttributes.ATK, playerCard, enemyCard)
                binding.layoutFight.tvEscolhaAtributo.text = "Você escolheu\nATK"}
            btnChoiceDef.setOnClickListener { setFight(CardAttributes.DEF, playerCard, enemyCard)
                binding.layoutFight.tvEscolhaAtributo.text = "Você escolheu\nDEF"}
            btnChoiceMag.setOnClickListener { setFight(CardAttributes.MAGIC, playerCard, enemyCard)
                binding.layoutFight.tvEscolhaAtributo.text = "Você escolheu\nMAGIC"}
        }
    }

    private fun ItemCardBinding.populateCard(cardModel: CardModel) {
        this.tvName.text = cardModel.name
        this.tvAttack.text = cardModel.atk.toString()
        this.tvDef.text = cardModel.def.toString()
        this.tvMagic.text = cardModel.magic.toString()
        this.imgSprite.load(cardModel.sprite)
        this.containerCard.setBackgroundResource(when(cardModel.rarity){
            Rarity.NORMAL -> R.drawable.card_normal
            Rarity.RARE -> R.drawable.card_rare
            Rarity.LEGENDARY -> R.drawable.card_legendary
        })
    }


    private fun setFight(attribute: CardAttributes, playerCard: CardModel, enemyCard: CardModel) {
       val result = when(attribute){
            CardAttributes.ATK -> calculateResult(playerCard.atk, enemyCard.atk)
            CardAttributes.DEF -> calculateResult(playerCard.def, enemyCard.def)
            CardAttributes.MAGIC -> calculateResult(playerCard.magic, enemyCard.magic)
        }
        updateScore(result)
        resultDetail += "${complementDetailText(true)}  ${playerCard.name}   x   ${enemyCard.name}  ${complementDetailText(false)}\n"
        if(binding.layoutAttributeChoice.root.isVisible){
            binding.layoutAttributeChoice.root.isVisible = false
            binding.layoutFight.root.isVisible = true
        }
    }

    private fun complementDetailText(isPlayerCard: Boolean): String{
        return when (currentMatchResult) {
            MatchResults.WIN -> if(isPlayerCard) "1" else "0"
            MatchResults.DEFEAT -> if(isPlayerCard) "0" else "1"
            MatchResults.DRAW -> "0"
        }
    }

    private fun calculateResult(playerValue: Int, enemyValue: Int): MatchResults {

        with(binding.layoutFight){
            tvPlayerAttribute.isVisible = true
            tvPlayerAttribute.text = playerValue.toString()
            tvEnemyAttribute.isVisible = true
            tvEnemyAttribute.text = enemyValue.toString()
            tvVsText.text = "X"
        }


        return if (playerValue > enemyValue) {
            MatchResults.WIN
        } else if (playerValue < enemyValue) {
            MatchResults.DEFEAT
        } else {
            MatchResults.DRAW
        }
    }

}

enum class MatchResults {
    WIN,
    DEFEAT,
    DRAW
}

enum class CardAttributes {
    ATK,
    DEF,
    MAGIC
}