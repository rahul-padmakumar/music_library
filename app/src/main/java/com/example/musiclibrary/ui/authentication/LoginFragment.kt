package com.example.musiclibrary.ui.authentication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.musiclibrary.MusicLibraryApplication
import com.example.musiclibrary.R
import com.example.musiclibrary.di.MusicLibraryViewModelFactory
import com.example.musiclibrary.models.Resource
import com.example.musiclibrary.models.UserModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    @Inject
    lateinit var musicLibraryViewModelFactory: ViewModelProvider.Factory

    @Inject lateinit var useModel: UserModel

    private val loginViewModel by lazy {
        ViewModelProvider(this, musicLibraryViewModelFactory).get(LoginViewModel::class.java)
    }

    private var savedStateHandle: SavedStateHandle? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MusicLibraryApplication)
            .appComponent
            .loginSubComponent()
            .build()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedStateHandle = Navigation.findNavController(requireActivity(), R.id.fcv_music_library)
            .previousBackStackEntry?.savedStateHandle
        savedStateHandle?.set(IS_USER_SIGNED_IN, false)

        loginViewModel.loginResponseLiveData.observe(
            viewLifecycleOwner,
            {
                when(it){
                    is Resource.Success -> Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
                    is Resource.Failure -> Toast.makeText(requireContext(), it.errorMessage, Toast.LENGTH_SHORT).show()
                    is Resource.Progress -> Toast.makeText(requireContext(), "Progressing", Toast.LENGTH_SHORT).show()
                }
            }
        )

        loginViewModel.validateAndLogin("rahul", null)
    }

    companion object {

        const val IS_USER_SIGNED_IN = "music_library_is_user_signed_in"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment LoginFragment.
         */
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}