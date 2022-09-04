package com.dicoding.githubuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListUserAdapter(private val ListUser: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    // Menampilkan tampilan tiap item
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_username)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
//        val tvLocation: TextView = itemView.findViewById(R.id.tv_location)
//        val tvRepository: TextView = itemView.findViewById(R.id.tv_repository)
//        val tvCompany: TextView = itemView.findViewById(R.id.tv_company)
//        val tvFollowers: TextView = itemView.findViewById(R.id.tv_followers)
//        val tvFollowing: TextView = itemView.findViewById(R.id.tv_following)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (photo, username, name, location, repository, company, followers, following) = ListUser[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvUsername.text = username
        holder.tvName.text = name
//        holder.tvLocation.text = location
//        holder.tvRepository.text = repository
//        holder.tvCompany.text = company
//        holder.tvFollowers.text = followers
//        holder.tvFollowing.text = following



        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(ListUser[holder.adapterPosition])
        }

    }

    override fun getItemCount(): Int  = ListUser.size

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}