import 'dart:convert';

import 'package:customer_ui/config/EnvironmentConfig.dart';
import 'package:customer_ui/models/ItemDto.dart';
import 'package:http/http.dart';

Future<List<ItemDto>> getItemsByCategoryId(int categoryId) async {
  var url = EnvironmentConfig.CUSTOMER_SERVICE_SAP_URL +
    "/customer-service/item?categoryId=" +
    categoryId.toString();

  Response response = await get(url);
  if(response.statusCode != 200) {
    throw new Exception("Error fetching items");
  }

  List l = jsonDecode(response.body);
  return List.from(l).map((model) => ItemDto.fromJson(model)).toList();
}