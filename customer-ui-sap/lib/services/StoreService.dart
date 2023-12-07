import 'dart:convert';

import 'package:customer_ui/config/EnvironmentConfig.dart';
import 'package:customer_ui/models/StoreDto.dart';
import 'package:http/http.dart' as http;
import 'package:http/http.dart';

/// Returns all the stores in the system
Future<List<StoreDto>> getStores() async {
  var url =
      EnvironmentConfig.CUSTOMER_SERVICE_SAP_URL + "/customer-service/store";

  Response response = await http.get(url);
  if (response.statusCode != 200) {
    throw new Exception("Error fetching stores");
  }

  List l = jsonDecode(response.body);
  return List.from(l).map((model) => StoreDto.fromJson(model)).toList();
}
