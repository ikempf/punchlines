package com.punchlines.punchline.common.dagger;

import com.punchlines.punchline.daily.DailyPunchlineFragment;
import com.punchlines.punchline.random.RandomPunchlineFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {PunchlineModule.class})
public interface PunchlineComponent {

    void inject(RandomPunchlineFragment randomPunchlineFragment);
    void inject(DailyPunchlineFragment dailyPunchlineFragment);

}