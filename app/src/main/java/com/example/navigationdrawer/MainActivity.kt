package com.example.navigationdrawer

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         drawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle =  ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            //to highlight anyone clicked
            it.isChecked = true

            when(it.itemId){


                R.id.nav_home ->{
                    Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()

                    replaceFragment(HomeFragment(), it.title.toString())
                }


                R.id.nav_message ->
                    Toast.makeText(this, "Message clicked", Toast.LENGTH_SHORT).show()

                R.id.nav_delete ->
                    Toast.makeText(this, "Delete clicked", Toast.LENGTH_SHORT).show()

                R.id.nav_delete ->
                    Toast.makeText(this, "Delete clicked", Toast.LENGTH_SHORT).show()

                R.id.nav_settings ->
                    Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()

                R.id.nav_share ->
                    Toast.makeText(this, "Share clicked", Toast.LENGTH_SHORT).show()

                R.id.nav_login ->
                    Toast.makeText(this, "Login clicked", Toast.LENGTH_SHORT).show()

                R.id.nav_sync ->
                    Toast.makeText(this, "Sync clicked", Toast.LENGTH_SHORT).show()

                R.id.nav_rate_us ->
                    Toast.makeText(this, "Rate us clicked", Toast.LENGTH_SHORT).show()

            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment, title: String){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
        //to close the drawer when a user clicks on an item
        drawerLayout.closeDrawers()
        //to set the title of the fragment clicked
        setTitle(title)

    }

}