package com.optiapp.androidlearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.optiapp.androidlearn.Activities.HomeActivity
import com.optiapp.androidlearn.Activities.Onboarding_item
import com.optiapp.androidlearn.Activities.Onboarding_items_Adapter
import com.optiapp.androidlearn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var onboardingItemsAdapter: Onboarding_items_Adapter
    private lateinit var dot: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        items()
        indicators()
        move(0)
    }
    private fun items(){
        onboardingItemsAdapter= Onboarding_items_Adapter(listOf(
            Onboarding_item(
                onboardingImage = R.drawable.one,
                title = "The Creative Developer",
                description = "Do you find coding hard? You're about to experience a lot of ease learning with Android Learn "
            ),
            Onboarding_item(
                onboardingImage = R.drawable.two,
                title = "The Beautiful Creator",
                description = "Easy learning Material design and itsbimplementation on Android Using Kotlin "
            ),
            Onboarding_item(
                onboardingImage = R.drawable.three,
                title = "The Debugger",
                description = "Every great developer is a great debugger, easy debug process with Android Learn "
            )
        ))
        val pager:ViewPager2=findViewById(R.id.viewPager)
        pager.adapter=onboardingItemsAdapter
        pager.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                move(position)
            }
        })
        (pager.getChildAt(0) as RecyclerView).overScrollMode=RecyclerView.OVER_SCROLL_NEVER
        findViewById<ImageView>(R.id.next).setOnClickListener(){
            if(pager.currentItem +1 < onboardingItemsAdapter.itemCount){
                pager.currentItem+=1
            }
            else{
                Home()
            }
        }
        findViewById<TextView>(R.id.skip).setOnClickListener() {
            Home()
        }
        findViewById<TextView>(R.id.start).setOnClickListener() {
            val layout=findViewById<ViewPager2>(R.id.viewPager)
            layout.visibility= View.INVISIBLE
            Home()
        }
    }
    private fun Home(){
//        var intent= Intent(applicationContext, HomeActivity::class.java)
//        applicationContext.startActivity(intent)
        startActivity(Intent(applicationContext, HomeActivity::class.java))
        finish()
    }
    private fun indicators(){
        dot=findViewById(R.id.dot)
        val dots= arrayOfNulls<ImageView>(onboardingItemsAdapter.itemCount)
        val params:LinearLayout.LayoutParams=LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
        params.setMargins(8,0,8,0)
        for (i in dots.indices){
            dots[i]= ImageView(applicationContext)
            dots[i]?.let{
                it.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext,R.drawable.iact)
                )
                it.layoutParams=params
                dot.addView(it)
            }
        }
    }
    private fun move(position:Int){
        val count=dot.childCount
        for (i in 0 until count){
            val imageView=dot.getChildAt(i) as ImageView
            if(i==position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext,R.drawable.iback))
            }
            else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable( applicationContext,R.drawable.iact)
                )
            }
        }

    }
}