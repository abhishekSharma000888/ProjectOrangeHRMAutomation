# OrangeHRM Selenium Automation Project
This project automates the login functionality and related flows of the OrangeHRM application using Selenium WebDriver and TestNG following the Page Object Model (POM) design pattern.

✅ Positive Test Scenarios (Valid Cases)
#	Test Scenario	Description
1	Valid Login	Enter correct username and password → User should land on the dashboard.
2	Login with 'Tab' Navigation	Enter username → Press Tab key → Enter password → Click Login → Successful login.
3	Logout and Re-login	Login → Logout → Login again → Dashboard should be accessible again.
4	Login, Perform Activity and Logout	Login → Navigate to 'My Info' → Validate Personal Details → Logout.

❌ Negative Test Scenarios (Invalid Cases)
#	Test Scenario	Description
1	Invalid Username	Enter incorrect username with correct password → Should show "Invalid credentials" message.
2	Invalid Password	Enter correct username with incorrect password → Should show "Invalid credentials" message.