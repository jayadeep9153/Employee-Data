# Employee Data Management System

## Overview

The **Employee Data Management System** is a Java-based project designed to demonstrate **dynamic object mapping** and management of employee-related data.
The project includes an `ObjectMapper` utility capable of converting **nested `Map<String, Object>` structures** into corresponding Java objects. This allows for **multi-level nested fields** like `address.city` to be populated automatically.

This project is ideal for developers looking to understand:

* Reflection in Java
* Dynamic object creation
* Recursive mapping
* Custom type conversion

---

## Features

* Map `Map<String, Object>` to Java objects dynamically
* Support for **nested components** (e.g., `User -> Address -> City`)
* Automatic creation of nested objects if `null`
* Flexible type conversion using a custom `ConverterRegistry`
* Serializable `Employee` and `User` objects
* Handles multi-level nested fields like `address.city.state.zip`

---

## How It Works

1. **Mapping:** `ObjectMapper.mapToObject(Map<String, Object> data, Class<T> clazz)` converts a map into a Java object of the given class.
2. **Nested Object Handling:** If the key contains nested paths (e.g., `address.city`), the mapper recursively creates nested objects when null.
3. **Reflection:** Uses Java reflection to either invoke setters or directly set field values.
4. **Type Conversion:** Supports type conversions via `ConverterRegistry` for flexibility (e.g., converting String to Integer).

---

## Example Usage

```java
Map<String, Object> userData = new HashMap<>();
userData.put("id", "12354");
userData.put("name", "Jayadeep");
userData.put("address.city", "Bhimavaram");
userData.put("address.zip", "534201");
userData.put("address.state", "Andhra Pradesh");

User user = ObjectMapper.mapToObject(userData, User.class);
System.out.println(user);
```

**Output:**

```
User { id = 12354, name = Jayadeep, address = Address { city = Bhimavaram, zip = 534201, state = Andhra Pradesh } }
```

---

## Project Structure

```
Employee Data/
├── src/
│   ├── com/
│   │   └── TypeConverter/
│   │       └── ConverterRegistry.java
│   ├── ObjectMapper.java
│   ├── User.java
│   ├── Address.java
│   └── TestObjectMapper.java
├── .gitignore
└── README.md
```

* `ObjectMapper.java`: Core utility for mapping maps to objects
* `User.java`, `Address.java`: Sample classes with nested fields
* `ConverterRegistry.java`: Handles type conversions dynamically
* `TestObjectMapper.java`: Demonstrates usage of `ObjectMapper`
