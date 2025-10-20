FROM openjdk:11-jre-slim
COPY artifacts/aqa-shop.jar /app/aqa-shop.jar
WORKDIR /app
CMD ["java", "-jar", "aqa-shop.jar"]