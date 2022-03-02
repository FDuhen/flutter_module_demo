package fr.norsys.moduleconsumerandroid.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import fr.norsys.moduleconsumerandroid.domain.models.DummyModel
import fr.norsys.moduleconsumerandroid.domain.utils.AppConstants
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class FlutterBridgeImpl @Inject constructor(flutterEngine: FlutterEngine) : FlutterBridge {

    private val methodChannel: MethodChannel = MethodChannel(
        flutterEngine.dartExecutor.binaryMessenger,
        AppConstants.CHANNEL_DUMMY
    )

    private val gson : Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    override suspend fun fetchDummyDatas(): DummyModel? =
        suspendCoroutine { cont ->
            methodChannel.invokeMethod(AppConstants.METHOD_GET_DUMMY, "DEFAULT", object : MethodChannel.Result {
                override fun success(result: Any?) {
                    if (result == null) {
                        cont.resumeWithException(Exception("Empty Model"))
                    } else {
                        try {
                            val data: String = result as String
                            val model : DummyModel = gson.fromJson(data, DummyModel::class.java)

                            cont.resume(model)
                        } catch (e: Exception) {
                            cont.resumeWithException(e)
                        }
                    }
                }

                override fun error(errorCode: String?, errorMessage: String?, errorDetails: Any?) {
                    cont.resumeWithException(Exception(errorMessage ?: "An error occured"))
                }

                override fun notImplemented() {
                    cont.resumeWithException(Exception("Method not found"))
                }

            })
        }
}