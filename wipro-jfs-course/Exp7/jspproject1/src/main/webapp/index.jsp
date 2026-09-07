<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Inventory</title>
</head>
<body>

<h2>Product Inventory Form</h2>

<form action="server.jsp" method="post">

    <label>Product ID:</label>
    <input type="text" name="productId" required>
    <br><br>

    <label>Product Name:</label>
    <input type="text" name="productName" required>
    <br><br>

    <label>Unit Price:</label>
    <input type="number" name="unitPrice" step="0.01" required>
    <br><br>

    <label>Quantity:</label>
    <input type="number" name="quantity" required>
    <br><br>

    <label>Supplier Name:</label>
    <input type="text" name="supplierName" required>
    <br><br>

    <button type="submit">Submit</button>

</form>

</body>
</html>