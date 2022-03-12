
# CryptKnow App

Mobile Application that displays the latest facts and figures of your favourite cryptocurrency coins.

This projects makes use of the [CoinLore](https://www.coinlore.com/cryptocurrency-data-api) API and also provides an android library that exposes the same to developers.




## Tech Stack

[JetPack Compose](https://developer.android.com/jetpack/compose): Jetpack Compose is Android’s modern toolkit for building native UI

[Android KTX](https://developer.android.com/kotlin/ktx.html):  KTX extensions provide concise, idiomatic Kotlin to Jetpack, Android platform, and other APIs.

[Retrofit](https://square.github.io/retrofit/): Retrofit turns your HTTP API into a Java interface.

[GSON](https://github.com/google/gson): Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object

[OkHttp-Logging-Interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md): Logs HTTP request and response data.

[Coroutines](https://github.com/Kotlin/kotlinx.coroutines): A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.

[Koin](https://insert-koin.io/): A dependency injection library.



## Library 

Install CoinLore API by adding the following to your 

```bash
 	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
add the following to the dependencies sections

```
dependencies {
	    implementation 'com.github.iankang:CryptKnow:1.0.5'
	}
```
    
## Usage/Examples

This is an implementation example for the CoinLoreApi.

Initialize the CoinLoreApi.

```kotlin
 private val coinLoreApi: CoinLoreApi = CoinLoreApi()
```

use the object in a stateful composable.

```kotlin
@Composable
fun Greeting(coinLoreApi: CoinLoreApi) {
    val coinState = produceState(initialValue = CoinLoreResponse<CoinsTickersResponse>()){
        value = coinLoreApi.getCoinsTickers()
    }

    if(coinState.value.isOk == true){
        Text(
            text = coinState.value.data.toString()
        )
    }else{
        Text("Loading")
    }
}
```
