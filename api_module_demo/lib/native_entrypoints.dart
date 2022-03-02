import 'package:api_module_demo/core/providers/backend_provider.dart';
import 'package:api_module_demo/core/utils/const.dart';
import 'package:api_module_demo/main.dart';
import 'package:flutter/services.dart';

class NativeEntrypoints {
  final platform = const MethodChannel(channelDummy);
  final BackendProvider _backendProvider = getIt.get();

  NativeEntrypoints() {
    setNativeListeners();
  }

  void setNativeListeners() {
    platform.setMethodCallHandler((methodCall) async {
      switch (methodCall.method) {
        case methodGetDummy:
          return await _backendProvider
              .fetchDatas()
              .then((dummyModel) => dummyModel.toRawJson());
      }
    });
  }
}
