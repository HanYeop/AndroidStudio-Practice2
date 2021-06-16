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
            // 두번째 화면으로 이등
            button.setOnClickListener {
                val action = R.id.action_oneFragment_to_twoFragment
                findNavController().navigate(action)
            }

            // 세번째 화면으로 이동
            submitButton.setOnClickListener {
                val user = User(nameEditView.text.toString(),ageEditView.text.toString().toInt())
                val action = OneFragmentDirections.actionOneFragmentToThreeFragment(user = user, name = "Han")
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}