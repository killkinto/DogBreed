package br.com.killkinto.mvvm_breeds.breeds

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater

import android.view.ViewGroup
import br.com.killkinto.mvvm_breeds.data.Breed
import br.com.killkinto.mvvm_breeds.databinding.BreedItemBinding
class BreedsAdapter(var items: List<Breed>) : RecyclerView.Adapter<BreedsAdapter.ViewHolder>(), AdapterItemsContract {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: BreedItemBinding = BreedItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    @Suppress("UNCHECKED_CAST")
    override fun replaceItems(list: List<*>) {
        this.items = list as List<Breed>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }


    class ViewHolder(private val binding: BreedItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(breed: Breed) {
            binding.breed = breed
            binding.executePendingBindings()
        }
    }
}