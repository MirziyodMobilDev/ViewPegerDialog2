package db

import modul.Ijtimoiy

interface DatabaseServiceIjtimoiy {
    fun addInformation(ijtimoiy: Ijtimoiy)
    fun deleteInformation(ijtimoiy: Ijtimoiy)
    fun updateInformation(ijtimoiy: Ijtimoiy):Int
    fun getInformationById(id:Int): Ijtimoiy
    fun getAllInformation():List<Ijtimoiy>

}