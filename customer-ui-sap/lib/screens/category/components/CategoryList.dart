import 'package:customer_ui/models/CategoryDto.dart';
import 'package:flutter/material.dart';

import 'CategoryRow.dart';

class CategoryList extends StatelessWidget {
  final List<CategoryDto> categories;

  const CategoryList({Key key, @required this.categories}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        padding: EdgeInsets.all(16.0),
        itemCount: categories.length,
        itemBuilder: (context, i) {
          return new CategoryRow(category: categories[i]);
        });
  }
}
