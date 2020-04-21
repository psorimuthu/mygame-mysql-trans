FROM openjdk:8
ADD target/padh2sb.jar padh2sb.jar
EXPOSE 8081
ENTRYPOINT [ "java","-jar","padh2sb.jar" ]