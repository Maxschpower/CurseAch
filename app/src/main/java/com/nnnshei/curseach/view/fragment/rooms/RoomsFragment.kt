package com.nnnshei.curseach.view.fragment.rooms

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
import com.nnnshei.curseach.model.Room
import com.nnnshei.curseach.presentation.rooms.RoomsPresenter
import com.nnnshei.curseach.presentation.rooms.RoomsView
import kotlinx.android.synthetic.main.fragment_rooms.*
import org.koin.android.ext.android.get

class RoomsFragment : MvpAppCompatFragment(), RoomsView {

    @InjectPresenter
    lateinit var presenter: RoomsPresenter

    @ProvidePresenter
    fun providePresenter() = get<RoomsPresenter>()

    private val adapter = RoomsAdapter { presenter.onRoomClicked(it) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_rooms, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_rooms.adapter = adapter
        recycler_rooms.layoutManager =
            LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
    }

    override fun bindData(rooms: List<Room>) {
        adapter.bindData(rooms)
        progress_circular.isVisible = false
    }

    companion object {
        fun newInstance() = RoomsFragment()
    }

}