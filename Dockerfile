FROM openjdk:17

ENV PORT 7777
ENV DB_USERNAME "usertest"
ENV DB_PASSWORD "123456"
ENV DB_URL "jdbc:postgresql://host.docker.internal:5432/dictionary"
COPY target/catrina-0.0.1-SNAPSHOT.jar java-app.jar
ENTRYPOINT ["java", "-jar", "java-app.jar"]
#
#ENV PORT 7777
#ENV DB_USERNAME "usertest"
#ENV DB_PASSWORD "123456"
#ENV DB_URL "jdbc:postgresql://host.docker.internal:5432/dictionary"
#ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.ddg.catrina.CatrinaApplication"]





