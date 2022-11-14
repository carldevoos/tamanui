package com.carldevoos.tamanui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.carldevoos.tamanui.databinding.FragmentAddDebtorBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddDebtorFragment : Fragment() {

    private var _binding: FragmentAddDebtorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddDebtorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.btnAddProduct.setOnClickListener {
            /*findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)*/

            val inflater = LayoutInflater.from(context).inflate(R.layout.form_product, null)
            binding.linearFormProduct.addView(inflater, binding.linearFormProduct.childCount)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}