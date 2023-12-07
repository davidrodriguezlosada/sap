import 'dart:convert';

import 'package:customer_ui/config/EnvironmentConfig.dart';
import 'package:customer_ui/models/CategoryDto.dart';
import 'package:http/http.dart';

/// Returns all the categories in the system
Future<List<CategoryDto>> getCategoriesByStoreId(int storeId) async {
  var url = EnvironmentConfig.CUSTOMER_SERVICE_SAP_URL +
      "/customer-service/category?storeId=" +
      storeId.toString();

  Response response = await get(url);
  if (response.statusCode != 200) {
    throw new Exception("Error fetching categories");
  }

  List l = jsonDecode(response.body);
  return List.from(l).map((model) => CategoryDto.fromJson(model)).toList();
}
