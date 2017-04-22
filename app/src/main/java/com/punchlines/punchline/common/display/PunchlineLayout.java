package com.punchlines.punchline.common.display;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.punchlines.R;
import com.punchlines.punchline.paas.Punchline;

public class PunchlineLayout {

    public static void displayPunchline(Activity activity, View view, Punchline punchline) {
        TextView text = (TextView) view.findViewById(R.id.punchline);
        TextView artist = (TextView) view.findViewById(R.id.artist);
        TextView album = (TextView) view.findViewById(R.id.album);

        activity.runOnUiThread(() -> {
            text.setText(punchline.punchline);
            artist.setText(punchline.artist);
            album.setText(punchline.album);
        });
    }

}