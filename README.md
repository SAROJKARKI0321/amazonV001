# 🛒 Amazon Automation Project

This project is an automated testing suite for [Amazon.com](https://www.amazon.com) using **Selenium WebDriver** in Java. It automates key user flows like login, product search, and adding items to the cart. The suite is scalable and includes basic parallel execution using Docker.

---

## ✅ Features

- 🔐 **Login Test** – Automates the login process on Amazon
- 🔎 **Product Search Test** – Searches for specified items
- 🛒 **Add to Cart Test** – Adds selected product to the cart
- 🔁 **Home UI Reset Test** – Refreshes homepage in case Amazon shows dynamic variant UIs
- ❌ **Price Slider Test** – *(Currently unstable due to UI issues – under development)*

---

## 🛠️ Tech Stack

| Tool         | Description                     |
|--------------|---------------------------------|
| Java         | Programming Language            |
| Selenium     | Web Automation Framework        |
| TestNG       | Testing Framework               |
| Maven        | Build Tool                      |
| IntelliJ IDEA| IDE                             |
| Docker       | Parallel Testing Setup (2 Chrome Nodes) |

---

## 🧪 Test Execution

### Clone the Repository

```bash
git clone https://github.com/SAROJKARKI0321/amazonV001.git
cd amazonV001
```
### Run Tests
You can run tests from the terminal using:
```bash
mvn test run
```
### Docker (Parallel Execution)
This project includes a Docker configuration to run tests in parallel using Selenium Grid with 2 Chrome nodes.

Make sure Docker is installed and running:
```bash
docker-compose up -d
```

## ⚠️ Known Issues
-🧩 Amazon CAPTCHA / Puzzle Verification
If Amazon prompts a puzzle or CAPTCHA, the test waits 15 seconds so you can solve it manually.

-🔁 Homepage Variation Handling
Amazon may sometimes serve a different homepage UI. A refresh is triggered at the beginning of every suite to normalize the layout.

-🎚️ Price Slider Test Fails
Amazon’s price filter slider behaves inconsistently and the related test is currently unstable
