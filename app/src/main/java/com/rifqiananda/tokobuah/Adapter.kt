package com.rifqiananda.tokobuah

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.rifqiananda.tokobuah.bottomnavbar.DetailBuah
import java.util.*


class Adapter(private val context: Context, private val data: ArrayList<Buah>): RecyclerView.Adapter<Adapter.BuahViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.BuahViewHolder {
        return BuahViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.recycler_view_template,
                parent,
                false))
    }


    override fun onBindViewHolder(holder: Adapter.BuahViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount() = data.size

    inner class BuahViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val imgView : ImageView = itemView.findViewById(R.id.image_view)
        private val txtName : TextView = itemView.findViewById(R.id.txt_name)
        private val txtPrice : TextView = itemView.findViewById(R.id.txt_price)

        private val btnDetail : ImageView = itemView.findViewById(R.id.btn_detail)
        private val cardContainer :RelativeLayout = itemView.findViewById(R.id.color_card1)
        private val cardPriceContainer : RelativeLayout = itemView.findViewById(R.id.color_card2)

        private fun getDominantColor(bitmap: Bitmap){
            Palette.Builder(bitmap).generate { p ->
                val dominantColor = p?.getDominantColor(ContextCompat.getColor(context, R.color.pruple_grape))
                dominantColor?.let { color ->
                    setBackgroundDrawableInPriceColor(color)
                    setBackgroundDrawableColor(color)
                }
            }

        }

        private fun setBackgroundDrawableColor(colorId: Int){
            val drawable : Drawable = cardContainer.background
            // idk why, but from my perspective, it should be a ShapeDrawable.
            // but android detects it as GradientDrawable
            if(drawable is GradientDrawable){
                drawable.setColor(colorId)
            }
        }

        private fun setBackgroundDrawableInPriceColor(colorId: Int){
            val drawable = cardPriceContainer.background
            if(drawable is GradientDrawable){
                drawable.setColor(colorId)
            }
        }

        fun bind(data: Buah)
        {


            imgView.setImageResource(data.imgView)

            //put getDominantCOlor func below imgView.set....
            getDominantColor(imgView.drawable.toBitmap())

            txtName.text = data.txtName
            txtPrice.text = data.txtPrice

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