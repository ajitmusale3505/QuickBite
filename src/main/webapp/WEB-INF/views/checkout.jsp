<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/checkout.css">
</head>
<body>

<div class="checkout-container">

    <h2 class="checkout-title">Checkout</h2>

    <div class="checkout-content">

        <!-- LEFT: BILL -->
        <div class="bill-section">

            <h3>Bill Summary</h3>

            <div class="bill-item">
                <span>Subtotal</span>
                <span>₹${subtotal}</span>
            </div>

            <div class="bill-item">
                <span>GST (5%)</span>
                <span>₹${gst}</span>
            </div>

            <div class="bill-item">
                <span>Delivery</span>
                <span>₹${delivery}</span>
            </div>

            <hr>

            <div class="bill-total">
                <span>Total</span>
                <span>₹${total}</span>
            </div>

        </div>

        <!-- RIGHT: PAYMENT -->
        <div class="payment-section">

            <h3>Select Payment Method</h3>

            <form action="placeOrder" method="post">

                <label class="payment-option">
                    <input type="radio" name="paymentMethod" value="COD" required>
                    <div class="payment-card">Cash on Delivery</div>
                </label>

                <label class="payment-option">
                    <input type="radio" name="paymentMethod" value="UPI">
                    <div class="payment-card">UPI</div>
                </label>

                <label class="payment-option">
                    <input type="radio" name="paymentMethod" value="CARD">
                    <div class="payment-card">Card</div>
                </label>

                <button type="submit" class="place-order-btn">
                    Place Order
                </button>

            </form>

        </div>

    </div>

</div>

</body>
</html>