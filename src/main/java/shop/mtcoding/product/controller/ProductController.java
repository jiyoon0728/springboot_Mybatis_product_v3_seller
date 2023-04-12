package shop.mtcoding.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import shop.mtcoding.product.model.product.Product;
import shop.mtcoding.product.model.product.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("product/addForm")
    public String addForm() {
        return "product/addForm";
    }

    @GetMapping("product/detail")
    public String detail() {
        return "product/detail";
    }

    @GetMapping("product/list")
    public String list(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);
        return "product/list";
    }

    @GetMapping("product/update")
    public String update() {
        return "product/updateForm";
    }

}
