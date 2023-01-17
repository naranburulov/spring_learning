#baseimage                      / it has to be in every docker file
FROM openjdk:17-jdk

# get jar file and copy/paste to the container
COPY ./target/Spring-24-Docker-0.0.1-SNAPSHOT.jar  /usr/app/
#to set the directory for execution
WORKDIR /usr/app

#will provide exacutable application when container is run
ENTRYPOINT ["java","-jar","Spring-24-Docker-0.0.1-SNAPSHOT.jar"]