package br.com.killkinto.mvvm_breeds.data.local

import br.com.killkinto.mvvm_breeds.data.Breed
import br.com.killkinto.mvvm_breeds.data.BreedDataSource
import br.com.killkinto.mvvm_breeds.util.AppExecutors

class DogCeoLocalDataSource(private val dao: BreedDao, private val appExecutors: AppExecutors) : BreedDataSource {

    override fun listAll(success: (List<Breed>) -> Unit, failure: () -> Unit) {
        appExecutors.roomThreadExecutor.execute {
            val breeds = dao.getAll()
            appExecutors.mainThreadExecutor.execute { success(breeds)}
        }
    }

    override fun save(breed: Breed) {
        appExecutors.roomThreadExecutor.execute {
            dao.insertAll(breed)
        }
    }
}