
import 'package:api_module_demo/core/models/dummy.dart';
import 'package:api_module_demo/core/services/api_accessor.dart';
import 'package:api_module_demo/core/services/api_dummy.dart';
import 'package:api_module_demo/main.dart';

class BackendProvider {
  final ApiAccessor _apiAccessor = getIt.get();
  late ApiDummy _apiDummy;

  BackendProvider() {
    _apiDummy = _apiAccessor.getApiDummy("https://api.jsonbin.io/b");
  }

  Future<Dummy> fetchDatas() {
    return _apiDummy.getDummy();
  }

}