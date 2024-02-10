This is a Kotlin Multiplatform project targeting Android, iOS.


![Screenshot_20240209_231635](https://github.com/omeryildirim01/KMPSample/assets/17796968/ce49ddc8-919b-4ac0-a90a-a63b0707dbc0)
![Simulator Screenshot - iPhone 15 - 2024-02-10 at 00 52 53](https://github.com/omeryildirim01/KMPSample/assets/17796968/7f30ec59-5b36-4932-8440-198f813a99de)

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
