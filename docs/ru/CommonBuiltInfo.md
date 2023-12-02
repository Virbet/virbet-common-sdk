<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
</head>
<body>

<h2>Интерфейс ICommonBuiltInfo</h2>

<p>Интерфейс <code>ICommonBuiltInfo</code> реализуется в объекте-компаньоне, предоставляя информацию о сборке SDK.</p>

<h3>Свойства:</h3>
<table>
  <tr>
    <th>Свойство</th>
    <th>Тип</th>
    <th>Описание</th>
  </tr>
  <tr>
    <td><code>version</code></td>
    <td>Double</td>
    <td>Номер версии SDK.</td>
  </tr>
  <tr>
    <td><code>versionText</code></td>
    <td>String</td>
    <td>Текст версии SDK.</td>
  </tr>
  <tr>
    <td><code>builtTime</code></td>
    <td>Date</td>
    <td>Дата и время сборки SDK.</td>
  </tr>
</table>

<h2>Использование</h2>

<p>Для использования <code>VirbetCommonSDK</code> следуйте следующим шагам:</p>

<ol>
  <li><strong>Создание экземпляра VirbetCommonSDK:</strong></li>
  <pre><code>val virbetCommonSDK = VirbetCommonSDK()</code></pre>

  <li><strong>Доступ к информации о сборке:</strong></li>
  <pre><code>val version = VirbetCommonSDK.version
val versionText = VirbetCommonSDK.versionText
val builtTime = VirbetCommonSDK.builtTime</code></pre>

  <li><strong>Получение сервиса Retrofit:</strong></li>
  <pre><code>val url = URL("ваш_базовый_адрес_здесь")
val retrofitService = virbetCommonSDK.getRetrofitService(url)</code></pre>

  <li><strong>Получение экземпляра Retrofit:</strong></li>
  <pre><code>val url = URL("ваш_базовый_адрес_здесь")
val retrofitInstance = virbetCommonSDK.getRetrofitInstance(url)</code></pre>
</ol>

<h2>Пример</h2>

<pre><code>// Создание экземпляра VirbetCommonSDK
val virbetCommonSDK = VirbetCommonSDK()

// Доступ к информации о сборке
val version = VirbetCommonSDK.version
val versionText = VirbetCommonSDK.versionText
val builtTime = VirbetCommonSDK.builtTime

// Получение сервиса Retrofit
val url = URL("ваш_базовый_адрес_здесь")
val retrofitService = virbetCommonSDK.getRetrofitService(url)

// Получение экземпляра Retrofit
val retrofitInstance = virbetCommonSDK.getRetrofitInstance(url)</code></pre>

<h2>Примечание</h2>

<p>Убедитесь, что у вас есть необходимые зависимости и конфигурации для Retrofit перед использованием этого SDK. SDK предполагает, что <code>RetrofitFactory</code> является допустимым и настроенным классом в вашем проекте.</p>

<h2>История версий</h2>

<p>- Версия 0.1 (Moth 0.0.1) - Первый релиз (собран 28 декабря 2023 года).</p>

</body>
</html>
