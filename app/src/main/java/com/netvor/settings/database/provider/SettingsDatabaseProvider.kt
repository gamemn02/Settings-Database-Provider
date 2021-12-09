package com.netvor.settings.database.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri

private const val SETTINGS_URI_AUTHORITY = "settings"
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
        return context?.contentResolver?.query(uri.buildUpon().authority(SETTINGS_URI_AUTHORITY).build(), projection, selection, selectionArgs, sortOrder)
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        return context?.contentResolver?.update(uri.buildUpon().authority(SETTINGS_URI_AUTHORITY).build(), values, selection, selectionArgs) ?: 0
    }
}