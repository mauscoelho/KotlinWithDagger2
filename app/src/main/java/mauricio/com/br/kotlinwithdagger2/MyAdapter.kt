package mauricio.com.br.kotlinwithdagger2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item.view.*


class MyAdapter : RecyclerView.Adapter<MyAdapter.ItemViewHolder>(){

    var myObjects = mutableListOf<String>()

    fun addObject(myObject: String){
        myObjects.add(myObject)
        this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyAdapter.ItemViewHolder?, position: Int) {
        holder?.bind(myObjects.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder{
        return ItemViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        return myObjects.size
    }

    class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item : String) = with(itemView){
            item_txt.text = item
        }
    }

}