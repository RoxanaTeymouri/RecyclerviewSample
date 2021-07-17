package com.roksanateimouri.recyclerviewsample.features.airlinlist.adapter

import androidx.recyclerview.widget.DiffUtil
import com.roksanateimouri.recyclerviewsample.pojo.model.AirlineItem

/**
 * DiffUtils for [AirlineListAdapter]
 *
 */
class AirlineListDiffUtils : DiffUtil.ItemCallback<AirlineItem>() {
    override fun areItemsTheSame(oldItem: AirlineItem, newItem: AirlineItem) =
        oldItem.code == newItem.code && oldItem.defaultName == newItem.defaultName && oldItem.logoURL == newItem.logoURL  && oldItem.name == newItem.name && oldItem.phone == newItem.phone

    override fun areContentsTheSame(oldItem: AirlineItem, newItem: AirlineItem) =
        oldItem.code == newItem.code && oldItem.defaultName == newItem.defaultName && oldItem.logoURL == newItem.logoURL  && oldItem.name == newItem.name && oldItem.phone == newItem.phone
}