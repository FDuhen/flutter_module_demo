
import 'dart:convert';

import 'package:json_annotation/json_annotation.dart';

part 'dummy.g.dart';

@JsonSerializable()
class Dummy {
  final String? dummyString;

  Dummy({this.dummyString});

  factory Dummy.fromJson(Map<String, dynamic> json) => _$DummyFromJson(json);
  Map<String, dynamic> toJson() => _$DummyToJson(this);

  String toRawJson() => jsonEncode(toJson());
}