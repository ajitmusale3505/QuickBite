<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Help & Support</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/help.css">
</head>
<body>

<jsp:include page="navbar.jsp" />

<div class="help-container">

    <h2 class="help-title">Help & Support</h2>

    <!-- FAQ -->
    <div class="section">
        <h3>Frequently Asked Questions</h3>

        <div class="faq-card">
            <p class="question">1. How do I place an order?</p>
            <p>Select a restaurant → Add items to cart → Proceed to checkout → Place order.</p>
        </div>

        <div class="faq-card">
            <p class="question">2. Can I cancel my order?</p>
            <p>Currently, cancellation is not available. This feature will be added soon.</p>
        </div>

        <div class="faq-card">
            <p class="question">3. How do I track my order?</p>
            <p>Go to "My Orders" section to check your order status.</p>
        </div>

        <div class="faq-card">
            <p class="question">4. What payment methods are available?</p>
            <p>You can pay using Cash on Delivery, UPI, or Card.</p>
        </div>
    </div>

    <!-- ORDER HELP -->
    <div class="section">
        <h3>Order Related Help</h3>

        <div class="quick-links">
            <a href="myOrders">My Orders</a>
            <a href="viewCart">View Cart</a>
            <a href="userDashboard">Browse Restaurants</a>
        </div>
    </div>

    <!-- CONTACT -->
    <div class="section contact-box">
        <h3>Contact Support</h3>

        <p>Email: <b>support@foodapp.com</b></p>
        <p>Phone: <b>+91 9876543210</b></p>
    </div>

    <!-- ISSUE FORM -->
    <div class="section form-section">
        <h3>Report an Issue</h3>

        <form action="submitIssue" method="post" class="issue-form">

            <div class="form-group">
                <label>Your Name</label>
                <input type="text" name="name" required>
            </div>

            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" required>
            </div>

            <div class="form-group">
                <label>Issue</label>
                <textarea name="issue" rows="4" required></textarea>
            </div>

            <button type="submit" class="submit-btn">Submit</button>

        </form>

    </div>

</div>

</body>
</html>