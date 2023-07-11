package com.example.myapplicationnavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.myapplicationnavigation.R

class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vbt = view.findViewById<Button>(R.id.view_transactions_btn)
        val smb = view.findViewById<Button>(R.id.send_money_btn)
        val vbb = view.findViewById<Button>(R.id.view_balance_btn)
        val contoller = findNavController()
        vbt.setOnClickListener { contoller.navigate(R.id.transactionsFragment) }
        smb.setOnClickListener { contoller.navigate(R.id.sendMoneyFragment) }
        vbb.setOnClickListener { contoller.navigate(R.id.viewBalanceFragment) }

    }
}