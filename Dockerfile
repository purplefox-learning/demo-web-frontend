FROM artifactory.global.standardchartered.com/edmi/edmi-java-base-image:latest

ARG artifactVersion=1.0.0-SNAPSHOT

EXPOSE 8080

RUN mkdir -p /opt/app/edmi-kube-demo-frontend/tmp
WORKDIR /opt/app/edmi-kube-demo-frontend

RUN chmod -R 777 .

RUN useradd -ms /bin/bash edmi-kube-demo-frontend
USER edmi-kube-demo-frontend

ENV JAVA_OPTS='-Djava.io.tmpdir=./tmp'

COPY build/libs/edmi-kube-demo-frontend-${artifactVersion}-exec.jar edmi-kube-demo-frontend-exec.jar

ENTRYPOINT exec java $JAVA_OPTS -jar edmi-kube-demo-frontend-exec.jar