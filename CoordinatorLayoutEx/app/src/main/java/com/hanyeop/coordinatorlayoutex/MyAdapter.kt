package com.hanyeop.coordinatorlayoutex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hanyeop.coordinatorlayoutex.databinding.LayoutItemBinding

class MyAdapter(val nameList : Array<String>, val desList : Array<String>)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // 생성된 뷰 홀더에 값 지정
    class MyViewHolder(val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(name: String, des: String) {
            // 뷰 홀더의 제목과 설명
            binding.nameText.text = name
            binding.descriptionText.text = des

//            // 뷰 홀더 클릭시 디테일뷰로
//            binding.cardView.setOnClickListener {
//                val intent: Intent = Intent(it.context, DetailViewActivity::class.java)
//                intent.putExtra("currentName", name)
//                intent.putExtra("currentDes", des)
//                it.context.startActivity(intent)
//            }
        }
    }

    // 어떤 xml 으로 뷰 홀더를 생성할지 지정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    // 뷰 홀더에 데이터 바인딩
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(nameList[position],desList[position])
    }

    // 뷰 홀더의 개수 리턴
    override fun getItemCount(): Int {
        return nameList.size
    }
}