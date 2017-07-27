# spring-boot-metrics-demo

This is a simple demo of a Spring Boot app with customer Actuators that can be used to send metrics using the Cloud Foundry Metrics Forwarder. as a spring boot app with actuators, the Java Buildpack 4+ will notice if the Metrics Forwarder service is bound to the app, and forward actuator metrics into the loggregator stream. Loggregator integrations like PCF Metrics 1.4+ can catch the metrics on the other side of the stream for storage, analytics, and more.

Example instructions:
* `mvnw install`
* `cf push APPNAME -p target/demo-0.0.1-SNAPSHOT.jar -b java_buildpack_offline_v4 --no-start`
* `cf create-service metrics-forwarder unlimited metrics-fowarder`
* `cf bind-service APPNAME metrics-forwarder`
* `cf start APPNAME`
* now go look in the loggregator stream or your metrics tool like PCF Metrics 1.4+ if you have it installed and you should see `counter.services.system.myservice.invoked`and `gauge.services.system.myservice.gauge`
