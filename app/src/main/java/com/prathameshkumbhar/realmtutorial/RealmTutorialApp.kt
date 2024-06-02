package com.prathameshkumbhar.realmtutorial

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RealmTutorialApp: Application(){

    override fun onCreate() {
        super.onCreate()
    }

}