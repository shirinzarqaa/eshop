package id.ac.ui.cs.advprog.eshop.controller;
import org.mockito.InjectMocks;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @InjectMocks
    private ProductController controller;
    @Mock
    private Model model;
    @Mock
    private ProductServiceImpl service;
    @Mock
    private Product product;


    @Test
    void testEditProductPage(){
        when(service.findById(String.valueOf(0))).thenReturn(new Product());

        String editProduct = controller.editProductPage(String.valueOf(0),model);
        assertEquals( "editProduct", editProduct);
    }

    @Test
    void testCreateProductPage() {
        String createProduct = controller.createProductPage(model);
        assertEquals("createProduct",createProduct);

    }

    @Test
    void testCreateProductPost(){
        String createPost = controller.createProductPost(product);


        assertEquals("redirect:list",createPost);

    }

    @Test
    void testProductListPage(){
        String pages = controller.productListPage(model);
        assertEquals("productList",pages);
    }

    @Test
    void testEditProductPost(){
        when(service.edit(product)).thenReturn(product);
        String editProductPostPage = controller.editProductPost(product);
        assertEquals("redirect:list", editProductPostPage);

    }

    @Test
    void testDeleteProduct(){
        when(service.findById(String.valueOf(0))).thenReturn(new Product());
        String deleteProductPage = controller.deleteProduct(String.valueOf(0));
        assertEquals("redirect:../list", deleteProductPage);

    }



}
