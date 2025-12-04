package com.example.pruebatecnica.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebatecnica.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import android.view.LayoutInflater
import android.widget.EditText
import com.example.pruebatecnica.ui.adapter.PostAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), PostAdapter.OnAddCommentListener {

    private val mainViewModel: MainViewModel by viewModels()
    private val commentViewModel: CommentViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PostAdapter(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        mainViewModel.posts.observe(this) { posts ->
            adapter.submitList(posts)
        }

        mainViewModel.refreshFromApi()
    }

    override fun onAddCommentClicked(postId: Int) {
        showAddCommentDialog(postId)
    }
    override fun onViewCommentsClicked(postId: Int) {
        showCommentsDialog(postId)
    }

    private fun showAddCommentDialog(postId: Int) {
        val view = LayoutInflater.from(this).inflate(com.example.pruebatecnica.R.layout.dialog_add_comment, null)
        val etAuthor = view.findViewById<EditText>(com.example.pruebatecnica.R.id.etAuthor)
        val etComment = view.findViewById<EditText>(com.example.pruebatecnica.R.id.etComment)

        AlertDialog.Builder(this)
            .setTitle("Agregar comentario")
            .setView(view)
            .setPositiveButton("Guardar") { _, _ ->
                val author = etAuthor.text.toString().ifBlank { "Anon" }
                val commentText = etComment.text.toString()
                commentViewModel.addComment(postId, commentText, author)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun showCommentsDialog(postId: Int) {
        // Observamos los comentarios de ese post
        commentViewModel.getComments(postId).observe(this) { comments ->
            val msg = if (comments.isEmpty()) {
                "No hay comentarios para este post"
            } else {
                comments.joinToString("\n\n") { c ->
                    "- ${c.author}: ${c.comment}"
                }
            }

            AlertDialog.Builder(this)
                .setTitle("Comentarios")
                .setMessage(msg)
                .setPositiveButton("Cerrar", null)
                .show()
        }
    }
}

