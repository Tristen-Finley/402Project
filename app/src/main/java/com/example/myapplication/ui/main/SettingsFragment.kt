package com.example.myapplication.ui.main

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceManager
import com.example.myapplication.R


class SettingsFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadSettings()
    }


    private fun loadSettings() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

        val username = sharedPreferences.getString("username", "")
        val email = sharedPreferences.getString("email", "")
        //val password = sharedPreferences.getString("password", "")

    }

}