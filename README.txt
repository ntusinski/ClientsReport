Installation instructions:
1. Execute from MySQL console: create database CLIENTS_REPORT;
2. Run mvn clean install
3. Copy folder /target/ClientsReport into Tomcat's webapps directory
4. Run Tomcat
5. To view report: localhost:8080, to generate data: localhost:8080/generateData?clients=<numberOfClients>