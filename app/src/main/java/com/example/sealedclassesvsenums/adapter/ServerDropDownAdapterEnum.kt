package com.example.sealedclassesvsenums.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.sealedclassesvsenums.R
import com.example.sealedclassesvsenums.ServerEnvEnum

class ServerDropDownAdapterEnum(private val context: Context, var list: ArrayList<ServerEnvEnum>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ItemRowHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.view_drop_down_menu, parent, false)
            holder = ItemRowHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ItemRowHolder
        }

        val item: ServerEnvEnum = list[position]
        holder.tvTitle.text = item.name

        return view
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return list.size
    }

    private class ItemRowHolder(val view: View) {
        val tvTitle: TextView = view.findViewById(R.id.tvDropDownTitle)
    }
}