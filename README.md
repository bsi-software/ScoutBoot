# Scout Boot - [Spring Boot](https://projects.spring.io/spring-boot/) & [Eclipse Scout](https://eclipse.org/scout/) Integration <img src="https://travis-ci.org/boardend/SpringBoot-and-EclipseScout.svg">

**Please Note**: This is work in progress and has not (yet) been tested for productive usage.

## Archetype

How to generate a minimal Scout Boot application:
<pre>
# Generate project from archetype

mvn archetype:generate \   
-DarchetypeGroupId=org.eclipse.scout.boot \
-DarchetypeArtifactId=scout-boot-archetype-minimal \
-DarchetypeVersion=6.1.0-SNAPSHOT \
-DgroupId=scout.boot.example \
-DartifactId=minimal

cd minimal

# Build with Maven and execute
mvn install eclipse:eclipse
java -jar target/minimal-\*.jar

# Execute application inside Docker container
mvn clean install docker:build
docker run -p 8080:8080 scout.boot.example:minimal</pre>

## TODO
* Remove Eclipse Maven repositories when first 7.0.0 milestone is published to [Maven Central](https://mvnrepository.com/artifact/org.eclipse.scout.rt/org.eclipse.scout.rt.ui.html)
