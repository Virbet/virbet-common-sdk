<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
</head>
<body>

<h1>RetrofitInterfaceMain</h1>

<p>Интерфейс <code>RetrofitInterfaceMain</code> содержит объявления методов для взаимодействия с удаленным сервером
посредством библиотеки Retrofit в контексте основных операций приложения.</p>

<h2>Метод `generateAnonymousIDKey`</h2>

<p>Метод выполняет GET-запрос для получения ID ключа, предназначенного для анонимного входа в систему.</p>

<h3>Параметры:</h3>

<ul>
  <li><code>requestId</code>: Строка (по умолчанию генерируется случайным образом) - Идентификатор запроса, предотвращающий холостой выпуск ключей.</li>
</ul>

<h3>Возвращаемое значение:</h3>

Объект типа <code>Call<KtorResponse<KtorIdKeyRelease>></code>, представляющий асинхронный результат запроса.

<h3>Примеры использования:</h3>

<pre><code>requestIdKey() // Возвращает ID ключа, например, "JHGKHJDGKJHG"</code></pre>
<pre><code>requestIdKey("AnyString") // Возвращает ID ключа, например, "JHGKHJDGKJHG"</code></pre>

#### CURL
```bash
curl -X GET "https://example.com/auth/requestIdKey?requestId=your_request_id" \
  -H "Content-Type: application/json;charset=UTF-8"
```

<hr>

<h2>Метод `login`</h2>

<p>Метод выполняет POST-запрос для входа в систему через ключ ID или с использованием данных для входа.</p>

<h3>Параметры:</h3>

<ul>
  <li><code>body</code>: Строка (для метода через ключ ID) или объект типа <code>KtorLoginUser</code> (для метода с данными входа) - Тело запроса.</li>
</ul>

<h3>Возвращаемое значение:</h3>

Объект типа <code>Call<KtorResponse<KtorLoginInUser>></code>, представляющий асинхронный результат запроса.


#### CURL
```bash
curl -X POST "https://example.com/auth/internal/loginThoughIDKey" \
  -H "Content-Type: application/json;charset=UTF-8" \
  -d "your_request_body_here"
```

<hr>

<h2>Метод `signup`</h2>

<p>Метод выполняет POST-запрос для регистрации нового пользователя.</p>

<h3>Параметры:</h3>

<ul>
  <li><code>body</code>: Объект типа <code>KtorCreateUser</code> - Данные для регистрации пользователя.</li>
</ul>

<h3>Возвращаемое значение:</h3>

Объект типа <code>Call<KtorResponse<KtorCreatedUser>></code>, представляющий асинхронный результат запроса.

#### CURL
```bash
curl -X POST "https://example.com/auth/internal/signup" \
  -H "Content-Type: application/json;charset=UTF-8" \
  -d "your_request_body_here"
```

<hr>

<h2>Метод `getMe`</h2>

<p>Метод выполняет GET-запрос для получения информации о текущем пользователе.</p>

<h3>Параметры:</h3>

<ul>
  <li><code>jwtBearerToken</code>: Строка - JWT-токен, используемый для аутентификации.</li>
</ul>

<h3>Возвращаемое значение:</h3>

Объект типа <code>Call<KtorResponse<KtorObtainMe>></code>, представляющий асинхронный результат запроса.

<h2>Методы для работы с балансом:</h2>

<p>Методы для выполнения операций с балансом пользователя.</p>

#### CURL
```bash
curl -X GET "https://example.com/account/me" \
  -H "Content-Type: application/json;charset=UTF-8" \
  -H "Authorization: your_jwt_bearer_token"
```

<hr>

<h2>Метод `getRelevantEvents`</h2>

<p>Метод выполняет GET-запрос для получения актуальных событий.</p>

<h3>Параметры:</h3>

<ul>
  <li><code>jwtBearerToken</code>: Строка - JWT-токен, используемый для аутентификации.</li>
  <li><code>requiredContentLanguage</code>: ContentLanguage - Язык контента (по умолчанию ContentLanguage.EN).</li>
  <li><code>sportId</code>: Sport - Идентификатор вида спорта (аннотация @NotNull указывает, что параметр не может быть null).</li>
  <li><code>limit</code>: Int - Максимальное количество событий (по умолчанию из Constants.RETROFIT_DEFAULT_ZIPPED_LIMIT).</li>
  <li><code>offset</code>: Int - Смещение (по умолчанию из Constants.RETROFIT_DEFAULT_ZIPPED_OFFSET).</li>
</ul>

<h3>Возвращаемое значение:</h3>

Объект типа <code>Call<KtorResponse<KtorEventsRequest<KtorEventSlim>></code>, представляющий асинхронный результат запроса.

#### CURL
```bash
curl -X GET "https://example.com/events/relevant" \
  -H "Content-Type: application/json;charset=UTF-8" \
  -H "Authorization: your_jwt_bearer_token" \
  -H "Content-Language: your_content_language" \
  -d "sportId=your_sport_id&limit=your_limit&offset=your_offset"
```

<hr>
</body>
</html>
