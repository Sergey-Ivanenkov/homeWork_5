package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Selenide {

    @BeforeAll
    static void config() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }

    @Test
    void githubSelenideWiki(){
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(byLinkText("Soft assertions")).click();
        $(".markdown-body").scrollTo().shouldHave(text("Using JUnit5 extend test class"));
        $(withTagAndText("h4", "Using JUnit5 extend test class")).sibling(0).shouldHave(cssClass("highlight-source-java"));
    }
}
