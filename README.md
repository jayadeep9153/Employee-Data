Employee Data Management
Overview

This project demonstrates a Java-based Employee Data Management system with a focus on object mapping. It includes an ObjectMapper utility that converts nested Map<String, Object> data structures into corresponding Java objects, supporting multi-level nested fields like address.city. The project is ideal for learning about reflection, dynamic object creation, and recursive mapping in Java.

Features

Map Map<String, Object> to Java objects dynamically.

Support for nested components (e.g., User -> Address -> City).

Automatic creation of nested objects if null.

Flexible type conversion using a custom ConverterRegistry.

Fully serializable Employee/User objects.

How It Works

The ObjectMapper.mapToObject method takes a Map<String, Object> and the target class type.

For each key-value pair:

If the key contains nested paths (e.g., address.city), the mapper recursively creates nested objects if they are null.

Uses reflection to call setters or directly set fields if setters are unavailable.

Supports custom type conversion via ConverterRegistry.

Example Usage
Map<String, Object> userData = new HashMap<>();
userData.put("id", "12354");
userData.put("name", "Jayadeep");
userData.put("address.city", "Bhimavaram");
userData.put("address.zip", "534201");
userData.put("address.state", "Andhra Pradesh");

User user = ObjectMapper.mapToObject(userData, User.class);
System.out.println(user);


Output:

User { id = 12354, name = Jayadeep, address = Address { city = Bhimavaram, zip = 534201, state = Andhra Pradesh } }
