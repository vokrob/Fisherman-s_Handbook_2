package com.vokrob.fishermans_handbook_2

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_fish -> Toast.makeText(this, "Id fish", Toast.LENGTH_SHORT).show()
            R.id.id_baits -> Toast.makeText(this, "Id baits", Toast.LENGTH_SHORT).show()
            R.id.id_tackle -> Toast.makeText(this, "Id tackle", Toast.LENGTH_SHORT).show()
            R.id.id_stories -> Toast.makeText(this, "Id stories", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}



















