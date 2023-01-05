package com.carldevoos.tamanui

import android.app.ActionBar.LayoutParams
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.carldevoos.tamanui.databinding.FragmentAddDebtorBinding
import com.carldevoos.tamanui.models.Debtor
import com.carldevoos.tamanui.models.Product
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
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
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
            // Debtor details
            val debtorName = this.binding.txtDebtorName.text.toString()
            if (debtorName.isEmpty() or debtorName.isBlank())
                this.binding.txtDebtorName.error = "Is required!"

            val debtorDocument = this.binding.txtDebtorDocument.text.toString()
            val debtorPhone = this.binding.txtDebtorPhone.text.toString()
            val debtor = Debtor(null, debtorName, debtorDocument, debtorPhone)

            var listProduct: MutableList<Product> = mutableListOf()
            var checkInputs: Boolean = true
            for (i in 0 until this.linearFormProduct.childCount) {
                val item = this.linearFormProduct.getChildAt(i)

                // Product Details
                val productName = item.findViewWithTag<EditText>("product_name")
                val productPrice = item.findViewWithTag<EditText>("product_price")

                if (productName.text.isEmpty() or productName.text.isBlank()) {
                    productName.error = "Is required!"
                    checkInputs = false
                }

                if (productPrice.text.isEmpty() or productPrice.text.isBlank()) {
                    productPrice.error = "Is required!"
                    checkInputs = false
                }

                //val product = Product()
            }

            if (!checkInputs) {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addChild(linearFormProduct: LinearLayout, resource: Int) {
        val formProduct = LayoutInflater.from(context).inflate(resource, null)
        val lp = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        lp.setMargins(5, 15, 5, 0)
        formProduct.layoutParams = lp

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
                    context, { _, year, monthOfYear, dayOfMonth ->
                        val dat = "$dayOfMonth-${monthOfYear + 1}-$year"
                        txtDate.setText(dat)
                    }, year, month, day
                )
            }
            datePickerDialog!!.show()
        }
        linearFormProduct.addView(formProduct, linearFormProduct.childCount)
    }
}