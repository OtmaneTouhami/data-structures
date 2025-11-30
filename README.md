# Data Structures Learning Project

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-Project-blue.svg)](https://maven.apache.org/)
[![JUnit](https://img.shields.io/badge/JUnit-5.10.0-green.svg)](https://junit.org/junit5/)

A hands-on learning project for implementing and understanding fundamental data structures in Java. This project focuses on building data structures from scratch to gain a deeper understanding of their internal workings.

## 📚 Table of Contents

- [About](#about)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Project](#running-the-project)
- [Data Structures Implemented](#data-structures-implemented)
- [Usage Examples](#usage-examples)
- [Running Tests](#running-tests)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## 🎯 About

This project is a personal learning journey into the world of data structures. Rather than relying on Java's built-in collections, this repository contains custom implementations that demonstrate the core concepts and algorithms behind common data structures.

**Learning Goals:**
- Understand the internal mechanics of data structures
- Practice implementing algorithms from scratch
- Write comprehensive unit tests
- Follow Java best practices and conventions

## ✨ Features

- **Type-Safe Implementations**: All data structures use Java generics for type safety
- **Comprehensive Testing**: JUnit 5 test suite with extensive test coverage
- **Well-Documented Code**: Clear comments and meaningful variable names
- **Dynamic Resizing**: Efficient memory management with automatic capacity adjustment
- **Maven Build System**: Easy dependency management and project building

## 🚀 Getting Started

### Prerequisites

- **Java Development Kit (JDK) 21** or higher
- **Apache Maven 3.6+**
- A Java IDE (IntelliJ IDEA, Eclipse, or VS Code recommended)

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd data-structures
```

2. Build the project using Maven:
```bash
mvn clean install
```

### Running the Project

Execute the main class:
```bash
mvn exec:java -Dexec.mainClass="com.learning.Main"
```

Or compile and run directly:
```bash
mvn compile
java -cp target/classes com.learning.Main
```

## 📊 Data Structures Implemented

### DynamicList&lt;E&gt;

A generic dynamic array implementation similar to `ArrayList` that automatically resizes as elements are added.

**Features:**
- Dynamic capacity management (doubles when full)
- Generic type support
- Index-based access, insertion, and removal
- Support for null elements
- O(1) average-time complexity for add and get operations
- O(n) worst-case for add when resizing is needed

**Available Operations:**
- `add(E element)` - Append element to the end
- `add(int index, E element)` - Insert element at specific index
- `get(int index)` - Retrieve element at index
- `set(int index, E element)` - Update element at index
- `remove(int index)` - Remove element by index
- `remove(Object element)` - Remove first occurrence of element
- `size()` - Get current number of elements
- `isEmpty()` - Check if list is empty
- `clear()` - Remove all elements
- `contains(Object element)` - Check if element exists
- `indexOf(Object element)` - Find first index of element
- `lastIndexOf(E element)` - Find last index of element

## 💡 Usage Examples

```java
import com.learning.structures.DynamicList;

public class Example {
    public static void main(String[] args) {
        // Create a new dynamic list
        DynamicList<String> names = new DynamicList<>();
        
        // Add elements
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        
        // Insert at specific position
        names.add(1, "David");
        
        // Access elements
        String first = names.get(0);  // "Alice"
        
        // Update elements
        names.set(2, "Eve");
        
        // Remove elements
        names.remove(0);                    // Remove by index
        names.remove("Bob");                // Remove by value
        
        // Check properties
        int size = names.size();            // Get current size
        boolean empty = names.isEmpty();    // Check if empty
        boolean hasEve = names.contains("Eve");  // Check existence
        
        // Find elements
        int index = names.indexOf("Charlie");
        
        // Display the list
        System.out.println(names);
    }
}
```

### Creating with Initial Capacity

```java
// Create with custom initial capacity
DynamicList<Integer> numbers = new DynamicList<>(50);

// Create from existing array
Integer[] array = {1, 2, 3, 4, 5};
DynamicList<Integer> fromArray = new DynamicList<>(array);
```

## 🧪 Running Tests

The project uses JUnit 5 for testing. Run all tests with:

```bash
mvn test
```

Run specific test class:
```bash
mvn test -Dtest=DynamicListTest
```

Run with verbose output:
```bash
mvn test -X
```

### Test Coverage

The test suite includes:
- ✅ Basic add and get operations
- ✅ Insertion at specific indices
- ✅ Dynamic resizing behavior
- ✅ Element removal (by index and value)
- ✅ Set and update operations
- ✅ Boundary condition testing
- ✅ Exception handling (IndexOutOfBoundsException)
- ✅ Edge cases (empty list, null elements)

## 📁 Project Structure

```
data-structures/
├── pom.xml                          # Maven configuration
├── README.md                        # This file
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── learning/
│   │   │           ├── Main.java              # Application entry point
│   │   │           └── structures/
│   │   │               └── DynamicList.java   # Dynamic array implementation
│   │   └── resources/
│   └── test/
│       └── java/
│           └── com/
│               └── learning/
│                   └── structures/
│                       └── DynamicListTest.java  # Unit tests
└── target/                          # Compiled classes (generated)
```

## 🤝 Contributing

This is a personal learning project, but suggestions and improvements are welcome! Feel free to:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-structure`)
3. Commit your changes (`git commit -am 'Add new data structure'`)
4. Push to the branch (`git push origin feature/new-structure`)
5. Open a Pull Request

## 📝 Future Enhancements

Planned data structures to implement:
- [ ] LinkedList (Singly and Doubly)
- [ ] Stack
- [ ] Queue (Array-based and LinkedList-based)
- [ ] Binary Search Tree
- [ ] Hash Table
- [ ] Heap (Min and Max)
- [ ] Graph (Adjacency List and Matrix)
- [ ] Trie

## 📄 License

This project is available for educational purposes. Feel free to use it for learning and reference.

## 👤 Author

A passionate learner exploring the fundamentals of computer science and data structures.

---

**Happy Learning! 🚀**

