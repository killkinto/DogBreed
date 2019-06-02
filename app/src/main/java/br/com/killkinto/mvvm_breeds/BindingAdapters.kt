package br.com.killkinto.mvvm_breeds

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import br.com.killkinto.mvvm_breeds.breeds.AdapterItemsContract

class BindingAdapters {
    companion object {
        @BindingAdapter("items")
        @JvmStatic
        fun setItems(recyclerView: RecyclerView, list: List<Any>) {
            recyclerView.adapter.let {
                if (it is AdapterItemsContract) {
                    it.replaceItems(list)
                }
            }
        }
    }
}