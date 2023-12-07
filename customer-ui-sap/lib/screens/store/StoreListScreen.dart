import 'package:customer_ui/models/StoreDto.dart';
import 'package:customer_ui/services/StoreService.dart';
import 'package:flutter/material.dart';

import 'components/StoreList.dart';

class StoreListScreen extends StatefulWidget {
  @override
  _StoreListState createState() => _StoreListState();
}

class _StoreListState extends State<StoreListScreen> {
  Future<List<StoreDto>> storesFuture;

  @override
  void initState() {
    super.initState();
    storesFuture = getStores();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: Text('Select your nearest pub')),
        body: Center(
          child: FutureBuilder<List<StoreDto>>(
            future: storesFuture,
            builder: (context, snapshot) {
              if (snapshot.hasData) {
                return new StoreList(stores: snapshot.data);
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
