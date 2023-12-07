import 'package:customer_ui/screens/cart/CartScreen.dart';
import 'package:customer_ui/screens/category/CategoryListScreen.dart';
import 'package:customer_ui/screens/item/ItemListScreen.dart';
import 'package:customer_ui/screens/store/StoreListScreen.dart';
import 'package:flutter/material.dart';

import 'config/theme.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  static const routeName = "/category";

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Startup name generator',
      theme: appTheme,
      home: StoreListScreen(),
      onGenerateRoute: (settings) {
        switch (settings.name) {
          case "/category":
            return showCategoryListScreen(settings);
          case "/item":
            return showItemListScreen(settings);
          case "/cart":
            return showCartScreen(settings);
          default:
            return null;
        }
      },
    );
  }

  MaterialPageRoute showCategoryListScreen(RouteSettings settings) {
    return MaterialPageRoute(
      builder: (context) {
        return CategoryListScreen(
          store: settings.arguments,
        );
      },
    );
  }

  MaterialPageRoute showItemListScreen(RouteSettings settings) {
    return MaterialPageRoute(
      builder: (context) {
        return ItemListScreen(
          category: settings.arguments,
        );
      },
    );
  }

  MaterialPageRoute showCartScreen(RouteSettings settings) {
    return MaterialPageRoute(
      builder: (context) {
        return CartScreen();
      }
    );
  }
}
