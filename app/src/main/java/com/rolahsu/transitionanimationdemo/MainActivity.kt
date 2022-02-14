package com.rolahsu.transitionanimationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.ViewCompat
import com.rolahsu.transitionanimationdemo.fragment.StartFragment

class MainActivity : AppCompatActivity() {
    lateinit var activityPic: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityPic = findViewById(R.id.activityPic)
        ViewCompat.setTransitionName(activityPic, ACTIVITY_IMAGE)

        activityPic.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .apply {
                    val fragment = StartFragment()
                    add(R.id.container_view, fragment, fragment.javaClass.name)
                    addSharedElement(activityPic, START_IMAGE)
                    setReorderingAllowed(true)
                    addToBackStack(fragment.javaClass.name)
                }
                .commit()
        }
    }
}
