package com.rifqiananda.tokobuah

import android.content.Context
import android.content.Intent
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.recyclerview.widget.RecyclerView
import com.rifqiananda.tokobuah.bottomnavbar.DetailBuah
import kotlinx.android.synthetic.main.recycler_view_template.view.*
import java.util.ArrayList

class Adapter(private val context: Context, private val data: ArrayList<Buah>): RecyclerView.Adapter<Adapter.BuahViewHolder>(){

    private var imgView : ImageView? = null
    private var txtName : TextView? = null
    private var txtPrice : TextView? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.BuahViewHolder {
        return BuahViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.recycler_view_template,
                parent,
                false))
    }


    override fun onBindViewHolder(holder: Adapter.BuahViewHolder, position: Int) {
        holder.bind(data[position])

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
        {
            if (position == 0)
            {
                holder.itemView.color_card1.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.red_apple), BlendMode.SRC_IN)
                holder.itemView.color_card2.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.red_apple), BlendMode.SRC_IN)
            }
            else if (position == 1)
            {
                holder.itemView.color_card1.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.red_dragon), BlendMode.SRC_IN)
                holder.itemView.color_card2.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.red_dragon), BlendMode.SRC_IN)
            }
            else if (position == 2)
            {
                holder.itemView.color_card1.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.orange_pinapple), BlendMode.SRC_IN)
                holder.itemView.color_card2.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.orange_pinapple), BlendMode.SRC_IN)
            }
            else if (position == 3)
            {
                holder.itemView.color_card1.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.orange_orange), BlendMode.SRC_IN)
                holder.itemView.color_card2.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.orange_orange), BlendMode.SRC_IN)
            }
            else if (position == 4)
            {
                holder.itemView.color_card1.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.yellow_banana), BlendMode.SRC_IN)
                holder.itemView.color_card2.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.yellow_banana), BlendMode.SRC_IN)
            }
            else if (position == 5)
            {
                holder.itemView.color_card1.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.yellow_star), BlendMode.SRC_IN)
                holder.itemView.color_card2.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.yellow_star), BlendMode.SRC_IN)
            }
            else if (position == 6)
            {
                holder.itemView.color_card1.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.green_avocado), BlendMode.SRC_IN)
                holder.itemView.color_card2.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.green_avocado), BlendMode.SRC_IN)
            }
            else if (position == 7)
            {
                holder.itemView.color_card1.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.green_wm), BlendMode.SRC_IN)
                holder.itemView.color_card2.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.green_wm), BlendMode.SRC_IN)
            }
            else if (position == 8)
            {
                holder.itemView.color_card1.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.blue_blueberry), BlendMode.SRC_IN)
                holder.itemView.color_card2.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.blue_blueberry), BlendMode.SRC_IN)
            }
            else if (position == 9)
            {
                holder.itemView.color_card1.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.pruple_grape), BlendMode.SRC_IN)
                holder.itemView.color_card2.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.pruple_grape), BlendMode.SRC_IN)
            }
            else
            {
                if (position == 0)
                {
                    holder.itemView.color_card1.setBackgroundResource(R.color.red_apple)
                    holder.itemView.color_card2.setBackgroundResource(R.color.red_apple)
                }
                else if (position == 1)
                {
                    holder.itemView.color_card1.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.red_dragon), BlendMode.SRC_IN)
                    holder.itemView.color_card2.background.colorFilter = BlendModeColorFilter(ContextCompat.getColor(context,R.color.red_dragon), BlendMode.SRC_IN)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class BuahViewHolder(item: View): RecyclerView.ViewHolder(item){

        private val btnDetail : ImageView = item.findViewById(R.id.btn_detail)

        fun bind(data: Buah)
        {
            imgView = itemView.findViewById(R.id.image_view)
            txtName = itemView.findViewById(R.id.txt_name)
            txtPrice = itemView.findViewById(R.id.txt_price)

            imgView?.setImageResource(data.imgView)
            txtName?.text = data.txtName
            txtPrice?.text = data.txtPrice

            btnDetail.setOnClickListener {
                val model = data
                val gName : String = model.txtName
                val gPrice : String = model.txtPrice
                val gDesc : String = model.txtDesc
                val gColor : Int = model.color
                val gImageView : Int = model.imgView

                val intent = Intent(context, DetailBuah::class.java)
                intent.putExtra("iImageView", gImageView)
                intent.putExtra("iName", gName)
                intent.putExtra("iPrice", gPrice)
                intent.putExtra("iDesc", gDesc)
                intent.putExtra("iColor", gColor)
                context.startActivity(intent)
            }
        }
    }
}