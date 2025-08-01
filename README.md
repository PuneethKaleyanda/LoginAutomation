# 🧪 Janitri LoginAutomation – QA Internship Assignment

This project automates the login functionality of the **Janitri Dashboard** as part of a QA internship assignment. It includes both manual test cases and Selenium-based automation using Java.

---

## 📁 Folder Structure

LoginAutomation/
│
├── src/
│   ├── main/
│   │   └── java/com/janitri/qa/pages/LoginPage.java
│   └── test/
│       ├── java/com/janitri/qa/base/BaseTest.java
│       └── java/com/janitri/qa/tests/LoginTest.java
│
├── pom.xml
├── testng.xml
├── Janitri_Login_TestCases.xlsx ✅


---

## ✅ Task 1: Manual Test Cases

- File: `Janitri_Login_TestCases.xlsx`
- Includes:
  - Functional test cases
  - Negative test cases
  - UI test cases
  - Boundary value test cases
- ✅ Status and Actual Results are filled based on manual testing (invalid login scenarios).

---

## 🤖 Task 2: Automated Test Scenarios

### 🔧 Tech Stack:

- Java 11
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)

### 🧪 Automated Tests in `LoginTest.java`:

- `testLoginButtonDisabledWhenFieldAreEmpty()`
- `testPasswordMaskedbutton()`
- `testInvalidLoginShowErrorMsg()`

---

## 🚀 How to Run Tests

1. **Clone the repository:**
   ```bash
   git clone https://github.com/PuneethKaleyanda/LoginAutomation.git
   cd LoginAutomation
   Install dependencies:

   

2. **Install dependencies:**
mvn clean install

3. **Run tests using TestNG:**
mvn test

Test URL
https://dev-dash.janitri.in/


