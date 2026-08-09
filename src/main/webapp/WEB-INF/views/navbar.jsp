<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Navbar</title>

    <!-- Navbar CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">
</head>
<body>

<!-- NAVBAR START -->
<div class="navbar">

    <!-- LEFT SECTION -->
    <div class="nav-left">
        <a href="userDashboard" class="logo">
            FoodDeliveryApp
        </a>
    </div>

    <!-- CENTER (SEARCH) -->
    <div class="nav-center">
        <form action="search" method="post" class="search-form">
            <input type="text" name="restaurent_Name" placeholder="Search restaurants...">
            <button type="submit">Search</button>
        </form>
    </div>

    <!-- RIGHT SECTION -->
    <div class="nav-right">

        <a href="offers">Offers</a>
        <a href="help">Help</a>
        <a href="viewCart">Cart</a>
        <a href="myOrders">My Orders</a>

        <a href="logout" class="logout-btn">Logout</a>

    </div>

</div>

<!-- NAVBAR END -->

</body>
</html>