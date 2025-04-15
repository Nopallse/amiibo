# Keep Kotlin classes and methods
-keep class kotlin.** { *; }
-dontwarn kotlin.**

# Keep classes from androidx package
-keep class androidx.** { *; }

# Keep any classes or methods for Android testing
-keep class androidx.test.** { *; }
-dontwarn androidx.test.**
