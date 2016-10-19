FROM fedora:23
MAINTAINER rubin.diego@gmail.com

RUN dnf install -y java-1.8.0-openjdk

# Copy application
RUN mkdir /packages
ADD api/target/monitor-api-*.jar /packages/api.jar
ADD eureka/target/monitor-eureka-*.jar /packages/eureka.jar
ADD worker/target/monitor-worker-*.jar /packages/worker.jar
ADD zuul/target/monitor-zuul-*.jar /packages/zuul.jar

