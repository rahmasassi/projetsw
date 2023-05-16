FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
WORKDIR /opt
ENV PORT 8011
EXPOSE 8011
COPY target/*.jar /opt/consumer.jar
ENTRYPOINT exec java $JAVA_OPTS -jar consumer.jar