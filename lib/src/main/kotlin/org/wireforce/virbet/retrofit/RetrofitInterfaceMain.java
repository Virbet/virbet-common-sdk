package org.wireforce.virbet.retrofit;

import kotlin.Suppress;
import org.wireforce.virbet.dto.*;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Интерфейс `RetrofitInterfaceMain` содержит объявления методов для взаимодействия с удаленным сервером
 * посредством библиотеки Retrofit в контексте основных операций приложения.
 *
 * <p><b>Пример использования:</b></p>
 * <pre>{@code
 * RetrofitInterfaceMain retrofitInterface = Retrofit.create(RetrofitInterfaceMain.class);
 * Call<KtorResponse<KtorIdKeyRelease>> call = retrofitInterface.generateAnonymousIDKey("AnyString");
 * KtorResponse<KtorIdKeyRelease> response = call.execute().body();
 * }</pre>
 */
interface RetrofitInterfaceMain {
    /**
     * Выполняет GET-запрос для получения ID ключа.
     * ID ключ предназначен для представления пользователя без логина и пароля,
     * обеспечивая анонимный вход в систему.
     *
     * @param requestId Строка, представляющая идентификатор запроса (по умолчанию генерируется случайным образом).
     *                  Служит для предотвращения безконтрольного выпуска ключей.
     *                  По умолчанию пользователь может выпустить 3 ID ключа на один IP-адрес в целях безопасности,
     *                  но существует вероятность холостого выпуска ключей. Чтобы предотвратить такой выпуск, используйте requestId.
     *                  ВНИМАНИЕ! requestId кешируется на 24 секунды с момента первого запроса.
     *
     *
     *                  <p><b>Пример использования:</b></p>
     *
     *                  <pre>{@code
     *                  Call<KtorResponse<KtorIdKeyRelease>> call = retrofitInterface.generateAnonymousIDKey("AnyString");
     *                  KtorResponse<KtorIdKeyRelease> response = call.execute().body();
     *                  }</pre>
     * @return Объект типа {@code Call<KtorResponse<KtorIdKeyRelease>>}, представляющий асинхронный результат запроса.
     * * @see #login(KtorAuthThoughIdKey)
     */
    @GET("/auth/requestIdKey")
    @Suppress(names = "Unused")
    Call<KtorResponse<KtorIdKeyRelease>> generateAnonymousIDKey(
            @Query("requestId") String requestId
    );

    /**
     * Метод {@code login} выполняет POST-запрос для входа в систему через ключ ID.
     *
     * @param idKey Строка, представляющая тело запроса.
     *              <p>
     *              Пример использования:
     *              <pre>{@code
     *                           KtorAuthThoughIdKey idKey = new KtorAuthThoughIdKey("your_id_key_here");
     *                           Call<KtorResponse<KtorLoginInUser>> call = retrofitInterfaceMain.login(idKey);
     *                           call.enqueue(callback);
     *                           }</pre>
     * @return Объект типа {@code Call<KtorResponse<KtorLoginInUser>>}, представляющий асинхронный результат запроса.
     * @see #generateAnonymousIDKey(String)
     * @since 1
     */
    @POST("/auth/internal/loginThoughIDKey")
    @Suppress(names = "Unused")
    Call<KtorResponse<KtorIdKeyRelease>> login(@Body KtorAuthThoughIdKey idKey);

    /**
     * Метод {@code login} выполняет POST-запрос для входа пользователя.
     *
     * @param body Объект типа {@code KtorLoginUser}, содержащий данные для входа.
     *             <p>
     *             Пример использования:
     *             <pre>{@code
     *                         KtorLoginUser userCredentials = new KtorLoginUser("your_username", "your_password");
     *                         Call<KtorResponse<KtorLoginInUser>> call = retrofitInterfaceMain.login(userCredentials);
     *                         call.enqueue(callback);
     *                         }</pre>
     */
    @POST("/auth/internal/login")
    @Suppress(names = "Unused")
    Call<KtorResponse<KtorLoginInUser>> login(@Body KtorLoginUser body);


