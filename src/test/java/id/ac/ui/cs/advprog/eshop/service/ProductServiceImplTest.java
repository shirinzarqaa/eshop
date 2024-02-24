package id.ac.ui.cs.advprog.eshop.service;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Arrays;


@SpringBootTest
class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    void testCreateProduct() {
        Product product = new Product();
        when(productRepository.create(product)).thenReturn(product);
        Product createdProduct = productService.create(product);
        assertEquals(product, createdProduct);
        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testDeleteProduct() {
        String productId = "1";
        productService.delete(productId);
        verify(productRepository, times(1)).delete(productId);
    }

    @Test
    void testEditProduct() {
        Product editedProduct = new Product();
        String productId = "1";
        when(productRepository.update(productId,editedProduct)).thenReturn(editedProduct);
        Product result = productService.update(productId,editedProduct);
        assertEquals(editedProduct, result);
        verify(productRepository, times(1)).update(productId,editedProduct);
    }

    @Test
    void testFindById() {
        String productId = "1";
        Product expectedProduct = new Product();
        when(productRepository.find(productId)).thenReturn(expectedProduct);
        Product result = productService.find(productId);
        assertEquals(expectedProduct, result);
        verify(productRepository, times(1)).find(productId);
    }

    @Test
    void testFindAll() {
        List<Product> productList = Arrays.asList(
                new Product(),
                new Product()
        );
        when(productRepository.findAll()).thenReturn(productList.iterator());
        List<Product> result = productService.findAll();
        assertEquals(productList, result);
        verify(productRepository, times(1)).findAll();
    }






}



