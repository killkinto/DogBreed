package br.com.killkinto.mvvm_breeds

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class BreedsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.breeds_activity)
        addFragmentTo(R.id.content_frame, createFragment())
        //setSupportActionBar(toolbar)
    }

    fun createFragment(): BreedsFragment {
        return BreedsFragment.newInstance()
    }
}
