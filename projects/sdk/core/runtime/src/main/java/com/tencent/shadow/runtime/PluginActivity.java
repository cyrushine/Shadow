package com.tencent.shadow.runtime;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

import com.tencent.shadow.runtime.container.HostActivityDelegator;

import java.util.List;

public abstract class PluginActivity extends ShadowContext implements Window.Callback{
    HostActivityDelegator mHostActivityDelegator;

    ShadowApplication mPluginApplication;

    PackageManager mPluginPackageManager;

    public final void setHostContextAsBase(Context context) {
        attachBaseContext(context);
    }

    public void setHostActivityDelegator(HostActivityDelegator delegator) {
        mHostActivityDelegator = delegator;
    }

    public void setPluginApplication(ShadowApplication pluginApplication) {
        mPluginApplication = pluginApplication;
    }

    public void setPluginPackageManager(PackageManager packageManager) {
        mPluginPackageManager = packageManager;
    }

    public void onCreate(Bundle savedInstanceState) {
        mHostActivityDelegator.superOnCreate(savedInstanceState);
    }

    public void onResume() {
        mHostActivityDelegator.superOnResume();
    }

    public void onNewIntent(Intent intent) {
        mHostActivityDelegator.superOnNewIntent(intent);
    }

    public void onSaveInstanceState(Bundle outState) {
        mHostActivityDelegator.superOnSaveInstanceState(outState);
    }

    public void onPause() {
        mHostActivityDelegator.superOnPause();
    }

    public void onStart() {
        mHostActivityDelegator.superOnStart();
    }

    public void onStop() {
        mHostActivityDelegator.superOnStop();
    }

    public void onDestroy() {
        mHostActivityDelegator.superOnDestroy();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        mHostActivityDelegator.superOnConfigurationChanged(newConfig);
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        return mHostActivityDelegator.superDispatchKeyEvent(event);
    }

    public void finish() {
        mHostActivityDelegator.superFinish();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mHostActivityDelegator.superOnActivityResult(requestCode, resultCode, data);
    }

    public void onChildTitleChanged(Activity childActivity, CharSequence title) {
        mHostActivityDelegator.superOnChildTitleChanged(childActivity, title);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        mHostActivityDelegator.superOnRestoreInstanceState(savedInstanceState);
    }

    public void onPostCreate(Bundle savedInstanceState) {
        mHostActivityDelegator.superOnPostCreate(savedInstanceState);
    }

    public void onRestart() {
        mHostActivityDelegator.superOnRestart();
    }

    public void onUserLeaveHint() {
        mHostActivityDelegator.superOnUserLeaveHint();
    }

    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        return mHostActivityDelegator.superOnCreateThumbnail(outBitmap, canvas);
    }

    public CharSequence onCreateDescription() {
        return mHostActivityDelegator.superOnCreateDescription();
    }

    public Object onRetainNonConfigurationInstance() {
        return mHostActivityDelegator.superOnRetainNonConfigurationInstance();
    }

    public void onLowMemory() {
        mHostActivityDelegator.superOnLowMemory();
    }

    public boolean onTrackballEvent(MotionEvent event) {
        return mHostActivityDelegator.superOnTrackballEvent(event);
    }

    public void onUserInteraction() {
        mHostActivityDelegator.superOnUserInteraction();
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        mHostActivityDelegator.superOnWindowAttributesChanged(params);
    }

    public void onContentChanged() {
        mHostActivityDelegator.superOnContentChanged();
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        mHostActivityDelegator.superOnWindowFocusChanged(hasFocus);
    }

    public View onCreatePanelView(int featureId) {
        return mHostActivityDelegator.superOnCreatePanelView(featureId);
    }

    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        return mHostActivityDelegator.superOnCreatePanelMenu(featureId, menu);
    }

    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        return false;
    }

    public void onPanelClosed(int featureId, Menu menu) {
        mHostActivityDelegator.superOnPanelClosed(featureId, menu);
    }

    public Dialog onCreateDialog(int id) {
        return mHostActivityDelegator.superOnCreateDialog(id);
    }

    public void onPrepareDialog(int id, Dialog dialog) {
        mHostActivityDelegator.superOnPrepareDialog(id, dialog);
    }

    public void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
    }

    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return mHostActivityDelegator.superOnCreateView(name, context, attrs);
    }

    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return mHostActivityDelegator.superOnCreateView(parent, name, context, attrs);
    }

    public void startActivityFromChild(Activity child, Intent intent, int requestCode) {
        mHostActivityDelegator.superStartActivityFromChild(child, intent, requestCode);
    }

    public LayoutInflater getLayoutInflater() {
        LayoutInflater inflater = mHostActivityDelegator.getWindow().getLayoutInflater();
        return ShadowLayoutInflater.build(inflater, this, mPartKey);
    }

    public void onBackPressed() {
        mHostActivityDelegator.superOnBackPressed();
    }

    public void onAttachedToWindow() {
        mHostActivityDelegator.superOnAttachedToWindow();
    }


    public void onDetachedFromWindow() {
        mHostActivityDelegator.superOnDetachedFromWindow();
    }

    public void onAttachFragment(Fragment fragment) {
        mHostActivityDelegator.superOnAttachFragment(fragment);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        mHostActivityDelegator.superOnRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return mHostActivityDelegator.superOnKeyDown(keyCode, event);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return mHostActivityDelegator.superOnOptionsItemSelected(item);
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        return mHostActivityDelegator.superDispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return mHostActivityDelegator.superDispatchTouchEvent(event);
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        return mHostActivityDelegator.superDispatchTrackballEvent(event);
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        return mHostActivityDelegator.superDispatchGenericMotionEvent(event);
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return mHostActivityDelegator.superDispatchPopulateAccessibilityEvent(event);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return mHostActivityDelegator.superOnMenuOpened(featureId, menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        return mHostActivityDelegator.superOnMenuItemSelected(featureId, item);
    }

    @Override
    public boolean onSearchRequested() {
        return mHostActivityDelegator.superOnSearchRequested();
    }

    @Override
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return mHostActivityDelegator.superOnSearchRequested(searchEvent);
    }

    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return mHostActivityDelegator.superOnWindowStartingActionMode(callback);
    }

    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) {
        return mHostActivityDelegator.superOnWindowStartingActionMode(callback, type);
    }

    @Override
    public void onActionModeStarted(ActionMode mode) {
        mHostActivityDelegator.superOnActionModeStarted(mode);
    }

    @Override
    public void onActionModeFinished(ActionMode mode) {
        mHostActivityDelegator.superOnActionModeFinished(mode);
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        mHostActivityDelegator.superOnProvideKeyboardShortcuts(data, menu, deviceId);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        mHostActivityDelegator.superOnPointerCaptureChanged(hasCapture);
    }

    public void recreate() {
        mHostActivityDelegator.recreate();
    }
}
