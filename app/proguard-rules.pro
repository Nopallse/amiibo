# Keep Kotlin classes and methods
-keep class kotlin.** { *; }
-dontwarn kotlin.**

# Keep classes from androidx package
-keep class androidx.** { *; }

# Keep any classes or methods for Android testing
-keep class androidx.test.** { *; }
-dontwarn androidx.test.**

# Keep data class Resource dan turunannya
-keep class com.example.core.data.Resource { *; }
-keep class com.example.core.data.Resource$* { *; }

# Keep model, repository, usecase
-keep class com.example.core.domain.model.** { *; }
-keep class com.example.core.domain.repository.** { *; }
-keep class com.example.core.domain.usecase.** { *; }

# Keep Koin module dan dependensi
-keep class com.example.core.di.** { *; }
-keep class com.example.moviecatalog.di.** { *; }

# Keep adapter dan UI pentings
-keep class com.example.core.ui.** { *; }
