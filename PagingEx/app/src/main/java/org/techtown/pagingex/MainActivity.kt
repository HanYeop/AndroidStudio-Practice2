package org.techtown.pagingex

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.techtown.pagingex.adapter.MyAdapter
import org.techtown.pagingex.databinding.ActivityMainBinding
import org.techtown.pagingex.paging.MyPagingRepository
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

        val repository = MyPagingRepository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        // 받아온 값을 리싸이클러뷰에 보여줌
        binding.button.setOnClickListener {
            viewModel.searchPost(Integer.parseInt(binding.editTextView.text.toString()))
            Log.d("tst5", "클릭됐음.")

            // 포커스 없애기
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(binding.editTextView.windowToken, 0)
        }

        // 관찰하여 submitData 메소드로 넘겨줌
        viewModel.result.observe(this, Observer {
            myAdapter.submitData(this.lifecycle,it)
            Log.d("tst5", "호출됐음.")
        })
    }
}