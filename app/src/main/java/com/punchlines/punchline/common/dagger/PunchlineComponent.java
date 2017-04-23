package com.punchlines.punchline.common.dagger;

import com.punchlines.punchline.artists.ArtistPunchlinesActivity;
import com.punchlines.punchline.artists.ArtistsActivity;
import com.punchlines.punchline.home.daily.DailyPunchlineFragment;
import com.punchlines.punchline.home.random.RandomPunchlineFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {PunchlineModule.class})
public interface PunchlineComponent {

    void inject(RandomPunchlineFragment randomPunchlineFragment);
    void inject(DailyPunchlineFragment dailyPunchlineFragment);
    void inject(ArtistsActivity artistsActivity);
    void inject(ArtistPunchlinesActivity artistPunchlinesActivity);

}