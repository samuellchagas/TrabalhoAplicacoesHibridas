package com.example.masterquizzfinal

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import com.example.masterquizzfinal.databinding.FragmentLoginBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginFragment : Fragment() {
    private val binding: FragmentLoginBinding by lazy {
        FragmentLoginBinding.inflate(layoutInflater)
    }
    private val apiService = ApiService
        .getEndPointInstance("http://victorgontijo-001-site1.htempurl.com/")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.loginEnter.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
//                getValidationFragment(
//                    binding.loginEmail.text.toString(),
//                    binding.loginPassword.text.toString()
//                )
                getValidationFragment("professor", "professor")
            }
        }
    }

    suspend fun getValidationFragment(email: String, senha: String) {

        val response = apiService.getValidation(Login(email, senha))

        val retornoApi = response.body() ?: RetornoApi(0, "")

        val preference = requireContext().getSharedPreferences("preference", Context.MODE_PRIVATE)

        preference.edit { putString(BEARER, retornoApi.bearer) }

        if (response.isSuccessful) {
            return findNavController().navigate(R.id.action_loginFragment_to_subjectFragment)
        } else {
            return Toast.makeText(context, "USUARIO E/OU SENHA INVALIDOS", Toast.LENGTH_SHORT)
                .show()
        }

    }

    companion object {
        const val BEARER = "BEARER"
    }

}