package br.com.killkinto.mvvm_breeds.breeds

import android.app.Application
import android.arch.lifecycle.*
import br.com.killkinto.mvvm_breeds.R
import br.com.killkinto.mvvm_breeds.data.Breed
import br.com.killkinto.mvvm_breeds.data.BreedDataSource

class BreedsViewModel(private val repository: BreedDataSource, application: Application) :
    AndroidViewModel(application), LifecycleObserver {

    val breeds = MutableLiveData<List<Breed>>().apply { value = emptyList() }
    val loadingVisibility = MutableLiveData<Boolean>().apply { value = false }
    val message = MutableLiveData<String>().apply { value = "" }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun load() {
        loadingVisibility.postValue(true)
        message.postValue("")
        repository.listAll({ items ->
            breeds.postValue(items)
            if (items.isEmpty()) {
                message.postValue(getApplication<Application>().getString(R.string.breed_empty))
            }
            loadingVisibility.postValue(false)
        }, {
            message.postValue(getApplication<Application>().getString(R.string.breed_failed))
            loadingVisibility.postValue(false)
        })
    }
 }