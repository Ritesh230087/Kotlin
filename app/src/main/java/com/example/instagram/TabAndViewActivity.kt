package com.example.instagram

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.instagram.databinding.ActivityTabAndViewBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabAndViewActivity : AppCompatActivity() {
    lateinit var tabAndViewBinding: ActivityTabAndViewBinding
    var heading=arrayOf("Message","Status","Call")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        tabAndViewBinding=ActivityTabAndViewBinding.inflate(layoutInflater)
        setContentView(tabAndViewBinding.root)

        tabAndViewBinding.viewPager2.adapter=TabAdapter(supportFragmentManager,lifecycle)
        TabLayoutMediator(tabAndViewBinding.tabLayout, tabAndViewBinding.viewPager2){
            tabs,position -> tabs.text= heading[position]
        }.attach()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}