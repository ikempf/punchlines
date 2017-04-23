package com.punchlines.punchline.artists;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.punchlines.R;
import com.punchlines.punchline.common.dagger.PunchlineActivity;
import com.punchlines.punchline.common.dagger.PunchlineComponent;
import com.punchlines.punchline.paas.PaasService;

import javax.inject.Inject;

import static android.util.TypedValue.COMPLEX_UNIT_PX;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static com.punchlines.punchline.artists.ArtistPunchlinesActivity.ARTIST;

public class ArtistsActivity extends PunchlineActivity {

    @Inject
    PaasService service;

    private static final LayoutParams ARTIST_LAYOUT = new LayoutParams(WRAP_CONTENT, WRAP_CONTENT);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artists_activity);

        displayArtists();
    }

    private void displayArtists() {
        LinearLayout artistList = (LinearLayout) findViewById(R.id.artists_list);

        service.artists()
                .thenAccept(artists ->
                        artists.forEach(artist ->
                                runOnUiThread(() -> artistList.addView(artistView(artist)))
                        ));
    }

    private TextView artistView(String artist) {
        TextView artistView = new TextView(this);
        artistView.setLayoutParams(ARTIST_LAYOUT);
        artistView.setText(artist);
        artistView.setTextColor(ContextCompat.getColor(this, R.color.textColorPrimary));
        artistView.setTextSize(COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.text_big));

        artistView.setOnClickListener(v -> showArtistsPunchlines(artist));

        return artistView;
    }

    private void showArtistsPunchlines(String artist) {
        Intent intent = new Intent(this, ArtistPunchlinesActivity.class);
        intent.putExtra(ARTIST, artist);
        startActivity(intent);
    }

    @Override
    protected void inject(PunchlineComponent component) {
        component.inject(this);
    }

}