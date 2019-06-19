package sayaradz.authentification

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import sayaradz.services.Marque

class MarqueAdapter(private val marques: List<Marque>, val context: Context)
    : RecyclerView.Adapter<MarqueAdapter.MarqueViewHolder>() {

    private var mMarques: List<Marque>

    init {
        mMarques = marques
    }

    class MarqueViewHolder(val layout: View) : RecyclerView.ViewHolder(layout) {
        var nameTextView: TextView
        var image: ImageView

        init {
            nameTextView = itemView.findViewById(R.id.marqueName)
            image = itemView.findViewById(R.id.logoImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarqueViewHolder {
        val marqueItemView = LayoutInflater.from(parent.context).inflate(R.layout.marque_list_item, parent, false)
        return MarqueViewHolder(marqueItemView)
    }

    override fun onBindViewHolder(holder: MarqueViewHolder, position: Int) {
        var marque = mMarques[position]
        holder.nameTextView.setText(marque.NomMarque)
        Log.i("marque", marque.NomMarque)
        Glide.with(context).load(marque.Image).into(holder.image)
    }

    override fun getItemCount() = mMarques.size
}