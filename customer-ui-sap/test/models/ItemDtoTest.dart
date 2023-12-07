import 'dart:convert';
import 'dart:io';

import 'package:customer_ui/models/ItemDto.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {

  test('Test dto from json.', () async {
    final file = new File('test_resources/itemDtoTest.json');
    final itemJson = jsonDecode(await file.readAsString());

    final ItemDto itemDto = ItemDto.fromJson(itemJson);
    expect(itemDto.id, 1);
    expect(itemDto.categoryId, 2);
    expect(itemDto.name, "itemName");
    expect(itemDto.description, "itemDescription");
    expect(itemDto.image, "IMAGE");
  });

  test('Test dto to json.', () async {
    final ItemDto itemDto = new ItemDto(
        id: 1,
        categoryId: 2,
        name: "itemName",
        description: "itemDescription",
        image: "IMAGE");

    final itemJson = itemDto.toJson();

    final file = new File('test_resources/itemDtoTest.json');
    final itemJsonTest = jsonDecode(await file.readAsString());

    expect(itemJson, itemJsonTest);
  });
}
