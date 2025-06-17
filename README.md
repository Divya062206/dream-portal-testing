# Dream Portal – Automated UI Tests  
**Wingify QA Internship Assignment – Divya S Lokesh**

Automated functional tests for the *Dream Portal* demo site  
<https://arjitnigam.github.io/myDreams/>  
implemented with **Java 17 · Maven · Selenium 4 · TestNG** using the **Page Object Model (POM)** pattern.

---

## 📋 Table of Contents
1. [Tech Stack](#tech-stack)  
2. [Project Structure](#project-structure)  
3. [Prerequisites](#prerequisites)  
4. [Setup & Execution](#setup--execution)  
5. [Test Coverage](#test-coverage)  
6. [Reports](#reports)  
7. [AI Validation (Bonus)](#ai-validation-bonus)  
8. [Contributing & Contact](#contributing--contact)

---

## Tech Stack
| Layer | Library / Tool | Notes |
|-------|----------------|-------|
| UI automation | **Selenium 4.18.1** | Chrome / Edge via WebDriverManager |
| Test runner   | **TestNG 7.8.0** | Parallel execution enabled |
| Build         | **Maven 3.9.x** | Surefire + Allure adaptors |
| Reporting     | **Allure** HTML reports | `target/allure-report` |
| Optional AI   | **OpenAI Java SDK** | Categorise dream names (Good / Bad) |

---

## Project Structure
src
├── main/java (shared utilities)
└── test/java
├── pages/ (POM classes)
├── tests/ (TestNG test classes)
└── utils/ (AI helper, driver factory)
pom.xml
testng.xml

---

## Prerequisites
* **Java 17 +** in `PATH`
* **Maven 3.8+**
* **Chrome** or **Edge** browser installed  
  (Drivers auto‑managed by WebDriverManager)

---

## Setup & Execution

```bash
# 1. Clone (already done privately)
git clone https://github.com/Divya062206/dream-portal-testing.git
cd dream-portal-testing

# 2. Run all tests & generate Surefire + Allure results
mvn clean test

# 3. View Allure HTML report locally
mvn allure:report

---
Run a specific suite or class:
mvn -DsuiteXmlFile=testng.xml test
mvn -Dtest=IndexPageTest test            # single class

---
Test Coverage
Page / Feature	        Assertions Implemented
index.html (Home)	Loading animation hides in ~3 s · “My Dreams” button visible · link opens both target pages in new tabs
dreams-diary.html	Exactly 10 rows · only “Good/Bad” values · no cell empty
dreams-total.html	Good = 6 · Bad = 4 · Total = 10 · Recurring = 2 (Flying over mountains, Lost in maze)
Cross‑page navigation	Tabs open correctly · titles verified
Bonus AI (optional)	OpenAI classification of each dream name vs table value

---
Reports
Surefire: target/surefire-reports/*.xml

Allure: target/allure-report/index.html – contains screenshots for failed steps.

---
AI Validation (Bonus)
utils/OpenAIClassifier.java sends each dream name to GPT‑3.5‐turbo (or local model) and returns a Good/Bad label.

Test compares AI output with the site’s value and flags mismatches.

---
Contributing & Contact
Created by Divya S Lokesh for Wingify QA Internship.
GitHub access already granted to user qawingify.

---
