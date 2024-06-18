## Basic sample (in Kotlin) for writing unit tests that mocks the Android framework
If you are new to unit testing on Android, try this sample first.

This project uses the Gradle build system and the Android gradle plugin support for unit testing. You can either benefit from IDEs integration such as Android studio or run the tests on the command line.

Unit tests run on a local JVM on your development machine. The Android Gradle plugin will compile your app's source code and execute it using gradle test task. Tests are executed against a modified version of android.jar where all final modifiers have been stripped off. This lets you use popular mocking libraries, like Mockito.