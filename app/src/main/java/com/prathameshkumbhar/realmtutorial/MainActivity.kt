package com.prathameshkumbhar.realmtutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.prathameshkumbhar.realmtutorial.presentation.screen.HomeScreen
import com.prathameshkumbhar.realmtutorial.presentation.viewmodel.HomeViewModel
import com.prathameshkumbhar.realmtutorial.ui.theme.RealmTutorialTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RealmTutorialTheme {
                val viewModel: HomeViewModel = hiltViewModel()
                val data by viewModel.data
                HomeScreen(
                    data = data,
                    filtered = viewModel.filtered.value,
                    name = viewModel.name.value,
                    objectId = viewModel.objectId.value,
                    onNameChanged = { viewModel.updateName(name = it) },
                    onObjectIdChanged = { viewModel.updateObjectId(id = it) },
                    onInsertClicked = { viewModel.insertPerson() },
                    onUpdateClicked = { viewModel.updatePerson() },
                    onDeleteClicked = { viewModel.deletePerson() },
                    onFilterClicked = { viewModel.filterData() }
                )
            }
        }
    }
}