package com.rolahsu.transitionanimationdemo.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.rolahsu.transitionanimationdemo.R
import com.rolahsu.transitionanimationdemo.START_IMAGE

class StartFragment : Fragment() {

    lateinit var startImage: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startImage = view.findViewById(R.id.startImage)

        startImage.setOnClickListener {
            val manager = parentFragment?.childFragmentManager ?: parentFragmentManager
            val fragment = EndFragment()
            val topFragment = manager.fragments.lastOrNull()
            manager.beginTransaction()
                .apply {
                    add(R.id.container_view, fragment, fragment.javaClass.name)
                    addToBackStack(fragment.javaClass.name)
                    if (topFragment != null) {
                        hide(topFragment)
                    }
                }
                .commit()
        }

    }
}