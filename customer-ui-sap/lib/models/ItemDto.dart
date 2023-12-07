class ItemDto {
  final int id;
  final int categoryId;
  final String name;
  final String description;
  final dynamic image;
  final double price;
  final String currency;

  const ItemDto({this.price, this.currency,
    this.id,
    this.categoryId,
    this.name,
    this.description,
    this.image,
  });

  factory ItemDto.fromJson(Map<String, dynamic> json) {
    return ItemDto(
        id: json['id'],
        categoryId: json['categoryId'],
        name: json['name'],
        description: json['description'],
        image: json['image'],
        price: double.parse(json['price'].toString()),
        currency: json['currency']);
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'categoryId': categoryId,
      'name': name,
      'description': description,
      'image': image,
      'price': price,
      'currency': currency,
    };
  }

  @override
  int get hashCode => id.hashCode;

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) || other is ItemDto && id == other.id;
  }
}
