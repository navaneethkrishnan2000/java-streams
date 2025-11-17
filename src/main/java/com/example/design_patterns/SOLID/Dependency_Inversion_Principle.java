package com.example.design_patterns.SOLID;

/**
 * High-level modules should not depend on low-level modules.
 * Both should depend on abstractions.
 * Abstractions should not depend on details.
 * Details should depend on abstractions

    BAD EXAMPLE - ProductService directly depends on MySQLRepository.
    class MySQLProductRepository {
        public void save(String product) {
            System.out.println("Saved on MySQL: " + product);
        }
    }

    class ProductService {
        private MySQLProductRepository repository = new MySQLProductRepository();

        public void addProduct(String product) {
            repository.save(product); // tightly coupled
        }
    }

    Problems:
        - If you want to switch to MongoDB, you must modify ProductService -> violates Open/Closed too.
        - Hard to test.
        - Strong coupling -> rigid design


    Good Example (Follows DIP)
        - We introduce an abstraction (interface).
        - Now both high-level and low-level modules depend on this interface.
 */

// Create an abstraction(interface)
interface ProductRepository {
    void save(String product);
}

// low-level modules depend on abstraction
class MySQLProductRepository implements ProductRepository {
    @Override
    public void save(String product) {
        System.out.println("Saved to MySQL: " + product);
    }
}
class MongoProductRepository implements ProductRepository {
    @Override
    public void save(String product) {
        System.out.println("Saved to MongoDB: " + product);
    }
}

// High-level module depends on abstraction
// Dependency is injected → constructor injection
class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(String product) {
        repository.save(product);
    }
}

public class Dependency_Inversion_Principle {
    public static void main(String[] args) {

        // We can choose the implementation at runtime
//        ProductRepository productRepository = new MySQLProductRepository();
        ProductRepository productRepository = new MongoProductRepository();

        ProductService productService = new ProductService(productRepository);

        productService.addProduct("Laptop");
    }
}

/**

 Why this follows DIP?
 | Before                                           | After                                                       |
 | ------------------------------------------------ | ----------------------------------------------------------- |
 | ProductService depends on MySQLProductRepository | ProductService depends on **ProductRepository (interface)** |
 | Changing DB requires modifying service           | Swap DB without modifying service                           |
 | Tight coupling                                   | Loose coupling                                              |
 | Hard to test                                     | Very easy to use mock in testing                            |

 */
