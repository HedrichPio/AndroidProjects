package com.hedrich.receipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    // creating a read-only state, derive it from a mutable state:
    // private variable only accessed within class
    private val _categoryState = mutableStateOf(ReceipeState())
    //public variable accessible from outside but read-only
    val categoryState:State<ReceipeState> = _categoryState

    private fun fetchCategories(){
        viewModelScope.launch {
            try{
                val response = receipeService.getCategories()
                _categoryState.value = _categoryState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )

            }catch (e:Exception){
                _categoryState.value = _categoryState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

data class ReceipeState(
    val loading : Boolean = true,
    val list : List<Category> = emptyList(),
    val error: String? = null
)

}