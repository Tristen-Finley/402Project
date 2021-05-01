package com.example.myapplication.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.preference.PreferenceFragmentCompat
import com.example.myapplication.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        Toast.makeText(context, "These are your settings", Toast.LENGTH_SHORT).show()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }
}
