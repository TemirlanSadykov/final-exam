# Final-exam

### При разрабобтке используется

* java version "11.0.2"
* javac 11.0.2
* Sring Boot 2.3.0.RELEASE
* MySQL Workbench 8.0
* IntelliJ IDEA 2019.3.3 (Ultimate Edition)
* Apache Maven 3.6.1

### Инструкция по разворчиванию окружения

Открыть коммандную строку с помощью горяих клавиш:
win+R. Указать путь к нужной вам папке и написать:
```
git clone https://github.com/TemirlanSadykov/final-exam.git
```

Открыть с помощью IntelliJ IDEA

В файле application.properties в местах где скобки указать данные от своей бд.

```
spring.datasource.url=jdbc:mysql://localhost:3306/final?serverTimezone=UTC
spring.datasource.username={root}
spring.datasource.password={20tem04}
```
Открыть MySQL и создать базу данных - final. Сделать Import Changes.
Запустить проект. Картинки лежат в папку src/main/resources/static/images/

## Собрано с помощью

* [Maven](https://maven.apache.org/) - Dependency Management

## Автор

* https://github.com/TemirlanSadykov

