import 'dart:convert';
import 'dart:io';

import 'package:customer_ui/models/CategoryDto.dart';
import 'package:customer_ui/models/ItemDto.dart';
import 'package:customer_ui/models/StoreDto.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {

  test('Test dto from json.', () async {
    final file = new File('test_resources/storeDtoTest.json');
    final storeJson = jsonDecode(await file.readAsString());

    final StoreDto storeDto = StoreDto.fromJson(storeJson);
    expect(storeDto.id, 1);
    expect(storeDto.name, "storeName");
    expect(storeDto.description, "storeDescription");
    expect(storeDto.logo, "LOGO");
    expect(storeDto.categories.length, 1);
  });

  test('Test dto to json.', () async {
    final CategoryDto categoryDto = new CategoryDto(
        id: 1,
        storeId: 1,
        name: "categoryName",
        description: "categoryDescription",
        image: "IMAGE");
    List<CategoryDto> categories = new List();
    categories.add(categoryDto);

    final StoreDto storeDto = new StoreDto(
        id: 1,
        name: "storeName",
        description: "storeDescription",
        logo: "LOGO",
        categories: categories
    );

    final storeJson = storeDto.toJson();

    final file = new File('test_resources/storeDtoTest.json');
    final categoryJsonTest = jsonDecode(await file.readAsString());

    expect(storeJson, categoryJsonTest);
  });
}
