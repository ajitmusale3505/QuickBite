<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css">

    <script>
        function increase(id) {
            let qtySpan = document.getElementById("qty-" + id);
            let input = document.getElementById("input-" + id);

            let value = parseInt(qtySpan.innerText);
            value++;

            qtySpan.innerText = value;
            input.value = value;
        }

        function decrease(id) {
            let qtySpan = document.getElementById("qty-" + id);
            let input = document.getElementById("input-" + id);

            let value = parseInt(qtySpan.innerText);
            if (value > 0) {
                value--;
            }

            qtySpan.innerText = value;
            input.value = value;
        }
    </script>
</head>

<body>

<jsp:include page="navbar.jsp" />

<div class="menu-container">

    <!-- RESTAURANT HEADER -->
    <div class="restaurant-header">
        <h2 class="restaurant-title">${restaurant.name}</h2>
        <p class="restaurant-info">${restaurant.address}, ${restaurant.city}</p>
    </div>

    <!-- FOOD GRID -->
    <div class="menu-grid">

        <c:forEach var="item" items="${foodItems}">

            <div class="food-card">

                <!-- IMAGE -->
                <img src="${item.img}" class="food-img"/>

                <!-- DETAILS -->
                <div class="food-details">

                    <h3 class="food-name">${item.name}</h3>

                    <p class="food-desc">${item.description}</p>

                    <p class="food-price">₹${item.price}</p>

                    <p class="food-type">
                        <c:choose>
                            <c:when test="${item.vage}">
                                <span class="veg">Veg</span>
                            </c:when>
                            <c:otherwise>
                                <span class="nonveg">Non-Veg</span>
                            </c:otherwise>
                        </c:choose>
                    </p>

                    <p class="prep-time">⏱ ${item.preparationTime} min</p>

                    <!-- QTY CONTROL -->
                    <div class="qty-control">
                        <button onclick="decrease(${item.foodId})">-</button>
                        <span id="qty-${item.foodId}">0</span>
                        <button onclick="increase(${item.foodId})">+</button>
                    </div>

                    <!-- ADD TO CART -->
                    <form action="addToCart" method="post">
                        <input type="hidden" name="foodId" value="${item.foodId}">
                        <input type="hidden" name="quantity" id="input-${item.foodId}" value="0">
                        <button type="submit" class="add-btn">Add to Cart</button>
                    </form>

                </div>

            </div>

        </c:forEach>

    </div>

</div>

</body>
</html>