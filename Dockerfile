FROM openjdk:11.0.7-jre-slim

ENV DEMO_ROOT=/root

ADD /student-impl/target/student-impl-0.0.1-SNAPSHOT.jar $DEMO_ROOT
WORKDIR ${DEMO_ROOT}

CMD  ["java", "-jar", "student-impl-0.0.1-SNAPSHOT.jar"]