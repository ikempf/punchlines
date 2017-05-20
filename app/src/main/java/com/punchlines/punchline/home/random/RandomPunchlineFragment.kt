package com.punchlines.punchline.home.random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.punchlines.R
import com.punchlines.punchline.common.dagger.PunchlineFragment
import com.punchlines.punchline.common.dagger.PunchlineComponent
import com.punchlines.punchline.common.display.PunchlineLayout
import com.punchlines.punchline.paas.PaasService
import com.punchlines.punchline.paas.Punchline

import javax.inject.Inject
import kotlinx.android.synthetic.main.home_random_fragment.*

class RandomPunchlineFragment : PunchlineFragment(), View.OnClickListener {

    @Inject
    lateinit var service: PaasService

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater!!.inflate(R.layout.home_random_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        showSpinner()
        service.randomPunchline()
                .thenAccept(this::displayPunchline)
                .thenRun(this::hideSpinner)

        next_punchline.setOnClickListener(this)
    }

    fun nextPunchline() {
        runOnUiThread { this.showSpinner() }

        service.randomPunchline()
                .thenAccept(this::displayPunchline)
                .thenRun { runOnUiThread(this::hideSpinner) }
    }

    private fun displayPunchline(p: Punchline) =
            PunchlineLayout.displayPunchline(activity, random_punchline, p)

    fun showSpinner() = spinnerDisplay(true)

    fun hideSpinner() = spinnerDisplay(false)

    fun spinnerDisplay(showSpinner: Boolean) =
            runOnUiThread {
                progress_loader.visibility = if (showSpinner) View.VISIBLE else View.GONE
                next_punchline.visibility = if (showSpinner) View.GONE else View.VISIBLE
            }

    override fun onClick(v: View) {
        if (v.id == R.id.next_punchline)
            nextPunchline()
    }

    override fun inject(component: PunchlineComponent) =
            component.inject(this)

}