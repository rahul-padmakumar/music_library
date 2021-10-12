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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.musiclibrary.MusicLibraryApplication
import com.example.musiclibrary.R
import com.example.musiclibrary.databinding.FragmentSignUpBinding
import com.example.musiclibrary.datasource.db.entities.Address
import com.example.musiclibrary.models.Resource
import com.example.musiclibrary.models.UserModel
import com.example.musiclibrary.ui.authentication.login.LoginFragment
import javax.inject.Inject
import kotlin.properties.Delegates
import kotlin.reflect.KProperty


/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() {

    private var savedStateHandle: SavedStateHandle? = null
    private var userName: String? by Delegates.observable(""){
            _: KProperty<*>, _: String?, newValue: String? ->
        signUpBinding?.txtUserName?.setText(newValue)
    }

    private val args: SignUpFragmentArgs by navArgs()

    private var signUpBinding: FragmentSignUpBinding? = null

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
        signUpBinding = FragmentSignUpBinding.inflate(inflater, container, false)
        return signUpBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedStateHandle = Navigation.findNavController(requireActivity(), R.id.fcv_music_library)
            .previousBackStackEntry?.savedStateHandle
        savedStateHandle?.set(LoginFragment.IS_USER_SIGNED_IN, false)

        args.argsUserName?.run {
            userName = this
        }

        signUpViewModel.liveData.observe(
            viewLifecycleOwner,
            {
                when(it){
                    is Resource.Success -> {
                        savedStateHandle?.set(LoginFragment.IS_USER_SIGNED_IN, true)
                        findNavController().popBackStack()
                    }
                    is Resource.Failure -> {
                        Toast.makeText(requireContext(), it.errorMessage, Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Progress -> {
                        Toast.makeText(
                            requireContext(),
                            "SignUp progress",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        )

        signUpBinding?.run {
            btnSignup.setOnClickListener {
                signUpViewModel.validateAndSignUpUser(
                    UserModel(
                        name = signUpBinding?.txtUserName?.text.toString(),
                        password = signUpBinding?.txtPassword?.text.toString(),
                        address = Address(
                            houseName = signUpBinding?.txtHouseName?.text.toString(),
                            streetName = signUpBinding?.txtStreetName?.text.toString(),
                            city = signUpBinding?.txtCityName?.text.toString(),
                            state = signUpBinding?.txtStateName?.text.toString(),
                            country = signUpBinding?.txtCountryName?.text.toString()
                        )
                    )
                )
            }
        }
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