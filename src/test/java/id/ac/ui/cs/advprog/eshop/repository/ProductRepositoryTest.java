package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setName("Product 1");
        product.setQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());

        Product savedProduct = productIterator.next();
        assertEquals(product.getId(), savedProduct.getId());
        assertEquals(product.getName(), savedProduct.getName());
        assertEquals(product.getQuantity(), savedProduct.getQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setName("Product 1");
        product1.setQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setId("eb558e9f-1c39-460e-8860-71af6af63bd7");
        product2.setName("Product 2");
        product2.setQuantity(200);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());

        Product savedProduct = productIterator.next();
        assertEquals(product1.getId(), savedProduct.getId());
        savedProduct = productIterator.next();
        assertEquals(product2.getId(), savedProduct.getId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindByIdProduct() {
        Product product = new Product();
        product.setName("Product 1");
        product.setQuantity(100);
        productRepository.create(product);

        Product findedProduct = productRepository.find(product.getId());
        assertEquals(product.getId(), findedProduct.getId());
        assertEquals(product.getName(), findedProduct.getName());
        assertEquals(product.getQuantity(), findedProduct.getQuantity());
    }

    @Test
    void testFindByIdProductIfDoesNotExist() {
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setQuantity(200);
        productRepository.create(product2);

        String randomId = UUID.randomUUID().toString();

        Product findedProduct = productRepository.find(randomId);
        assertNull(findedProduct);
    }

    @Test
    void testFindByIdProductIfMoreThanOneProduct() {
        for (int i = 0; i < 5; i++) {
            Product product = new Product();
            product.setName(String.format("Product %d", i + 1));
            product.setQuantity(100 + i);
            productRepository.create(product);
        }

        Product lastProduct = new Product();
        lastProduct.setName("Last Product");
        lastProduct.setQuantity(130);
        productRepository.create(lastProduct);

        Product findedProduct = productRepository.find(lastProduct.getId());
        assertEquals(lastProduct.getId(), findedProduct.getId());
        assertEquals(lastProduct.getName(), findedProduct.getName());
        assertEquals(lastProduct.getQuantity(), findedProduct.getQuantity());
    }

    @Test
    void testEditAndFindByIdProduct() {
        Product product = new Product();
        product.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setName("Product 1");
        product.setQuantity(100);
        productRepository.create(product);

        Product findProductById = productRepository.find(product.getId());
        assertEquals(findProductById.getId(), product.getId());
        assertEquals(findProductById.getName(), product.getName());
        assertEquals(findProductById.getQuantity(), product.getQuantity());

        Product editProductData = new Product();
        editProductData.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        editProductData.setName("Product 1 Edited");
        editProductData.setQuantity(200);
        //productRepository.update(editProductData);

        Product editedProduct = productRepository.find(editProductData.getId());
        assertEquals(editProductData.getId(), editedProduct.getId());
        assertEquals("Product 1 Edited", editedProduct.getName());
        assertEquals(200, editedProduct.getQuantity());
    }

    @Test
    void testEditProductIfQuantityPositive() {
        Product product = new Product();
        product.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setName("Product 1");
        product.setQuantity(100);
        productRepository.create(product);

        Product findProductById = productRepository.find(product.getId());
        assertEquals(findProductById.getId(), product.getId());
        assertEquals(findProductById.getName(), product.getName());
        assertEquals(findProductById.getQuantity(), product.getQuantity());

        Product editProductData = new Product();
        editProductData.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        editProductData.setName("Product 1 Edited");
        editProductData.setQuantity(110);
        productRepository.update("eb558e9f-1c39-460e-8860-71af6af63bd6",editProductData);

        Product editedProduct = productRepository.find(editProductData.getId());
        assertEquals(editProductData.getId(), editedProduct.getId());
        assertEquals("Product 1 Edited", editedProduct.getName());
        assertEquals(110, editedProduct.getQuantity());
    }

    @Test
    void testEditProductIfQuantityNegative() {
        Product product = new Product();
        product.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setName("Product 1");
        product.setQuantity(100);
        productRepository.create(product);

        Product findProductById = productRepository.find(product.getId());
        assertEquals(findProductById.getId(), product.getId());
        assertEquals(findProductById.getName(), product.getName());
        assertEquals(findProductById.getQuantity(), product.getQuantity());

        Product editProductData = new Product();
        editProductData.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        editProductData.setName("Product 1 Edited");
        editProductData.setQuantity(-120);
        productRepository.update("eb558e9f-1c39-460e-8860-71af6af63bd6",editProductData);

        Product editedProduct = productRepository.find(editProductData.getId());
        assertEquals(editProductData.getId(), editedProduct.getId());
        assertEquals("Product 1 Edited", editedProduct.getName());
        assertEquals(0, editedProduct.getQuantity());
    }

    @Test
    void testDeleteAndFindProduct() {
        Product product = new Product();
        product.setName("Product 1");
        product.setQuantity(100);
        productRepository.create(product);

        Product deletedProduct = productRepository.delete(product.getId());
        assertEquals(product.getId(), deletedProduct.getId());
        assertEquals(product.getName(), deletedProduct.getName());
        assertEquals(product.getQuantity(), deletedProduct.getQuantity());

        Product deletedProductIfSearch = productRepository.find(product.getId());
        assertNull(deletedProductIfSearch);
    }

    @Test
    void testDeleteProductIfEmpty() {
        String randomId = UUID.randomUUID().toString();

        Product deletedProduct = productRepository.delete(randomId);
        assertNull(deletedProduct);
    }

    @Test
    void testDeleteProductIfDoesNotExist() {
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setQuantity(200);
        productRepository.create(product2);

        String randomId = UUID.randomUUID().toString();

        Product findedProduct = productRepository.delete(randomId);
        assertNull(findedProduct);
    }

}
