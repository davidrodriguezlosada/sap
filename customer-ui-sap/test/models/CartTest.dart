

import 'dart:convert';
import 'dart:io';

import 'package:customer_ui/models/Cart.dart';
import 'package:customer_ui/models/ItemDto.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {

  test('Test add item for the first time.', () async {
    Cart cart = new Cart();

    final ItemDto item = new ItemDto(
        id: 1,
        categoryId: 1,
        name: "itemName",
        description: "itemDescription",
        image: "IMAGE");

    cart.addItem(item, 1);

    expect(cart.getItems().length, 1);
    expect(cart.getItems().first.quantity, 1);
    expect(cart.getItems().first.item.id, 1);
  });

  test('Test add item for second time.', () async {
    Cart cart = new Cart();

    final ItemDto item = new ItemDto(
        id: 1,
        categoryId: 1,
        name: "itemName",
        description: "itemDescription",
        image: "IMAGE");

    cart.addItem(item, 1);
    cart.addItem(item, 1);

    expect(cart.getItems().length, 1);
    expect(cart.getItems().first.quantity, 2);
    expect(cart.getItems().first.item.id, 1);
  });

  test('Test add two different items.', () async {
    Cart cart = new Cart();

    final ItemDto item = new ItemDto(
        id: 1,
        categoryId: 1,
        name: "itemName",
        description: "itemDescription",
        image: "IMAGE");

    final ItemDto item2 = new ItemDto(
        id: 2,
        categoryId: 1,
        name: "itemName2",
        description: "itemDescription2",
        image: "IMAGE");

    cart.addItem(item, 1);
    cart.addItem(item2, 1);

    expect(cart.getItems().length, 2);
    expect(cart.getItems().first.quantity, 1);
    expect(cart.getItems().first.item.id, 1);
    expect(cart.getItems().last.quantity, 1);
    expect(cart.getItems().last.item.id, 2);
  });
}