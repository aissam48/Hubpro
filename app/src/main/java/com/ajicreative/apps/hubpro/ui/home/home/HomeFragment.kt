package com.ajicreative.apps.hubpro.ui.home.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.ajicreative.apps.hubpro.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {


    lateinit var cutomViewModel: HomeFragmentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        cutomViewModel = ViewModelProviders.of(this)[HomeFragmentViewModel::class.java]
        cutomViewModel.fetchCategories()
        cutomViewModel.categoriesMutableLiveData.observe(viewLifecycleOwner){
            recycler_view.adapter = HomeFragmentAdapter(it, this)
        }


    }

}