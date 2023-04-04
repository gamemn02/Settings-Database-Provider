package com.netvor.settings.database.provider

import android.Manifest
import android.content.ContentProvider
import android.content.ContentValues
import android.content.pm.PackageManager
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import androidx.core.content.ContextCompat

private const val SETTINGS_URI_AUTHORITY = "settings"
private const val WRITE_SECURE_PERMISSION_PATH = "/writeSecurePermission"
private const val PERMISSION = "com.netvor.settings.database.provider.permission.SETTINGS_DATABASE_PROVIDER"

class SettingsDatabaseProvider : ContentProvider() {

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        return context?.contentResolver?.delete(uri.buildUpon().authority(SETTINGS_URI_AUTHORITY).build(), selection, selectionArgs) ?: 0
    }

    override fun getType(uri: Uri): String? {
        return context?.contentResolver?.getType(uri.buildUpon().authority(SETTINGS_URI_AUTHORITY).build())
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return context?.contentResolver?.insert(uri.buildUpon().authority(SETTINGS_URI_AUTHORITY).build(), values)
    }

    override fun onCreate(): Boolean {
        return true;
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        return if (uri.path == WRITE_SECURE_PERMISSION_PATH)
            MatrixCursor(arrayOf("granted")).apply { addRow(arrayOf(if (checkWriteSecureSettingsPermission()) 1 else 0)) }
        else
            context?.contentResolver?.query(uri.buildUpon().authority(SETTINGS_URI_AUTHORITY).build(), projection, selection, selectionArgs, sortOrder)
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        return context?.contentResolver?.update(uri.buildUpon().authority(SETTINGS_URI_AUTHORITY).build(), values, selection, selectionArgs) ?: 0
    }

    private fun checkWriteSecureSettingsPermission() =
        ContextCompat.checkSelfPermission(
            context ?: throw (NullPointerException("Context should already set but is null!")),
            Manifest.permission.WRITE_SECURE_SETTINGS
        ) == PackageManager.PERMISSION_GRANTED
}