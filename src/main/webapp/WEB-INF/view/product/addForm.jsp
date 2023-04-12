<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
    <h3>상품 등록 페이지</h3>
    <form action="/product/add" method="post">
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
            <button id="btnProductSameCheck" type="submit"
                class="btn btn-warning">상품명 중복 확인</button>
            <button id="btnInsert" type="submit" 
                class="btn btn-primary">상품등록완료</button>
        </div>
    </form>
</div>

<%@ include file="../layout/footer.jsp"%>