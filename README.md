# marathon-client

This project is a Java library for communicating with Marathon API. At this point this library supports version v2 of Marathon API, please refer [docs](https://mesosphere.github.io/marathon/docs/rest-api.html) for more details.

## Using marathon-client in your maven project

Add marathon-client as a dependency:

```
<dependency>
  <groupId>mesosphere</groupId>
  <artifactId>marathon-client</artifactId>
  <version>0.2.0</version>
</dependency>

```

Add the following repository:

```
<repository>
   <id>downloads.mesosphere.com</id>
   <url>https://downloads.mesosphere.com/maven/</url>
</repository>

```

Please look at [releases](https://github.com/mesosphere/marathon-client/releases) page for more versions.

## Usage

### Initialization

The following piece of code initializes the client. ```MarathonClient.getInstance()``` method expects the endpoint for marathon:

```
String endpoint = "<Marathon's endpoint>";
Marathon marathon = MarathonClient.getInstance(endpoint);
```

### Getting all applications

The following will return all the applications that have been created:

```
GetAppsResponse appsResponse = marathon.getApps();
```

### Create a new application

The following example demonstrates how a new application can be created:
```
App app = new App();
app.setId("echohisleepbye-app");
app.setCmd("echo hi; sleep 10; echo bye;");
app.setCpus(1.0);
app.setMem(16.0);
app.setInstances(1);
marathon.createApp(app);
```

### Get details about an existing application

The following example, demostrates how to get details about an already created application:

```
GetAppResponse appGet = marathon.getApp("echohisleepbye-app");
```

### Delete an application

The following example demostrate, how one can delete an existing application:
```
marathon.deleteApp("echohisleepbye-app");
```

## Building

This project is built using [Apache Maven](http://maven.apache.org/).

Run the following command from the root of repository, to build the client JAR:

```
$ mvn clean install
```

## Bugs

Bugs can be reported using Github issues.
