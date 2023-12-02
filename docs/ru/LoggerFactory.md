<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
</head>
<body>

<h1>LoggerFactory</h1>

<p><code>LoggerFactory</code> - это класс, который расширяет <code>AbstractSingletonFactory</code> и реализует интерфейс <code>ICommonSingletonFactoryStatic</code> для предоставления единственного экземпляра класса <code>Logger</code> с определенной конфигурацией.</p>

<h2>Companion Object - ICommonSingletonFactoryStatic</h2>

<p>Объект-компаньон реализует интерфейс <code>ICommonSingletonFactoryStatic</code>, предоставляя лениво инициализированный экземпляр класса <code>Logger</code> с настроенными обработчиком и форматтером журнала.</p>

<h3>Свойства:</h3>

<table>
  <tr>
    <th>Свойство</th>
    <th>Тип</th>
    <th>Описание</th>
  </tr>
  <tr>
    <td><code>handler</code></td>
    <td><code>ConsoleHandler</code></td>
    <td>Лениво инициализированный обработчик консоли с настроенным форматтером.</td>
  </tr>
  <tr>
    <td><code>formatter</code></td>
    <td><code>LogFormatter</code></td>
    <td>Лениво инициализированный форматтер журнала.</td>
  </tr>
  <tr>
    <td><code>logger</code></td>
    <td><code>Logger</code></td>
    <td>Лениво инициализированный экземпляр класса <code>Logger</code> с настроенным обработчиком.</td>
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
    <td><code>Logger</code></td>
    <td>Возвращает единственный экземпляр <code>Logger</code>.</td>
  </tr>
</table>

<h2>Пример</h2>

<pre><code>val loggerInstance = LoggerFactory.getInstance()</code></pre>

</body>
</html>
