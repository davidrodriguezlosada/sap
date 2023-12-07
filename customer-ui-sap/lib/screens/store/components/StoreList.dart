import 'package:customer_ui/models/StoreDto.dart';
import 'package:flutter/material.dart';

import 'StoreRow.dart';

class StoreList extends StatelessWidget {
  final List<StoreDto> stores;

  const StoreList({Key key, @required this.stores}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        padding: EdgeInsets.all(16.0),
        itemCount: stores.length,
        itemBuilder: (context, i) {
          return new StoreRow(store: stores[i]);
        });
  }
}
