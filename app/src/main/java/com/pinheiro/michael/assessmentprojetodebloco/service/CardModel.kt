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

    )
}
