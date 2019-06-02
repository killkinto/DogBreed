package br.com.killkinto.mvvm_breeds

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.killkinto.mvvm_breeds.breeds.BreedsViewModel
import br.com.killkinto.mvvm_breeds.data.BreedRepository
import br.com.killkinto.mvvm_breeds.remote.DogCeoApi
import br.com.killkinto.mvvm_breeds.remote.DogCeoDataSource
import kotlinx.android.synthetic.main.breeds_activity.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BreedsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.breeds_activity)
        addFragmentTo(R.id.content_frame, createFragment())
        //setSupportActionBar(toolbar)
    }

    fun createViewModel() : BreedsViewModel {
        val retrofit = Retrofit.Builder().baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val dogCeoDataSource = DogCeoDataSource(retrofit.create(DogCeoApi::class.java))
        val repository = BreedRepository(dogCeoDataSource)
        return BreedsViewModel(repository, applicationContext)
    }

    fun createFragment(): BreedsFragment {
        return BreedsFragment.newInstance(createViewModel())
    }
}
