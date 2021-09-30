package com.example.musiclibrary.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.musiclibrary.R
import com.example.musiclibrary.datastore.UserPreferences
import com.example.musiclibrary.ui.authentication.LoginFragment

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {

    private val dashboardViewModel by lazy {
        ViewModelProvider(this).get(DashboardViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navController = findNavController()
        val currentBackStackEntry = navController.currentBackStackEntry
        currentBackStackEntry?.run {
            savedStateHandle.getLiveData<Boolean>(LoginFragment.IS_USER_SIGNED_IN)
                .observe(
                    this,
                    {
                        if(!it){
                            requireActivity().finish()
                        }
                    }
                )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        UserPreferences.getUserId(requireContext()).asLiveData().observe(
            viewLifecycleOwner,
            {
                if(it == 0){
                    Navigation.findNavController(requireActivity(), R.id.fcv_music_library)
                        .navigate(DashboardFragmentDirections.actionDashboardFragmentToLoginFragment())
                } else {
                    dashboardViewModel.userId = it
                }
            }
        )
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment DashboardFragment.
         */
        @JvmStatic
        fun newInstance() = DashboardFragment()
    }
}