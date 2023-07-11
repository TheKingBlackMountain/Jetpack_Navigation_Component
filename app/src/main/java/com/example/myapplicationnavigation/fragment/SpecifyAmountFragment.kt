package com.example.myapplicationnavigation.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.myapplicationnavigation.R
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment() {

    lateinit var recipient: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = requireArguments().getString("recipient").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spabs = view.findViewById<Button>(R.id.send_btn)
        val spabc = view.findViewById<Button>(R.id.cancell_btn)
        val message = "Sending money to $recipient"
        view.findViewById<TextView>(R.id.recipient).text = message
        val edtamount = view.findViewById<EditText>(R.id.input_amount)

        val controller = findNavController()
        spabs.setOnClickListener {
            if (!TextUtils.isEmpty(edtamount.text.toString())){
                val amount = Money(BigDecimal(edtamount.text.toString()))
                val bundle = bundleOf(
                    "recipient" to recipient,
                    "amount" to amount
                )
                controller.navigate(R.id.confirmationFragment,
                    bundle
                )
            }else{
                Toast.makeText(activity, "Enter an amount" ,  Toast.LENGTH_SHORT).show()
            }

        }
        spabc.setOnClickListener { requireActivity()!!.onBackPressedDispatcher.onBackPressed() }
    }
}