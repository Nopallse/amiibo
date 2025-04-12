package com.example.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.ui.AmiiboAdapter
import com.example.favorite.databinding.ActivityFavoriteBinding
import com.example.moviecatalog.detail.DetailAmiiboActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load the Koin modules for this dynamic feature
        loadKoinModules(favoriteModule)

        // Setup the toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.favorite_amiibo)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val amiiboAdapter = AmiiboAdapter()

        amiiboAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailAmiiboActivity::class.java)
            intent.putExtra(DetailAmiiboActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteAmiibo.observe(this) { favoriteAmiibo ->
            amiiboAdapter.submitList(favoriteAmiibo)
            binding.viewEmpty.root.visibility = if (favoriteAmiibo.isNotEmpty()) View.GONE else View.VISIBLE
        }

        with(binding.rvFavoriteAmiibo) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = amiiboAdapter
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}