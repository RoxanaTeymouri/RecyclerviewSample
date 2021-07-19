package com.roksanateimouri.recyclerviewsample.features.airlinelist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.roksanateimouri.recyclerviewsample.R
import com.roksanateimouri.recyclerviewsample.pojo.model.AirlineItem
import com.roksanateimouri.recyclerviewsample.util.BASE_URL
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.airline_list_item.view.*

/**
 * AirlineListAdapter that shows offline list of airline
 *
 */
class AirlineListAdapter : ListAdapter<AirlineItem, AirlineListAdapter.AirlineListViewHolder>(
    AirlineListDiffUtils()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirlineListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.airline_list_item, parent, false)
        return AirlineListViewHolder(view)
    }

    override fun onBindViewHolder(holder: AirlineListViewHolder, position: Int) =
        holder.bind(getItem(position))

    /**
     * ViewHolder class for [AirlineListAdapter]
     *
     * @constructor takes the item view to be shown on AirlineList recycler view
     *
     *
     * @param itemView
     */
    inner class AirlineListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: AirlineItem) = with(itemView) {
            with(item) {
                tv_name.text = name
                Picasso.get().load(BASE_URL + item.logoURL).into(iv_logo_list)

                ll_airline_list.setOnClickListener { view ->
                    val bundle = bundleOf(
                        "name" to item.name,
                        "url" to item.site,
                        "phone" to item.phone,
                        "logo" to item.logoURL
                    )
                    view.findNavController().navigate(
                        R.id.action_airlineListFragment_to_airlineListDetailFragment,
                        bundle
                    )
                }
            }
        }
    }
}