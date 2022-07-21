package com.ajicreative.apps.hubpro.ui.home

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.ajicreative.apps.hubpro.R
import com.ajicreative.apps.hubpro.databinding.ActivityHomeBinding
import com.ajicreative.apps.hubpro.ui.home.home.HomeFragment
import com.ajicreative.apps.hubpro.ui.home.home.HomeFragmentViewModel
import com.ajicreative.apps.hubpro.ui.home.profile.ProfileFragment
import com.ajicreative.apps.hubpro.ui.home.search.SearchFragment
import com.ajicreative.apps.hubpro.ui.home.store.StoreFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    val viewModel: HomeFragmentViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        replaceFragment(HomeFragment())

        setUpClicks()
        observeToggleMenu()
    }

    private fun observeToggleMenu() {
        viewModel.toggleLiveData.observe(this) {
            if (binding.navDrawer.isOpen) {
                binding.navDrawer.close()
            } else {
                binding.navDrawer.open()
            }
        }

    }

    private fun setUpClicks() {

        binding.bottomNavigationHome.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                }

                R.id.search -> {
                    replaceFragment(SearchFragment())
                }

                R.id.store -> {
                    replaceFragment(StoreFragment())
                }

                R.id.profile -> {
                    replaceFragment(ProfileFragment())
                }

            }
            return@setOnItemSelectedListener true

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameFragments, fragment)
        fragmentTransaction.commit()
    }
}