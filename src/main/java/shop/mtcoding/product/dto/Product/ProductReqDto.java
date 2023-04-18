package shop.mtcoding.product.dto.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ProductReqDto {

    @Setter
    @Getter
    public static class SameReqDto {
        private String productname;
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductAddReqDto {
        private String productName;
        private Integer productPrice;
        private Integer productQty;
    }
}