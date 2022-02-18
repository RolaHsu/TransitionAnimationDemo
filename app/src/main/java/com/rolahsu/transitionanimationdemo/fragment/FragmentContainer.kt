package com.rolahsu.transitionanimationdemo.fragment

import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rolahsu.transitionanimationdemo.B_IMAGE
import com.rolahsu.transitionanimationdemo.R
import com.rolahsu.transitionanimationdemo.fragment.easy.AFragment
import com.rolahsu.transitionanimationdemo.fragment.easy.BFragment

class FragmentContainer : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val childManager = parentFragment?.childFragmentManager ?: childFragmentManager
        val navigatedFragment = AFragment()

        childManager.beginTransaction().apply {
            add(R.id.fragment_container, navigatedFragment, navigatedFragment.javaClass.name)
            addToBackStack(navigatedFragment.javaClass.name)
        }.commit()
    }
}