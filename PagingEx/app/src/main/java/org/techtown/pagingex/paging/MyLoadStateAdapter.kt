package org.techtown.pagingex.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import org.techtown.pagingex.databinding.LoadStateBinding

class MyLoadStateAdapter(private val retry: () -> Unit)
    : LoadStateAdapter<MyLoadStateAdapter.LoadStateViewHolder>() {


    override fun onBindViewHolder(
        holder: MyLoadStateAdapter.LoadStateViewHolder,
        loadState: LoadState
    ) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): MyLoadStateAdapter.LoadStateViewHolder {
        val binding = LoadStateBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LoadStateViewHolder(binding)
    }

    inner class LoadStateViewHolder(private val binding: LoadStateBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            // 버튼 클릭 시 Fragment 에서 받아온 동작 호출 (retry)
            binding.retryButton.setOnClickListener {
                retry.invoke()
            }
        }

        fun bind(loadState : LoadState){
            binding.apply {
                progressBar.isVisible = loadState is LoadState.Loading
                retryButton.isVisible = loadState !is LoadState.Loading
                errorText.isVisible = loadState !is LoadState.Loading
            }
        }
    }
}