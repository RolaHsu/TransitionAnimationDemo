package com.rolahsu.transitionanimationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rolahsu.transitionanimationdemo.fragment.StartFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .apply {
                val fragment = StartFragment()
                add(R.id.container_view, fragment, fragment.javaClass.name)
                addToBackStack(fragment.javaClass.name)
            }
            .commit()

    }
}
