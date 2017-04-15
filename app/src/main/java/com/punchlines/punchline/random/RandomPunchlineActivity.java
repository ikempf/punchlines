package com.punchlines.punchline.random;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.punchlines.R;
import com.punchlines.punchline.paas.PaasService;
import com.punchlines.punchline.paas.Punchline;
import com.punchlines.punchline.dagger.PunchlineActivity;
import com.punchlines.punchline.dagger.PunchlineComponent;

import javax.inject.Inject;

public class RandomPunchlineActivity extends PunchlineActivity {

    @Inject
    protected PaasService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_punchline);

        showSpinner();
        service.randomPunchline()
                .thenAccept(this::displayPunchline)
                .thenRun(this::hideSpinner);
    }

    private void displayPunchline(Punchline punchline) {
        TextView text = (TextView) findViewById(R.id.punchline);
        TextView artist = (TextView) findViewById(R.id.artist);
        TextView album = (TextView) findViewById(R.id.album);

        runOnUiThread(() -> {
            text.setText(punchline.punchline);
            artist.setText(punchline.artist);
            album.setText(punchline.album);
        });
    }


    public void nextPunchline(View view) {
        runOnUiThread(this::showSpinner);

        service.randomPunchline()
                .thenAccept(this::displayPunchline)
                .thenRun(() -> runOnUiThread(this::hideSpinner));
    }

    public void showSpinner() {
        spinnerDisplay(true);
    }

    public void hideSpinner() {
        spinnerDisplay(false);
    }

    public void spinnerDisplay(Boolean showSpinner) {
        View spinner = findViewById(R.id.progress_loader);
        View nextPunchline = findViewById(R.id.next_punchline);

        runOnUiThread(() -> {
            spinner.setVisibility(showSpinner ? View.VISIBLE : View.GONE);
            nextPunchline.setVisibility(showSpinner ? View.GONE : View.VISIBLE);
        });
    }

    protected void inject(PunchlineComponent component) {
        component.inject(this);
    }

}