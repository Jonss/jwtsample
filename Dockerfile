FROM openjdk:8-jdk-alpine

RUN mkdir /jwtsample

COPY build/libs/jwtsample-0.0.1-SNAPSHOT.jar /jwtsample/app.jar

WORKDIR /jwtsample

CMD ["sh", "-c", "java -Dspring.profiles.active=$JAVA_ENV -Djava.security.egd=file:/dev/./urandom -Xms128m -Xmx512m -jar app.jar"]