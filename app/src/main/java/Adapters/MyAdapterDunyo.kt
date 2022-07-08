package Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpegerdialog2.R
import modul.Asos
import modul.Dunyo

class MyAdapterDunyo(var asosList:ArrayList<Dunyo>): RecyclerView.Adapter<MyAdapterDunyo.Vh>() {
    inner class Vh(itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(dunyo: Dunyo){

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapterDunyo.Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false))

    }

    override fun onBindViewHolder(holder: MyAdapterDunyo.Vh, position: Int) {
        var listPos = asosList[position]
        holder.onBind(listPos)
    }

    override fun getItemCount(): Int {
        return asosList.size
    }
}