<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
</head>
<body>

<h1>GsonFactory</h1>

<p><code>GsonFactory</code> - это класс на, который расширяет <code>AbstractSingletonFactory</code> и реализует интерфейс <code>ICommonSingletonFactoryStatic</code> для предоставления единственного экземпляра класса <code>Gson</code> с определенной конфигурацией.</p>

<h2>Companion Object - ICommonSingletonFactoryStatic</h2>

<p>Объект-компаньон реализует интерфейс <code>ICommonSingletonFactoryStatic</code>, предоставляя лениво инициализированный экземпляр класса <code>Gson</code> с пользовательской конфигурацией, включая красивый вывод и пользовательский адаптер типов для работы с классом <code>Instant</code>.</p>

<h3>Свойства:</h3>

<table>
  <tr>
    <th>Свойство</th>
    <th>Тип</th>
    <th>Описание</th>
  </tr>
  <tr>
    <td><code>gson</code></td>
    <td><code>Gson</code></td>
    <td>Лениво инициализированный экземпляр <code>Gson</code> с пользовательской конфигурацией.</td>
  </tr>
</table>

<h3>Методы:</h3>

<table>
  <tr>
    <th>Метод</th>
    <th>Тип возвращаемого значения</th>
    <th>Описание</th>
  </tr>
  <tr>
    <td><code>getInstance()</code></td>
    <td><code>Gson</code></td>
    <td>Возвращает единственный экземпляр <code>Gson</code>.</td>
  </tr>
</table>

<h2>Пример</h2>

<pre><code>val gsonInstance = GsonFactory.getInstance()</code></pre>

</body>
</html>
