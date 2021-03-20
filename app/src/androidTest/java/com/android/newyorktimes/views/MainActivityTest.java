package com.android.newyorktimes.views;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;

import com.android.newyorktimes.R;

import org.junit.Test;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityTest {

    @Test
    public void isActivityInView() {
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);
        Espresso.onView(withId(R.id.recycler_view))
                .check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.recycler_view))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void isVisible_RecyclerView() {

    }
}