    /**
     * Метод {@code signup} выполняет POST-запрос для регистрации нового пользователя.
     *
     * @param body Объект типа {@code KtorCreateUser}, содержащий данные для регистрации пользователя.
     *
     *             <p>
     *             Пример использования:
     *             <pre>{@code
     *                         KtorCreateUser newUser = new KtorCreateUser("new_username", "new_password");
     *                         Call<KtorResponse<KtorCreatedUser>> call = retrofitInterfaceMain.signup(newUser);
     *                         call.enqueue(callback);
     *                         }</pre>
     * @return Объект типа {@code Call<KtorResponse<KtorCreatedUser>>}, представляющий асинхронный результат запроса.
     */
    @POST("/auth/internal/signup")
    @Suppress(names = "Unused")
    Call<KtorResponse<KtorCreatedUser>> signup(@Body KtorCreateUser body);

    /**
     * Метод {@code getMe} выполняет GET-запрос для получения информации о текущем пользователе.
     *
     * @param jwtBearerToken Строка, содержащая JWT-токен, используемый для аутентификации.
     *
     *                       <p>
     *                       Пример использования:
     *                       <pre>{@code
     *                                             String jwtToken = "your_jwt_token_here";
     *                                             Call<KtorResponse<KtorObtainMe>> call = retrofitInterfaceMain.getMe(jwtToken);
     *                                             call.enqueue(callback);
     *                                             }</pre>
     * @return Объект типа {@code Call<KtorResponse<KtorObtainMe>>}, представляющий асинхронный результат запроса.
     */
    @GET("/account/me")
    @Headers("Content-Type: application/json;charset=UTF-8")
    @Suppress(names = "Unused")
    Call<KtorResponse<KtorObtainMe>> getMe(@Header("Authorization") String jwtBearerToken);

    /**
     * Метод {@code getBalance} выполняет GET-запрос для получения баланса текущего пользователя.
     *
     * @param jwtBearerToken Строка, содержащая JWT-токен, используемый для аутентификации.
     *
     *                       <p>
     *                       Пример использования:
     *                       <pre>{@code
     *                                             String jwtToken = "your_jwt_token_here";
     *                                             Call<KtorResponse<KtorObtainBalance>> call = retrofitInterfaceMain.getBalance(jwtToken);
     *                                             call.enqueue(callback);
     *                                             }</pre>
     * @return Объект типа {@code Call<KtorResponse<KtorObtainBalance>>}, представляющий асинхронный результат запроса.
     */
    @GET("/wallet/balance")
    @Suppress(names = "Unused")
    @Headers("Content-Type: application/json;charset=UTF-8")
    @Deprecated()
    Call<KtorResponse<KtorObtainBalance>> getBalance(@Header("Authorization") String jwtBearerToken);

    /**
     * Метод {@code createBalanceIfNotExists} выполняет POST-запрос для создания баланса текущего пользователя,
     * если его еще не существует.
     *
     * @param jwtBearerToken Строка, содержащая JWT-токен, используемый для аутентификации.
     *
     *                       <p>
     *                       Пример использования:
     *                       <pre>{@code
     *                                             String jwtToken = "your_jwt_token_here";
     *                                             Call<KtorResponse<KtorCreatedBalance>> call = retrofitInterfaceMain.createBalanceIfNotExists(jwtToken);
     *                                             call.enqueue(callback);
     *                                             }</pre>
     * @return Объект типа {@code Call<KtorResponse<KtorCreatedBalance>>}, представляющий асинхронный результат запроса.
     */
    @POST("/wallet/createBalance")
    @Suppress(names = "Unused")
    @Headers("Content-Type: application/json;charset=UTF-8")
    @Deprecated()
    Call<KtorResponse<KtorCreatedBalance>> createBalanceIfNotExists(@Header("Authorization") String jwtBearerToken);

    /**
     * Метод {@code getBalanceOrCreate} выполняет GET-запрос для получения баланса текущего пользователя
     * или создания его, если его еще не существует.
     *
     * @param jwtBearerToken Строка, содержащая JWT-токен, используемый для аутентификации.
     *
     *                       <p>
     *                       Пример использования:
     *                       <pre>{@code
     *                                             String jwtToken = "your_jwt_token_here";
     *                                             Call<KtorResponse<KtorCreatedBalance>> call = retrofitInterfaceMain.getBalanceOrCreate(jwtToken);
     *                                             call.enqueue(callback);
     *                                             }</pre>
     * @return Объект типа {@code Call<KtorResponse<KtorCreatedBalance>>}, представляющий асинхронный результат запроса.
     */
    @GET("/wallet/balanceGetOrCreate")
    @Suppress(names = "Unused")
    @Headers("Content-Type: application/json;charset=UTF-8")
    Call<KtorResponse<KtorCreatedBalance>> getBalanceOrCreate(@Header("Authorization") String jwtBearerToken);
}
