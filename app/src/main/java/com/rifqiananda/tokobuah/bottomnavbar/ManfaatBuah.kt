package com.rifqiananda.tokobuah.bottomnavbar

import android.content.Intent
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.drawable.ShapeDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.rifqiananda.tokobuah.MainActivity
import com.rifqiananda.tokobuah.R
import kotlinx.android.synthetic.main.activity_manfaat_buah.*

class ManfaatBuah : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manfaat_buah)

        menu_color_card1.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(this,R.color.red_apple), BlendMode.SRC_IN)
        menu_color_card2.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(this,R.color.green_avocado), BlendMode.SRC_IN)
        menu_color_card3.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(this,R.color.red_dragon), BlendMode.SRC_IN)
        menu_color_card4.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(this,R.color.yellow_banana), BlendMode.SRC_IN)
        menu_color_card5.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(this,R.color.green_wm), BlendMode.SRC_IN)
        menu_color_card6.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(this,R.color.yellow_star), BlendMode.SRC_IN)
        menu_color_card7.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(this,R.color.blue_blueberry), BlendMode.SRC_IN)
        menu_color_card8.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(this,R.color.orange_orange), BlendMode.SRC_IN)
        menu_color_card9.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(this,R.color.pruple_grape), BlendMode.SRC_IN)
        menu_color_card10.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(this,R.color.orange_pinapple), BlendMode.SRC_IN)

        btn_read.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}