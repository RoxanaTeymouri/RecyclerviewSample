package com.roksanateimouri.recyclerviewsample.features.airlinelist.adapter

import androidx.recyclerview.widget.DiffUtil
import com.roksanateimouri.recyclerviewsample.pojo.model.AirlineItem

/**
 * DiffUtils for [AirlineListAdapter]
 *
 */
class AirlineListDiffUtils : DiffUtil.ItemCallback<AirlineItem>() {
    override fun areItemsTheSame(oldItem: AirlineItem, newItem: AirlineItem) =
        oldItem == newItem
    override fun areContentsTheSame(oldItem: AirlineItem, newItem: AirlineItem) =
        oldItem == newItem
}