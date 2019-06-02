package br.com.killkinto.mvvm_breeds

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.killkinto.mvvm_breeds.breeds.BreedsViewModel
import br.com.killkinto.mvvm_breeds.data.BreedDataSource
import java.lang.IllegalArgumentException

class BreedsViewModelFactory constructor(private val repository: BreedDataSource,
                                         private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            with(modelClass) {
                when {
                    isAssignableFrom(BreedsViewModel::class.java) -> BreedsViewModel(
                        repository,
                        application
                    )
                    else -> throw IllegalArgumentException("Class desconhecida")
                }
            } as T
}