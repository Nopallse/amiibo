package com.example.moviecatalog.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.IntentCompat.getParcelableExtra
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.core.domain.model.Amiibo
import com.example.moviecatalog.R
import com.example.moviecatalog.databinding.ActivityDetailAmiiboBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.getValue

class DetailAmiiboActivity : AppCompatActivity() {

    private val detailAmiiboViewModel: DetailViewModel by viewModel()
    private lateinit var binding: ActivityDetailAmiiboBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailAmiiboBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailAmiibo = intent.getParcelableExtra<Amiibo>(EXTRA_DATA)
        showDetailAmiibo(detailAmiibo)
    }

    @SuppressLint("SetTextI18n")
    private fun showDetailAmiibo(detailAmiibo: Amiibo?) {
        detailAmiibo?.let {
            // Set toolbar title in collapsing toolbar
            binding.collapsingToolbar.title = detailAmiibo.name

            // Set type badge
            binding.tvTypeBadge.text = detailAmiibo.type

            // Load image with crossfade animation
            Glide.with(this)
                .load(detailAmiibo.image)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivDetailImage)

            // Set basic info
            binding.tvCharacter.text = detailAmiibo.character
            binding.tvSeries.text = detailAmiibo.amiiboSeries
            binding.tvGame.text = detailAmiibo.gameSeries
            binding.tvId.text = "${detailAmiibo.head}-${detailAmiibo.tail}"

            // Format release dates
            binding.tvDetailDescription.text = formatReleaseInfo(detailAmiibo)

            // Set up favorite button
            var statusFavorite = detailAmiibo.isFavorite
            setStatusFavorite(statusFavorite)

            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailAmiiboViewModel.setFavoriteAmiibo(detailAmiibo, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }


    private fun formatReleaseInfo(amiibo: Amiibo): String {
        val releases = mutableListOf<String>()

        amiibo.releaseNa?.let {
            if (it.isNotEmpty()) releases.add("North America: $it")
        }

        amiibo.releaseEu?.let {
            if (it.isNotEmpty()) releases.add("Europe: $it")
        }

        amiibo.releaseJp?.let {
            if (it.isNotEmpty()) releases.add("Japan: $it")
        }

        amiibo.releaseAu?.let {
            if (it.isNotEmpty()) releases.add("Australia: $it")
        }

        return if (releases.isEmpty()) {
            getString(R.string.no_release_info)
        } else {
            releases.joinToString("\n")
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}