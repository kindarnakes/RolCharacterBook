package com.example.RolCharacterBook.view;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.RolCharacterBook.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EmptyTest {

    @Rule
    public ActivityTestRule<SplashScreen> mActivityTestRule = new ActivityTestRule<>(SplashScreen.class);

    @Test
    public void emptyTest() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.nameText), withText("Nombre"),
                        withParent(withParent(withId(R.id.name))),
                        isDisplayed()));
        editText.check(matches(withText("Nombre")));

        ViewInteraction textView = onView(
                allOf(withId(R.id.textinput_error), withText("Campo obligatorio"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        textView.check(matches(withText("Campo obligatorio")));

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.nameText), withText("Nombre"),
                        withParent(withParent(withId(R.id.name))),
                        isDisplayed()));
        editText2.check(matches(withText("Nombre")));

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.nameText),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.name),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText.perform(replaceText("t"), closeSoftKeyboard());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.textinput_error), withText("Campo obligatorio"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        textView2.check(matches(withText("Campo obligatorio")));

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.strengthText), withText("Fuerza"),
                        withParent(withParent(withId(R.id.strength))),
                        isDisplayed()));
        editText3.check(matches(withText("Fuerza")));

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.dexterityText), withText("Destreza"),
                        withParent(withParent(withId(R.id.dexterity))),
                        isDisplayed()));
        editText4.check(matches(withText("Destreza")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.textinput_error), withText("Campo obligatorio"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        textView3.check(matches(withText("Campo obligatorio")));

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.constitutionText), withText("Constitución"),
                        withParent(withParent(withId(R.id.constitution))),
                        isDisplayed()));
        editText5.check(matches(withText("Constitución")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.textinput_error), withText("Campo obligatorio"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        textView4.check(matches(withText("Campo obligatorio")));

        ViewInteraction editText6 = onView(
                allOf(withId(R.id.intelligenceText), withText("Inteligencia"),
                        withParent(withParent(withId(R.id.intelligence))),
                        isDisplayed()));
        editText6.check(matches(withText("Inteligencia")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.textinput_error), withText("Campo obligatorio"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        textView5.check(matches(withText("Campo obligatorio")));

        ViewInteraction editText7 = onView(
                allOf(withId(R.id.wisdomText), withText("Sabiduría"),
                        withParent(withParent(withId(R.id.wisdom))),
                        isDisplayed()));
        editText7.check(matches(withText("Sabiduría")));

        ViewInteraction editText8 = onView(
                allOf(withId(R.id.wisdomText), withText("Sabiduría"),
                        withParent(withParent(withId(R.id.wisdom))),
                        isDisplayed()));
        editText8.check(matches(withText("Sabiduría")));

        ViewInteraction editText9 = onView(
                allOf(withId(R.id.charismaText), withText("Carisma"),
                        withParent(withParent(withId(R.id.charisma))),
                        isDisplayed()));
        editText9.check(matches(withText("Carisma")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.textinput_error), withText("Campo obligatorio"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        textView6.check(matches(withText("Campo obligatorio")));

        ViewInteraction editText10 = onView(
                allOf(withId(R.id.emailText), withText("Email"),
                        withParent(withParent(withId(R.id.email))),
                        isDisplayed()));
        editText10.check(matches(withText("Email")));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.textinput_error), withText("Campo obligatorio"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        textView7.check(matches(withText("Campo obligatorio")));

        ViewInteraction editText11 = onView(
                allOf(withId(R.id.emailText), withText("Email"),
                        withParent(withParent(withId(R.id.email))),
                        isDisplayed()));
        editText11.check(matches(withText("Email")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
