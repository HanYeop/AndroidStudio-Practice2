package com.hanyeop.coordinatorlayoutex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hanyeop.coordinatorlayoutex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var nameList : Array<String>
    lateinit var descriptionList : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        // 뷰 바인딩
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 이름과 설명 초기화
        nameList = resources.getStringArray(R.array.item_name)
        descriptionList = resources.getStringArray(R.array.item_description)

        // 아이템을 가로로 하나씩 보여줌
        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        // 어댑터 연결
        binding.recyclerView.adapter = MyAdapter(nameList,descriptionList)

    }
}