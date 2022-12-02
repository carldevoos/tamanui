package com.carldevoos.tamanui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.carldevoos.tamanui.databinding.FragmentListDebtorBinding
import com.carldevoos.tamanui.models.Debtor

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListDebtorFragment : Fragment() {

    private var _binding: FragmentListDebtorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListDebtorBinding.inflate(inflater, container, false)
        val navController = NavHostFragment.findNavController(this)

        val a = Debtor()

        binding.fab.setOnClickListener {
            navController.navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = binding.mainList
        recyclerview.layoutManager = LinearLayoutManager(context)

        val data = ArrayList<ItemsViewModel>()
        for (i in 1..20) {
            data.add(
                ItemsViewModel(
                    "Carlosssssssssssssssssssssssssssssssssssss" + i,
                    (i * 10).toString()
                )
            )
        }
        Log.d("onStart", data.size.toString())
        val adapter = CustomAdapter(data)

        recyclerview.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}