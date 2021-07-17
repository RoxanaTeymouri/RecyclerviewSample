package com.roksanateimouri.recyclerviewsample.features.airlinlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.roksanateimouri.recyclerviewsample.R
import com.roksanateimouri.recyclerviewsample.pojo.model.AirlineItem
import kotlinx.android.synthetic.main.airline_list_item.view.*


/**
 * VehiclesListAdapter that shows offline list of vehicles
 *
 */
class AirlineListAdapter : ListAdapter<AirlineItem, AirlineListAdapter.AillineListViewHolder>(
    AirlineListDiffUtils()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AillineListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.airline_list_item, parent, false)
        return AillineListViewHolder(view)
    }

    override fun onBindViewHolder(holder: AillineListViewHolder, position: Int) =
        holder.bind(getItem(position))

    /**
     * ViewHolder class for [AirlineListAdapter]
     *
     * @constructor takes the item view to be shown on VehicleList recycler view
     *
     *
     * @param itemView
     */
    inner class AillineListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: AirlineItem) = with(itemView) {
            with(item) {
               tv_name.text = context.getString(R.string.vehicle_type, name)
                tv_name.setOnClickListener {

                }
            }
        }
    }

}