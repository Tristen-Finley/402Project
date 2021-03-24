package com.example.myapplication

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication.ui.main.MenuFragment
import com.example.myapplication.ui.main.ScannerFragment
import com.example.myapplication.ui.main.SectionsPagerAdapter
import com.example.myapplication.ui.main.SettingsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpTabs()
    }

    private fun setUpTabs(){
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        sectionsPagerAdapter.addFragment(ScannerFragment(), title = "Scanner")
        sectionsPagerAdapter.addFragment(MenuFragment(), title = "Menu")
        sectionsPagerAdapter.addFragment(SettingsFragment(), title = "Settings")

    }

}