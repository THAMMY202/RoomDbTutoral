package com.tutorial.roomdbtutoral.repository

import androidx.lifecycle.LiveData
import com.tutorial.roomdbtutoral.dao.UserDao
import com.tutorial.roomdbtutoral.models.User

class UserRepository (private val userSource: UserDao) {
    //Get the data from the DB
    val allUsers: LiveData<List<User>> = userSource.getAll()

    //Insert the element to the DB
    fun insetUser(user: User) {
        userSource.insertAll(user)
    }

    //Update the selected element title
    suspend fun updateTitle(id:Int, title:String)
    {
        //movieSource. (id = id , newTitle = title)
    }

    //Delete the selected item
    fun delete(user: User) {
        userSource.delete(user)
    }
}