package com.roksanateimouri.recyclerviewsample.base

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.roksanateimouri.recyclerviewsample.R

/**
 * Base fragment that all fragment extends it.
 */
abstract class BaseFragment : Fragment() {
    /**
     * Represents error exception response handling.
     *
     * @param liveData The liveData of exceptionResource that received from server.
     */
    fun observeErrorMessage(liveData: LiveData<Any>) {
        liveData.observe(viewLifecycleOwner, Observer {
            showGetDataError()
        })
    }
    private fun showGetDataError() {
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.error_fetching_data))
            .setMessage("An error accrued while fetching data. Please try again ")
            .show()
    }
}



