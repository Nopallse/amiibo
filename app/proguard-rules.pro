# Jangan ubah class SQLCipher dan dependensinya
-keep class net.sqlcipher.** { *; }
-keep class org.sqlite.database.** { *; }

# Hindari warning dari SQLCipher
-dontwarn net.sqlcipher.**
-dontwarn org.sqlite.database.**

# Kalau pakai Room juga
-keep class androidx.sqlite.db.SupportSQLite* { *; }
