package fr.norsys.moduleconsumerandroid.domain.repositories

import fr.norsys.moduleconsumerandroid.data.FlutterBridge
import fr.norsys.moduleconsumerandroid.domain.models.DummyModel
import fr.norsys.moduleconsumerandroid.domain.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DummyRepository @Inject constructor(private val flutterBridge: FlutterBridge) {

    suspend fun getDummyDatas(): Flow<DataState<DummyModel?>> = flow {
        emit(DataState.Loading)

        try {
            val dummyModel = flutterBridge.fetchDummyDatas()
            if (dummyModel != null) {
                emit(DataState.Success(dummyModel))
            } else {
                emit(DataState.Error(Exception("Error while loading dummy model")))
            }
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}
