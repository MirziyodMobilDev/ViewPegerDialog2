package db

import modul.Asos

interface DatabaseServiceAsos {
    fun addInformation(asos: Asos)
    fun deleteInformation(asos: Asos)
    fun updateInformation(asos: Asos):Int
    fun getInformationById(id:Int): Asos
    fun getAllInformation():List<Asos>

}