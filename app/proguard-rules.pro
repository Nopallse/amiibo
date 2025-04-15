#############################################################
# SQLCipher
#############################################################
-keep,includedescriptorclasses class net.sqlcipher.** { *; }
-keep,includedescriptorclasses interface net.sqlcipher.** { *; }
-dontwarn net.sqlcipher.**
-keep class org.sqlite.database.** { *; }
-dontwarn org.sqlite.database.**

#############################################################
# Room
#############################################################
-keep class androidx.room.** { *; }
-dontwarn androidx.room.**
-keep class androidx.sqlite.db.SupportSQLite* { *; }
-dontwarn androidx.sqlite.db.**

#############################################################
# Retrofit
#############################################################
-keepattributes Signature, InnerClasses, EnclosingMethod
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations

-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

-if interface * { @retrofit2.http.* <methods>; }
-keep,allowobfuscation interface <1>

-dontwarn retrofit2.**
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn javax.annotation.**
-dontwarn kotlin.Unit
-dontwarn kotlinx.**
-dontwarn retrofit2.KotlinExtensions
-dontwarn retrofit2.KotlinExtensions$*

#############################################################
# Gson
#############################################################
-keepattributes Signature
-keepattributes *Annotation*
-dontwarn com.google.gson.**
-dontwarn sun.misc.**



#############################################################
# Glide
#############################################################
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule {
    <init>(...);
}
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
}
-keep class com.bumptech.glide.load.data.ParcelFileDescriptorRewinder$InternalRewinder {
    *** rewind();
}

#############################################################
# ViewModel & LiveData
#############################################################
-keepclassmembers class * extends androidx.lifecycle.ViewModel {
    <init>(...);
}

#############################################################
# Koin (optional - kalau pakai class inject)
#############################################################
-dontwarn org.koin.**

#############################################################
# General
#############################################################
-keepattributes *Annotation*
-keep class kotlin.Metadata { *; }
