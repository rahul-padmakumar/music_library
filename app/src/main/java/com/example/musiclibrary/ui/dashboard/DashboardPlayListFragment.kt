package com.example.musiclibrary.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musiclibrary.R

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardPlayListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardPlayListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard_play_list, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment DashboardPlayListFragment.
         */
        @JvmStatic
        fun newInstance() = DashboardPlayListFragment()
    }
}