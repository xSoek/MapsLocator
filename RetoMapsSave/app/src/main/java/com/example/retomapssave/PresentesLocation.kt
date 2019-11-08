package com.example.retomapssave

import android.view.View
import com.example.persistence.data.local.AppDatabase
import com.example.retomapssave.Dao.Location
import com.example.retomapssave.Dao.LocationDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NotesListPresenter(val appDatabase: AppDatabase, view: View) {

    fun onInsertClicked(new: Location){
        val locationDao = appDatabase.locationDao()

        CoroutineScope(Dispatchers.IO).launch {
            locationDao.insert(new)
            val locat = locationDao.getAll()
            withContext(Dispatchers.Main) {
                view.showNotes(locat)
            }

        }
    }
}

interface NotesListView {
    fun showNotes(location: List<Location>)
}