![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F.svg?style=for-the-badge&logo=Spring-Boot&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Git](https://img.shields.io/badge/git%20-%23F05033.svg?&style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)


# Склад носков
Приложение для автоматизации учёта носков на складе магазина. 
  
**Кладовщик** имеет возможность:

 <li> учесть приход носков;</li>
 <li> отпуск носков;</li>
 <li> узнать общее количество носков определенного цвета и состава в данный момент времени.</li>


**Для запуска нужно:**
1. Клонировать проект в среду разработки</li>
2. Настроить БД и прописать значения в файле **[application.properties](src/main/resources/application.properties)** 
3. Запустить метод **main** в файле **[SocksWarehouseApplication.java](/src/main/java/pro/sky/SocksWarehouseApplication.java)**


После этого вам будет доступен функционал на http://localhost:8080/swagger-ui/index.html#.

