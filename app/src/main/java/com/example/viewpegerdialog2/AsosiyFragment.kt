package com.example.viewpegerdialog2

import Adapters.MyAdapterAsos
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import db.DatabaseHelperAsos
import kotlinx.android.synthetic.main.fragment_asosiy.*
import kotlinx.android.synthetic.main.fragment_asosiy.view.*
import modul.Asos


class AsosiyFragment : Fragment() {
    lateinit var root:View
    lateinit var databaseHelperAsos: DatabaseHelperAsos
    lateinit var listAsos:ArrayList<Asos>
    lateinit var myAdapterAsos: MyAdapterAsos


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        databaseHelperAsos = DatabaseHelperAsos(container?.context!!)
        listAsos = databaseHelperAsos.getAllInformation() as ArrayList<Asos>
        // Inflate the layout for this fragment
       root = inflater.inflate(R.layout.fragment_asosiy, container, false)
        myAdapterAsos = MyAdapterAsos(listAsos)
     root.rv_asos.adapter = myAdapterAsos
        return root
    }

}