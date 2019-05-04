<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<h4>Add Product</h4>
<form method="post" action="<c:url value="/updateProductDB/${product.productId}"/>" enctype="multipart/form-data">
<table class="table table-hover">
<tr>
<td>Select Category:</td>
<td><select required id="sel" name="catid">
<option value="" disabled selected>Select</option>

<c:forEach items="${listCategories}" var="category">
<option value="${category.catid}">${category.catname}</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td>Select Supplier:</td>
<td><select required id="sel" name="supId">
<option value="" disabled selected>Select</option>
<c:forEach items="${listSuppliers}" var="supplier">
<option value="${supplier.supId}">${supplier.supName}</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td>Product Name</td>
<td><input name="productName" value="${product.productName}"/></td>
</tr>
<tr>
<td>Product Description</td>
<td><input name="prodDesc" value="${product.prodDesc}"/></td>
</tr>
<tr>
<td>Product Price</td>
<td><input name="price" value="${product.price}"/></td>
</tr>
<tr>
<td>Product Stock</td>
<td><input name="stock" value="${product.stock}"/></td>
</tr>
<tr>
<td>Product Image</td>
<td><img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="75px" height="75px"></td>
</tr>
<tr>
<td>Change Image</td>
<td><input type="file" accept="/resources/images/*" name="pimage"/></td>
</tr>
<tr>
<td colspan = "2">
<center><input type="submit" class="btn btn-success btn-xs" value="UPDATE"/>
<input type="reset" class="btn btn-danger btn-xs" value="RESET"/></center>
</td>
</tr>
</table>
<div class="container">
<table class="table table-bordered" style="border-width:3px;border-color:black;">
<tr style="background-color:black; color:white;">
<td>Product ID</td>
<td>Product Name</td>
<td>Product Description</td>
<td>Product Price</td>
<td>Product Stock</td>
<td>Category ID</td>
<td>Supplier ID</td>
<td>Product Image</td>
<td>Operation</td>
</tr>
<c:forEach items="${listProducts}" var="product">
<tr>
<td>${product.productId}</td>
<td>${product.productName}</td>
<td>${product.prodDesc}</td>
<td>${product.price}</td>
<td>${product.stock}</td>
<td>${product.catid}</td>
<td>${product.supId}</td>
<td><img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="75px" height="75px"></td>

<td>
<a href="<c:url value="/updateProduct/${product.productId}"/>" class="btn btn-success btn-xs">UPDATE</a>
<a href="<c:url value="/deleteProduct/${product.productId}"/>" class="btn btn-danger btn-xs">DELETE</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</form>

</body>
</html>