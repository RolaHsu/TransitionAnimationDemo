package com.rolahsu.transitionanimationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.ViewCompat
import com.rolahsu.transitionanimationdemo.fragment.FragmentContainer
import com.rolahsu.transitionanimationdemo.fragment.GridFragment
import com.rolahsu.transitionanimationdemo.fragment.StartFragment
import com.rolahsu.transitionanimationdemo.fragment.easy.AFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        // 單一 ImageView
        supportFragmentManager.beginTransaction()
            .apply {
                val fragment = StartFragment()
                add(R.id.container_view, fragment, fragment.javaClass.name)
                setReorderingAllowed(true)
                addToBackStack(fragment.javaClass.name)
            }
            .commit()*/


        // Grid Layout
        /*supportFragmentManager.beginTransaction()
            .add(R.id.container_view, GridFragment())
            .commit()*/


        // easy sample
        supportFragmentManager.beginTransaction()
            .add(R.id.container_view, FragmentContainer())
            .commit()
    }
}
