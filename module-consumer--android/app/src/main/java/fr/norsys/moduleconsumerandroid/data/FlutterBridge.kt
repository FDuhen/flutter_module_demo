package fr.norsys.moduleconsumerandroid.data

import fr.norsys.moduleconsumerandroid.domain.models.DummyModel

interface FlutterBridge {
    suspend fun fetchDummyDatas(): DummyModel?
}