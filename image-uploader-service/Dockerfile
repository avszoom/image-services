FROM openjdk:12
ENV JAR_NAME="image-uploader-service-1.0.jar"
ADD target/$JAR_NAME $JAR_NAME
ENTRYPOINT java -jar $JAR_NAME