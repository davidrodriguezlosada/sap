import 'dart:convert';
import 'dart:typed_data';

import 'package:customer_ui/constants.dart';
import 'package:customer_ui/models/CategoryDto.dart';
import 'package:flutter/material.dart';

class CategoryRow extends StatelessWidget {
  final CategoryDto category;

  const CategoryRow({Key key, @required this.category}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    //TODO: check image null
    Uint8List image = Base64Codec().decode(category.image);

    return InkWell(
      child: Card(
        child: Column(children: [
          Container(child: new Image.memory(image)),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Align(
              alignment: Alignment.centerLeft,
              child: Text(
                category.name,
                style: biggerFont,
              ),
            ),
          ),
        ]),
      ),
      onTap: () {
        Navigator.pushNamed(context, "/item", arguments: category);
      },
    );
  }
}
