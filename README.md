## VirbetCommonSDK
**VirbetCommonSDK** предоставляет удобные инструменты для взаимодействия с событиями и API Virbet.

## Установка
Для подключения `VirbetCommonSDK` к вашему проекту, добавьте следующий блок в файл `build.gradle`:

```groovy
repositories {
    maven {
        url = uri("http://31.214.157.126:83/releases")
        isAllowInsecureProtocol = true
    }
}

dependencies {
    implementation("virbet:common-sdk:snapshot-30")
}
```

### EventsProvider

Класс `EventsProvider` облегчает работу с событиями. Используйте его для выполнения запросов к API Virbet и получения информации о событиях.

```kotlin
val events = EventsProvider(URL("https://.../"))
  .queryCall(
    from (Sport.FOOTBALL) select {  

    }
  )

println(events)
```

<hr/>

### RetrofitFactory

`RetrofitFactory` предоставляет готовые к использованию сервисы Retrofit для работы с API Virbet. Используйте его для выполнения HTTP-запросов к серверу.

```kotlin
RetrofitFactory.getServiceInstance("https://...")
```
