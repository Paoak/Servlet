# Java Servlet Demo

Простейшая демонстрация сервлетов на Java с примерами обработки GET/POST-запросов, загрузки файлов и передачи данных на JSP.

## Структура проекта

Servlet/

├── src/

│ └── main/

│ └── java/

│ └── horsov/

│ ├── ForFileServlet.java

│ ├── ForJspServlet.java

│ ├── Main.java

│ └── User.java


## Описание классов

### `Main.java`
Сервлет по пути `/servlet`, демонстрирует:
- Переопределение методов `init`, `service`, `doGet`, `doPost`, `destroy`.
- Обработку параметров запроса и их вывод в теле ответа.
- Логгирование жизненного цикла сервлета.

### `ForFileServlet.java`
Сервлет по пути `/servlet-file`, демонстрирует:
- Обработку POST-запросов с `multipart/form-data`.
- Логгирование значения текстового поля `some-name`, если оно присутствует.
- Сохранение загружаемых файлов в папку `D:/prog/servletapp` с уникальными именами.

### `ForJspServlet.java`
Сервлет по пути `/jsp-serv`, демонстрирует:
- Создание списка пользователей (`User`).
- Передачу этого списка в JSP через `setAttribute`.
- Перенаправление на `first-jsp.jsp` (JSP-файл должен быть добавлен вручную в `webapp` или `resources`).

### `User.java`
Простой JavaBean, представляющий пользователя с полями:
- `name` (имя),
- `country` (страна),
- `age` (возраст).

## Требования

- Java 8+
- Servlet API (например, Apache Tomcat)
- Maven или Gradle (по желанию)
- JSP-файл `first-jsp.jsp` (если нужен пример с JSP)

## Запуск

1. Убедитесь, что вы используете сервер приложений, поддерживающий сервлеты (например, Apache Tomcat).
2. Скомпилируйте проект и соберите `.war` файл (если используете Maven/Gradle).
3. Разверните `.war` в папке `webapps` вашего сервера.
4. Примеры URL для тестирования:
   - `http://localhost:8080/app/servlet?param=test` — тест GET-запроса
   - `http://localhost:8080/app/servlet-file` — форма для загрузки файла
   - `http://localhost:8080/app/jsp-serv` — передача данных в JSP

## Примечания

- Путь `D:/prog/servletapp` должен существовать и быть доступен для записи. При необходимости можно изменить путь в аннотации `@MultipartConfig`.
- Для отправки данных на `/servlet-file` используйте HTML-форму с типом `multipart/form-data`. Поле `some-name` будет логгироваться как текст, остальные части будут сохранены как файлы.

## Пример формы для загрузки файла

```html
<form method="post" action="/app/servlet-file" enctype="multipart/form-data">
  <input type="text" name="some-name" placeholder="Введите имя"><br>
  <input type="file" name="file"><br>
  <button type="submit">Загрузить</button>
</form>
