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

// Arquivo provisório para salvar as cartas
// Adicione as cartas geradas aqui conforme o modelo, o ID será sempre o próximo ao dar carta anterior
// Liberdade total para nome
// Atributos de 0 a 10000
object allCards {

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
            id = 0,
            name = "Arkilon, o goblin",
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
            rarity = Rarity.NORMAL
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
        )
    )
}
