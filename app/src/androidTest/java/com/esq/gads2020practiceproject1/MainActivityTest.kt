package com.esq.gads2020practiceproject1

import androidx.test.espresso.Espresso.onView
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun swipeTabs(){
        onView(withId(R.id.tabs)).perform(swipeRight())
        onView(withId(R.id.tabs)).perform(swipeLeft())
    }

}