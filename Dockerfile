FROM openjdk:22-jdk
ADD target/UserModule.jar UserModule.jar
ENTRYPOINT [ "java", "-jar", "/UserModule.jar" ]