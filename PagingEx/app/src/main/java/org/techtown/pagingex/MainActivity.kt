package org.techtown.pagingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.techtown.pagingex.adapter.MyAdapter
import org.techtown.pagingex.databinding.ActivityMainBinding
import org.techtown.pagingex.repository.Repository
import org.techtown.pagingex.viewModel.MainViewModel
import org.techtown.pagingex.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel
    private lateinit var binding : ActivityMainBinding
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰바인딩
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 어댑터 연결
        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        // 받아온 값을 리싸이클러뷰에 보여줌
        binding.button.setOnClickListener {
            viewModel.getCustomPosts2(Integer.parseInt(binding.editTextView.text.toString()),"id","asc")
            viewModel.myCustomPosts2.observe(this, Observer {
                if(it.isSuccessful){
                    myAdapter.setData(it.body()!!)
                }
                else{
                    Toast.makeText(this,it.code(), Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}