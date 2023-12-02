<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
</head>
<body>

<h1>RetrofitFactory</h1>

<p>Класс <code>RetrofitFactory</code> представляет собой фабрику для создания экземпляра Retrofit и соответствующего сервиса.</p>

<h2>Companion Object - ICommonSingletonFactoryStatic</h2>

<p>Объект-компаньон реализует интерфейс <code>ICommonSingletonFactoryStatic</code> и содержит статические методы для получения экземпляра Retrofit и соответствующего сервиса на основе базового URL или объекта URL.</p>

<h3>Методы:</h3>

<table>
  <tr>
    <th>Метод</th>
    <th>Тип возвращаемого значения</th>
    <th>Описание</th>
  </tr>
  <tr>
    <td><code>getInstance(useBaseUrl: String)</code></td>
    <td><code>RetrofitFactoryResult</code></td>
    <td>Получение экземпляра Retrofit и сервиса на основе строки, представляющей базовый URL.</td>
  </tr>
  <tr>
    <td><code>getInstance(useBaseUrl: URL)</code></td>
    <td><code>RetrofitFactoryResult</code></td>
    <td>Получение экземпляра Retrofit и сервиса на основе объекта URL, представляющего базовый URL.</td>
  </tr>
  <tr>
    <td><code>getInstance()</code></td>
    <td><code>RetrofitFactoryResult</code></td>
    <td>(Устаревший) Получение экземпляра Retrofit и сервиса с использованием значения по умолчанию.</td>
  </tr>
</table>

<h3>Data Class:</h3>

<p>Класс данных <code>RetrofitFactoryResult</code> представляет результат создания экземпляра Retrofit и сервиса.</p>

<h4>Свойства:</h4>

<table>
  <tr>
    <th>Свойство</th>
    <th>Тип</th>
    <th>Описание</th>
  </tr>
  <tr>
    <td><code>instance</code></td>
    <td><code>Retrofit</code></td>
    <td>Экземпляр Retrofit.</td>
  </tr>
  <tr>
    <td><code>service</code></td>
    <td><code>RetrofitInterfaceMain</code></td>
    <td>Сервис RetrofitInterfaceMain.</td>
  </tr>
</table>

<h3>Пример использования:</h3>

<pre><code>val result = RetrofitFactory.getInstance("https://server_url_here")</code></pre>

</body>
</html>
