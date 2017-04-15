package com.punchlines.punchline.dagger;

import com.punchlines.punchline.random.RandomPunchlineActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {PunchlineModule.class})
public interface PunchlineComponent {

    void inject(RandomPunchlineActivity randomPunchlineActivity);

}