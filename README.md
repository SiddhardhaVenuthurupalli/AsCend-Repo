# AsCend-Repo
This repository is created to help host projects which are developed as part of ascend programme
# Microservices 
This project uses Spring Boot Microservices to print a random text message using a Service Registry(Eureka) from Pivotal Cloud Foundry. Project was first tested locally to check if it gives the desired results. Project was then pushed to PCF using CF CLI where it was deployed in a particular space consuming 1GB.

# Steps for CF CLI installation
Please visit the site https://pivotal.io/platform/pcf-tutorials/getting-started-with-pivotal-cloud-foundry/introduction. Download CF CLI for Windows 64 bit and install the same. Check for installation using the commands : cf help -a or cf version. Register with pivotal to create a free account and login. You can create your own org and space. In your windows cmd,login to CF through CLI using cf login command. API endpoint: https://api.run.pivotal.io. Provide your credentials.

# CF CLI commands for PCF
cf apps : shows various apps available in that space

cf push PCF app name -p target jar to be pushed eg:cf push Hello2929 -p ProductManagementSystem-0.0.1-SNAPSHOT.jar

cf delete -r appname : removes an application from a given PCF space

# Microservices Circuit Breaker(Hystrix) - Fall Back Method
In this project, to fulfill a client request, one microservice may need to talk to other microservices. We should minimize this kind of direct dependencies on other microservices, but in some cases, it is unavoidable. If a microservice is down or not functioning properly then the issue may cascade up to the upstream services. Netflix created Hystrix library implementing the Circuit Breaker pattern to address these kinds of issues. We can use Spring Cloud Netflix Hystrix Circuit Breaker to protect microservices from cascading failures.

In this post, we are going to learn:
Implementing Circuit Breaker pattern using @HystrixCommand
How to propagate ThreadLocal variables
Monitoring Circuit Breakers using Hystrix Dashboard
