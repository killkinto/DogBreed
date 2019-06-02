package br.com.killkinto.mvvm_breeds.breeds

import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import br.com.killkinto.mvvm_breeds.R
import br.com.killkinto.mvvm_breeds.data.Breed
import br.com.killkinto.mvvm_breeds.data.BreedDataSource

class BreedsViewModel(val repository: BreedDataSource, val context: Context) {
    val breeds = ObservableArrayList<Breed>()
    val loadingVisibility = ObservableBoolean(false)
    val message = ObservableField<String>()

    fun load() {
        loadingVisibility.set(true)
        message.set("")
        repository.listAll({ items ->
            breeds.clear()
            breeds.addAll(items)
            if (items.isEmpty()) {
                message.set(context.getString(R.string.breed_empty))
            }
            loadingVisibility.set(false)
        }, {
            message.set(context.getString(R.string.breed_failed))
            loadingVisibility.set(false)
        })
    }
 }