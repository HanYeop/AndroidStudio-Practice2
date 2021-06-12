package org.techtown.pagingex.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.techtown.pagingex.model.Post
import org.techtown.pagingex.repository.Repository
import retrofit2.Response

// 데이터를 처리함
class MainViewModel(private val repository : Repository) : ViewModel() {

    val myResponse : MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2 : MutableLiveData<Response<Post>> = MutableLiveData()
    val myCustomPosts : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myCustomPosts2 : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myCustomPosts3 : MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost2(number : Int){
        viewModelScope.launch {
            val response = repository.getPost2(number)
            myResponse2.value = response
        }
    }

    fun getCustomPosts(userId : Int){
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId)
            myCustomPosts.value = response
        }
    }

    fun getCustomPosts2(userId : Int, sort : String, order : String){
        viewModelScope.launch {
            val response = repository.getCustomPosts2(userId,sort,order)
            myCustomPosts2.value = response
        }
    }

    fun getCustomPosts3(userId : Int, option : Map<String, String>){
        viewModelScope.launch {
            val response = repository.getCustomPosts3(userId,option)
            myCustomPosts3.value = response
        }
    }
}