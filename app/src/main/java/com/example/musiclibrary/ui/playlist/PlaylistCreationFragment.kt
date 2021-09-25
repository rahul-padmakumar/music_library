package com.example.musiclibrary.ui.playlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musiclibrary.R

/**
 * A simple [Fragment] subclass.
 * Use the [PlaylistCreationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlaylistCreationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playlist_creation, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment PlaylistCreationFragment.
         */
        @JvmStatic
        fun newInstance() = PlaylistCreationFragment()
    }
}