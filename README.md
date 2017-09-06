# marathon-client

This project is a Java library for communicating with Marathon API. At this point this library supports version v2 of Marathon API, please refer to the [docs](https://mesosphere.github.io/marathon/docs/rest-api.html) for more details.

## Using marathon-client in your maven project

Add marathon-client as a dependency:

For Marathon v1.x:

```
<dependency>
  <groupId>com.mesosphere</groupId>
  <artifactId>marathon-client</artifactId>
  <version>0.6.0</version>
</dependency>
```

For Marathon v0.x:

```
<dependency>
  <groupId>com.mesosphere</groupId>
  <artifactId>marathon-client</artifactId>
  <version>0.2.1</version>
</dependency>
```

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

## Debugging / Logging

Feign is used as the underlying REST library.  Sometimes it is useful to see the low level JSON and responses.   It is possible to setup debug without directed to stdout or to a log file.
This is simplified by set the environment variable `DEBUG_JSON_OUTPUT` to either a file name `debug.log` or to `System.out`.


## Bugs

Bugs can be reported using Github issues.
