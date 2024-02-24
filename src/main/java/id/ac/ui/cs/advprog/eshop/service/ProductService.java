package id.ac.ui.cs.advprog.eshop.service;


import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;


public interface ProductService<T extends Product> {
  public T create(T product);


  public List<T> findAll();

  public void delete(String productId);


  T find(String productId);

  public T update(String productId,  T product);
}
