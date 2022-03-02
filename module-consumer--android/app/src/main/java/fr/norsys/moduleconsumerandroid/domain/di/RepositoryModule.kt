package fr.norsys.moduleconsumerandroid.domain.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fr.norsys.moduleconsumerandroid.data.FlutterBridge
import fr.norsys.moduleconsumerandroid.data.FlutterBridgeImpl
import fr.norsys.moduleconsumerandroid.domain.repositories.DummyRepository
import fr.norsys.moduleconsumerandroid.domain.utils.AppConstants
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideFlutterEngine(@ApplicationContext appContext: Context): FlutterEngine {
        val flutterEngine = FlutterEngine(appContext)
        flutterEngine
            .dartExecutor
            .executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            )

        FlutterEngineCache
            .getInstance()
            .put(AppConstants.FULL_SCREEN_ENGINE_ID, flutterEngine)

        return flutterEngine
    }

    @Singleton
    @Provides
    fun provideFlutterBridge(flutterEngine: FlutterEngine): FlutterBridge {
        return FlutterBridgeImpl(flutterEngine)
    }

    @Singleton
    @Provides
    fun provideDummyRepository(flutterBridge: FlutterBridge): DummyRepository {
        return DummyRepository(flutterBridge)
    }
}