package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class SearchWikiTests extends TestBase {

    @Test
    @Tag("android")
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
        @Tag("android")
        void checkButtonLogIn() {
            step("Click on the NavBar Menu button", () -> {
                $(id("org.wikipedia.alpha:id/menu_overflow_button")).click();
            });
            step("Check button log in", () -> {
                $(id("org.wikipedia.alpha:id/explore_overflow_account_name")).shouldHave(text("Log in to Wikipedia"));
                $(id("org.wikipedia.alpha:id/explore_overflow_account_name")).click();
            });

            step("Check text on button at login form", () -> {
                $(id("org.wikipedia.alpha:id/login_button")).shouldHave(text("Log in"));
            });
        }
}
