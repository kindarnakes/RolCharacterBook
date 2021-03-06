package com.example.RolCharacterBook.view;


import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.RolCharacterBook.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SplashScreenTest2 {

    @Rule
    public ActivityTestRule<SplashScreen> mActivityTestRule = new ActivityTestRule<>(SplashScreen.class);

    @Test
    public void splashScreenTest2() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.characterName), withText("Hombre desconocido"),
                        withParent(withParent(withId(R.id.recycler))),
                        isDisplayed()));
        textView.check(matches(withText("Hombre desconocido")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.characterName), withText("Saulok"),
                        withParent(withParent(withId(R.id.recycler))),
                        isDisplayed()));
        textView2.check(matches(withText("Saulok")));
    }
}
