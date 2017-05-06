#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#macro( ccase $str )
#foreach( $word in $artifactId.split('-') )$word.substring(0,1).toUpperCase()$word.substring(1)#end
#end
#set( $classNamePrefix = "#ccase( $artifactId )" )
FROM openjdk:8-jdk

COPY target/${artifactId}-${version}.jar /opt/${artifactId}-${version}.jar

EXPOSE 8080

CMD ["java", "-jar", "/opt/${artifactId}-${version}.jar"]
