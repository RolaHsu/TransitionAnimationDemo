package com.rolahsu.transitionanimationdemo.fragment.easy

import android.os.Bundle
import android.transition.Fade
import android.transition.TransitionInflater
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import com.rolahsu.transitionanimationdemo.A_IMAGE
import com.rolahsu.transitionanimationdemo.B_IMAGE
import com.rolahsu.transitionanimationdemo.R

class AFragment : Fragment() {

    lateinit var aImage: ImageView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        aImage = view.findViewById(R.id.aImage)
        aImage.transitionName = A_IMAGE
        aImage.setImageResource(R.drawable.dog1)

        aImage.setOnClickListener {
            val childManager = parentFragment?.childFragmentManager ?: childFragmentManager
            val topFragment = childManager.fragments.lastOrNull()
            val navigatedFragment = BFragment().apply {

            }
            exitTransition = Fade()


            childManager.beginTransaction().apply {
                setCustomAnimations(R.anim.right_in, R.anim.stay, R.anim.stay, R.anim.right_out)
                addSharedElement(aImage, B_IMAGE)
                add(R.id.fragment_container, navigatedFragment, navigatedFragment.javaClass.name)
                addToBackStack(navigatedFragment.javaClass.name)
                if (topFragment != null) {
                    Log.d("xxx", "topFragment = $topFragment")
                    hide(topFragment)
                }
            }.commit()
        }
    }

}