package com.punchlines.punchline.random;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.punchlines.R;
import com.punchlines.punchline.common.dagger.PunchlineFragment;
import com.punchlines.punchline.common.dagger.PunchlineComponent;
import com.punchlines.punchline.common.display.PunchlineLayout;
import com.punchlines.punchline.paas.PaasService;
import com.punchlines.punchline.paas.Punchline;

import javax.inject.Inject;

public class RandomPunchlineFragment extends PunchlineFragment implements View.OnClickListener{

    @Inject
    protected PaasService service;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.random_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showSpinner();
        service.randomPunchline()
                .thenAccept(this::displayPunchline)
                .thenRun(this::hideSpinner);

        findViewById(R.id.next_punchline).setOnClickListener(this);
    }

    public void nextPunchline() {
        runOnUiThread(this::showSpinner);

        service.randomPunchline()
                .thenAccept(this::displayPunchline)
                .thenRun(() -> runOnUiThread(this::hideSpinner));
    }

    private void displayPunchline(Punchline p) {
        PunchlineLayout.displayPunchline(getActivity(), findViewById(R.id.random), p);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next_punchline: nextPunchline(); break;
        }
    }

}