import 'CategoryDto.dart';

class StoreDto {
  final int id;
  final String name;
  final String description;
  final dynamic logo;
  final List<CategoryDto> categories;

  const StoreDto(
      {this.id, this.name, this.description, this.logo, this.categories});

  factory StoreDto.fromJson(Map<String, dynamic> json) {
    return StoreDto(
        id: json['id'],
        name: json['name'],
        description: json['description'],
        logo: json['logo'],
        categories: json['categories'] != null
            ? (json['categories'] as List)
                .map((i) => CategoryDto.fromJson(i))
                .toList()
            : new List());
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'description': description,
      'logo': logo,
      'categories': categories != null
          ? categories.map((i) => i.toJson()).toList()
          : new List(),
    };
  }

  @override
  int get hashCode => id.hashCode;

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) || other is StoreDto && id == other.id;
  }
}
