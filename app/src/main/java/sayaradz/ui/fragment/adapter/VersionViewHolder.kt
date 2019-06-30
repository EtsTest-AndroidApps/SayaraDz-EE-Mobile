package sayaradz.ui.fragment.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import sayaradz.authentification.R
import sayaradz.dataClasses.Version
import sayaradz.ui.fragment.version.VersionFragmentDirections

class VersionViewHolder private constructor(val layout: View) : RecyclerView.ViewHolder(layout) {
    private var versionName: TextView = itemView.findViewById(R.id.item_name)
    private var versionImage: ImageView = itemView.findViewById(R.id.img_item_logo)

    companion object {
        fun creat(parent: ViewGroup): VersionViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item, parent, false)
            return VersionViewHolder(itemView)
        }
    }

    fun bind(version: Version) {
        versionName.text = version.name
        handleClick(layout, version.id)

        Log.i("version", version.name)
        /*val imageUrl = GlideUrl(marque.imageUrl, LazyHeaders.Builder()
                .addHeader("Authorization", token)
                .build())
        Glide.with(context).load(imageUrl).into(holder.image)*/
        versionImage.setImageResource(R.drawable.a3_sedan)
    }

    private fun handleClick(view: View, marqueId: String) {
        val action = VersionFragmentDirections.actionVersionFragmentToFicheTechFragment()
        view.setOnClickListener { v: View ->
            v.findNavController().navigate(action)
        }
    }
}