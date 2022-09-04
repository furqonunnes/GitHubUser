package com.dicoding.githubuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubuser.databinding.ItemUserBinding

class ListUserAdapter(private val ListUser: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    // Menampilkan tampilan tiap item
    class ListViewHolder(var binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    // BINDING
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (photo, username, name) = ListUser[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemUsername.text = username
        holder.binding.tvItemName.text = name

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(ListUser[holder.adapterPosition])
        }

    }

    override fun getItemCount(): Int  = ListUser.size

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}