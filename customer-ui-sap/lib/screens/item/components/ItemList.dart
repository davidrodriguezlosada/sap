import 'package:customer_ui/models/ItemDto.dart';
import 'package:flutter/material.dart';

import 'ItemRow.dart';

class ItemList extends StatelessWidget {
  final List<ItemDto> items;

  const ItemList({Key key, @required this.items}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        padding: EdgeInsets.all(16.0),
        itemCount: items.length,
        itemBuilder: (context, i) {
          return new ItemRow(item: items[i]);
        });
  }
}
