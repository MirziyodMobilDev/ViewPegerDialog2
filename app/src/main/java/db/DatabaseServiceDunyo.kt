package db

import modul.Dunyo

interface DatabaseServiceDunyo {
    fun addInformation(dunyo: Dunyo)
    fun deleteInformation(dunyo: Dunyo)
    fun updateInformation(dunyo: Dunyo):Int
    fun getInformationById(id:Int): Dunyo
    fun getAllInformation():List<Dunyo>

}