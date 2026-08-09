<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Orders</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myorders.css">
</head>
<body>

<jsp:include page="navbar.jsp" />

<div class="orders-container">

    <h2 class="orders-title">My Orders</h2>

    <c:if test="${empty orders}">
        <p class="no-orders">No orders found.</p>
    </c:if>

    <div class="orders-list">

        <c:forEach var="order" items="${orders}">

            <div class="order-card">

                <!-- ORDER HEADER -->
                <div class="order-header">
                    <h3>Order #${order.orderId}</h3>
                    <span class="order-status ${order.status}">${order.status}</span>
                </div>

                <div class="order-info">
                    <p><b>Total:</b> ₹${order.totalAmount}</p>
                    <p><b>Time:</b> ${order.orderTime}</p>
                    <p><b>Restaurant:</b> ${order.restaurant.name}</p>
                </div>

                <!-- ITEMS -->
                <div class="order-items">

                    <c:forEach var="item" items="${order.orderItems}">

                        <div class="order-item">

                            <img src="${item.foodItem.img}" class="order-img"/>

                            <div class="item-details">
                                <p class="item-name">${item.foodItem.name}</p>
                                <p>Qty: ${item.quantity}</p>
                                <p>₹${item.price}</p>
                            </div>

                        </div>

                    </c:forEach>

                </div>

            </div>

        </c:forEach>

    </div>

</div>

</body>
</html>