import 'package:customer_ui/constants.dart';
import 'package:customer_ui/models/CartItem.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

class CartRow extends StatelessWidget {
  final CartItem cartItem;

  const CartRow({Key key, @required this.cartItem}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Text(
            NumberFormat.compactLong(locale: 'en').format(cartItem.quantity) + ' x ' + cartItem.item.name,
            style: biggerFont,
          ),
          Text(NumberFormat.simpleCurrency(locale: 'en').format(cartItem.item.price * cartItem.quantity), style: biggerFont)
        ],
      ),
    );
  }
}