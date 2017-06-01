package za.co.riggaroo.datecountdown

import android.app.Application

import com.jakewharton.threetenabp.AndroidThreeTen

import timber.log.Timber
import za.co.riggaroo.datecountdown.injection.CountdownComponent
import za.co.riggaroo.datecountdown.injection.CountdownModule
import za.co.riggaroo.datecountdown.injection.DaggerCountdownComponent

open class CountdownApplication : Application() {

    val countDownComponent: CountdownComponent = DaggerCountdownComponent.builder()
            .countdownModule(CountdownModule(this))
            .build()

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree()) //TODO Install a Crashlytics tree in production
        }
    }

}
