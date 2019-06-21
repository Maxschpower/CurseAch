package com.nnnshei.curseach.view.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nnnshei.curseach.R
import com.nnnshei.curseach.model.Room
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_room.view.*
import java.text.SimpleDateFormat
import java.util.*

class RoomsAdapter(
    private val clickListener: (String) -> Unit
) : RecyclerView.Adapter<RoomsAdapter.ViewHolder>() {

    private val items = mutableListOf<Room>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_room, parent, false),
            clickListener
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun bindData(data: List<Room>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(
        override val containerView: View,
        private val clickListener: (String) -> Unit
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private val yearFormat = SimpleDateFormat("d.MM.yyyy", Locale.getDefault())
        private val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

        fun bind(item: Room) {
            containerView.apply {
                setOnClickListener {
                    clickListener(item.title.orEmpty())
                }
                title.text = item.title
                sender.text = item.lastMessage?.sender + ":"
                date.text =
                    "${yearFormat.format(item.lastMessage?.timestamp ?: 0)}" +
                            "\n" +
                            "${timeFormat.format(item.lastMessage?.timestamp ?: 0)}"
                message.text = item.lastMessage?.text
            }
        }

    }

}