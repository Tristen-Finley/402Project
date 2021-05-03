package com.example.myapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.MySQLDatabaseExampleKotlin
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    private val model: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        val menuItems = generateItemList()
        recycler_view.adapter = CartAdapter(menuItems)
        recycler_view.layoutManager = LinearLayoutManager(context)
    }

    private fun generateItemList(): List<Item> {

        val list = ArrayList<Item>()

        model.selected.observe(viewLifecycleOwner, Observer { item ->

            val items = MySQLDatabaseExampleKotlin.executeMySQLQuery(item)
            println(items)
            for(i in 0 until items.size) {
                val item1 = Item(items[i])
                list += item1
            }
        })
        println(list)
        return list
    }
}

