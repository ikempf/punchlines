package com.punchlines.punchline.home.daily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.punchlines.R
import com.punchlines.punchline.common.dagger.PunchlineComponent
import com.punchlines.punchline.common.dagger.PunchlineFragment
import com.punchlines.punchline.paas.PaasService

import javax.inject.Inject

import com.punchlines.punchline.common.display.PunchlineLayout.displayPunchline

class DailyPunchlineFragment : PunchlineFragment() {

    @Inject
    @JvmField
    var service: PaasService? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater!!.inflate(R.layout.home_daily_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        service!!.dailyPunchline()
                .thenAccept { p -> displayPunchline(activity!!, findViewById(R.id.daily), p) }
    }

    override fun inject(component: PunchlineComponent) =
        component.inject(this)

}