import 'package:api_module_demo/core/providers/backend_provider.dart';
import 'package:api_module_demo/core/services/api_accessor.dart';
import 'package:api_module_demo/native_entrypoints.dart';
import 'package:flutter/material.dart';
import 'package:get_it/get_it.dart';

final GetIt getIt = GetIt.instance;

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  getIt.registerSingleton(ApiAccessor());
  getIt.registerSingleton(BackendProvider());

  NativeEntrypoints();
}