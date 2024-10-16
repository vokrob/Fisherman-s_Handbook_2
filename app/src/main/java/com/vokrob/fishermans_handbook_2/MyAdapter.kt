package com.vokrob.fishermans_handbook_2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val listArray: ArrayList<ListItem>, private val context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvContent: TextView = view.findViewById(R.id.tvContent)
        val im: ImageView = view.findViewById(R.id.im)

        fun bind(listItem: ListItem, context: Context) {
            tvTitle.text = listItem.titleText
            tvContent.text = listItem.contentText
            im.setImageResource(listItem.image_id)
            itemView.setOnClickListener {
                Toast.makeText(context, "Pressed : ${tvTitle.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int = listArray.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listArray[position]
        holder.bind(listItem, context)
    }

    fun updateAdapter(listArray: List<ListItem>) {
        this.listArray.clear()
        this.listArray.addAll(listArray)
        notifyDataSetChanged()
    }
}





























