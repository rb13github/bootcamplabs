FROM openjdk:latest
COPY Bootcampexercise1-0.0.1-SNAPSHOT.jar Bootcampexercise1-0.0.1-SNAPSHOT.jar
EXPOSE 8091
ENV EUREKA_DISCOVERY_SERVER_URL=http://localhost:8761/eureka
ENV ZIPKIN_BASE_URL=http://localhost:9410
ENTRYPOINT ["java","-jar","Bootcampexercise1-0.0.1-SNAPSHOT.jar"]