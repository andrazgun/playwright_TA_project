# Playwright Java Test Automation Project

### Description
TBU

---

### Key Technologies:
- **[Java](https://docs.oracle.com/en/java/index.html)**: High-level, class-based, object-oriented programming language.
- **[Playwright](https://playwright.dev/java/)**: Automates browser interactions for functional testing.
- **[Cucumber-JVM](https://cucumber.io/)**: Enables Behavior-Driven Development (BDD) with readable feature files.
- **[Cucumber PicoContainer](https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-picocontainer)**: Dependency injection of step definition classes and their dependencies.
- **[Cucumber TestNG](https://cucumber.io/docs/guides/parallel-execution/#testng)**: Dependency for parallel test execution.
- **[Page Object Model](https://www.guru99.com/page-object-model-pom-page-factory-in-selenium.html)**: A design pattern to create object-oriented classes that serve as an interface to the pages of the application.
- **[Page Factory](https://www.lambdatest.com/blog/page-factory-in-selenium/)**: A design pattern to initialize and manage web elements.

### How To:
- Browsers supported: Firefox, Chromium and Webkit.
Execute tests in parallel:
1. Set in config.properties the desired browser (i.e. firefox, chromium, webkit) and the thread.count (<=3 ideally).
2. Set in RunCucumberTest the desired tags (i.e. @regression, @smoke, @yourCustomTag)

Execute tests individually:
1. To execute a feature file, right click on file > Run
2. To execute a scenario, right click on scenario > Run

Reports:
The report is generated if tests are executed from RunCucumberTest class
The view the test report, go to target\cucumber-reports.html, right click > Open In > Browser > Default.

CI/CD:
The framework is designed for integration with Jenkins and Github Actions:
Jenkins:
As prerequisite, Jenkins installed locally, Cucumber reports plugin installed, admin credentials.
Create a build job with parameters to execute tests and generate a report using command: mvn clean compile test -Dcucumber.filter.tags="(@%TAG% and (not @ignore))" -Ddataproviderthreadcount=%THREAD_COUNT% DBROWSER=%BROWSER%
Github Actions:
Each push or PR to master branch on Github will trigger a job executing the @smoke tests suite, on 2 threads, using Chromium.
After executing the test suite, the Cucumber report will be published to GitHub Pages.

### Disclaimer:
This project is developed for demonstration and educational purposes only.
It is not affiliated with or endorsed by any mentioned herein or other third party.
Use at your own discretion.

---

- Author: Andrei Gunta
- Java version: 17.0.5
- Maven 3.9.6



