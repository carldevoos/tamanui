package com.carldevoos.tamanui

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.carldevoos.tamanui.databinding.FragmentAddDebtorBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddDebtorFragment : Fragment() {

    private var _binding: FragmentAddDebtorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var linearFormProduct: LinearLayout
    private lateinit var btnAddProduct: Button
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddDebtorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.linearFormProduct = binding.linearFormProduct
        this.btnAddProduct = binding.btnAddProduct
        this.floatingActionButton = binding.fab

        addChild(this.linearFormProduct, R.layout.form_product)

        this.btnAddProduct.setOnClickListener {
            /*findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)*/
            addChild(this.linearFormProduct, R.layout.form_product)
        }

        this.floatingActionButton.setOnClickListener {
            //var listProduct = ArrayList<Any>()
            for (i in 0 until this.linearFormProduct.childCount) {
                val item = this.linearFormProduct.getChildAt(i)
                Log.d("Number", "$i")
                val name = item.findViewWithTag<EditText>("product_name").text
                val price = item.findViewWithTag<EditText>("product_price").text
                val date = item.findViewWithTag<EditText>("product_date").text

                Log.d("Product", "$name - $price - $date")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addChild(linearFormProduct: LinearLayout, resource: Int) {
        val formProduct = LayoutInflater.from(context).inflate(resource, null)
        val btnDelete = formProduct.findViewWithTag<View>("delete")
        val txtDate = formProduct.findViewWithTag<EditText>("product_date")

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        txtDate.setText(day.toString().plus("-").plus(month + 1).plus("-").plus(year))

        btnDelete.setOnClickListener { linearFormProduct.removeView(formProduct) }
        txtDate.setOnClickListener {
            val datePickerDialog = context?.let { context ->
                DatePickerDialog(
                    context,
                    { _, year, monthOfYear, dayOfMonth ->
                        val dat = "$dayOfMonth-${monthOfYear + 1}-$year"
                        txtDate.setText(dat)
                    },
                    year,
                    month,
                    day
                )
            }
            datePickerDialog!!.show()
        }
        linearFormProduct.addView(formProduct, linearFormProduct.childCount)
    }
}