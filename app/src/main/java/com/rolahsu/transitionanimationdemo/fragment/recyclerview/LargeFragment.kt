package com.rolahsu.transitionanimationdemo.fragment.recyclerview

import android.os.Bundle
import android.transition.Fade
import android.transition.TransitionInflater
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.rolahsu.transitionanimationdemo.ImageData.IMAGE_DRAWABLES
import com.rolahsu.transitionanimationdemo.R

class LargeFragment : Fragment() {

    lateinit var imageView: ImageView
    lateinit var back: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(this.requireContext()).inflateTransition(R.transition.shared_image)
        sharedElementReturnTransition = TransitionInflater.from(this.requireContext()).inflateTransition(R.transition.shared_image)
        enterTransition = Fade()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_large, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = view.findViewById(R.id.imageView)
        back = view.findViewById(R.id.back)

        back.setOnClickListener {
            parentFragment?.childFragmentManager?.popBackStack()
        }

        val position = arguments?.getInt(POSITION) ?: return
        imageView.setImageResource(IMAGE_DRAWABLES[position])
        ViewCompat.setTransitionName(imageView, LARGE_IMAGE)

        setEnterSharedElementCallback(object :androidx.core.app.SharedElementCallback() {
            override fun onMapSharedElements(names: MutableList<String>?,
                sharedElements: MutableMap<String, View>?) {
                super.onMapSharedElements(names, sharedElements)
                Log.d("xxx", "LargeFragment, names = $names, sharedElements = $sharedElements")
                sharedElements!![names!![0]] = view.findViewById(R.id.imageView)

            }
        })
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