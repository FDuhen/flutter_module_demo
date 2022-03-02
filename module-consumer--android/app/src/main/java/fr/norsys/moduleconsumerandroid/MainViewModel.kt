package fr.norsys.moduleconsumerandroid

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.norsys.moduleconsumerandroid.domain.models.DummyModel
import fr.norsys.moduleconsumerandroid.domain.repositories.DummyRepository
import fr.norsys.moduleconsumerandroid.domain.utils.DataState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val dummyRepository: DummyRepository,
) : ViewModel() {
    private val _dataState: MutableLiveData<DataState<DummyModel?>> = MutableLiveData()

    val dataState: LiveData<DataState<DummyModel?>>
        get() = _dataState

    fun fetchDatas() {
        viewModelScope.launch {
            dummyRepository.getDummyDatas()
                .onEach { dataState ->
                    _dataState.value = dataState
                }
                .launchIn(viewModelScope)
        }
    }
}