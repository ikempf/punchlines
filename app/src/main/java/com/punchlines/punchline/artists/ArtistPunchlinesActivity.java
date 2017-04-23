package com.punchlines.punchline.artists;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.punchlines.R;
import com.punchlines.punchline.common.dagger.PunchlineActivity;
import com.punchlines.punchline.common.dagger.PunchlineComponent;
import com.punchlines.punchline.paas.PaasService;
import com.punchlines.punchline.paas.Punchline;

import javax.inject.Inject;

import static android.util.TypedValue.COMPLEX_UNIT_PX;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class ArtistPunchlinesActivity extends PunchlineActivity {

    public static final String ARTIST = "artist";

    @Inject
    PaasService service;

    private static final LayoutParams PUNCHLINE_LAYOUT = new LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
    private static final LayoutParams SEPARATOR_LAYOUT = new LayoutParams(MATCH_PARENT, 1);
    static {
        SEPARATOR_LAYOUT.setMargins(0,50,0,50);
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artists_artist_punchlines_activity);

        String artist = getIntent().getStringExtra(ARTIST);
        getSupportActionBar().setTitle(artist);

        displayArtistPunchlines(artist);
    }

    private void displayArtistPunchlines(String artist) {
        LinearLayout artistPunchlines = (LinearLayout) findViewById(R.id.artist_punchlines_list);

        service.artistPunchlines(artist)
                .thenAccept(punchlines ->
                        punchlines.forEach(punchline ->
                            runOnUiThread(() -> {
                                artistPunchlines.addView(punchlineView(punchline));
                                artistPunchlines.addView(separator());
                            })
                        ));
    }

    private View separator() {
        View separator = new View(this);
        separator.setLayoutParams(SEPARATOR_LAYOUT);
        separator.setBackgroundColor(ContextCompat.getColor(this, R.color.textColorPrimary));

        return separator;
    }

    private TextView punchlineView(Punchline punchline) {
        TextView punchlineView = new TextView(this);
        punchlineView.setLayoutParams(PUNCHLINE_LAYOUT);
        punchlineView.setText(punchline.punchline);
        punchlineView.setGravity(Gravity.CENTER);
        punchlineView.setTextColor(ContextCompat.getColor(this, R.color.textColorPrimary));
        punchlineView.setTextSize(COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.text_big));

        return punchlineView;
    }


    @Override
    protected void inject(PunchlineComponent component) {
        component.inject(this);
    }

}