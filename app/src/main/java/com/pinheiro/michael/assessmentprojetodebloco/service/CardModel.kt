package com.pinheiro.michael.assessmentprojetodebloco.service

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

// Arquivo provisório para salvar as cartas
// Adicione as cartas geradas aqui conforme o modelo, o ID será sempre o próximo ao dar carta anterior
// Liberdade total para nome
// Atributos de 0 a 10000
object AllCards {

    val cardsList = listOf(
        CardModel(
            id = 0,
            name = "Carta ID 0",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 5000,
            def = 4500,
            magic = 1500,
            rarity = Rarity.RARE
        ),
        CardModel(
            id = 1,
            name = "Carta ID 1",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 3000,
            def = 2000,
            magic = 1500,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 2,
            name = "Carta ID 2",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 5000,
            def = 4500,
            magic = 1500,
            rarity = Rarity.LEGENDARY
        ),
        CardModel(
            id = 3,
            name = "Carta ID 3",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 3000,
            def = 2000,
            magic = 1500,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 4,
            name = "Carta ID 4",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 5000,
            def = 4500,
            magic = 1500,
            rarity = Rarity.RARE
        ),
        CardModel(
            id = 5,
            name = "Carta ID 5",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 3000,
            def = 2000,
            magic = 1500,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 6,
            name = "Carta ID 6",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 5000,
            def = 4500,
            magic = 1500,
            rarity = Rarity.RARE
        ),
        CardModel(
            id = 7,
            name = "Carta ID 7",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 3000,
            def = 2000,
            magic = 1500,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 8,
            name = "Carta ID 8",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 3000,
            def = 2000,
            magic = 1500,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 9,
            name = "Carta ID 9",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 3000,
            def = 2000,
            magic = 1500,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 10,
            name = "Carta ID 10",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 3000,
            def = 2000,
            magic = 1500,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 11,
            name = "Carta ID 11",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 3000,
            def = 2000,
            magic = 1500,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 12,
            name = "Carta ID 12",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 3000,
            def = 2000,
            magic = 1500,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 13,
            name = "Carta ID 13",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 3000,
            def = 2000,
            magic = 1500,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 14,
            name = "Carta ID 14",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 3000,
            def = 2000,
            magic = 1500,
            rarity = Rarity.NORMAL
        ),
        CardModel(
            id = 15,
            name = "Carta ID 15",
            sprite = "https://cdn.midjourney.com/cd533c59-6bdd-44b4-b86f-56e5367753e9/grid_0.png",
            atk = 3000,
            def = 2000,
            magic = 1500,
            rarity = Rarity.NORMAL
        ),
    )
}
