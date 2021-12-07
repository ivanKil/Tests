package com.geekbrains.tests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTestFake : MainActivityEspressoTestBase() {


    @Test
    fun activitySearch_IsWorking() {
        onView(withId(R.id.searchEditText)).perform(click())
        onView(withId(R.id.searchEditText)).perform(
            replaceText("algol"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.searchEditText)).perform(pressImeActionButton())

        onView(withId(R.id.totalCountTextView)).check(matches(withText("Number of results: 42")))

    }
}
