package com.hanyeop.navigationex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hanyeop.navigationex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 네비게이션 선언
    private lateinit var navController: NavController

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 네비게이션 연결
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.findNavController()

        // 바텀 네비게이션 연결
        binding.bottomNavi.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            // 바텀 네비게이션이 표시되는 Fragment
            if(destination.id == R.id.bottomOneFragment || destination.id == R.id.bottomTwoFragment
                || destination.id == R.id.bottomThreeFragment){
                binding.bottomNavi.visibility = View.VISIBLE
            }
            // 바텀 네비게이션이 표시되지 않는 Fragment
            else{
                binding.bottomNavi.visibility = View.GONE
            }
        }

        // 앱 바 생성
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    // 뒤로가기
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    var waitTime = 0L
    override fun onBackPressed() {
        super.onBackPressed()
        if(System.currentTimeMillis() - waitTime >=1500 ) {
            waitTime = System.currentTimeMillis()
            Toast.makeText(this,"뒤로가기 버튼을 한번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT).show()
        } else {
            finish() // 액티비티 종료
        }
    }
}