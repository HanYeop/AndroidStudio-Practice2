package com.hanyeop.navigationex2.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hanyeop.navigationex2.R
import com.hanyeop.navigationex2.databinding.ActivityMainBinding
import com.hanyeop.navigationex2.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager
    private var oneFragment: OneFragment? = null
    private var twoFragment: TwoFragment? = null
    private var threeFragment: ThreeFragment? = null

    private val mainViewModel by viewModels<MainViewModel>()

    private var oneState = true
    private var twoState = false
    private var threeState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        initBottomNavigation()
    }

    private fun initBottomNavigation(){
        // 최초로 보이는 프래그먼트
        oneFragment = OneFragment()
        fragmentManager.beginTransaction().replace(R.id.fragmentContainerView,oneFragment!!).commit()

        binding.bottomNavi.setOnItemSelectedListener {

            // 최초 선택 시 fragment add, 선택된 프래그먼트 show, 나머지 프래그먼트 hide
            when(it.itemId){
                R.id.oneFragment ->{
                    // 같은 메뉴 두번 클릭 시
                    if(oneState) mainViewModel.upOneFragment()

                    if(oneFragment == null){
                        oneFragment = OneFragment()
                        fragmentManager.beginTransaction().add(R.id.fragmentContainerView,oneFragment!!).commit()
                    }
                    if(oneFragment != null) fragmentManager.beginTransaction().show(oneFragment!!).commit()
                    if(twoFragment != null) fragmentManager.beginTransaction().hide(twoFragment!!).commit()
                    if(threeFragment != null) fragmentManager.beginTransaction().hide(threeFragment!!).commit()
                    oneState = true
                    twoState = false
                    threeState = false

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
                    oneState = false
                    twoState = true
                    threeState = false

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
                    oneState = false
                    twoState = false
                    threeState = true

                    return@setOnItemSelectedListener true
                }
                else ->{
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    companion object{
        private lateinit var binding : ActivityMainBinding

        // 바텀네비게이션 가림
        fun hideNavi(state: Boolean){
            if(state) binding.bottomNavi.visibility = View.GONE else binding.bottomNavi.visibility = View.VISIBLE
        }
    }
}