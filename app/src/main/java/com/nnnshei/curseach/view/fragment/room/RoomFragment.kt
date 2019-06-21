package com.nnnshei.curseach.view.fragment.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nnnshei.curseach.R
import com.nnnshei.curseach.model.Message
import com.nnnshei.curseach.presentation.room.RoomPresenter
import com.nnnshei.curseach.presentation.room.RoomView
import kotlinx.android.synthetic.main.fragment_room.*
import org.koin.android.ext.android.get

class RoomFragment : MvpAppCompatFragment(), RoomView {

    @InjectPresenter
    lateinit var presenter: RoomPresenter

    @ProvidePresenter
    fun providePresenter() = get<RoomPresenter>()

    private val adapter = RoomAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_room, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_messages.adapter = adapter
        recycler_messages.layoutManager =
            LinearLayoutManager(this.context, RecyclerView.VERTICAL, true)
        send_button.setOnClickListener {
            if (message.text.toString().isNotBlank()) {
                presenter.sendClicked(message.text.toString())
                message.text?.clear()
            }
        }
    }

    override fun bindData(data: List<Message>) {
        adapter.bindData(data)
        recycler_messages.scrollToPosition(0)
        progress_circular.isVisible = false
    }

    companion object {
        fun newInstance() = RoomFragment()
    }
}