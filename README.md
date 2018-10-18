# Scout Boot - [Spring Boot](https://projects.spring.io/spring-boot/) & [Eclipse Scout](https://eclipse.org/scout/) Integration <img src="https://travis-ci.org/BSI-Business-Systems-Integration-AG/SpringBoot-and-EclipseScout.svg">

**Please Note**: This is only a proof of concept and has not been tested for productive usage nor is there any support available from the scout contributors.

There are currently no plans to publish the modules to Maven Central.

## Initialize Modules

Before you can use any archetypes you need to build the scout-boot modules and the archetypes. To do this change into the ScoutBoot project folder and run Maven.

```
mvn clean install
```

## Archetype

How to generate a minimal Scout Boot application:

### Generate minimal Project from Archetype

```
mvn archetype:generate \   
-DarchetypeGroupId=org.eclipse.scout.boot \
-DarchetypeArtifactId=scout-boot-archetype-minimal \
-DarchetypeVersion=7.0.150.002 \
-DgroupId=com.bsiag.demo \
-DartifactId=minimal \
-Dversion=1.0-SNAPSHOT
```

```
cd minimal
```

### Build minimal Project with Maven and execute

```
mvn install eclipse:eclipse
java -jar target/minimal-\*.jar
```

### Generate standard Project from Archetype

After building the scout-boot modules and the archetypes (see above) use the standard archetype to create a simple *Tasks Application*.

```
mvn archetype:generate \
-B \
-DarchetypeGroupId=org.eclipse.scout.boot \
-DarchetypeArtifactId=scout-boot-archetype-standard  \
-DarchetypeVersion=7.0.150.002 \
-DgroupId=com.bsiag.demo  \
-DartifactId=tasks \
-Dversion=1.0-SNAPSHOT
```

```
cd tasks
```

### Build standard Project with Maven and execute

```
mvn clean package
java -jar target/tasks-1.0-SNAPSHOT.jar
```

### Play with the Application

In your browser change to [localhost](http://localhost:8080). This starts the UI of the Tasks application. To log in you may use any of the following pre-created users (user/password) below.

* root/eclipse
* alice/test
* bob/test

In case your user has rights to access the aAPI of the pplications API (log in with root/eclipse to check for this) you can also access the business objects (tasks) via REST.

* [http://localhost:8080/api/tasks/today](http://localhost:8080/api/tasks/today)
* [http://localhost:8080/api/tasks/all](http://localhost:8080/api/tasks/all)

Remark: In order to see any tasks you have to enter some of them first in the UI of the application.

## TODO
* Remove Eclipse Maven repositories when first 7.0.0 milestone is published to [Maven Central](https://mvnrepository.com/artifact/org.eclipse.scout.rt/org.eclipse.scout.rt.ui.html)
