package Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpegerdialog2.AsosiyFragment
import com.example.viewpegerdialog2.DunyoFragment
import com.example.viewpegerdialog2.IjtimoiyFragment
import modul.Ijtimoiy

class MyViewPegerAdapter(fragmentManager: FragmentManager):FragmentStatePagerAdapter(fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return  when(position){
            0->{
                return AsosiyFragment()
            }
            1->{
                return DunyoFragment()
            }
            else->{
                return IjtimoiyFragment()
            }
        }
    }


}