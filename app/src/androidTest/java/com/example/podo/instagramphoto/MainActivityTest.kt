package com.example.podo.instagramphoto

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.podo.instagramphoto.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkContainerIsDisplayed() {
        onView(withId(R.id.container))
            .check(matches(isDisplayed()))
    }

    @Test
    fun clickOnBottomBar() {
        onView(withId(R.id.bottom_nav))
            .perform(click())
            .check(matches(isDisplayed()))
    }

}