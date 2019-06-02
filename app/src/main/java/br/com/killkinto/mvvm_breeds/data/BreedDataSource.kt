package br.com.killkinto.mvvm_breeds.data

interface BreedDataSource {
    fun listAll(success: (List<Breed>) -> Unit, failure: () -> Unit)

    fun save(breed: Breed)
}