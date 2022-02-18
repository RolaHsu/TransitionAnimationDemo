package com.rolahsu.transitionanimationdemo

import android.os.Bundle
import android.transition.Fade
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.rolahsu.transitionanimationdemo.ImageData.IMAGE_DRAWABLES

class LargeFragment : Fragment() {

    lateinit var imageView: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_large, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = view.findViewById(R.id.imageView)

        val position = arguments?.getInt(POSITION) ?: return
        imageView.setImageResource(IMAGE_DRAWABLES[position])
        ViewCompat.setTransitionName(imageView, LARGE_IMAGE)
    }

    companion object {

        const val POSITION = "POSITION"
        const val LARGE_IMAGE = "LARGE_IMAGE"

        fun newInstance(position: Int): LargeFragment {
            val args = Bundle().apply {
                putInt(POSITION, position)
            }
            val fragment = LargeFragment()
            fragment.arguments = args

            return fragment
        }
    }
}