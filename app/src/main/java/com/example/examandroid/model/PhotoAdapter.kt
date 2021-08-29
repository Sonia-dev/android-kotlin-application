package com.example.examandroid.model


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examandroid.R


class PhotoAdapter(private val context: Context, private val photos: List<Photo?>) : RecyclerView.Adapter<PhotoViewHolder>() {

    var itemClickListener:((position:Int,photo:Photo)->Unit)?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            PhotoViewHolder {
        // Inflating R.layout.name_item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_layout, parent, false)
        return PhotoViewHolder(view)
    }
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        // Getting element from names list at this position
        val element = photos[position]
        Glide.with(context)
            .load(element?.urls?.regular)
            .into(holder.imageView!!)
        // Updating the text of the txtName with this element
        holder.textView?.text = element?.user?.username
        holder.itemView.setOnClickListener{
            itemClickListener?.invoke(position,element!!)
        }
    }
    override fun getItemCount(): Int {
        return photos.size
    }
}
class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView: ImageView? = itemView.findViewById(R.id.imageView)
    var textView: TextView? = itemView.findViewById(R.id.textView)



}