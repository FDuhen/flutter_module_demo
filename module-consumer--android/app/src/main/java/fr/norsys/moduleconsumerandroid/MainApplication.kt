package fr.norsys.moduleconsumerandroid

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import fr.norsys.moduleconsumerandroid.domain.utils.AppConstants
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

@HiltAndroidApp
class MainApplication : Application() {
//    lateinit var flutterEngine : FlutterEngine

    override fun onCreate() {
        super.onCreate()

//        flutterEngine = FlutterEngine(this)
//
//        flutterEngine
//            .dartExecutor
//            .executeDartEntrypoint(
//                DartExecutor.DartEntrypoint.createDefault()
//            )
//
//        FlutterEngineCache
//            .getInstance()
//            .put(AppConstants.FULL_SCREEN_ENGINE_ID, flutterEngine)

    }
}