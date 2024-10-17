package com.vokrob.fishermans_handbook_2

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContentActivity : AppCompatActivity() {
    private lateinit var tvTitle: TextView
    private lateinit var tvContent: TextView
    private lateinit var im: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)

        getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        tvTitle = findViewById(R.id.tvTitle)
        tvContent = findViewById(R.id.tvContent)
        im = findViewById(R.id.im)

        tvTitle.text = intent.getStringExtra("title")
        tvContent.text = intent.getStringExtra("content")
        im.setImageResource(intent.getIntExtra("image", R.drawable.som))
    }
}
























