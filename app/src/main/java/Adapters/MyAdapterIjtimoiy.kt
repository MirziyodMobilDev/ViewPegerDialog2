package Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpegerdialog2.R
import modul.Dunyo
import modul.Ijtimoiy

class MyAdapterIjtimoiy(var asosList:ArrayList<Ijtimoiy>): RecyclerView.Adapter<MyAdapterIjtimoiy.Vh>() {
    inner class Vh(itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(ijtimoiy: Ijtimoiy){

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapterIjtimoiy.Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false))

    }

    override fun onBindViewHolder(holder: MyAdapterIjtimoiy.Vh, position: Int) {
        var listPos = asosList[position]
        holder.onBind(listPos)
    }

    override fun getItemCount(): Int {
        return asosList.size
    }
}