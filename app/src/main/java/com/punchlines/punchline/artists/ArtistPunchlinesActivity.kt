package com.punchlines.punchline.artists

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.TypedValue.COMPLEX_UNIT_PX
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import com.punchlines.R
import com.punchlines.punchline.common.dagger.PunchlineActivity
import com.punchlines.punchline.common.dagger.PunchlineComponent
import com.punchlines.punchline.paas.PaasService
import com.punchlines.punchline.paas.Punchline
import javax.inject.Inject
import kotlinx.android.synthetic.main.artists_artist_punchlines_activity.*

class ArtistPunchlinesActivity : PunchlineActivity() {

    companion object {
        val ARTIST = "artist"

        private val PUNCHLINE_LAYOUT = LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        private val SEPARATOR_LAYOUT = LayoutParams(MATCH_PARENT, 1)

        init {
            SEPARATOR_LAYOUT.setMargins(0, 50, 0, 50)
        }
    }

    @Inject
    lateinit internal var service: PaasService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.artists_artist_punchlines_activity)

        val artist = intent.getStringExtra(ARTIST)
        supportActionBar!!.title = artist

        displayArtistPunchlines(artist)
    }

    private fun displayArtistPunchlines(artist: String) =
            service.artistPunchlines(artist)
                    .thenAccept { punchlines ->
                        punchlines.forEach { punchline ->
                            runOnUiThread {
                                artist_punchlines_list.addView(punchlineView(punchline))
                                artist_punchlines_list.addView(separator())
                            }
                        }
                    }

    private fun separator(): View {
        val separator = View(this)
        separator.layoutParams = SEPARATOR_LAYOUT
        separator.setBackgroundColor(ContextCompat.getColor(this, R.color.textColorPrimary))

        return separator
    }

    private fun punchlineView(punchline: Punchline): TextView {
        val punchlineView = TextView(this)
        punchlineView.layoutParams = PUNCHLINE_LAYOUT
        punchlineView.text = punchline.punchline
        punchlineView.gravity = Gravity.CENTER
        punchlineView.setTextColor(ContextCompat.getColor(this, R.color.textColorPrimary))
        punchlineView.setTextSize(COMPLEX_UNIT_PX, resources.getDimension(R.dimen.text_big))

        return punchlineView
    }

    override fun inject(component: PunchlineComponent) =
            component.inject(this)

}