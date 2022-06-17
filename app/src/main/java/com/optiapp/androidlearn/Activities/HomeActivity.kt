package com.optiapp.androidlearn.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.optiapp.androidlearn.R
import com.optiapp.androidlearn.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

     private lateinit var navCon: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navCon = navHost.navController
        setupActionBarWithNavController(navCon)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navCon.navigateUp() || super.onSupportNavigateUp()
    }
}