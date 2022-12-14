package com.pinheiro.michael.assessmentprojetodebloco.service

import coil.load
import com.pinheiro.michael.assessmentprojetodebloco.R
import com.pinheiro.michael.assessmentprojetodebloco.databinding.ItemCardBinding

data class CardModel(
    val id: Int,
    val name: String,
    val sprite: String,
    val atk: Int,
    val def: Int,
    val magic: Int,
    val rarity: Rarity
)

enum class Rarity {
    NORMAL,
    RARE,
    LEGENDARY
}

fun List<Int>.findCards(): List<CardModel>{
    val deck = mutableListOf<CardModel>()
    this.forEachIndexed { _, id ->
        deck.add(AllCards.cardsList[id])
    }
    return deck
}

fun Int.toCard() = AllCards.cardsList[this]

fun ItemCardBinding.populateCard(cardModel: CardModel) {
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

// Arquivo provisório para salvar as cartas
// Adicione as cartas geradas aqui conforme o modelo, o ID será sempre o próximo ao dar carta anterior
// Liberdade total para nome
// Atributos de 0 a 10000
object AllCards {

    val cardsList = listOf(
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
            id = 2,
            name = "Arkilon, o goblin",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 5000,
            def = 4500,
            magic = 1500,
            rarity = Rarity.LEGENDARY
        ),
        CardModel(
            id = 3,
            name = "Grungkin",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 3000,
            def = 2000,
            magic = 1500,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 4,
            name = "Arkilon, o goblin",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 5000,
            def = 4500,
            magic = 1500,
            rarity = Rarity.RARE
        ),
        CardModel(
            id = 5,
            name = "Grungkin",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 3000,
            def = 2000,
            magic = 1500,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 6,
            name = "Arkilon, o goblin",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 5000,
            def = 4500,
            magic = 1500,
            rarity = Rarity.RARE
        ),
        CardModel(
            id = 7,
            name = "Grungkin",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 3000,
            def = 2000,
            magic = 1500,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 8,
            name = "Earth Nighthawk",
            sprite = "https://cdn.midjourney.com/ae6e0161-2b87-4d69-b546-307f4404fbc7/grid_0.png",
            atk= 4000,
            def = 2300,
            magic = 1600,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 9,
            name = "Mulonsauda",
            sprite = "https://cdn.midjourney.com/4d41be84-93b8-4ae1-a493-bc9a48158e2e/grid_0.png",
            atk= 2000,
            def = 2300,
            magic = 3600,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 10,
            name = "Skevern",
            sprite = "https://cdn.midjourney.com/b5baf2f4-0843-48c3-84e7-694932838f8a/grid_0.png",
            atk= 7000,
            def = 3300,
            magic = 5600,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 11,
            name = "Skeleton",
            sprite = "https://cdn.midjourney.com/5efcf410-0208-47e6-9e2d-5c2bd8e81335/grid_0.png",
            atk= 1000,
            def = 2300,
            magic = 1600,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 12,
            name = "Braacorn",
            sprite = "https://cdn.midjourney.com/f419734a-cd46-4006-b786-67ad2f33844a/grid_0.png",
            atk= 1000,
            def = 2300,
            magic = 4600,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 13,
            name = "Hrateops",
            sprite = "https://cdn.midjourney.com/b368e3e2-7d1a-468f-88fc-1da04f6267a0/grid_0.png",
            atk= 6700,
            def = 4300,
            magic = 4600,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 14,
            name = "Galno",
            sprite = "https://cdn.midjourney.com/04bbc7cd-a8ea-4731-af55-1b54c0f1fada/grid_0.png",
            atk= 2700,
            def = 3300,
            magic = 4600,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 15,
            name = "ArnoldBeast",
            sprite = "https://cdn.midjourney.com/42e74e00-97f2-40aa-8087-45aaa663a064/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 16,
            name = "Chidrad",
            sprite = "https://cdn.midjourney.com/cb390089-7f65-463e-9639-ad4bc67a0e97/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 17,
            name = "Ciesnbi",
            sprite = "https://cdn.midjourney.com/5ea7e0e7-3f84-4d67-b095-79cbafdf7a2e/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 18,
            name = "The Agile Shadow Cobra",
            sprite = "https://cdn.midjourney.com/621c469a-9306-4cf5-bdae-8ab654db2903/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 19,
            name = "The Titanic Rot Hawk",
            sprite = "https://cdn.midjourney.com/61dc4116-2387-4ba6-a888-f705e6fa323f/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 20,
            name = "The Ugly Charmer",
            sprite = "https://cdn.midjourney.com/aafaf273-f6a1-4039-bbd5-eaa57fa9af79/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 21,
            name = "Crainara",
            sprite = "https://cdn.midjourney.com/082c659d-d164-4a61-be18-6d816626a778/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 22,
            name = "Vushui Kobe",
            sprite = "https://cdn.midjourney.com/d64caa52-7972-4874-8426-1eac5be21be6/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 23,
            name = "The Giant",
            sprite = "https://cdn.midjourney.com/39dc3ea4-bd41-44fd-bb6a-71f9b1b00e9b/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 24,
            name = "Terrorhag",
            sprite = "https://cdn.midjourney.com/17229aac-50c9-4cde-8f2e-175517b917bf/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 25,
            name = "Optimus Player",
            sprite = "https://cdn.midjourney.com/79e22140-a421-4110-8405-dd5db7967736/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 26,
            name = "Smokeling",
            sprite = "https://cdn.midjourney.com/3991b664-637c-4d68-b2fc-3a0ae59b5edd/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 27,
            name = "String Storm",
            sprite = "https://cdn.midjourney.com/9841ff3b-20d7-4744-a0cd-606cb2b2dd23/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 28,
            name = "The Mean Critter",
            sprite = "https://cdn.midjourney.com/bc005cd5-7b82-4bc7-8b58-7d470fab6c0a/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 29,
            name = "Terrorhag",
            sprite = "https://cdn.midjourney.com/17229aac-50c9-4cde-8f2e-175517b917bf/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 30,
            name = "Spitesword",
            sprite = "https://cdn.midjourney.com/5b0b40bb-59ac-42e6-beb7-19cf220b7533/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 31,
            name = "The Politician",
            sprite = "https://cdn.midjourney.com/0df1d446-d676-4629-b554-e984d834ff68/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 32,
            name = "Murkwoman",
            sprite = "https://cdn.midjourney.com/0c6da92a-bd70-479f-90a1-abbe40026f6f/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 33,
            name = "Haunthood",
            sprite = "https://cdn.midjourney.com/56d55740-b2dd-4d35-9aeb-ee522c1af24b/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 34,
            name = "Big Nacho",
            sprite = "https://cdn.midjourney.com/901fb31f-371e-45bf-93c1-bbb6d4ee1bc5/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 35,
            name = "The nun",
            sprite = "https://cdn.midjourney.com/2b88259d-dab5-489d-8dc1-6b7fa6017de5/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 36,
            name = "Webhound",
            sprite = "https://cdn.midjourney.com/11c618a7-7dfe-4b19-bacd-d0200c9fb0d4/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 37,
            name = "Stonebug",
            sprite = "https://cdn.midjourney.com/19a880fc-11c0-4c7a-b512-92fd679e8e57/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 38,
            name = "Grieveserpent",
            sprite = "https://cdn.midjourney.com/223e4081-43e8-4b77-b25e-789365310e92/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 39,
            name = "Mournstep",
            sprite = "https://cdn.midjourney.com/17cac2ba-013d-4dd2-aa14-2bcf1cf52be6/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 40,
            name = "The mustahce elf",
            sprite = "https://cdn.midjourney.com/ed599328-0b50-4ac6-aad7-8d8fa7173a93/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 41,
            name = "John",
            sprite = "https://cdn.midjourney.com/6ff1bb23-61aa-483a-8f8c-14daeb5fff25/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 42,
            name = "Invisible Wizard",
            sprite = "https://cdn.midjourney.com/e995751f-02bd-42f3-a02a-919696ed69ee/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 43,
            name = "Cloudsword",
            sprite = "https://cdn.midjourney.com/7f729c06-8c2d-4bf0-a357-a37db4520540/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 44,
            name = "Putridsnare",
            sprite = "https://cdn.midjourney.com/5edb53e2-fecb-431a-8c59-5b664175a2c5/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 45,
            name = "Rotserpent",
            sprite = "https://cdn.midjourney.com/d9f6cddc-548a-4d1a-a377-1f77f0db0ed5/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 46,
            name = "Vaporsoul",
            sprite = "https://cdn.midjourney.com/21d9fa0a-6b5a-4a9f-a1be-81761e8fe52e/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 47,
            name = "Stenchchild",
            sprite = "https://cdn.midjourney.com/db830cc5-fc3e-4b8a-bb97-0f1922e08bc8/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 48,
            name = "Steamgirl",
            sprite = "https://cdn.midjourney.com/96818b97-da53-48cc-a0f9-017b4e7f6d3c/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 49,
            name = "Coolk",
            sprite = "https://cdn.midjourney.com/2b41cda1-ca3b-4929-b1bd-6e602ee4ef83/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 50,
            name = "Glowthing",
            sprite = "https://cdn.midjourney.com/319b9036-045c-47d0-a4e0-82490a7d5ef5/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 51,
            name = "RedSamba",
            sprite = "https://cdn.midjourney.com/2c62d9e0-51dc-49a8-8c3d-bd46fc96359d/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 52,
            name = "Smokeseeker",
            sprite = "https://cdn.midjourney.com/b2e214f9-08b8-4b4e-a2cf-87177f5bec38/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 53,
            name = "Chaoswings",
            sprite = "https://cdn.midjourney.com/e392694c-10fc-416a-bcdb-37a3c59d5a55/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 54,
            name = "Stoneclaw",
            sprite = "https://cdn.midjourney.com/27f59e9c-e66f-4c49-aa5e-4f281c3a045d/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 55,
            name = "Glowbug",
            sprite = "https://cdn.midjourney.com/46785450-29ae-43ac-a9a5-798e03a933e9/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 56,
            name = "Chaoshand",
            sprite = "https://cdn.midjourney.com/1f7d64a6-5ab0-4054-ae0b-939ef9c4bb71/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 57,
            name = "Dustboy",
            sprite = "https://cdn.midjourney.com/6cd8ea77-5845-4225-ab55-dc7cf01fdb0f/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 58,
            name = "Grimedeviation",
            sprite = "https://cdn.midjourney.com/49a65928-10e4-4d9a-9506-81900b2a96f7/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 59,
            name = "Warpfigure",
            sprite = "https://cdn.midjourney.com/5109e63f-954c-4776-9dde-ff3bf49116fc/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 60,
            name = "Mistcat",
            sprite = "https://cdn.midjourney.com/44f1f8e7-34c1-4a55-8553-c1a109339066/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 61,
            name = "Hellfang",
            sprite = "https://cdn.midjourney.com/10215c13-23c1-4075-a7ef-c713adef298b/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 62,
            name = "Terrorhag",
            sprite = "https://cdn.midjourney.com/17229aac-50c9-4cde-8f2e-175517b917bf/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 63,
            name = "Dart on the beach",
            sprite = "https://cdn.midjourney.com/b791ad38-ccf1-410e-a30c-77f8494bac63/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.RARE
        ),
        CardModel(
            id = 64,
            name = "DartSmart",
            sprite = "https://cdn.midjourney.com/f4794f9d-52f4-4a3c-b30a-c2991490ee9e/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.RARE
        ),
        CardModel(
            id = 65,
            name = "Dart fat",
            sprite = "https://cdn.midjourney.com/e5ca84ec-6f9b-4efe-ba14-470697afe180/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.RARE
        ),
        CardModel(
            id = 66,
            name = "DartNerd",
            sprite = "https://cdn.midjourney.com/c17ae127-934e-44a0-9244-48f9b1b84ec9/grid_0.png",
            atk= 8700,
            def = 3300,
            magic = 100,
            rarity = Rarity.RARE
        ),
        CardModel(
            id = 67,
            name = "DartPhone",
            sprite = "https://cdn.midjourney.com/70e5716a-5c8f-40c7-a04f-ae29b3d43e7c/grid_0.png",
            atk= 9000,
            def = 8000,
            magic = 7000,
            rarity = Rarity.RARE
        ),
        CardModel(
            id = 68,
            name = "dartBeer",
            sprite = "https://cdn.midjourney.com/b236574b-79f3-4fea-8e26-83be79bbfc8b/grid_0.png",
            atk= 8700,
            def = 8300,
            magic = 500,
            rarity = Rarity.RARE
        ),
        CardModel(
            id = 69,
            name = "DartFun",
            sprite = "https://cdn.midjourney.com/21dbb5ac-25d8-46ca-a5a1-07ed7cc774fa/grid_0.png",
            atk= 8700,
            def = 6300,
            magic = 100,
            rarity = Rarity.RARE
        ),
        CardModel(
            id = 70,
            name = "DartDancing",
            sprite = "https://cdn.midjourney.com/4077e71b-c2aa-458d-bada-3800de0d3b29/grid_0.png",
            atk= 8900,
            def = 8300,
            magic = 100,
            rarity = Rarity.RARE
        ),

    )
}
