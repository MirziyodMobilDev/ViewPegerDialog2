package db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import const.ConstantDunyo
import modul.Dunyo


class DatabaseHelperDunyo(context: Context): SQLiteOpenHelper(context, ConstantDunyo.DB_NAME,null, ConstantDunyo.DB_VERSION),DatabaseServiceDunyo {
    override fun onCreate(p0: SQLiteDatabase?) {
        var query = "create table ${ConstantDunyo.TABLE_NAME}  (${ConstantDunyo.ID} integer not null primary key autoincrement unique," +
                "${ConstantDunyo.NAME} text not null," +
                "${ConstantDunyo.Text} text not null)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun addInformation(dunyo: Dunyo) {
        var database = this.writableDatabase
        var contentValues = ContentValues()
        contentValues.put(ConstantDunyo.NAME,dunyo.sarlavha)
        contentValues.put(ConstantDunyo.Text,dunyo.discription)
        database.insert(ConstantDunyo.TABLE_NAME,null,contentValues)
        database.close()
    }

    override fun deleteInformation(dunyo: Dunyo) {
        var database = this.writableDatabase
        database.delete(ConstantDunyo.TABLE_NAME,"${ConstantDunyo.ID}=?", arrayOf("${dunyo.id}"))
        database.close()
    }

    override fun updateInformation(dunyo: Dunyo): Int {
        var database = this.writableDatabase
        var contentValues = ContentValues()
        contentValues.put(ConstantDunyo.ID,dunyo.id)
        contentValues.put(ConstantDunyo.NAME,dunyo.sarlavha)
        contentValues.put(ConstantDunyo.Text,dunyo.discription)
        return database.update(ConstantDunyo.TABLE_NAME,contentValues,"${ConstantDunyo.ID}=?", arrayOf(dunyo.id.toString()))
        database.close()
    }

    override fun getInformationById(id: Int): Dunyo {
        var database = this.readableDatabase
        var cursor = database.query(
            ConstantDunyo.TABLE_NAME, arrayOf(ConstantDunyo.ID, ConstantDunyo.NAME, ConstantDunyo.Text),
            "${ConstantDunyo.ID} = ?", arrayOf("$id"),null,null,null)
        cursor?.moveToFirst()
        return Dunyo(cursor.getString(0),cursor.getString(1),cursor.getInt(2))
    }

    override fun getAllInformation(): List<Dunyo> {
        var list = ArrayList<Dunyo>()
        var query = "select*from ${ConstantDunyo.TABLE_NAME}"
        var database = this.readableDatabase
        var cursor = database.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {

                var  name =cursor.getString(0)
                var text = cursor.getString(1)
                var id = cursor.getInt(2)
                var dunyo = Dunyo(name,text,id)
                list.add(dunyo)
            }while (cursor.moveToNext())
        }
        return list
    }

}