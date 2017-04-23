package com.punchlines.punchline.home.daily;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.punchlines.R;
import com.punchlines.punchline.common.dagger.PunchlineComponent;
import com.punchlines.punchline.common.dagger.PunchlineFragment;
import com.punchlines.punchline.paas.PaasService;

import javax.inject.Inject;

import static com.punchlines.punchline.common.display.PunchlineLayout.displayPunchline;

public class DailyPunchlineFragment extends PunchlineFragment {

    @Inject
    protected PaasService service;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.home_daily_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        service.dailyPunchline()
                .thenAccept(p -> displayPunchline(getActivity(), findViewById(R.id.daily), p));
    }

    protected void inject(PunchlineComponent component) {
        component.inject(this);
    }

}