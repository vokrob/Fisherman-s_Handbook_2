package com.vokrob.fishermans_handbook_2

import android.content.res.TypedArray
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter: MyAdapter? = null
    private lateinit var navView: NavigationView
    private lateinit var rcView: RecyclerView
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        navView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this)

        rcView = findViewById(R.id.rcView)

        drawerLayout = findViewById(R.id.drawerLayout)

        var list = ArrayList<ListItem>()

        list.addAll(
            fillArrays(
                resources.getStringArray(R.array.fish),
                resources.getStringArray(R.array.fish_content), getImageId(R.array.fish_image_array)
            )
        )

        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        rcView.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_fish -> {
                Toast.makeText(this, "Id fish", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(
                    fillArrays(
                        resources.getStringArray(R.array.fish),
                        resources.getStringArray(R.array.fish_content),
                        getImageId(R.array.fish_image_array)
                    )
                )
            }

            R.id.id_baits -> {
                Toast.makeText(this, "Id baits", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(
                    fillArrays(
                        resources.getStringArray(R.array.baits),
                        resources.getStringArray(R.array.baits_content),
                        getImageId(R.array.baits_image_array)
                    )
                )
            }

            R.id.id_tackle -> {
                Toast.makeText(this, "Id tackle", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(
                    fillArrays(
                        resources.getStringArray(R.array.tackle),
                        resources.getStringArray(R.array.tackle_content),
                        getImageId(R.array.tackle_image_array)
                    )
                )
            }

            R.id.id_stories -> {
                Toast.makeText(this, "Id stories", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(
                    fillArrays(
                        resources.getStringArray(R.array.stories),
                        resources.getStringArray(R.array.stories_content),
                        getImageId(R.array.stories_image_array)
                    )
                )
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }

    fun fillArrays(
        titleArray: Array<String>,
        contentArray: Array<String>,
        imageArray: IntArray
    ): List<ListItem> {
        var listItemArray = ArrayList<ListItem>()

        for (n in 0..titleArray.size - 1) {
            var listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    fun getImageId(imageArrayId: Int): IntArray {
        var tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)

        for (i in ids.indices) {
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }
}


















