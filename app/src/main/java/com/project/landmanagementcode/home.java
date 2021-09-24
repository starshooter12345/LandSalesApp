<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    package="com.project.landmanagementcode">
    <!-- camera permission -->
    <uses-permission android:name="android.permission.CAMERA" /> <!-- write external storage permission -->
    <uses-permission
        android:name="android.permission.WRITE_EXTERNAL_STORAGE"
        tools:ignore="ScopedStorage" />

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="Land Management"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.LandManagementCode">
        <activity
            android:name=".Feedback"
            android:exported="true" />
        <activity
            android:name=".CalculateDiscount"
            android:exported="true" />
        <activity
            android:name=".EditRecordActivity"
            android:exported="true" />
        <activity
            android:name=".AddRecordActivity"
            android:exported="true" />
        <activity
            android:name=".MainActivity"
            android:exported="true"
            android:label="Land Management">
        </activity>
       
        //pawan
          <activity
            android:name=".buyerlogin"
            android:exported="true" />


        <activity
            android:name=".buyerregister"
            android:exported="true">

        </activity>
        <activity
            android:name=".rentandsell"
            android:exported="true">

        </activity>

        <activity
            android:name=".home"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>

        </activity>
        
        //Yasas
        <activity
            android:name=".SellerLogin"
            android:exported="true" />
        <activity android:name=".SellerMain"
                    android:exported="true" >
        </activity>
        <activity
            android:name=".sellerbuyandrent"
            android:exported="true" />
        
        
        
        
        
        
        
        <activity
            android:name="com.theartofdev.edmodo.cropper.CropImageActivity"
            android:theme="@style/Theme.LandManagementCode" />
    </application>

</manifest>
