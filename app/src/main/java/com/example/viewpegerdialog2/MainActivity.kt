package com.example.viewpegerdialog2

import Adapters.MyAdapterAsos
import Adapters.MyAdapterDunyo
import Adapters.MyAdapterIjtimoiy
import Adapters.MyViewPegerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import db.DatabaseHelperAsos
import db.DatabaseHelperDunyo
import db.DatabaseHelperIjtimoiy
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_dialog.view.*
import kotlinx.android.synthetic.main.item_table.view.*
import modul.Asos
import modul.Dunyo
import modul.Ijtimoiy

class MainActivity : AppCompatActivity() {
    lateinit var categorList:ArrayList<String>
    lateinit var myViewPegerAdapter: MyViewPegerAdapter
    lateinit var databaseHelperAsos: DatabaseHelperAsos
    lateinit var databaseHelperIjtimoiy: DatabaseHelperIjtimoiy
    lateinit var databaseHelperDunyo: DatabaseHelperDunyo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        databaseHelperAsos = DatabaseHelperAsos(this)
        databaseHelperDunyo = DatabaseHelperDunyo(this)
        databaseHelperIjtimoiy = DatabaseHelperIjtimoiy(this)
        myViewPegerAdapter = MyViewPegerAdapter(supportFragmentManager)
        categorList = ArrayList()
        categorList.add("Asosiy")
        categorList.add("Dunyo")
        categorList.add("Ijtimoiy")

        view_peger.adapter = myViewPegerAdapter
        tab_layout.setupWithViewPager(view_peger)
        setTab()


        tab_layout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                var customView=tab?.customView
                customView?.tag_chiziq?.visibility = View.VISIBLE
                var a = tab?.position
                when(a){
                    0->{
                        add.setOnClickListener {
                            var mDialog = LayoutInflater.from(this@MainActivity).inflate(R.layout.fragment_dialog,null)
                            var alertDialog = AlertDialog.Builder(this@MainActivity)
                            alertDialog.setView(mDialog)
                            val mAlertDialog =  alertDialog.show()
                            mDialog.saqlash.setOnClickListener {
                                mAlertDialog.dismiss()
                                var name = mDialog.sarlavha.text.toString()
                                var text = mDialog.desciription.text.toString()
                                var asos =  Asos(name,text)
                                databaseHelperAsos.addInformation(asos)

                            }
                            mDialog.bekor.setOnClickListener {
                                mAlertDialog.dismiss()
                            }

                        }

                    } 1->{
                    add.setOnClickListener {
                        var mDialog = LayoutInflater.from(this@MainActivity).inflate(R.layout.fragment_dialog,null)
                        var alertDialog = AlertDialog.Builder(this@MainActivity)
                        alertDialog.setView(mDialog)
                        val mAlertDialog =  alertDialog.show()
                        mDialog.saqlash.setOnClickListener {
                            mAlertDialog.dismiss()
                            var name = mDialog.sarlavha.text.toString()
                            var text = mDialog.desciription.text.toString()
                            var dunyo =  Dunyo(name,text)
                            databaseHelperDunyo.addInformation(dunyo)

                        }
                        mDialog.bekor.setOnClickListener {
                            mAlertDialog.dismiss()
                        }

                    }
                    }2->{
                    add.setOnClickListener {
                        var mDialog = LayoutInflater.from(this@MainActivity).inflate(R.layout.fragment_dialog,null)
                        var alertDialog = AlertDialog.Builder(this@MainActivity)
                        alertDialog.setView(mDialog)
                        val mAlertDialog =  alertDialog.show()
                        mDialog.saqlash.setOnClickListener {
                            mAlertDialog.dismiss()
                            var name = mDialog.sarlavha.text.toString()
                            var text = mDialog.desciription.text.toString()
                            var ijtimoiy =  Ijtimoiy(name,text)
                            databaseHelperIjtimoiy.addInformation(ijtimoiy)

                        }
                        mDialog.bekor.setOnClickListener {
                            mAlertDialog.dismiss()
                        }
                    }
                    }
                    }
                }


            override fun onTabUnselected(tab: TabLayout.Tab?) {
              var customView = tab?.customView
                customView?.tag_chiziq?.visibility = View.INVISIBLE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }
    private fun setTab(){
        var tabCount = tab_layout.tabCount
        for (i in 0 until tabCount){
            var tabView = LayoutInflater.from(this).inflate(R.layout.item_table,null,false)
            var tab = tab_layout.getTabAt(i)
            tab?.customView=tabView
            tabView.title_tv?.text =categorList[i]
            if (i == 0){
                tabView.tag_chiziq.visibility =View.VISIBLE
            }else{
                tabView.tag_chiziq.visibility = View.INVISIBLE
            }
        }
    }

}