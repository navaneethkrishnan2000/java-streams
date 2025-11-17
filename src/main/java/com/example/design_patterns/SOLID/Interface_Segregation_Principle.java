package com.example.design_patterns.SOLID;

/**
 * A client should not be forced to depend on methods it does not use,
 * Interfaces should be small and specific, not large and general.

    BAD EXAMPLE
    interface ProductOperations {
        void addProduct();
        void viewProducts();
        void deleteProduct();
        void applyDiscount();
    }

    problem:
        - AdminService -> add, delete, discount
        - CustomerService -> only view products
    But both must implement all four methods, even if they don't use them -> it's an ISP violation

    GOOD EXAMPLE
        Split the single fat interface into role-based smaller interfaces
 */

// Customer can only view products
interface ProductViewOperations {
    void viewProducts();
}

// Admin can manage CRUD
interface ProductAdminCrudOperations {
    void addProduct();
    void deleteProduct();
}

// Admin can apply discount
interface ProductDiscountOperations {
    void applyDiscount();
}

// Implement only what each service needs
// Admin Service -> Needs CRUD + discount + view
class AdminService implements
        ProductAdminCrudOperations,
        ProductDiscountOperations,
        ProductViewOperations {

    @Override
    public void addProduct() {
        System.out.println("Admin: Product added");
    }

    @Override
    public void deleteProduct() {
        System.out.println("Admin: Product deleted");
    }

    @Override
    public void applyDiscount() {
        System.out.println("Admin: Discount applied");
    }

    @Override
    public void viewProducts() {
        System.out.println("Admin: Viewing all products");
    }
}

// CustomerService -> Needs only view
class CustomerService implements ProductViewOperations {

    @Override
    public void viewProducts() {
        System.out.println("Customer: Viewing available products");
    }
}

public class Interface_Segregation_Principle {
    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        CustomerService customerService = new CustomerService();

        adminService.addProduct();
        adminService.applyDiscount();
        customerService.viewProducts();
    }
}


