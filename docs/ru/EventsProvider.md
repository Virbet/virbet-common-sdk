# EventsProvider

Класс `EventsProvider` предоставляет методы для выполнения асинхронных запросов к серверу событий.

## Использование


1. **Создание экземпляра `EventsProvider`:**

    ```kotlin
    val hostUrl = URL("https://example.com")
    val eventsProvider = EventsProvider(hostUrl)
    ```

2. **Выполнение асинхронного запроса событий:**

    ```kotlin
    val query = from () select {} // ваш объект ESL2
    val results = eventsProvider.queryCall(query)
    ```

## Метод `queryCall`

### Описание

Выполняет асинхронный запрос к серверу для выборки событий.

### Параметры

- `query`: Объект, представляющий параметры запроса.
- `requiredContentLanguage` (по умолчанию - `ContentLanguage.EN`): Язык контента, требуемый в ответе.
- `limit` (по умолчанию - `Constants.RETROFIT_DEFAULT_LIMIT`): Максимальное количество результатов запроса.
- `offset` (по умолчанию - `Constants.RETROFIT_DEFAULT_OFFSET`): Смещение для запроса пагинации.

### Возвращаемое значение

Результаты запроса в виде `NestedEventsResults` или `null` в случае ошибки.
