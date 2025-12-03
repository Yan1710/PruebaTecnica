package com.example.pruebatecnica.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatecnica.R
import com.example.pruebatecnica.data.model.Post

class MainAdapter : ListAdapter<Post, MainAdapter.UserViewHolder>(
    object : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(old: Post, new: Post) = old.id == new.id
        override fun areContentsTheSame(old: Post, new: Post) = old == new
    }
) {

    inner class UserViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(post: Post) {
            view.findViewById<TextView>(R.id.txtTitle).text = post.title
            view.findViewById<TextView>(R.id.txtBody).text = post.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user, parent, false)
        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}