package com.example.tabapplication

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.tabapplication.ui.main.SectionsPagerAdapter
import com.example.tabapplication.databinding.ActivityMainBinding
import com.google.android.material.appbar.AppBarLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)

        binding.btnDisableScroll.setOnClickListener { view ->
            val params = binding.title.layoutParams as AppBarLayout.LayoutParams
            params.scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_NO_SCROLL
            binding.title.layoutParams = params
        }

        binding.btnEnableScroll.setOnClickListener {
            val params = binding.title.layoutParams as AppBarLayout.LayoutParams
            params.scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
            binding.title.layoutParams = params
        }
    }
}