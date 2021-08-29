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

class UserAdapter(private val context: Context, private val users: List<Photo?>) : RecyclerView.Adapter<UserViewHolder>() {
    var itemClickListener: ((position: Int, name: Photo) -> Unit)? = null
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            UserViewHolder {

        // Inflating R.layout.name_item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycleviewhorizontalitem, parent, false)
        return UserViewHolder(view)
    }
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        // Getting element from names list at this position
        val element = users[position]
        Glide.with(context)
            .load(element?.user!!.profile_image?.small)
            .into(holder.imageView!!)
        // Updating the text of the txtName with this element
        holder.textView?.text = element?.user.username
        holder.itemView.setOnClickListener {
            // Invoking itemClickListener and passing it the position and name
            itemClickListener?.invoke(position, element)
        }
        }
    override fun getItemCount(): Int {
        return users.size
    }
}
class  UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView: ImageView? = itemView.findViewById(R.id.imageView)
    var textView: TextView? = itemView.findViewById(R.id.textView)


    }

