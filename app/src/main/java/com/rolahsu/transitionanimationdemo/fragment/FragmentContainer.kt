package com.rolahsu.transitionanimationdemo.fragment

import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isVisible
import com.rolahsu.transitionanimationdemo.B_IMAGE
import com.rolahsu.transitionanimationdemo.R
import com.rolahsu.transitionanimationdemo.fragment.easy.AFragment
import com.rolahsu.transitionanimationdemo.fragment.easy.BFragment
import com.rolahsu.transitionanimationdemo.fragment.recyclerview.GridFragment

class FragmentContainer : Fragment() {

    lateinit var easySampleBtn: Button
    lateinit var recyclerViewSampleBtn: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        easySampleBtn = view.findViewById(R.id.easySampleBtn)
        recyclerViewSampleBtn = view.findViewById(R.id.recyclerViewSampleBtn)

        easySampleBtn.setOnClickListener {
            val childManager = parentFragment?.childFragmentManager ?: childFragmentManager
            val navigatedFragment = AFragment()

            childManager.beginTransaction().apply {
                add(R.id.fragment_container, navigatedFragment, navigatedFragment.javaClass.name)
                addToBackStack(navigatedFragment.javaClass.name)
                easySampleBtn.isVisible = false
                recyclerViewSampleBtn.isVisible = false
            }.commit()
        }

        recyclerViewSampleBtn.setOnClickListener {
            val childManager = parentFragment?.childFragmentManager ?: childFragmentManager
            val navigatedFragment = GridFragment()

            childManager.beginTransaction().apply {
                add(R.id.fragment_container, navigatedFragment, navigatedFragment.javaClass.name)
                addToBackStack(navigatedFragment.javaClass.name)
                easySampleBtn.isVisible = false
                recyclerViewSampleBtn.isVisible = false
            }.commit()
        }
    }
}