package com.rolahsu.transitionanimationdemo.fragment

import android.os.Bundle
import android.transition.Fade
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rolahsu.transitionanimationdemo.*
import com.rolahsu.transitionanimationdemo.LargeFragment.Companion.LARGE_IMAGE

class GridFragment: Fragment(), GridAdapterInterface {

    lateinit var recyclerVIew: RecyclerView
    lateinit var adapter: GridAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_grid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerVIew = view.findViewById(R.id.imageRecyclerVIew)
        with(recyclerVIew) {
            layoutManager = GridLayoutManager(this@GridFragment.requireContext(), 2)
            adapter = GridAdapter(this@GridFragment)
        }
        adapter = recyclerVIew.adapter as GridAdapter
    }

    override fun onItemClicked(holder: GridViewHolder, position: Int) {
        val fragment = LargeFragment.newInstance(position).apply {

            sharedElementEnterTransition = TransitionInflater.from(this@GridFragment.requireContext()).inflateTransition(R.transition.shared_image)
            sharedElementReturnTransition = TransitionInflater.from(this@GridFragment.requireContext()).inflateTransition(R.transition.shared_image)
            enterTransition = Fade()
        }
        exitTransition = Fade()

        val manager = parentFragment?.childFragmentManager ?: parentFragmentManager
        val topFragment = manager.fragments.lastOrNull()
        manager
            .beginTransaction()
            .setCustomAnimations(R.anim.right_in, R.anim.stay, R.anim.stay, R.anim.right_out)
            .addSharedElement(holder.imageView, LARGE_IMAGE)
            .add(R.id.container_view, fragment)
            .addToBackStack(null)
            .apply {
                if (topFragment != null) {
                    hide(topFragment)
                }
            }
            .commit()


    }
}