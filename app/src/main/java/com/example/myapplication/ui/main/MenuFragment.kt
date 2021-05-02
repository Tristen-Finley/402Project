package com.example.myapplication.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.myapplication.R


class MenuFragment : Fragment() {

    class ItemViewModel : ViewModel() {
        private val mutableSelectedItem = MutableLiveData<String>()
        val selectedItem: LiveData<String> get() = mutableSelectedItem

        fun selectItem(item: String) {
            mutableSelectedItem.value = item
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onResume() {
        val viewModel: ItemViewModel by viewModels()
        println("switched")
        viewModel.selectedItem.observe(viewLifecycleOwner, Observer { item ->
            Toast.makeText(context, item, Toast.LENGTH_LONG).show()
            println("lamo")
            println(item)
        })
        super.onResume()
    }
}