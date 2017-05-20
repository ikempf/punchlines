package com.punchlines.punchline.home.tabs

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

import com.punchlines.R
import com.punchlines.punchline.artists.ArtistsActivity
import kotlinx.android.synthetic.main.home_activity.*

class HomeActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.home_activity)

        pager.adapter = HomeTabPager(supportFragmentManager, this)

        sliding_tabs.setupWithViewPager(pager)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.menu_artists -> {
                startActivity(Intent(this, ArtistsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

}