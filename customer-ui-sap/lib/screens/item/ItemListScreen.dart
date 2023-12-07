import 'package:customer_ui/models/CategoryDto.dart';
import 'package:customer_ui/models/ItemDto.dart';
import 'package:customer_ui/services/ItemService.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

import 'components/ItemList.dart';

class ItemListScreen extends StatefulWidget {
  final CategoryDto category;

  ItemListScreen({Key key, @required this.category}) : super(key: key);

  @override
  _ItemListState createState() => _ItemListState(category);
}

class _ItemListState extends State<ItemListScreen> {
  Future<List<ItemDto>> itemsFuture;
  CategoryDto category;

  _ItemListState(CategoryDto categoryDto) {
    this.category = categoryDto;
  }

  @override
  void initState() {
    super.initState();

    itemsFuture = getItemsByCategoryId(category.id);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Select items'),
          actions: [
            IconButton(
              icon: Icon(Icons.shopping_cart),
              onPressed: () => Navigator.pushNamed(context, '/cart'),
            ),
          ],
        ),
        body: Center(
          child: FutureBuilder<List<ItemDto>>(
            future: itemsFuture,
            builder: (context, snapshot) {
              if (snapshot.hasData && snapshot.data.length > 0) {
                return new ItemList(items: snapshot.data);
              } else if (snapshot.hasError) {
                return Text("${snapshot.error}");
              } else if (snapshot.connectionState == ConnectionState.done) {
                return Text('Not found');
              }

              // By default, show a loading spinner.
              return CircularProgressIndicator();
            },
          ),
        ));
  }
}
