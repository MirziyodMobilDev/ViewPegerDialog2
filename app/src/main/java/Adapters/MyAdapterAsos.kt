package Adapters

import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpegerdialog2.R
import kotlinx.android.synthetic.main.item_rv.view.*
import modul.Asos

class MyAdapterAsos(var asosList:ArrayList<Asos>):RecyclerView.Adapter<MyAdapterAsos.Vh>() {
    inner class Vh(itemView:View):RecyclerView.ViewHolder(itemView){
        fun onBind(asos: Asos){
            itemView.item_name.text = asos.sarlavha
            itemView.item_definition.text = asos.discription
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapterAsos.Vh {
      var itemView:View
      itemView  = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent,false)
        var vh = Vh(itemView)
        return vh

    }

    override fun onBindViewHolder(holder: MyAdapterAsos.Vh, position: Int) {
      var listPos = asosList[position]
        holder.onBind(listPos)
    }

    override fun getItemCount(): Int {
      return asosList.size
    }
}