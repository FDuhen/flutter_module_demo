import 'package:api_module_demo/core/models/dummy.dart';
import 'package:dio/dio.dart' hide Headers;
import 'package:retrofit/retrofit.dart';

part 'api_dummy.g.dart';

@RestApi()
abstract class ApiDummy {
  factory ApiDummy(Dio dio, {String baseUrl}) = _ApiDummy;

  @GET("/621e47f1a703bb67491f5146")
  Future<Dummy> getDummy();
}
