import 'dart:convert';
import 'dart:typed_data';

import 'package:customer_ui/components/CartHandler.dart';
import 'package:customer_ui/constants.dart';
import 'package:customer_ui/models/StoreDto.dart';
import 'package:flutter/material.dart';

class StoreRow extends StatelessWidget {
  final StoreDto store;

  const StoreRow({Key key, @required this.store}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    // TODO: Check image null
    Uint8List image = Base64Codec().decode(store.logo);

    return InkWell(
      child: Card(
        child: Column(
          children: [
            Container(child: new Image.memory(image)),
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Align(
                alignment: Alignment.centerLeft,
                child: Text(
                  store.name,
                  style: biggerFont,
                ),
              ),
            ),
          ],
        ),
      ),
      onTap: () {
        CartHandler.setActiveStore(store);

        Navigator.pushNamed(context, "/category", arguments: store);
      },
    );
  }
}
