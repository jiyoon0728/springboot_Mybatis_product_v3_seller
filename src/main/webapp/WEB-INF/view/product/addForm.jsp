<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
    <h3>상품 등록 페이지</h3>
    <%-- <form action="/product/add" method="post"> --%>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>상품명</th>
                    <th>상품가격</th>
                    <th>상품수량</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input id="name" name="name" type="text"
                            class="form-control" placeholder="상품명을 입력하세요"></td>
                    <td><input id="price" name="price" type="text"
                            class="form-control" placeholder="가격을 입력하세요"></td>
                    <td><input id="qty" name="qty" type="text"
                            class="form-control" placeholder="수량을 입력하세요"></td>
                </tr>
            </tbody>
        </table>
        <div align="center">
            <button id="btnProductSameCheck" type="button"
                class="btn btn-warning" onclick="productSameCheck()">상품명 중복 확인</button>
            <button id="btnInsert" type="submit" 
                class="btn btn-primary">상품등록완료!</button>
        </div>
    </form>
</div>

<script>
let submitCheck = false;
let productnameSameCheckEvent = true;

     // 상품등록
$("#btnInsert").click(() => {
	insertProduct();
});

$("#btnProductSameCheck").click(() => {
	checkProductName();
});// 리스너


function insertProduct() {
	if (submitCheck == false) {
		alert("상품명 중복 확인을 해주세요");
		return;
	}

    if(productnameSameCheckEvent != $("#name").val()){
        alert("상품명 중복 확인을 다시 해주세요")
        return;
    }

	let data = {
		productName: $("#name").val(),
		productPrice: $("#price").val(),
		productQty: $("#qty").val()
	};

	$.ajax({
		type : "POST",
        url : "/product/add",
		dataType : "json",
		data : JSON.stringify(data), 
		contentType: "application/json",
	}).done((res)=> {
		if(res.code == 1){
			alert("제품등록에 성공하였습니다.");
			location.replace("/");
		} else {
			alert("제품등록에 실패하였습니다");
			history.back();
		}
	});
}

         //상품명 중복 확인
    function productSameCheck() {
        let productname = $("#name").val();
        $.ajax({
            type: "get",
            url: "/product/productnameSameCheck?productname=" + productname
        }).done((res) => {
            console.log(res);
            if (res.data === true) {
                alert(res.msg);
                submitCheck = true;
                productnameSameCheckEvent = $("#name").val();
            } else {
                alert(res.msg);
                submitCheck = false;
            }
        }).fail((err) => {
        });
    }
   
</script>
<%@ include file="../layout/footer.jsp"%>