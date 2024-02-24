package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.*;
import id.ac.ui.cs.advprog.eshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {


  @Autowired
  private ProductServiceImpl service;


  @GetMapping("/create")
  public String createProductPage(Model model) {
    Product product = new Product();
    model.addAttribute("product", product);
    return "CreateProduct";
  }


  @PostMapping("/create")
  public String createProductPost(@ModelAttribute Product product, Model model) {
    service.create(product);
    return "redirect:list";
  }

  @GetMapping("/list")
  public String productListPage(Model model) {
    List<Product> allProducts = service.findAll();
    model.addAttribute("products", allProducts);
    return "ListProduct";
  }

  @GetMapping("/edit/{productId}")
  public String editProductPage(@PathVariable("productId") String productId, Model model) {
    Product product = service.find(productId);
    model.addAttribute("product", product);
    return "EditProduct";
  }

  @PutMapping("/edit")
  public String editProductPost(@ModelAttribute Product product) {
    service.update(product.getId().toString(),product);
    return "redirect:list";
  }
  @DeleteMapping("/delete/{productId}")
  public String deleteProduct(@PathVariable("productId") String productId) {
    service.delete(productId);
    return "redirect:../list";
  }

}

