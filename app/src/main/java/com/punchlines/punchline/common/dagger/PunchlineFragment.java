package com.punchlines.punchline.common.dagger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class PunchlineFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        inject(DaggerPunchlineComponent.create());
        return null;
    }

    protected abstract void inject(PunchlineComponent component);

    public View findViewById(int id) {
        return getView().findViewById(id);
    }

    public final void runOnUiThread(Runnable action) {
        getActivity().runOnUiThread(action);
    }

}