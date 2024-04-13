## Settings Database Provider

Extend your Android app's capabilities by allowing seamless access to the settings database, even on newer Android versions.

## How it works

The package contains only a Content Provider component, that works as a bridge between your app and the settings database. By targeting SDK level 22, the provider circumvents restrictions imposed on newer applications,  allowing other apps to modify all system settings without targeting an outdated SDK level themselves and enabling broader functionality for system customization apps

## Installation and Usage

Simply install the Settings Database Provider package. Other apps are responsible for detecting the provider and making use of it. Ignore any warnings about compatibility with older Android versions, that's totally fine.

[<img src="https://fdroid.gitlab.io/artwork/badge/get-it-on.png"
     alt="Get it on F-Droid"
     height="80">](https://f-droid.org/packages/com.netvor.settings.database.provider/)

Or get the latest APK from the [Releases Section](https://github.com/gamemn02/Settings-Database-Provider/releases/latest).

### Grant Permission (Optional, but Important): 
For editing secure and global tables, after installation, there's a quick ADB command to grant provider the permission:

#### Using PC with ADB

```
adb shell pm grant com.netvor.settings.database.provider android.permission.WRITE_SECURE_SETTINGS
```
#### Using LADB or Brevent
```
pm grant com.netvor.settings.database.provider android.permission.WRITE_SECURE_SETTINGS
```



## For Android 14
Android 14 introduces restrictions on installing applications that target SDK levels lower than 23. Also, some users reported inability to modify any setting but worked using the provider. To install Settings Database Provider on devices running Android 14, special installation steps are required:

**Using PC with ADB**

To install via ADB from a PC, use the following command, replacing sdp-v1.1.apk with the actual file path to the APK.
```
adb install --bypass-low-target-sdk-block sdp-v1.1.apk
```

**Using LADB or Brevent**

You can also install the APK using local ADB alternatives like LADB or Brevent. Use the following commands in your local ADB shell:
```
cat sdcard/Download/sdp-v1.1.apk | pm install --bypass-low-target-sdk-block -S 106579
```
For some cases (error message like "Unknown option --bypass-low-target-sdk-block"), try:
```
cat sdcard/Download/sdp-v1.1.apk | su -c pm install --bypass-low-target-sdk-block -S 106579
```

`106579` is the apk exact file size in bytes (for v1.1)

## Support

For any issues or support questions, please file an issue on the GitHub repository. You can also join our Telegram group or contact us via email. Contributions and feedback are welcome.

Telegram Group: [Settings Database Editor](https://t.me/+o140MdSojRI2MjA0)  
Email: contact@netvorgroup.com
