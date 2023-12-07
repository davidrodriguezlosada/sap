import 'package:customer_ui/models/Cart.dart';
import 'package:customer_ui/models/StoreDto.dart';

class CartHandler {
  static Map<StoreDto, Cart> _carts = new Map();
  static StoreDto _activeStore;

  static setActiveStore(StoreDto store) {
    _activeStore = store;
    if (!_hasCart(_activeStore)) {
      _createCart(_activeStore);
    }
  }

  static Cart getCart() {
    return _carts[_activeStore];
  }

  static bool _hasCart(StoreDto storeDto) {
    return _carts.containsKey(storeDto);
  }

  static cleanCart() {
    _carts.remove(_activeStore);
  }

  static Cart _createCart(StoreDto storeDto) {
    return _carts.putIfAbsent(storeDto, () => new Cart());
  }
}
