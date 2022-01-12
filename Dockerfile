FROM openjdk:8u302-jdk as LAYERS_BUILD
WORKDIR application
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:8u302-jdk
WORKDIR application
EXPOSE 9999
COPY --from=LAYERS_BUILD application/dependencies/ ./
COPY --from=LAYERS_BUILD application/spring-boot-loader ./
COPY --from=LAYERS_BUILD application/snapshot-dependencies/ ./
COPY --from=LAYERS_BUILD application/application/ ./

COPY config/ ./config/
COPY newrelic/ ./newrelic/

ENTRYPOINT ["java", "-javaagent:./newrelic/newrelic.jar", "org.springframework.boot.loader.JarLauncher"]