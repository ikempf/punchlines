package com.punchlines.punchline.common.dagger

import com.punchlines.punchline.artists.ArtistPunchlinesActivity
import com.punchlines.punchline.artists.ArtistsActivity
import com.punchlines.punchline.home.daily.DailyPunchlineFragment
import com.punchlines.punchline.home.random.RandomPunchlineFragment

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = arrayOf(PunchlineModule::class))
interface PunchlineComponent {

    fun inject(randomPunchlineFragment: RandomPunchlineFragment)
    fun inject(dailyPunchlineFragment: DailyPunchlineFragment)
    fun inject(artistsActivity: ArtistsActivity)
    fun inject(artistPunchlinesActivity: ArtistPunchlinesActivity)

}