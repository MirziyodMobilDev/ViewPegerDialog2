package db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import const.ConstantAsos
import modul.Asos

class DatabaseHelperAsos(context: Context): SQLiteOpenHelper(context, ConstantAsos.DB_NAME,null, ConstantAsos.DB_VERSION),DatabaseServiceAsos {
    override fun onCreate(p0: SQLiteDatabase?) {
        var query = "create table ${ConstantAsos.TABLE_NAME}  (${ConstantAsos.ID} integer not null primary key autoincrement unique," +
                "${ConstantAsos.NAME} text not null," +
                "${ConstantAsos.Text} text not null)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun addInformation(asos: Asos) {
        var database = this.writableDatabase
        var contentValues = ContentValues()
        contentValues.put(ConstantAsos.NAME,asos.sarlavha)
        contentValues.put(ConstantAsos.Text,asos.discription)
        database.insert(ConstantAsos.TABLE_NAME,null,contentValues)
        database.close()
    }

    override fun deleteInformation(asos: Asos) {
        var database = this.writableDatabase
        database.delete(ConstantAsos.TABLE_NAME,"${ConstantAsos.ID}=?", arrayOf("${asos.id}"))
        database.close()
    }

    override fun updateInformation(asos: Asos): Int {
        var database = this.writableDatabase
        var contentValues = ContentValues()
        contentValues.put(ConstantAsos.ID,asos.id)
        contentValues.put(ConstantAsos.NAME,asos.sarlavha)
        contentValues.put(ConstantAsos.Text,asos.discription)
        return database.update(ConstantAsos.TABLE_NAME,contentValues,"${ConstantAsos.ID}=?", arrayOf(asos.id.toString()))
        database.close()
    }

    override fun getInformationById(id: Int): Asos {
        var database = this.readableDatabase
        var cursor = database.query(
            ConstantAsos.TABLE_NAME, arrayOf(ConstantAsos.ID, ConstantAsos.NAME, ConstantAsos.Text),
            "${ConstantAsos.ID} = ?", arrayOf("$id"),null,null,null)
        cursor?.moveToFirst()
        return Asos(cursor.getString(0),cursor.getString(1),cursor.getInt(2))
    }

    override fun getAllInformation(): List<Asos> {
        var list = ArrayList<Asos>()
        var query = "select*from ${ConstantAsos.TABLE_NAME}"
        var database = this.readableDatabase
        var cursor = database.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {

                var  name =cursor.getString(0)
                var text = cursor.getString(1)
                var id = cursor.getInt(2)
                var asos = Asos(name,text,id)
                list.add(asos)
            }while (cursor.moveToNext())
        }
        return list
    }

}