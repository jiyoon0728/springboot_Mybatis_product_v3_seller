package shop.mtcoding.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("product/addForm")
    public String addForm() {
        return "product/addForm";
    }

    @GetMapping("product/detail")
    public String detail() {
        return "product/detail";
    }

    @GetMapping("product/list")
    public String list() {
        return "product/list";
    }

    @GetMapping("product/update")
    public String update() {
        return "product/updateForm";
    }

}
