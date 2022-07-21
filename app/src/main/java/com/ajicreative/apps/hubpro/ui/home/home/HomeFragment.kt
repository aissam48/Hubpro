package com.ajicreative.apps.hubpro.ui.home.home

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import com.ajicreative.apps.hubpro.R
import com.ajicreative.apps.hubpro.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    val cutomViewModel: HomeFragmentViewModel by activityViewModels()


     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
//        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        cutomViewModel.fetchCategories()
        cutomViewModel.categoriesMutableLiveData.observe(viewLifecycleOwner) {
            recycler_view.adapter = HomeFragmentAdapter(it, this)
        }

    binding.ivMenu.setOnClickListener {
        cutomViewModel.toggleDrawer()
    }


    }

}