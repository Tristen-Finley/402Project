package com.example.myapplication

import android.os.Bundle
import android.os.StrictMode
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.ui.main.MenuFragment
import com.example.myapplication.ui.main.ScannerFragment
import com.example.myapplication.ui.main.SectionsPagerAdapter
import com.example.myapplication.ui.main.SettingsFragment
import java.sql.*
import java.util.Properties

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MySQLDatabaseExampleKotlin.main()
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

object MySQLDatabaseExampleKotlin {

    private var conn: Connection? = null
    private var username = "sgnet" // provide the username
    private var password = "436qxvRco6" // provide the corresponding password

    @JvmStatic fun main() {
        // make a connection to MySQL Server
        getConnection()
        // execute the query via connection object
    }

    fun executeMySQLQuery(): ArrayList<String> {
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        var items = ArrayList<String>()

        stmt = conn!!.createStatement()
        resultset = stmt!!.executeQuery("select * from item;")

        if (stmt.execute("select * from item;")) {
            resultset = stmt.resultSet
        }

        while (resultset!!.next()) {
            items.plusAssign(resultset.getString("item_name") + " " + resultset.getString("item_price"))
        }
        return items
    }

    /**
     * This method makes a connection to MySQL Server
     * In this example, MySQL Server is running in the local host (so 127.0.0.1)
     * at the standard port 3306
     */
    fun getConnection() {
        val connectionProps = Properties()
        connectionProps.put("user", username)
        connectionProps.put("password", password)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        Class.forName("com.mysql.jdbc.Driver").newInstance()
        conn = DriverManager.getConnection("jdbc:" + "mysql" + "://" + "boostem.net" + ":" + "3306" + "/sgnet_kotlin", connectionProps)
    }
}
