$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Features/logintest.feature");
formatter.feature({
  "line": 2,
  "name": "Mercury tour login",
  "description": "",
  "id": "mercury-tour-login",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smoke"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Login to mercury tour site",
  "description": "",
  "id": "mercury-tour-login;login-to-mercury-tour-site",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@TC01"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User opens the application with the URL",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User clicks on SignOn link",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "User inputs the valid user credentials",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "User clicks Submit button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Able to successfully load the page",
  "keyword": "Then "
});
formatter.match({
  "location": "Registration.user_opens_the_application_with_the_URL()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Registration.user_clicks_on_SignOn_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Registration.user_inputs_the_valid_user_credentials()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Registration.user_clicks_Submit_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Registration.able_to_successfully_load_the_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 13,
  "name": "Login to Agile project",
  "description": "",
  "id": "mercury-tour-login;login-to-agile-project",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 12,
      "name": "@TC02"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "user clicks on agile project link",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "user enters the \"\u003cusername\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "user gives the \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "click on login button",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "homepage is visible",
  "keyword": "Then "
});
formatter.examples({
  "line": 20,
  "name": "",
  "description": "",
  "id": "mercury-tour-login;login-to-agile-project;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 21,
      "id": "mercury-tour-login;login-to-agile-project;;1"
    },
    {
      "cells": [
        "1303",
        "Guru99"
      ],
      "line": 22,
      "id": "mercury-tour-login;login-to-agile-project;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 22,
  "name": "Login to Agile project",
  "description": "",
  "id": "mercury-tour-login;login-to-agile-project;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@smoke"
    },
    {
      "line": 12,
      "name": "@TC02"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "user clicks on agile project link",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "user enters the \"1303\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "user gives the \"Guru99\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "click on login button",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "homepage is visible",
  "keyword": "Then "
});
formatter.match({
  "location": "exerciseProject.user_clicks_on_agile_project_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1303",
      "offset": 17
    }
  ],
  "location": "exerciseProject.user_enters_the(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Guru99",
      "offset": 16
    }
  ],
  "location": "exerciseProject.user_gives_the(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "exerciseProject.click_on_login_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "exerciseProject.homepage_is_visible()"
});
formatter.result({
  "status": "skipped"
});
});