# RESTFul-web-services-using-jersey
This project is implemented  using Jersey RESTful web services framework. It mainly implements HTTP Methods(GET, PUT, POST, DELETE) and helps one to understand working of RESTful web services. This project is built on employees datasource available on Git

Step to follow :- 
1. Install eclipse.
2. Create maven project using jersey-quickstart-webapp archetype.
3. Install Tomcat (I have worked on version 8.5.50 any latest can be installed to work on).
4. Right click on project and Go to configure build path -> targeted runtimes -> select apache tomcat -> click on apply and close.
5. Look for web.xml file for configuration.
6. jersey provides you MyResource.java to test your application before you start building your own.
7. In pom.xml uncomment jersey-media-json-binding to work with data binding using json format.
8. Install MySQL and create database employees (Follow https://github.com/datacharmer/test_db)
9. Test your application and understand the working using resource, repository and entity files.
10. I have used PostMan as a client to send requests to the server.
11. See RESTful Implementation.png file for better understanding of implementation.
