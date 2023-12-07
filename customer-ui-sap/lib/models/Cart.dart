import 'CartItem.dart';
import 'ItemDto.dart';

class Cart {
  Set<CartItem> _cartItems = new Set();

  Cart();

  addItem(ItemDto item, double quantity) {
    _cartItems.add(_getItem(item, quantity));
  }

  CartItem _getItem(ItemDto item, double quantity) {
    CartItem cartItem = _cartItems.firstWhere((element) => element.item == item, orElse: () => new CartItem(item, 0));
    cartItem.quantity += quantity;

    return cartItem;
  }

  removeItem(CartItem cartItem) {
    _cartItems.remove(cartItem);
  }

  List<CartItem> getItems() {
    return List.unmodifiable(_cartItems);
  }
}
