# Kebutuhan Room
-keep class androidx.room.** { *; }
-dontwarn androidx.room.**

# Kebutuhan Retrofit
-keep class retrofit2.** { *; }
-dontwarn retrofit2.**

# Kebutuhan Gson
-keep class com.google.gson.** { *; }
-dontwarn com.google.gson.**

# Kebutuhan ViewModel dan LiveData
-keepclassmembers class * extends androidx.lifecycle.ViewModel {
    <init>(...);
}
