<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Restaurant</title>

    <!-- You can link your CSS later -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owner.css">

</head>
<body>

<div id="add-restaurant-container">

    <div id="add-restaurant-card">

        <h2 class="add-restaurant-title">Add Your Restaurant</h2>

        <form action="saveRestaurant" method="post" id="add-restaurant-form">

            <!-- Restaurant Name -->
            <div class="form-group">
                <label for="name">Restaurant Name</label>
                <input type="text" id="name" name="name" required class="input-field">
            </div>

            <!-- Address -->
            <div class="form-group">
                <label for="address">Address</label>
                <input type="text" id="address" name="address" required class="input-field">
            </div>

            <!-- City -->
            <div class="form-group">
                <label for="city">City</label>
                <input type="text" id="city" name="city" required class="input-field">
            </div>

            <!-- Phone -->
            <div class="form-group">
                <label for="phone">Phone</label>
                <input type="number" id="phone" name="phone" required class="input-field">
            </div>

            <!-- Open Time -->
            <div class="form-group">
                <label for="openTime">Opening Time</label>
                <input type="time" id="openTime" name="openTime" required class="input-field">
            </div>

            <!-- Close Time -->
            <div class="form-group">
                <label for="closeTime">Closing Time</label>
                <input type="time" id="closeTime" name="closeTime" required class="input-field">
            </div>

            <!-- Rating -->
            <div class="form-group">
                <label for="rating">Rating</label>
                <input type="text" id="rating" name="rating" placeholder="e.g. 4.5" required class="input-field">
            </div>

            <!-- Delivery Charge -->
            <div class="form-group">
                <label for="deliveryCharge">Delivery Charge</label>
                <input type="number" step="0.01" id="deliveryCharge" name="deliveryCharge" required class="input-field">
            </div>

            <!-- Active Status -->
            <div class="form-group checkbox-group">
                <label for="isactive">Active</label>
                <input type="checkbox" id="isactive" name="isactive" value="true" class="checkbox-field">
            </div>

            <!-- Submit -->
            <div class="form-group">
                <button type="submit" id="submit-btn" class="submit-button">
                    Add Restaurant
                </button>
            </div>

        </form>

    </div>

</div>

</body>
</html>