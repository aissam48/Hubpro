package com.ajicreative.apps.hubpro.ui.home.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajicreative.apps.hubpro.R
import com.ajicreative.apps.hubpro.ui.CategoryModel

class HomeFragmentViewModel:ViewModel() {

    val categoriesMutableLiveData : MutableLiveData<MutableList<CategoryModel>> = MutableLiveData()
    fun fetchCategories(){
        val categories = mutableListOf<CategoryModel>()
        categories.apply {
            add(CategoryModel("Fruits", R.mipmap.fruits))
            add(CategoryModel("Légumes",R.mipmap.legumes))
            add(CategoryModel("Viandes",R.mipmap.viande))
            add(CategoryModel("Poissons",R.mipmap.piossone))
        }

        categoriesMutableLiveData.value = categories
    }
}