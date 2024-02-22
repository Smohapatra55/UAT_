How to execute locally

applicationType=app
environment=qanext
execution.type=local
execution.mode=local

mvn clean test

/** How to open allure report **/

mvn allure:serve


Navigate to target folder -> UAT\target and open cmd and type below command -> 

allure generate --single-file --clean allure-results