<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Placed Successfully</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/order_success.css">
</head>

<body>

<div class="success-container">

    <div class="success-card">

        <!-- ICON -->
        <div class="success-icon">✔</div>

        <!-- TITLE -->
        <div class="title">Order Placed Successfully!</div>

        <!-- MESSAGE -->
        <div class="message">
            Thank you for your order. Your food is being prepared.
        </div>

        <!-- DETAILS -->
        <div class="details">
            <p><b>Order ID:</b> ${order.orderId}</p>
            <p><b>Total Amount:</b> ₹${order.totalAmount}</p>
            <p><b>Status:</b> ${order.status}</p>
            <p><b>Order Time:</b> ${order.orderTime}</p>
        </div>

        <!-- BUTTONS -->
        <div class="btn-group">

            <form action="userDashboard" method="get">
                <button class="btn home-btn" type="submit">
                    Back to Home
                </button>
            </form>

            <form action="myOrders" method="get">
                <button class="btn orders-btn" type="submit">
                    View My Orders
                </button>
            </form>

        </div>

    </div>

</div>

</body>
</html>