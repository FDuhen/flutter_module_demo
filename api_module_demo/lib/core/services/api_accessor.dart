
import 'package:api_module_demo/core/services/api_dummy.dart';
import 'package:dio/dio.dart';


class ApiAccessor {
  Dio configureDio() {
    Dio dio = Dio();
    //Uncomment if you need to create your own interceptor
    // dio.interceptors.add(ApiInterceptor(dio));

    //Uncomment this for testing purpose if your backend is using
    //self-signed HTTPS certificates
    // (dio.httpClientAdapter as DefaultHttpClientAdapter).onHttpClientCreate =
    //     (HttpClient client) {
    //   client.badCertificateCallback =
    //       (X509Certificate cert, String host, int port) => true;
    //   return client;
    // };
    return dio;
  }

  ApiDummy getApiDummy(String baseUrl) {
    return ApiDummy(configureDio(), baseUrl: baseUrl);
  }
}
