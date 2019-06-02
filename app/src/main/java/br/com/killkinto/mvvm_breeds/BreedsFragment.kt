package br.com.killkinto.mvvm_breeds

import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.killkinto.mvvm_breeds.breeds.BreedsAdapter
import br.com.killkinto.mvvm_breeds.breeds.BreedsViewModel
import br.com.killkinto.mvvm_breeds.databinding.BreedsFragmentBinding

class BreedsFragment : Fragment() {

    //val vm: BreedsViewModel by viewModel()

    lateinit var viewModel: BreedsViewModel

    companion object {
        fun newInstance(viewModel: BreedsViewModel): BreedsFragment {
            val fragment = BreedsFragment()
            fragment.viewModel = viewModel
            return fragment
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.load()
    }

    override fun onCreateView(@NonNull inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : BreedsFragmentBinding = BreedsFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.recyclerView.adapter = BreedsAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        return binding.root
    }
}