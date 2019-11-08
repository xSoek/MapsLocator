package com.example.retomapssave

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retomapssave.Dao.Location

class CityAdapter() :
    RecyclerView.Adapter<CityAdapter.ViewHolder>() {
    private var cities = listOf<Location>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return cities.size
    }

    override fun onBindViewHolder(holder: CityAdapter.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.city_item, parent, false)
                return ViewHolder(view)
            }
        }
    }
}