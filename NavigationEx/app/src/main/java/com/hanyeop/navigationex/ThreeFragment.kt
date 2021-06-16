package com.hanyeop.navigationex

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.hanyeop.navigationex.databinding.FragmentThreeBinding

class ThreeFragment : Fragment(R.layout.fragment_three) {

    private val args by navArgs<ThreeFragmentArgs>()

    private var _binding : FragmentThreeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentThreeBinding.bind(view)

        binding.apply {
            nameText.text = args.user.name
            ageText.text = args.user.age.toString()
            Log.d("tst5", "${args.name}")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}