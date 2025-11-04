Курсовой проект по модулю «Автоматизация тестирования» для профессии «Инженер по тестированию»
Курсовой проект — автоматизация тестирования комплексного сервиса, взаимодействующего с СУБД и API банка.

План автоматизации
Отчёт по итогам автоматизации

Начало работы:
Сделайте fork проекта на GitHub.
Перейдите в папку (директорию) на вашем компьютере, где будет храниться проект.
С помощью терминала, командной строки вашей операционной системы или консоли Git (ПКМ -> GitBash Here) откройте
выбранную вами директорию.
Склонируйте репозиторий с домашними заданиями с помощью команды git clone в открывшемся терминале или командной строке.
Перейдите в директорию склонированного репозитория.
Prerequisites
Для запуска необходимы следующие инструменты:

Git
IntelliJ IDEA
браузер Google Chrome
Docker Desktop
СУБД: Mysql 8 и PostgreSQL 15
Установка и запуск
Запустить Docker Desktop

Загрузить контейнеры mysql в терминале IDEA командой

docker-compose up

Запуск SUT и тестов с MySQL
3.1. Запустить .jar-файл с MySQL:

java -jar artifacts/aqa-shop.jar -Dspring.datasource.url=jdbc:mysql://localhost:3306/app

3.2. Запустить автотесты с MySQL:

./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app" "-Ddb.user=app" "-Ddb.password=pass"

Запуск SUT и тестов с PostgreSQL

4.1. Запустить .jar-файл с PostgreSQL:

java -jar artifacts/aqa-shop.jar -Dspring.datasource.url=jdbc:postgresql://localhost:5432/app

4.2. Запустить автотесты с PostgreSQL:

./gradlew clean test "-Pdb.url=jdbc:mysql://localhost:3306/app" "-Pdb.user=app" "-Pdb.password=pass"

В браузере открыть SUT в окне с адресом:

http://localhost:8080/

6.Остановить SUT командой CTRL + C 
7.Остановить контейнеры командой CTRL + C и после удалить контейнеры командой

`docker-compose down`
Посмотреть отчёт о проведённом тестировании:

./gradlew allureServe