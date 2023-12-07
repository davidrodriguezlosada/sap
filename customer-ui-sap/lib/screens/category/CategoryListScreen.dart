import 'package:customer_ui/models/CategoryDto.dart';
import 'package:customer_ui/models/StoreDto.dart';
import 'package:customer_ui/services/CategoryService.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

import 'components/CategoryList.dart';

class CategoryListScreen extends StatefulWidget {
  final StoreDto store;

  CategoryListScreen({Key key, @required this.store}) : super(key: key);

  @override
  _CategoryListState createState() => _CategoryListState(store);
}

class _CategoryListState extends State<CategoryListScreen> {
  Future<List<CategoryDto>> storesFuture;
  StoreDto store;

  _CategoryListState(StoreDto storeDto) {
    this.store = storeDto;
  }

  @override
  void initState() {
    super.initState();

    storesFuture = getCategoriesByStoreId(store.id);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Select category'),
          actions: [
            IconButton(
              icon: Icon(Icons.shopping_cart),
              onPressed: () => Navigator.pushNamed(context, '/cart'),
            ),
          ],
        ),
        body: Center(
          child: FutureBuilder(
            future: storesFuture,
            builder: (context, snapshot) {
              if (snapshot.hasData && snapshot.data.length > 0) {
                return new CategoryList(categories: snapshot.data);
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
