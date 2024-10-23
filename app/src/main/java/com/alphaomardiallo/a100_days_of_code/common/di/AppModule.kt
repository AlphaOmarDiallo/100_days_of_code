package com.alphaomardiallo.a100_days_of_code.common.di

import com.alphaomardiallo.a100_days_of_code.feature.addentry.di.addEntryModule
import com.alphaomardiallo.a100_days_of_code.feature.dashboard.di.dashboardModule
import com.alphaomardiallo.a100_days_of_code.feature.history.di.historyModule
import com.alphaomardiallo.a100_days_of_code.feature.info.di.infoModule
import com.alphaomardiallo.a100_days_of_code.feature.learn.di.learnModule
import com.alphaomardiallo.a100_days_of_code.feature.onboarding.di.onBoardingModule
import com.alphaomardiallo.a100_days_of_code.feature.settings.di.settingsModule

fun moduleList() = listOf(
    commonModule,
    onBoardingModule,
    dashboardModule,
    addEntryModule,
    infoModule,
    learnModule,
    historyModule,
    settingsModule
)
