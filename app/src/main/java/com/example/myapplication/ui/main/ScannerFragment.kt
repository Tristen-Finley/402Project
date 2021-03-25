package com.example.myapplication.ui.main

import android.R.attr
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.myapplication.R
import com.google.zxing.integration.android.IntentIntegrator
import androidx.fragment.app.Fragment as Fragment1

class ScannerFragment : Fragment1() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_scanner, container, false)
        val btn: Button = view.findViewById(R.id.scan_button)


        btn.setOnClickListener {

            val scanner = IntentIntegrator(activity)
            scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            scanner.setBeepEnabled(false)
            scanner.initiateScan()
        }

        // Inflate the layout for this fragment
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.i("dwdf", "deqwdfwefdew")
        if(resultCode == Activity.RESULT_OK){
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            Log.i("dwdf", "deqwdfwefdew")
            if (result != null) {
                if (result.contents == null) {
                    Log.e("scan error!", "Cancelled")
                    System.out.printf("Cancelled")
                    Toast.makeText(context, "Cancelled", Toast.LENGTH_SHORT).show()
                } else {
                    Log.i("Scanned", result.contents)
                    System.out.printf("Scanned" + result.contents)
                    Toast.makeText(context, "Scanned: " + result.contents, Toast.LENGTH_SHORT).show()
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }
}
