package com.example.pruebatecnica.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatecnica.databinding.ItemPostBinding
import com.example.pruebatecnica.domain.model.Post

class PostAdapter(
    private val listener: OnAddCommentListener
) : ListAdapter<Post, PostAdapter.PostVH>(Diff()) {

    interface OnAddCommentListener {
        fun onAddCommentClicked(postId: Int)
        fun onViewCommentsClicked(postId: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostVH {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostVH(binding)
    }

    override fun onBindViewHolder(holder: PostVH, position: Int) =
        holder.bind(getItem(position))

    inner class PostVH(private val b: ItemPostBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(post: Post) {
            b.tvTitle.text = post.title
            b.tvBody.text = post.body
            b.btnAddComment.setOnClickListener { listener.onAddCommentClicked(post.id) }
            b.btnViewComments.setOnClickListener {
                listener.onViewCommentsClicked(post.id)
            }
        }
    }

    class Diff : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(old: Post, new: Post) = old.id == new.id
        override fun areContentsTheSame(old: Post, new: Post) = old == new
    }
}
