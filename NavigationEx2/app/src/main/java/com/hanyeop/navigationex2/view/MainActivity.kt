package com.hanyeop.navigationex2.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.hanyeop.navigationex2.R
import com.hanyeop.navigationex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 네비게이션 선언
    private lateinit var navController: NavController

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        initNavigation()
    }

    // 네비게이션 연결
    private fun initNavigation(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.findNavController()
        binding.bottomNavi.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.oneFragment -> {
                    binding.textTitle.text = "화면 1"
                }
                R.id.twoFragment -> {
                    binding.textTitle.text = "화면 2"
                }
                R.id.threeFragment -> {
                    binding.textTitle.text = "화면 3"
                }
            }
        }
    }
}