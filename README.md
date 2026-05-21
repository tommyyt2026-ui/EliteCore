diff --git a/README.md b/README.md
index 8770b8cd084f725b9adfa9f17d6ccfd02761e669..2dcf044e6941a4cae75b8b349d66e1a539613423 100644
--- a/README.md
+++ b/README.md
@@ -1 +1,27 @@
\ No newline at end of file
+# EliteCore
+
+EliteCore ist ein modulares Premium-Core-Plugin für Paper/Spigot-Netzwerkserver.
+
+## Tech Stack
+- Java 21
+- Paper API 1.21+
+- Gradle Kotlin DSL
+- Adventure API
+- PlaceholderAPI und LuckPerms Support
+
+## Architektur
+- Modul-Lader (`ModuleLoader`)
+- Konfigurations-Lader (`ConfigLoader`)
+- Trennung nach Modulen (Profiles, Economy, Skills, Clans, Cosmetics, Chat, Scoreboard, GUI, Database)
+- Basis für Manager/Services/Repositories pro Modul
+
+## Wichtige Dateien
+- `src/main/java/com/elitecore/bootstrap/EliteCorePlugin.java`
+- `src/main/java/com/elitecore/module/ModuleLoader.java`
+- `src/main/java/com/elitecore/config/ConfigLoader.java`
+- `src/main/resources/*.yml`
+
+## Build
+```bash
+./gradlew clean build
+```
