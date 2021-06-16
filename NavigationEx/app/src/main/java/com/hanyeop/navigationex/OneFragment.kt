package com.hanyeop.navigationex

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hanyeop.navigationex.databinding.FragmentOneBinding

class OneFragment : Fragment(R.layout.fragment_one) {

    private var _binding : FragmentOneBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentOneBinding.bind(view)

        // 액션 연결
        binding.apply {
            button.setOnClickListener {
                val action = R.id.action_oneFragment_to_twoFragment
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}