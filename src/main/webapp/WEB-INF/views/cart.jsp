<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cart</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cart.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />
<div class="cart-container">

    <h2 class="cart-title">Your Cart</h2>

    <div class="cart-content">

        <!-- LEFT: ITEMS -->
        <div class="cart-items">

            <c:forEach var="item" items="${cart.items.values()}">

                <div class="cart-item">

                    <img src="${item.img}" class="cart-img"/>

                    <div class="cart-details">

                        <h3 class="item-name">${item.name}</h3>

                        <p class="item-price">₹${item.price}</p>

                        <!-- Quantity Controls -->
                        <div class="qty-control">
                            <a href="decreaseQty?foodId=${item.foodId}" class="qty-btn">−</a>
                            <span class="qty-value">${item.quantity}</span>
                            <a href="increaseQty?foodId=${item.foodId}" class="qty-btn">+</a>
                        </div>

                        <p class="item-total">Total: ₹${item.price * item.quantity}</p>

                        <!-- Remove -->
                        <a href="removeItem?foodId=${item.foodId}">
                            <button class="remove-btn">Remove</button>
                        </a>

                    </div>

                </div>

            </c:forEach>

        </div>

        <!-- RIGHT: BILL -->
        <div class="bill-box">

            <h3>Subtotal: ₹${subtotal}</h3>
            <h3>GST (5%): ₹${gst}</h3>
            <h3>Delivery: ₹${delivery}</h3>

            <hr>

            <h2 class="total">Total: ₹${total}</h2>

            <form action="checkout" method="get">
                <button type="submit" class="checkout-btn">
                    Proceed to Checkout
                </button>
            </form>

        </div>

    </div>

</div>

</body>
</html>