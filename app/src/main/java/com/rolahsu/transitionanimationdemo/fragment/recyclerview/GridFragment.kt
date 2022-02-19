package com.rolahsu.transitionanimationdemo.fragment.recyclerview

import android.os.Bundle
import android.os.Handler
import android.transition.Fade
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rolahsu.transitionanimationdemo.*
import com.rolahsu.transitionanimationdemo.fragment.recyclerview.LargeFragment.Companion.LARGE_IMAGE

class GridFragment: Fragment(), GridAdapterInterface {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: GridAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        postponeEnterTransition()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_grid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.imageRecyclerVIew)
        with(recyclerView) {
            layoutManager = GridLayoutManager(this@GridFragment.requireContext(), 2)
            adapter = GridAdapter(this@GridFragment)
        }
        adapter = recyclerView.adapter as GridAdapter

        scrollToPosition()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            scrollToPosition()
        }
    }

    override fun onItemClicked(holder: GridViewHolder, position: Int) {
        GRID_POSITION = position

        val fragment = LargeFragment.newInstance(position)
        exitTransition = Fade()

        val manager = parentFragment?.childFragmentManager ?: parentFragmentManager
        val topFragment = manager.fragments.lastOrNull()
        manager
            .beginTransaction()
            .addSharedElement(holder.imageView, LARGE_IMAGE)
            .add(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .apply {
                if (topFragment != null) {
                    hide(topFragment)
                }
                recyclerView.scrollToPosition(0)
            }
            .commit()
    }

    override fun onImageLoadCompleted() {
        if (sharedElementEnterTransition != null) {
            Log.d("xxx", "sharedElementEnterTransition = $sharedElementEnterTransition")
            Log.d("xxx", "onImageLoadCompleted")
            Handler().postDelayed({
                startPostponedEnterTransition()
            }, 2000)
        }
    }

    private fun scrollToPosition() {
        recyclerView.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            val layoutManager = recyclerView.layoutManager ?: return@addOnLayoutChangeListener
            if (GRID_POSITION != 0) {
                recyclerView.post {
                    layoutManager.scrollToPosition(GRID_POSITION)
                }
            }
        }
    }
}