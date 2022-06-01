package com.hanyeop.navigationex2.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.hanyeop.navigationex2.R
import com.hanyeop.navigationex2.databinding.ActivityMainBinding

private const val TAG = "테스트"
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val fragmentManager = supportFragmentManager

    private var oneFragment: OneFragment? = null
    private var twoFragment: TwoFragment? = null
    private var threeFragment: ThreeFragment? = null
    private var floatingFragment = FloatingFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        initBottomNavigation()

        binding.floatingActionButton.setOnClickListener{
            fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,floatingFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    private fun initBottomNavigation(){
        // 최초로 보이는 프래그먼트
        oneFragment = OneFragment()
        fragmentManager.beginTransaction().replace(R.id.fragmentContainerView,oneFragment!!).commit()

        binding.bottomNavi.setOnItemSelectedListener {

            // 최초 선택 시 fragment add, 선택된 프래그먼트 show, 나머지 프래그먼트 hide
            when(it.itemId){
                R.id.oneFragment ->{
                    if(oneFragment == null){
                        oneFragment = OneFragment()
                        fragmentManager.beginTransaction().add(R.id.fragmentContainerView,oneFragment!!).commit()
                    }
                    if(oneFragment != null) fragmentManager.beginTransaction().show(oneFragment!!).commit()
                    if(twoFragment != null) fragmentManager.beginTransaction().hide(twoFragment!!).commit()
                    if(threeFragment != null) fragmentManager.beginTransaction().hide(threeFragment!!).commit()

                    return@setOnItemSelectedListener true
                }
                R.id.twoFragment ->{
                    if(twoFragment == null){
                        twoFragment = TwoFragment()
                        fragmentManager.beginTransaction().add(R.id.fragmentContainerView,twoFragment!!).commit()
                    }
                    if(oneFragment != null) fragmentManager.beginTransaction().hide(oneFragment!!).commit()
                    if(twoFragment != null) fragmentManager.beginTransaction().show(twoFragment!!).commit()
                    if(threeFragment != null) fragmentManager.beginTransaction().hide(threeFragment!!).commit()

                    return@setOnItemSelectedListener true
                }
                R.id.threeFragment ->{
                    if(threeFragment == null){
                        threeFragment = ThreeFragment()
                        fragmentManager.beginTransaction().add(R.id.fragmentContainerView,threeFragment!!).commit()
                    }
                    if(oneFragment != null) fragmentManager.beginTransaction().hide(oneFragment!!).commit()
                    if(twoFragment != null) fragmentManager.beginTransaction().hide(twoFragment!!).commit()
                    if(threeFragment != null) fragmentManager.beginTransaction().show(threeFragment!!).commit()

                    return@setOnItemSelectedListener true
                }
                else ->{
                    return@setOnItemSelectedListener true
                }
            }
        }
    }
}