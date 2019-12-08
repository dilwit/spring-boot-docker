#### Docker Commands
 prune -> docker system prune -a
        image -> is the template
         - docker images or docker image ls
         - docker image rm -f <image-name>
        container -> is the instance
         - docker container ls OR docker ps
         - docker container kill [container id]

        - docker push <tag>
	- Cheat sheet -> https://www.digitalocean.com/community/tutorials/how-to-remove-docker-images-containers-and-volumes

#### DockerFile
// Ref: https://spring.io/guides/gs/spring-boot-docker/
// Ref: https://spring.io/guides/topicals/spring-boot-docker
// https://thepracticaldeveloper.com/2017/12/11/dockerize-spring-boot/#Building_a_Spring_Boot_app_using_Docker
// And then https://docs.docker.com/get-started/ to get started with docker
# Build With standard DockerFile:

        ./mvnw clean install -DskipTests
        docker build -t dilwit/spring-boot-docker/ping .
        OR
        ./mvnw install dockerfile:build
	OR
        ./gradlew clean build -x test
        docker build --build-arg JAR_FILE=build/libs/*.jar -t dilwit/spring-boot-docker/pong .

        docker run -p 8089:8080 -t dilwit/spring-boot-docker/ping
        [tomcat stared on port 8080 within the container but mapped 8089 to the host]
        curl http://localhost:8089

        # With spring profile
        docker run -e "SPRING_PROFILES_ACTIVE=stg" -p 8089:8080 -t dilwit/spring-boot-docker/ping

#### DockerCompose depends on docker-compose.yml
- help you run multiple containers
- define how they are connected
- how many istances
- ...

mvnw install or gradle build
docker-compose build
docker-compose up
docker-compose down
docker-compose ps

curl http://localhost:<port via ps command>

docker-compose up --scale dilwit/spring-boot-docker/ping=[number_of_instances]


#### Dockerfile-build
https://thepracticaldeveloper.com/2017/12/11/dockerize-spring-boot/#Building_a_Spring_Boot_app_using_Docker
so that you do not have build env locally, it is managed by docker (works well in ci pipeline)
docker-compose build




TODO:


        # Debug container -> this did not work for me
        extract agentlib details from intellij run configs
        docker run -e "JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,server=n,address=dilushas-mbp:5005,suspend=y,onthrow=<FQ exception class name>,onuncaught=<y/n>" -p 8089:8080 -p 5005:5005 -t dilwit/spring-boot-docker

        # Push local image to docker repo
        docker login (With dockerId, not email address)
        docker tag dilwit/spring-boot-docker dilwit/spring-boot-docker:0.0.1-SNAPSHOT (docker tag image username/repository:tag)
        docker push dilwit/spring-boot-docker:0.0.1-SNAPSHOT

        # Spring cloud applications in docker -> This will be on spring library application


        # With spring specific DockerFile -> (Im not yet sure about the value of this)

     */
