package com.rolahsu.transitionanimationdemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.rolahsu.transitionanimationdemo.R

class EndFragment : Fragment() {
    lateinit var back: Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_end, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        back = view.findViewById(R.id.back)

        back.setOnClickListener {
            parentFragment?.childFragmentManager?.popBackStack()
        }
    }
}