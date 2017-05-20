package com.punchlines.punchline.common.dagger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class PunchlineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject(DaggerPunchlineComponent.create())
    }

    protected abstract fun inject(component: PunchlineComponent)

}