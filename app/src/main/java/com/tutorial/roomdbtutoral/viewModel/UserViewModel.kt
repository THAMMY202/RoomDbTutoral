package com.tutorial.roomdbtutoral.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutorial.roomdbtutoral.models.User
import com.tutorial.roomdbtutoral.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel (private val repository: UserRepository) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allItems: LiveData<List<User>> = repository.allUsers

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(user: User) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.insetUser(user)
        }
    }

    fun delete(user: User) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.delete(user)
        }
    }

    fun updateTitle(id:Int, title:String) = viewModelScope.launch {
        withContext(Dispatchers.IO)
        {
            repository.updateTitle(id = id, title = title)
        }
    }
}