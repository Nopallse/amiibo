package com.example.moviecatalog.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecatalog.R
import com.example.core.data.Resource
import com.example.core.ui.AmiiboAdapter
import com.example.moviecatalog.databinding.FragmentHomeBinding
import com.example.moviecatalog.detail.DetailAmiiboActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val amiiboAdapter = AmiiboAdapter()
            amiiboAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailAmiiboActivity::class.java)
                intent.putExtra(DetailAmiiboActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.amiibo.observe(viewLifecycleOwner) { amiibo ->
                if (amiibo != null) {
                    when (amiibo) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            amiiboAdapter.submitList(amiibo.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text =
                                amiibo.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            }

            with(binding.rvAmiibo) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = amiiboAdapter
            }
        }
    }
}
