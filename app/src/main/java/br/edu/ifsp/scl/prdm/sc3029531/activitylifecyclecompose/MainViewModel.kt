package br.edu.ifsp.scl.prdm.sc3029531.activitylifecyclecompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// herda de ViewModel
class MainViewModel(val savedStateHandle: SavedStateHandle): ViewModel() {

    private val _uiState = MutableStateFlow(
        savedStateHandle[USER_KEY]?: User()
    )

    //está exposto, mas como ele não é mutable, eu só consigo dar get nele
    val uiState: StateFlow<User> = _uiState.asStateFlow()

    //  companion object -> é um singleton interno
    private companion object {
        const val USER_KEY = "user"
    }

//    val x = mutableStateOf("")

    var name by mutableStateOf("")
        private set

    var age by mutableIntStateOf(0)
        private set

    fun updateName(name: String) {
        _uiState.update { it.copy(name = name) }
        savedStateHandle[USER_KEY] = uiState.value.copy(name = name)
    }

    //it -> é o objeto do user atual

    fun updateAge(age: Int?) {
        _uiState.update {
//            User(name = it.name, age = age)
            it.copy(age = age?: 0)
        }
        savedStateHandle[USER_KEY] = _uiState.value.copy(age = age?: 0)
    }



}