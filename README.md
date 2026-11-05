# PoilabsVdNavigation Android Integration

Sample Android app that integrates **Android-VD-Navigation-SDK 7.3.0**.

## Setup

Add these values to `local.properties` (they are provided by PoiLabs and are not committed):

```
APPID=APPLICATION_ID
APPSECRET=APPLICATION_SECRET_KEY
jitpackToken=JITPACK_TOKEN
```

The SDK is downloaded from JitPack (`build.gradle`):

```groovy
implementation 'com.github.poiteam:Android-VD-Navigation-SDK:7.3.0'
```

## Usage

`MainActivity` calls `PoiManager.init(...)` and starts `PoiVdNavigationActivity` in `onSuccess()`.
See the Android VD SDK documentation for every parameter, closing the SDK screen and the notes for apps targeting Android 15 or later.

### Opening a specific venue (placeId)

From **7.3.0** you can open one venue directly instead of the venue list by passing its `placeId`
(set `placeId` in `MainActivity`). Ask PoiLabs for the `placeId` values of your venues. If it is `null`,
empty or not one of your application's venues, the SDK opens the venue list as before.

```kotlin
PoiManager.init(
    context = this,
    appId = BuildConfig.APPID,
    secret = BuildConfig.APPSECRET,
    language = localeLanguage,
    title = "Test title",
    vdResponseListener = vdResponseListener,
    locationCallback = locationCallback,
    placeId = "PLACE_ID"
)
```
