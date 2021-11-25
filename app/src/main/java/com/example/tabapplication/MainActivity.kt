package com.example.tabapplication

import android.app.ActionBar
import android.content.res.Resources
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import com.example.tabapplication.ui.main.SectionsPagerAdapter
import com.example.tabapplication.databinding.ActivityMainBinding
import com.google.android.material.appbar.AppBarLayout
import android.util.DisplayMetrics
import android.widget.Toast
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private val TAB_TITLES = arrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = getString(TAB_TITLES[position])
        }.attach()


        // code to prevent app bar scrolling beyond a point

        //val width1 = Resources.getSystem().displayMetrics.widthPixels
        //val height1 = Resources.getSystem().displayMetrics.heightPixels
        //binding.title.minimumHeight = height - 500

        binding.btnDisableScroll.setOnClickListener {
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