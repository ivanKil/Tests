package com.geekbrains.tests

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geekbrains.tests.view.search.MainActivity
import junit.framework.TestCase
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class MainActivityEspressoTestBase {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun activity_AssertNotNull() {
        scenario.onActivity {
            TestCase.assertNotNull(it)
        }
    }

    @Test
    fun activity_IsResumed() {
        TestCase.assertEquals(Lifecycle.State.RESUMED, scenario.state)
    }

    fun delay(): ViewAction? {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> = isRoot()
            override fun getDescription(): String = "wait for $2 seconds"
            override fun perform(uiController: UiController, v: View?) {
                uiController.loopMainThreadForAtLeast(2000)
            }
        }
    }

    @Test
    fun searchEditText_IsDisplayed() {
        onView(withId(R.id.searchEditText)).check(matches(isDisplayed()))
    }

    @Test
    fun toDetailsActivityButton_IsDisplayed() {
        onView(withId(R.id.toDetailsActivityButton)).check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun progressBar_IsNotDisplayedInit() {
        onView(withId(R.id.progressBar)).check(matches(not(isDisplayed())))
    }

    @Test
    fun toDetailsActivityButton_CheckText() {
        onView(withId(R.id.toDetailsActivityButton)).check(matches(withText(R.string.to_details)))
    }

    @Test
    fun searchEditText_InitText() {
        onView(withId(R.id.searchEditText)).check(matches(withText("")))
    }

    @Test
    fun totalCountTextView_IsNotDisplayed() {
        onView(withId(R.id.totalCountTextView)).check(matches(not(isDisplayed())))
    }

    @Test
    fun searchEditText_CheckPrintedText() {
        val assertion = matches(withText("asd"))
        onView(withId(R.id.searchEditText)).perform(
            ViewActions.replaceText("asd"),
            ViewActions.closeSoftKeyboard()
        ).check(assertion)
    }

    @After
    fun close() {
        scenario.close()
    }
}
