package shop.mtcoding.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.product.dto.ResponseDto;
import shop.mtcoding.product.dto.Product.ProductReqDto.ProductAddReqDto;
import shop.mtcoding.product.dto.Product.ProductReqDto.SameReqDto;
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
    

    @GetMapping("/product/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "product/detail";
    }

    @GetMapping({ "/", "/product" })
    public String list(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);
        return "product/list";
    }

    @GetMapping("/product/{id}/updateForm")
    public String updateForm(@PathVariable Integer id, Model model) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "product/updateForm";
    }

    @PostMapping("/product/{id}/update")
    public String update(
            @PathVariable Integer id,
            String name,
            Integer price,
            Integer qty) {
        int result = productRepository.update(id, name, price, qty);
        if (result == 1) {
            return "redirect:/product/" + id;
        } else {
            return "redirect:/product/" + id + "/updateForm";
        }
    }

    @PostMapping("/product/{id}/delete")
    public String delete(@PathVariable int id) {
        int result = productRepository.delete(id);
        if (result == 1) {
            return "redirect:/";
        } else {
            return "redirect:/product/" + id;
        }
    }

    //상품 중복 확인
    @GetMapping("/product/productnameSameCheck")
    public @ResponseBody ResponseDto<?> check(String productname, SameReqDto SameReqDto) {

        if (productname == null || productname.isEmpty()) {
            return new ResponseDto<>(-1, "제품 이름을 입력 해 주세요", null);
        }

        Product sameProduct = productRepository.findByName(SameReqDto.getProductname());
        if (sameProduct != null) {
            return new ResponseDto<>(1, "동일한 제품이 존재합니다", false);
        } else {
            return new ResponseDto<>(1, "제품 등록이 가능합니다", true);

        }
    }

    //상품 등록하기 
    @PostMapping("/product/add")
    public @ResponseBody ResponseDto<?> add(@RequestBody ProductAddReqDto productAddReqDto) {
        System.out.println("디버깅 : " + productAddReqDto.getProductName());
        System.out.println("디버깅 : " + productAddReqDto.getProductPrice());
        System.out.println("디버깅 : " + productAddReqDto.getProductQty());
        int result = productRepository.insert(productAddReqDto);
        System.out.println("디버깅 : ");
        if (result == 1) {
            return new ResponseDto<>(1, "제품등록 성공", null);
        } else {
            return new ResponseDto<>(-1, "제품등록 실패", null);
        }
    }
}