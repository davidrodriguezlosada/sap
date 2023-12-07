import 'package:flutter/material.dart';

import 'components/CartList.dart';

class CartScreen extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Your order')
      ),
      body: Center(
        child: new CartList(),
      ),
    );
  }
}