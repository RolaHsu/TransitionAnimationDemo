package com.rolahsu.transitionanimationdemo.fragment

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import com.rolahsu.transitionanimationdemo.END_IMAGE
import com.rolahsu.transitionanimationdemo.R

class EndFragment : Fragment() {
    lateinit var back: ImageView
    lateinit var endImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext()).inflateTransition(R.transition.shared_image)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_end, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back = view.findViewById(R.id.back)
        endImage = view.findViewById(R.id.endImage)

        ViewCompat.setTransitionName(endImage, END_IMAGE)

        back.setOnClickListener {
            parentFragment?.childFragmentManager?.popBackStack()
        }
    }
}