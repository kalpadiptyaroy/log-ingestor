# How to use this log-ingestor

This is a simple Spring boot project backed by Postgres Database.

To run it in your system, make sure you have the following -
a. JDK 17
b. Maven
c. Postgres 15

If you have the above requirements, then close this repo and navigate to the project folder.
# Run Spring boot app using the following command
```
mvn spring-boot:run
```
OR you can use the maven wrapper
```
mvnw spring-boot:run
```

# How to feed log into the app?
Consider the following Postman snapshot

![image](https://github.com/kalpadiptyaroy/log-ingestor/assets/40118928/93dd652a-0bf5-43f2-bfe4-ea743a1fce08)

You need to replace port no. 8080 with 3000 - as this repository is used port 3000 and REST remains identical.

# How to query logs ?

I have created seperate endpoints for this. Note base url remains same `http://localhost:3000`.

1. `/searchByLevel` - Follow the screenshot below.
   We have to specify the parameter `level` in the form-data and its value as the partial or full search word
   ![image](https://github.com/kalpadiptyaroy/log-ingestor/assets/40118928/c2ac5c2e-7722-4fc2-bd2c-240f9ad9a167)

2. `/searchByMessage` - Form-data parameter name is `message`
3. `/searchByResourceId` - Form-data parameter name is `resourceId`
4. `/searchByTraceId` - Form-data parameter name is `traceId`
5. `/searchBySpanId ` - Form-data parameter name is `spanId`
6. `/searchByCommit` - Form-data parameter name is `commit`
7. `/searchByTimestamp` - Form-data parameter name is `from` and `to`
8. `/searchByMetadataParentResourceId` - Form-data parameter name is `parentResourceId`

Please follow the snap for the last query
![image](https://github.com/kalpadiptyaroy/log-ingestor/assets/40118928/4d425347-1795-47b0-98c6-e9ba4508a689)

All the above APIs are REST APIs and hence they can be integrated with any frontend app - on demand.
