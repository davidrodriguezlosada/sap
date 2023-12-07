import 'ItemDto.dart';

class CategoryDto {
  final int id;
  final int storeId;
  final String name;
  final String description;
  final dynamic image;
  final List<ItemDto> items;

  const CategoryDto(
      {this.id,
      this.storeId,
      this.name,
      this.description,
      this.image,
      this.items});

  factory CategoryDto.fromJson(Map<String, dynamic> json) {
    return CategoryDto(
        id: json['id'],
        storeId: json['storeId'],
        name: json['name'],
        description: json['description'],
        image: json['image'],
        items: json['items'] != null
            ? (json['items'] as List).map((i) => ItemDto.fromJson(i)).toList()
            : new List());
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'storeId': storeId,
      'name': name,
      'description': description,
      'image': image,
      'items':
          items != null ? items.map((i) => i.toJson()).toList() : new List(),
    };
  }

  @override
  int get hashCode => id.hashCode;

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) || other is CategoryDto && id == other.id;
  }
}
