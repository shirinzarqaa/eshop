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
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void testCreateProduct() {
        Product product = new Product();
        when(productRepository.create(product)).thenReturn(product);
        Product createdProduct = productService.create(product);
        assertEquals(product, createdProduct);
        verify(productRepository, times(1)).create(product);
    }

    @Test
    public void testDeleteProduct() {
        String productId = "1";
        productService.delete(productId);
        verify(productRepository, times(1)).delete(productId);
    }

    @Test
    public void testEditProduct() {
        Product editedProduct = new Product();
        when(productRepository.edit(editedProduct)).thenReturn(editedProduct);
        Product result = productService.edit(editedProduct);
        assertEquals(editedProduct, result);
        verify(productRepository, times(1)).edit(editedProduct);
    }

    @Test
    public void testFindById() {
        String productId = "1";
        Product expectedProduct = new Product();
        when(productRepository.findById(productId)).thenReturn(expectedProduct);
        Product result = productService.findById(productId);
        assertEquals(expectedProduct, result);
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    public void testFindAll() {
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



