import 'dart:convert';
import 'dart:io';

import 'package:customer_ui/models/CategoryDto.dart';
import 'package:customer_ui/models/ItemDto.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {

  test('Test dto from json.', () async {
    final file = new File('test_resources/categoryDtoTest.json');
    final categoryJson = jsonDecode(await file.readAsString());

    final CategoryDto categoryDto = CategoryDto.fromJson(categoryJson);
    expect(categoryDto.id, 1);
    expect(categoryDto.storeId, 1);
    expect(categoryDto.name, "categoryName");
    expect(categoryDto.description, "categoryDescription");
    expect(categoryDto.image, "IMAGE");
    expect(categoryDto.items.length, 1);
  });

  test('Test dto to json.', () async {
    final ItemDto itemDto = new ItemDto(
        id: 1,
        categoryId: 1,
        name: "itemName",
        description: "itemDescription",
        image: "IMAGE");
    List<ItemDto> items = new List();
    items.add(itemDto);

    final CategoryDto categoryDto = new CategoryDto(
        id: 1,
        storeId: 1,
        name: "categoryName",
        description: "categoryDescription",
        image: "IMAGE",
        items: items
    );

    final categoryJson = categoryDto.toJson();

    final file = new File('test_resources/categoryDtoTest.json');
    final categoryJsonTest = jsonDecode(await file.readAsString());

    expect(categoryJson, categoryJsonTest);
  });
}
