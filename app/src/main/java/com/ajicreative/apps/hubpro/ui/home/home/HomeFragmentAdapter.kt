package com.ajicreative.apps.hubpro.ui.home.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ajicreative.apps.hubpro.R
import com.ajicreative.apps.hubpro.ui.CategoryModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_home_fragment.view.*

class HomeFragmentAdapter(val list:MutableList<CategoryModel>, val context: HomeFragment):RecyclerView.Adapter<HomeFragmentAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val title = itemView.item_title_home_fragment
        val image = itemView.item_img_home_fragment
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_home_fragment, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]
        holder.title.text = item.title
        Log.e("title", item.title)
        Glide.with(context).load(item.image).into(holder.image)

    }

    override fun getItemCount(): Int = list.size
}