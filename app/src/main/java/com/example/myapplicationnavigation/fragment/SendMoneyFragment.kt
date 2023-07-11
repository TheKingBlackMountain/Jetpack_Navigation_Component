package com.example.myapplicationnavigation.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.myapplicationnavigation.R

class SendMoneyFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send_money, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val smbn = view.findViewById<Button>(R.id.next_btn)
        val smbc = view.findViewById<Button>(R.id.cancel_btn)
        val ebttext = view.findViewById<EditText>(R.id.input_recipient)
        val controller = findNavController()
        smbn.setOnClickListener {
            if(!TextUtils.isEmpty(ebttext.text.toString())){
                val bundle = bundleOf("recipient" to ebttext.text.toString())
                controller.navigate(R.id.specifyAmountFragment, bundle)
            }else{
                Toast.makeText(activity, "Enter an recipient" ,  Toast.LENGTH_SHORT).show()
            }

        }
        smbc.setOnClickListener {requireActivity()!!.onBackPressedDispatcher.onBackPressed()}
    }
}


