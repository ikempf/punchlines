package com.punchlines.punchline.artists

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView

import com.punchlines.R
import com.punchlines.punchline.common.dagger.PunchlineActivity
import com.punchlines.punchline.common.dagger.PunchlineComponent
import com.punchlines.punchline.paas.PaasService

import javax.inject.Inject

import android.util.TypedValue.COMPLEX_UNIT_PX
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import kotlinx.android.synthetic.main.artists_activity.*

class ArtistsActivity : PunchlineActivity() {

    companion object {
        private val ARTIST_LAYOUT = LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
    }

    @Inject
    lateinit internal var service: PaasService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.artists_activity)

        displayArtists()
    }

    private fun displayArtists() =
            service.artists()
                    .thenAccept {
                        artists ->
                        artists.forEach {
                            artist ->
                            runOnUiThread { artists_list.addView(artistView(artist)) }
                        }
                    }

    private fun artistView(artist: String): TextView {
        val artistView = TextView(this)
        artistView.layoutParams = ARTIST_LAYOUT
        artistView.text = artist
        artistView.setTextColor(ContextCompat.getColor(this, R.color.textColorPrimary))
        artistView.setTextSize(COMPLEX_UNIT_PX, resources.getDimension(R.dimen.text_big))

        artistView.setOnClickListener { _ -> showArtistsPunchlines(artist) }

        return artistView
    }

    private fun showArtistsPunchlines(artist: String) {
        val intent = Intent(this, ArtistPunchlinesActivity::class.java)
        intent.putExtra(ArtistPunchlinesActivity.ARTIST, artist)
        startActivity(intent)
    }

    override fun inject(component: PunchlineComponent) =
            component.inject(this)

}