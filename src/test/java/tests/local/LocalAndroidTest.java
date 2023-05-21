package tests.local;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class LocalAndroidTest extends TestBase {

    @Tag("android_emulator")
    @Test
    void successfulSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $(id("org.wikipedia.alpha:id/view_card_header_title"))
                        .click());
        step("Check error text", () -> {
            $(id("org.wikipedia.alpha:id/view_wiki_error_text")).shouldBe(visible);
        });

    }

    @Test
    @Tag("android_emulator")
    void onboardingScreenApp() {
        step("Open App", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia")));

    }

    @Test
    @Tag("android_emulator")
    void continueOnboardingScreen() {
        step("Go to the second page", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());
        step("Проверка текста", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore")));
    }

    @Test
    @Tag("android_emulator")
    void thirdContinueOnboardingScreen() {
        step("Go to the third page", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверка текста", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Reading lists with sync")));
    }

    @Test
    @Tag("android_emulator")
    void fourthContinueOnboardingScreen() {
        step("Go to the fourth page", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверка текста", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Send anonymous data")));
    }
}
