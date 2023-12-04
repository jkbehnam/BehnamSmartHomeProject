package com.example.smarthomeproject.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smarthomeproject.R
import com.example.smarthomeproject.databinding.FragmentAddBinding
import com.example.smarthomeproject.databinding.FragmentListBinding

class AddFragment : Fragment() {

lateinit var binding: FragmentAddBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAddBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }
}