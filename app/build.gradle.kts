<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical"
android:padding="16dp">
<EditText
android:id="@+id/email"
android:layout_width="match_parent"
android:layout_height="48dp"
android:hint="Email"
android:padding="10dp" />

<EditText
android:id="@+id/password"
android:layout_width="match_parent"
android:layout_height="48dp"
android:hint="Password"
android:inputType="textPassword"
android:padding="10dp" />

<Button
android:id="@+id/registerButton"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:text="Register" />
</LinearLayout>