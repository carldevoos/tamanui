package com.carldevoos.tamanui.sql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ListSQLiteHelper(
    context: Context, name: String,
    factory: SQLiteDatabase.CursorFactory?, version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

        private val TABLE_NOTIFICATIONS =
            "CREATE TABLE notifications(id INTEGER PRIMARY KEY, notification_id INTEGER, created_at TEXT, proccess TEXT, text TEXT, operation TEXT, operation_id INT, user_id INT, avatar TEXT, user_name TEXT, user_surname TEXT, username TEXT, paid_id TEXT, product_id TEXT, singer TEXT, dedit_from TEXT, dedit_to TEXT, cost TEXT)"
        private val TABLE_OPERATIONS =
            "CREATE TABLE operations(id INTEGER PRIMARY KEY, operation_id INTEGER, province TEXT, location TEXT, province_id INTEGER, location_id INTEGER, place TEXT, created_at TEXT, proccess TEXT, day TEXT, user_id INT, user_name TEXT, user_surname TEXT, username TEXT, avatar TEXT, amount_to_paid TEXT, active TEXT)"

        override fun onCreate(db: SQLiteDatabase) {
            // se crear las tablas necesarias
            db.execSQL(TABLE_NOTIFICATIONS)
            db.execSQL(TABLE_OPERATIONS)
        }

        override fun onUpgrade(db: SQLiteDatabase, arg1: Int, arg2: Int) {

            // Se elimina la versión anterior de la bd
            db.execSQL("DROP TABLE IF EXISTS notifications")
            db.execSQL("DROP TABLE IF EXISTS operations")

            // se crear las tablas necesarias
            db.execSQL(TABLE_NOTIFICATIONS)
            db.execSQL(TABLE_OPERATIONS)
        }

}