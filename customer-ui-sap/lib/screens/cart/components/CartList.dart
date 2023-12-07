import 'package:customer_ui/components/CartHandler.dart';
import 'package:flutter/widgets.dart';

import 'CartRow.dart';

class CartList extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        padding: EdgeInsets.all(16.0),
        itemCount: CartHandler.getCart().getItems().length,
        itemBuilder: (context, i) {
          return new CartRow(cartItem: CartHandler.getCart().getItems().elementAt(i));
        });
  }
}