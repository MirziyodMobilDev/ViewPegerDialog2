package db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import const.ConstantIjtimoiy
import modul.Ijtimoiy

class DatabaseHelperIjtimoiy(context: Context): SQLiteOpenHelper(context, ConstantIjtimoiy.DB_NAME,null, ConstantIjtimoiy.DB_VERSION),DatabaseServiceIjtimoiy {
    override fun onCreate(p0: SQLiteDatabase?) {
        var query = "create table ${ConstantIjtimoiy.TABLE_NAME}  (${ConstantIjtimoiy.ID} integer not null primary key autoincrement unique," +
                "${ConstantIjtimoiy.NAME} text not null," +
                "${ConstantIjtimoiy.Text} text not null)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun addInformation(ijtimoiy: Ijtimoiy) {
        var database = this.writableDatabase
        var contentValues = ContentValues()
        contentValues.put(ConstantIjtimoiy.NAME,ijtimoiy.sarlavha)
        contentValues.put(ConstantIjtimoiy.Text,ijtimoiy.discription)
        database.insert(ConstantIjtimoiy.TABLE_NAME,null,contentValues)
        database.close()
    }

    override fun deleteInformation(ijtimoiy: Ijtimoiy) {
        var database = this.writableDatabase
        database.delete(ConstantIjtimoiy.TABLE_NAME,"${ConstantIjtimoiy.ID}=?", arrayOf("${ijtimoiy.id}"))
        database.close()
    }

    override fun updateInformation(ijtimoiy: Ijtimoiy): Int {
        var database = this.writableDatabase
        var contentValues = ContentValues()
        contentValues.put(ConstantIjtimoiy.ID,ijtimoiy.id)
        contentValues.put(ConstantIjtimoiy.NAME,ijtimoiy.sarlavha)
        contentValues.put(ConstantIjtimoiy.Text,ijtimoiy.discription)
        return database.update(ConstantIjtimoiy.TABLE_NAME,contentValues,"${ConstantIjtimoiy.ID}=?", arrayOf(ijtimoiy.id.toString()))
        database.close()
    }

    override fun getInformationById(id: Int): Ijtimoiy {
        var database = this.readableDatabase
        var cursor = database.query(
            ConstantIjtimoiy.TABLE_NAME, arrayOf(ConstantIjtimoiy.ID, ConstantIjtimoiy.NAME, ConstantIjtimoiy.Text),
            "${ConstantIjtimoiy.ID} = ?", arrayOf("$id"),null,null,null)
        cursor?.moveToFirst()
        return Ijtimoiy(cursor.getString(0),cursor.getString(1),cursor.getInt(2))
    }

    override fun getAllInformation(): List<Ijtimoiy> {
        var list = ArrayList<Ijtimoiy>()
        var query = "select*from ${ConstantIjtimoiy.TABLE_NAME}"
        var database = this.readableDatabase
        var cursor = database.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {

                var  name =cursor.getString(0)
                var text = cursor.getString(1)
                var id = cursor.getInt(2)
                var ijtimoiy = Ijtimoiy(name,text,id)
                list.add(ijtimoiy)
            }while (cursor.moveToNext())
        }
        return list
    }

}