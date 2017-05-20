package com.punchlines.punchline.common.dagger

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class PunchlineFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        inject(DaggerPunchlineComponent.create())
        return null
    }

    protected abstract fun inject(component: PunchlineComponent)

    fun findViewById(id: Int): View =
        view!!.findViewById(id)

    fun runOnUiThread(action: () -> Unit) =
        activity.runOnUiThread(action)

}