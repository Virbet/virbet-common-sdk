## VirbetCommonSDK
**VirbetCommonSDK** предоставляет удобные инструменты для взаимодействия с событиями и API Virbet.

## Сборка

Перед началом работы вам необходимо собрать пакет в ваш репозиторий MavenLocal

```bash
git clone https://github.com/Virbet/virbet-common-sdk

cd virbet-common-sdk

gradle publishToMavenLocal # for Linux
sh gradlew publishToMavenLocal # for Mac
./gradlew.bat publishToMavenLocal # For Windows
 
```

При сборке в терминале вы сможете найти строки, которые уведомят вас о самой последней версии библиотеки и способах ее подключения:

```
Thank you for compiling the library! Latest version of the library = snapshot-31
You can connect the library through: implementation("virbet:common-sdk:snapshot-31")
```

## Установка
Для подключения `VirbetCommonSDK` к вашему проекту, добавьте следующий блок в файл `build.gradle`:

```groovy
repositories {
    mavenLocal()
}

dependencies {
    implementation("virbet:common-sdk:LATEST_VERSION")
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
