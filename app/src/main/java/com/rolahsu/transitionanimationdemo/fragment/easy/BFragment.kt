package com.rolahsu.transitionanimationdemo.fragment.easy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import com.rolahsu.transitionanimationdemo.A_IMAGE
import com.rolahsu.transitionanimationdemo.B_IMAGE
import com.rolahsu.transitionanimationdemo.R


class BFragment : Fragment() {

    lateinit var bImage: ImageView
    lateinit var back: ImageView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bImage = view.findViewById(R.id.bImage)
        back = view.findViewById(R.id.back)

        bImage.transitionName = B_IMAGE
        bImage.setImageResource(R.drawable.dog3)

        back.setOnClickListener {
            parentFragment?.childFragmentManager?.popBackStack()
        }

    }

}