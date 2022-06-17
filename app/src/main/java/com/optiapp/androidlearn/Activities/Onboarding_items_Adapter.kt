package com.optiapp.androidlearn.Activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.optiapp.androidlearn.R

class Onboarding_items_Adapter(private val onboardingItems: List<Onboarding_item>):
RecyclerView.Adapter<Onboarding_items_Adapter.OnboardingItemViewHolder>(){
    inner class OnboardingItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private var imageOnboarding: ImageView = view.findViewById(R.id.imageBoard)
        private val textTitle:TextView = view.findViewById(R.id.textOne)
        private val textDescription:TextView = view.findViewById(R.id.textTwo)
        fun binder(onboardingItem: Onboarding_item){
            imageOnboarding.setImageResource(onboardingItem.onboardingImage)
            textTitle.text=onboardingItem.title
            textDescription.text=onboardingItem.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewHolder {
        return OnboardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.onboard_item_contianerlayout,parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: OnboardingItemViewHolder, position: Int) {
        holder.binder(onboardingItems[position])
    }

    override fun getItemCount(): Int {
       return onboardingItems.size
    }

}