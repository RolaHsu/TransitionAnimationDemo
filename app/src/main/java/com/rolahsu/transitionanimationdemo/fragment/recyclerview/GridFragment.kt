package com.rolahsu.transitionanimationdemo.fragment.recyclerview

import android.app.SharedElementCallback
import android.os.Bundle
import android.os.Handler
import android.transition.Fade
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
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
        Log.d("xxx", "onCreate")
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("xxx", "onCreateView")
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
        aa()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            scrollToPosition()
            aa()
        }
    }

    private fun aa() {
        setExitSharedElementCallback(object : androidx.core.app.SharedElementCallback() {
            override fun onSharedElementStart(sharedElementNames: MutableList<String>?,
                sharedElements: MutableList<View>?,
                sharedElementSnapshots: MutableList<View>?) {
                super.onSharedElementStart(sharedElementNames,
                    sharedElements,
                    sharedElementSnapshots)
                Log.d("xxx", "onSharedElementStart")
            }

            override fun onMapSharedElements(names: MutableList<String>, sharedElements: MutableMap<String, View>) {
                super.onMapSharedElements(names, sharedElements)
                Log.d("xxx", "onMapSharedElements")
                if (GRID_POSITION == null) return
                val selectViewHolder = recyclerView.findViewHolderForAdapterPosition(GRID_POSITION!!)
                    ?: return
                Log.d("xxx", "names = $names, sharedElements = $sharedElements")
                sharedElements[names[0]] = selectViewHolder.itemView.findViewById(R.id.imageView)
            }

            override fun onSharedElementEnd(sharedElementNames: MutableList<String>?,
                sharedElements: MutableList<View>?,
                sharedElementSnapshots: MutableList<View>?) {
                super.onSharedElementEnd(sharedElementNames, sharedElements, sharedElementSnapshots)
                Log.d("xxx", "onSharedElementEnd")
            }
        })
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

    override fun onImageLoadCompleted(position: Int) {
        if (position != GRID_POSITION || GRID_POSITION == null || sharedElementEnterTransition != null) return
        Log.d("xxx", "onImageLoadCompleted")
        Log.d("xxx", "sharedElementEnterTransition = $sharedElementEnterTransition")
        Handler().postDelayed({
            startPostponedEnterTransition()
        }, 2000)
    }

    private fun scrollToPosition() {
        recyclerView.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            val layoutManager = recyclerView.layoutManager ?: return@addOnLayoutChangeListener
            if (GRID_POSITION != null) {
                recyclerView.post {
                    layoutManager.scrollToPosition(GRID_POSITION!!)
                }
            }
        }
    }
}