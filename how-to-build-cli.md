
When F-Droid tried enabling reproducible build, they find differences between my build apk (using AndroidStudio on Windows 10) and their build. 
the solution was to build using CLI instead, here is the steps to build the app using cli (on Windows 10 Command line):

- cd /d <project-path>

- gradlew assembleRelease

- move <project-path>\app\build\outputs\apk\release\app-release-unsigned.apk to <project-path>\releases folder

- cd /d <project-path>\releases

- <android-sdk-path>\build-tools\29.0.2\zipalign -v -p 4 app-release-unsigned.apk app-release-unsigned-aligned.apk

- <android-sdk-path>\build-tools\29.0.2\apksigner sign --ks netvor-03-18-23.jks --ks-key-alias settingsdatabaseprovider --out app-release.apk app-release-unsigned-aligned.apk
