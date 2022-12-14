# recipes-app

### 1. Setup Material3

The project uses Material3 to customize:

- Color Theme
- Typography
- Spacing 

### 2. Setup Dependency Injection

#### Use Scaffold to define TopAppBar

#### Setup project dependencies

The project will use the following:

- __Hilt-Dagger__ for Dependency Injection
- __Coroutines__
- __Hilt for Navigation__
- __Lifecycle Scope__ - Lifecycle-aware components perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
- __Coil__
- __Retrofit__
- __OkHttp__
- __Room__
- __JSON Converter__

#### Add Internet permmissions to AndroidManifest.xml

````xml
    <uses-permission android:name="android.permission.INTERNET"/>
````

#### Define RecipesApplication

@HiltAndroidApp triggers Hilt's code generation, including a base class for your application 
that serves as the application-level dependency container.

````kotlin
@HiltAndroidApp
class RecipesApplication: Application() {
}
````
This generated Hilt component is attached to the Application object's lifecycle and 
provides dependencies to it. Additionally, it is the parent component of the app, which means that 
other components can access the dependencies that it provides.

Register the class to AndroidManifest.xml

````xml
 <application
        android:allowBackup="true"
        android:name=".RecipesApplication"
/>
````

#### Define AppModule to define dependecies

#### Annotate MainActivity with @AndroidEntryPoint

@AndroidEntryPoint generates an individual Hilt component for each Android class in your project.

## 3. Set up Navigation

For navigation, the screens will be defined in a enum class.

The first screen is the Splash Screen which shows an animation and then navigates to the 
MainScreen.

## 4. Retrofit

The response from the spoonacular API is modeled with Kotlin data classes using the 
JSON To Kotlin Class plugin in Android Studio. 

#### Define API_KEY in local.properties

````text
API_KEY = _API KEY HERE_
````

#### Update build.gradle to get the API_KEY:

````text
defaultConfig {
        ...........

        Properties properties = new Properties()
        properties.load(project.rootProject.file("local.properties").newDataInputStream())

        buildConfigField "String", "API_KEY", "\"${properties.getProperty("API_KEY")}\""
    }
````

#### Define BASE_URL and API_KEY in the utils package:

````kotlin
object Constants {
    const val BASE_URL = "https://api.spoonacular.com/"
    const val API_KEY = BuildConfig.API_KEY
}
````

#### Define the RecipesApi Interface for making requests in network package:

````kotlin
@Singleton
interface RecipesApi {

    @GET(value = "recipes/random")
    suspend fun getRandomRecipes(
        @Query("limitLicense") query: Boolean = true,
        @Query("number") number : Int = 2,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): RecipesModel
}
````