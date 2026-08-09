<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
</head>

<body>

<jsp:include page="navbar.jsp" />

<div id="dashboard-container" class="dashboard-container">

   

    <header id="dashboard-header" class="dashboard-header">
        <h1 class="dashboard-title">Restaurants</h1>
    </header>

    <!-- ================= RESTAURANT LIST ================= -->
    <section id="restaurant-list" class="restaurant-grid">

        <c:forEach var="restaurant" items="${restaurants}">

            <div class="restaurant-card" id="restaurant-${restaurant.restaurantId}">

                <h2 class="restaurant-name">
                    ${restaurant.name}
                </h2>

                <p class="restaurant-owner">
                    Owner: <span>${restaurant.owner}</span>
                </p>

                <p class="restaurant-address">
                    ${restaurant.address}, ${restaurant.city}
                </p>

                <p class="restaurant-phone">
                    📞 ${restaurant.phone}
                </p>

                <p class="restaurant-timing">
                    🕒 ${restaurant.openTime} - ${restaurant.closeTime}
                </p>

                <p class="restaurant-rating">
                    ⭐ ${restaurant.rating}
                </p>

                <p class="restaurant-delivery">
                    🚚 ₹${restaurant.deliveryCharge}
                </p>

                <p class="restaurant-status ${restaurant.isactive ? 'active' : 'inactive'}">
                    <span>
                        <c:choose>
                            <c:when test="${restaurant.isactive}">
                                Open
                            </c:when>
                            <c:otherwise>
                                Closed
                            </c:otherwise>
                        </c:choose>
                    </span>
                </p>

                <a href="viewMenu?restaurantId=${restaurant.restaurantId}">
                    <button class="btn-primary">View Menu</button>
                </a>

            </div>

        </c:forEach>

    </section>

</div>

</body>
</html>