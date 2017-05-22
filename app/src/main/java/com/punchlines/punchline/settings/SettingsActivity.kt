package com.punchlines.punchline.settings

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.punchlines.R
import org.intellij.lang.annotations.Language

class SettingsActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        val Languages = "Languages"

        enum class Language {
            All,
            Fr,
            En
        }
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.settings_view)
    }


    override fun onClick(v: View) {
        val toggle = { l: Language ->
            {
                val preferences = getPreferences(0)
                val languages = preferences.getStringSet(Languages, emptySet())
                val edit = preferences.edit()
                val copy = HashSet(languages).also { c -> c.add(l.name) }
                edit.putStringSet(Languages, copy)
                edit.apply()
            }
        }
        when (v.id) {
            R.id.setting_language_all -> toggle(Language.All)
            R.id.setting_language_fr -> toggle(Language.Fr)
            R.id.setting_language_en -> toggle(Language.En)
        }

    }

}