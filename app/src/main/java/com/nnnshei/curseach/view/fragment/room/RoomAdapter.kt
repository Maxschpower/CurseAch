package com.nnnshei.curseach.view.fragment.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nnnshei.curseach.R
import com.nnnshei.curseach.model.Message
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_message.view.*

class RoomAdapter : RecyclerView.Adapter<RoomAdapter.ViewHolder>() {

    private val items = mutableListOf<Message>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_message,
                parent,
                false
            )
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun bindData(data: List<Message>) {
        items.clear()
        items.addAll(data.sortedByDescending { it.timestamp })
        notifyDataSetChanged()
    }

    class ViewHolder(
        override val containerView: View
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(item: Message) {
            containerView.apply {
                sender.text = item.sender
                message_text.text = item.text
            }
        }
    }
}