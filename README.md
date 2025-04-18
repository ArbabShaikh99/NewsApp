


# PAK News

PAK News is a modern news application that provides users with the latest news across various categories. Built with Jetpack Compose and Material 3, the app features a clean and intuitive user interface. The application integrates with NewsAPI.org to fetch up-to-date news articles, and leverages Coil for image loading and Shimmer for loading effects, ensuring a smooth and engaging user experience.




## Screenshots

<img src="https://github.com/user-attachments/assets/920952e4-b6ba-4574-9218-99d9451a9f98" alt="Screenshot 1" width="200" height="400" style="margin-right: 30px;">  
<img src="https://github.com/user-attachments/assets/bf075e9a-1181-41e5-b48b-260403aedc6b" alt="Screenshot 2" width="200" height="400" style="margin-right: 10px;">  
<img src="https://github.com/user-attachments/assets/7f2109e6-7eb4-484f-91ac-1b8b75c0a49e" alt="Screenshot 3" width="200" height="400" style="margin-right: 10px;">  
<img src="https://github.com/user-attachments/assets/bd203173-cb48-4597-98da-4f445df487cc" alt="Screenshot 4" width="200" height="400">





## Features

- **Multiple News Categories:** Stay updated with news across different categories like Business, Entertainment, Sports, Technology, and more.
- **Jetpack Compose:** Modern UI toolkit for building native Android UI.
- **Material 3:** Utilizes Material Design 3 guidelines for a polished and cohesive user interface.
- **Additive UI:** Dynamic and interactive UI components.
- **NewsAPI.org Integration:** Fetches real-time news articles from NewsAPI.org.
- **Coil for Image Loading:** Fast and efficient image loading with Coil.
- **Shimmer Effect:** Attractive loading animations while fetching data.
- **Clean and Intuitive UI:** Focuses on delivering a seamless user experience with a neat layout.
- **Offline Support:** Browse previously loaded news even when offline.
- **Light and Dark Mode:** Supports both light and dark themes.

## Technologies Used

- Jetpack Compose
- Material 3
- Additive UI
- NewsAPI.org
- Coil
- Shimmer Effect
- Retrofit (for network requests)
- Kotlin Coroutines (for asynchronous programming)
- ViewModel and LiveData (for managing UI-related data)
- MVVM

## Dependencies

```gradle
dependencies {
    implementation "androidx.compose.ui:ui:1.0.0"
    implementation "androidx.compose.material3:material3:1.0.0"
    implementation "io.coil-kt:coil-compose:1.4.0"
    implementation "com.facebook.shimmer:shimmer:0.5.0"
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.2"
    implementation "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
}
```


## Getting Started

To get started with IND News, follow these steps:

1. Clone this repository:
    ```sh
    git clone https://github.com/yourusername/ind-news.git
    ```

2. Open the project in Android Studio.

3. Set up your NewsAPI.org API key:
    - Register at [NewsAPI.org](https://newsapi.org) and obtain your API key.
    - Add your API key in the `local.properties` file:
        ```properties
        NEWS_API_KEY=your_api_key_here
        ```

4. Build and run the project on an emulator or a physical device.

## How to Contribute

If you'd like to contribute to IND News, follow these steps:

1. Fork this repository.

2. Create a new branch:
    ```sh
    git checkout -b feature/your-feature
    ```

3. Make your changes and commit them:
    ```sh
    git commit -m 'Add some feature'
    ```

4. Push to the branch:
    ```sh
    git push origin feature/your-feature
    ```

5. Submit a pull request.

## Acknowledgements

- [NewsAPI.org](https://newsapi.org) for providing access to news data.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) for the modern UI toolkit.
- [Coil](https://coil-kt.github.io/coil/) for efficient image loading.
- [Shimmer](https://facebook.github.io/shimmer-android/) for the beautiful loading animations.
- [Material Design](https://material.io/design) for the design guidelines.

## Contact

For any inquiries or feedback, please contact us at [arbabshaikh901@gmail.com](mailto:arbabshaikh901@gmail.com).
