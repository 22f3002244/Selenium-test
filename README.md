# 🚀 Selenium TestNG Demo

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.java.net/)
[![Maven](https://img.shields.io/badge/Maven-3.6%2B-blue.svg)](https://maven.apache.org/)
[![TestNG](https://img.shields.io/badge/TestNG-7.10.2-green.svg)](https://testng.org/)
[![Selenium](https://img.shields.io/badge/Selenium-4.25.0-purple.svg)](https://www.selenium.dev/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A comprehensive Selenium WebDriver automation testing project using TestNG framework with Maven build system. This project demonstrates web automation testing best practices with real-world examples.

## 📋 Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Quick Start](#quick-start)
- [Project Structure](#project-structure)
- [Test Examples](#test-examples)
- [Running Tests](#running-tests)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [License](#license)

## ✨ Features

- **Amazon Product Search** - Automated product search and data extraction
- **WebDriverManager Integration** - Automatic browser driver management
- **TestNG Framework** - Advanced testing with parallel execution support
- **Maven Build System** - Dependency management and build automation
- **Cross-browser Testing Ready** - Easy configuration for multiple browsers
- **Comprehensive Reporting** - Detailed HTML and XML test reports

## 🛠 Prerequisites

- **Java JDK 21** or compatible version
- **Maven 3.6+** for build automation
- **Chrome Browser** (latest stable version recommended)
- **Git** for version control

## 🚀 Quick Start

### 1. Clone the Repository
```bash
git clone https://github.com/HumayunK01/Selenium-test.git
cd Selenium-test
```

### 2. Build the Project
```bash
mvn clean compile
```

### 3. Run Tests
```bash
mvn test
```

### 4. View Test Reports
```bash
# Open the generated HTML report
open target/surefire-reports/index.html
```

---


## 📁 Project Structure

```
Selenium-test/
├── src/
│   ├── main/java/com/selenium/
│   │   └── App.java                    # Main application class
│   └── test/java/com/selenium/
│       └── AmazonSearchTest.java       # Amazon product search test
├── .gitignore                          # Git ignore rules
├── pom.xml                            # Maven configuration
├── testng.xml                         # TestNG suite configuration
└── README.md                          # Project documentation
```

## 🧪 Test Examples

### Amazon Product Search Test

This test demonstrates automated web scraping and data extraction from Amazon India. It searches for "laptop" and extracts product information.

```java
package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class AmazonSearchTest {

    @Test
    public void searchAmazonProduct() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Navigate to Amazon India
            driver.get("https://www.amazon.in/");

            // Wait for page to load
            Thread.sleep(1000);

            // Locate and use search box
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("laptop" + Keys.ENTER);

            // Wait for search results
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.s-main-slot")));

            // Extract first 5 product titles
            List<WebElement> productTitles = driver.findElements(
                By.cssSelector("span.a-size-medium.a-color-base.a-text-normal")
            );

            for (int i = 0; i < Math.min(5, productTitles.size()); i++) {
                System.out.println(productTitles.get(i).getText());
            }

        } catch (Exception e) {
            Reporter.log("Exception caught: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
```

## 🏃 Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Test Class
```bash
mvn test -Dtest=AmazonSearchTest
```

### Run with Specific Browser
```bash
# The project uses WebDriverManager for automatic driver management
# No manual driver setup required!
mvn test
```

### Generate Test Reports
```bash
# HTML Report (opens automatically after test execution)
open target/surefire-reports/index.html

# XML Reports
ls target/surefire-reports/*.xml
```

## ⚙️ Configuration

### TestNG Suite Configuration (`testng.xml`)
```xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Amazon Suite">
    <test name="Amazon Search Test">
        <classes>
            <class name="com.selenium.AmazonSearchTest"/>
        </classes>
    </test>
</suite>
```

### Maven Dependencies (`pom.xml`)
- **Selenium WebDriver 4.25.0** - Browser automation
- **TestNG 7.10.2** - Testing framework
- **WebDriverManager 5.6.2** - Automatic driver management
- **Maven Surefire Plugin 3.1.2** - Test execution

## 🐛 Troubleshooting

### Common Issues

**1. ChromeDriver Issues**
```bash
# The project uses WebDriverManager - no manual setup needed
# If you encounter issues, try:
mvn clean test
```

**2. Browser Not Found**
- Ensure Chrome browser is installed
- Check Chrome version compatibility
- WebDriverManager will automatically download the correct driver

**3. Test Failures**
- Check network connectivity for Amazon access
- Verify element selectors are up-to-date
- Check browser console for JavaScript errors

### Debug Mode
```bash
# Run tests in debug mode
mvn test -Dmaven.surefire.debug

# Enable verbose logging
mvn test -X
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Contribution Guidelines
- Follow Java coding standards
- Add tests for new features
- Update documentation as needed
- Ensure all tests pass before submitting PR

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- [Selenium WebDriver](https://www.selenium.dev/) - Browser automation framework
- [TestNG](https://testng.org/) - Testing framework
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) - Driver management library
- [Amazon India](https://www.amazon.in/) - Test website

## 📞 Support

For questions or support:
- Create an issue in the repository
- Check existing issues for similar problems
- Review the troubleshooting section above

---

**Happy Testing!** 🚀
