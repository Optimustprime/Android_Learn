package com.optiapp.androidlearn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.optiapp.androidlearn.Fragments.RoadmapFragmentDirections
import com.optiapp.androidlearn.R
import com.optiapp.androidlearn.model.Declaration

class itemAdapter (private var context: Context, private var dataset:List<Declaration>): RecyclerView.Adapter<itemAdapter.itemViewHolder>() {
    class itemViewHolder(var view: View): RecyclerView.ViewHolder(view){
        var image: ImageView =view.findViewById(R.id.learnImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        var adapterLayout=LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent,false)
        return itemViewHolder(adapterLayout)

    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        var item=dataset[position]
//        holder.image.background=context.resources.getDrawable(item.stringResource)
        holder.image.setImageResource(item.stringResource)
        var mylist= item.stringResource

        holder.image.setOnClickListener {
//            var context = holder.view.context
//            var intent= Intent(context, DetailActivity::class.java)
//            intent.putExtra("code", mylist)
//            intent.putExtra("letter", holder.adapterPosition.toString())
//            Log.v("test",mylist.toString())
//            context.startActivity(intent)
            var letters=holder.adapterPosition.toString()
            var actionn=RoadmapFragmentDirections.actionRoadMapFragmentToDetailsFragment(code = mylist, letter = letters)
            holder.view.findNavController().navigate(actionn)

        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}