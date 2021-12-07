package com.geekbrains.tests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.core.IsNot.not
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTestReal : MainActivityEspressoTestBase() {

    @Test
    fun activitySearch_IsWorking() {
        onView(withId(R.id.searchEditText)).perform(click())
        onView(withId(R.id.searchEditText)).perform(
            replaceText("algol"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.searchEditText)).perform(pressImeActionButton())

        onView(isRoot()).perform(delay())
        onView(withId(R.id.totalCountTextView)).check(matches(withText("Number of results: 2692")))

    }

    @Test
    fun progressBar_IsDisplayed() {
        onView(withId(R.id.searchEditText)).perform(click())
        onView(withId(R.id.searchEditText)).perform(
            replaceText("algol"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.searchEditText)).perform(pressImeActionButton())
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()))
        onView(isRoot()).perform(delay())
        onView(withId(R.id.progressBar)).check(matches(not(isDisplayed())))
    }
}
