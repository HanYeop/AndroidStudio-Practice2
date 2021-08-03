package com.hanyeop.recyclerviewex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hanyeop.recyclerviewex2.Constants.Companion.LEFT_POSITION
import com.hanyeop.recyclerviewex2.Constants.Companion.RIGHT_POSITION
import com.hanyeop.recyclerviewex2.databinding.ActivityMainBinding
import com.hanyeop.recyclerviewex2.model.Item
import com.hanyeop.recyclerviewex2.viewmodel.ItemViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyAdapter
    private val viewModel by viewModels<ItemViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 뷰 바인딩
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 어댑터 연결
        adapter = MyAdapter()

        // 아이템 변경시 갱신
        viewModel.readAllData.observe(this){
            adapter.submitList(it)
        }

        binding.apply {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

            // 왼쪽에 추가
            leftButton.setOnClickListener {
                val item = Item(0,nameText.text.toString(),descriptionText.text.toString(),LEFT_POSITION)
                viewModel.addItem(item)
            }

            // 오른쪽에 추가
            rightButton.setOnClickListener {
                val item = Item(0,nameText.text.toString(),descriptionText.text.toString(), RIGHT_POSITION)
                viewModel.addItem(item)
            }

            deleteButton.setOnClickListener{
                viewModel.deleteAll()
            }
        }

    }
}