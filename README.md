# Scout Boot - [Spring Boot](https://projects.spring.io/spring-boot/) & [Eclipse Scout](https://eclipse.org/scout/) Integration <img src="https://travis-ci.org/BSI-Business-Systems-Integration-AG/SpringBoot-and-EclipseScout.svg">

**Please Note**: This is work in progress and has not (yet) been tested for productive usage.

## Archetype

How to generate a minimal Scout Boot application:
<pre>

### Generate minimal Project from Archetype

mvn archetype:generate \   
-DarchetypeGroupId=org.eclipse.scout.boot \
-DarchetypeArtifactId=scout-boot-archetype-minimal \
-DarchetypeVersion=7.0.150.002 \
-DgroupId=com.bsiag.demo \
-DartifactId=minimal \
-Dversion=1.0-SNAPSHOT

cd minimal

### Build minimal Project with Maven and execute
mvn install eclipse:eclipse
java -jar target/minimal-\*.jar

### Generate standard Project from Archetype

mvn archetype:generate \
-B \
-DarchetypeGroupId=org.eclipse.scout.boot \
-DarchetypeArtifactId=scout-boot-archetype-standard  \
-DarchetypeVersion=7.0.150.002 \
-DgroupId=com.bsiag.demo  \
-DartifactId=tasks \
-Dversion=1.0-SNAPSHOT

cd tasks

### Build standard Project with Maven and execute
mvn clean package
java -jar target/tasks-\*.jar

## TODO
* Remove Eclipse Maven repositories when first 7.0.0 milestone is published to [Maven Central](https://mvnrepository.com/artifact/org.eclipse.scout.rt/org.eclipse.scout.rt.ui.html)
