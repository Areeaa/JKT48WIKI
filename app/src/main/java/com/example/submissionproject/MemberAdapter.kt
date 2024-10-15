package com.example.submissionproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MemberAdapter (private val listMember:ArrayList<Member>): RecyclerView.Adapter<MemberAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_members, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listMember[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvDescription.text = description


        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, MemberDetail::class.java).apply {
                putExtra(MemberDetail.KEY_MEMBER, listMember[position])
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listMember.size

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.item_description)

    }


}