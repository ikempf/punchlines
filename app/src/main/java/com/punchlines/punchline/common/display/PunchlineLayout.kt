package com.punchlines.punchline.common.display

import android.app.Activity
import android.view.View
import android.widget.TextView

import com.punchlines.R
import com.punchlines.punchline.paas.Punchline

object PunchlineLayout {

    fun displayPunchline(activity: Activity, view: View, punchline: Punchline) {
        val text = view.findViewById(R.id.punchline_text) as TextView
        val artist = view.findViewById(R.id.punchline_artist) as TextView
        val album = view.findViewById(R.id.punchline_album) as TextView

        activity.runOnUiThread {
            text.text = punchline.punchline
            artist.text = punchline.artist
            album.text = punchline.album
        }
    }

}