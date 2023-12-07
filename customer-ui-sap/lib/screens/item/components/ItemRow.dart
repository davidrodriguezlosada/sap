import 'package:customer_ui/components/CartHandler.dart';
import 'package:customer_ui/constants.dart';
import 'package:customer_ui/models/ItemDto.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

class ItemRow extends StatelessWidget {
  final ItemDto item;

  const ItemRow({Key key, @required this.item}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return InkWell(
        child: Padding(
          padding: const EdgeInsets.all(8.0),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text(
                item.name,
                style: biggerFont,
              ),
              Text(NumberFormat.simpleCurrency(locale: 'en').format(item.price), style: biggerFont)
            ],
          ),
        ),
        onTap: () {
          Scaffold.of(context).hideCurrentSnackBar();
          CartHandler.getCart().addItem(item, 1);
          Scaffold.of(context).showSnackBar(SnackBar(
            content: Text("Item added to the cart"),
            duration: const Duration(seconds: 1),
          ));
        });
  }
}
