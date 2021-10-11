package com.example.musiclibrary.ui.authentication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.musiclibrary.MusicLibraryApplication
import com.example.musiclibrary.R
import com.example.musiclibrary.datasource.db.entities.Address
import com.example.musiclibrary.models.Resource
import com.example.musiclibrary.models.UserModel
import com.example.musiclibrary.ui.authentication.login.LoginFragment
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() {

    private var savedStateHandle: SavedStateHandle? = null
    private var userName: String? = null

    private val args: SignUpFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val signUpViewModel by lazy{
        ViewModelProvider(this, viewModelFactory)[SignUpViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as? MusicLibraryApplication)?.run {
            appComponent.inject(this@SignUpFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        userName = args.argsUserName
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedStateHandle = Navigation.findNavController(requireActivity(), R.id.fcv_music_library)
            .previousBackStackEntry?.savedStateHandle
        savedStateHandle?.set(LoginFragment.IS_USER_SIGNED_IN, false)

        signUpViewModel.liveData.observe(
            viewLifecycleOwner,
            {
                when(it){
                    is Resource.Success -> {
                        Log.d("Rahul", "Sign up successful")
                    }
                    is Resource.Failure -> {
                        Log.d("Rahul", "Sign up failure: ${it.errorMessage}")
                    }
                    is Resource.Progress -> {
                        Log.d("Rahul", "Sign up progress")
                    }
                }
            }
        )

        signUpViewModel.validateAndSignUpUser(
            UserModel(
                name = userName ?: "Name0",
                password = "123456",
                address = Address(
                    houseName = "ARC",
                    streetName = "SS Road",
                    city = "TVPM",
                    state = "KERALA",
                    country = "IND"
                )
            )
        )

        Log.d("Rahul", "User name is $userName")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment SignUpFragment.
         */
        @JvmStatic
        fun newInstance() = SignUpFragment()
    }
}