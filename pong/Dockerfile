# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="dilusha.withanage@gmail.com"

#Set app home folder
ENV APP_HOME /app
##Possibility to set JVM options (https://www.oracle.com/technetwork/java/javase/tech/vmoptions-jsp-140102.html)
#ENV JAVA_OPTS=""

# Add a volume pointing
# The effect is to create a temporary file on your host under "/var/lib/docker" and link it to the container under "/tmp".
VOLUME $APP_HOME/log
VOLUME $APP_HOME/config

ARG DEPENDENCY=build/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib $APP_HOME/lib
COPY ${DEPENDENCY}/META-INF $APP_HOME/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes $APP_HOME
COPY ${DEPENDENCY}/BOOT-INF/classes/templates/config $APP_HOME
ENTRYPOINT ["java", "-cp","app:app/lib/*","net.dilwit.springboot.docker.pong.PongApplication"]