package com.vokrob.fishermans_handbook_2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val listArray: ArrayList<ListItem>, private val context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvContent: TextView = view.findViewById(R.id.tvContent)
        val im: ImageView = view.findViewById(R.id.im)

        fun bind(listItem: ListItem, context: Context) {
            tvTitle.text = listItem.titleText
            var textCon = listItem.contentText.substring(0, 50) + "..."
            tvContent.text = textCon
            im.setImageResource(listItem.image_id)
            itemView.setOnClickListener {
                val i = Intent(context, ContentActivity::class.java).apply {
                    putExtra("title", tvTitle.text.toString())
                    putExtra("content", listItem.contentText)
                    putExtra("image", listItem.image_id)
                }
                context.startActivity(i)
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





























