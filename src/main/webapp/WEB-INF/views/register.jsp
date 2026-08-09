<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register — FoodieExpress</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>

<div class="page-wrapper auth-page">
    <div class="auth-card">

        <div class="auth-card-header">
            <img src="https://cdn-icons-png.flaticon.com/512/1404/1404945.png" class="brand-icon"/>
            <h2 class="auth-title">Create Account</h2>
            <p class="subtitle">Join FoodieExpress today</p>
        </div>

        <div class="auth-card-body">

            <c:if test="${not empty errorMsg}">
                <div class="msg-error">${errorMsg}</div>
            </c:if>

            <form action="register" method="post" class="auth-form">

                <div class="form-group">
                    <label for="name">Full Name</label>
                    <input type="text" id="name" name="name"
                           placeholder="Enter Your Name..." required />
                </div>

                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email" id="email" name="email"
                           placeholder="abcd@gmail.com" required />
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password"
                           placeholder="Create a strong password" required />
                </div>

                <div class="form-group role-select-group">
                    <label>Register as</label>

                    <div class="role-options">

                        <label class="role-option">
                            <input type="radio" name="role" value="CUSTOMER" checked />
                            <div class="role-card">
                                <img src="https://cdn-icons-png.flaticon.com/512/3144/3144456.png" />
                                <span>Customer</span>
                            </div>
                        </label>

                        <label class="role-option">
                            <input type="radio" name="role" value="RESTAURANT_OWNER" />
                            <div class="role-card">
                                <img src="https://cdn-icons-png.flaticon.com/512/2921/2921822.png" />
                                <span>Restaurant Owner</span>
                            </div>
                        </label>

                        <label class="role-option">
                            <input type="radio" name="role" value="DELIVERY_AGENT" />
                            <div class="role-card">
                                <img src="https://cdn-icons-png.flaticon.com/512/2972/2972185.png" />
                                <span>Delivery Agent</span>
                            </div>
                        </label>

                    </div>
                </div>

                <input type="submit" value="Create Account" class="btn-primary"/>

            </form>

            <div class="auth-footer">
                Already have an account? <a href="login">Sign In</a>
            </div>

        </div>
    </div>
</div>

</body>
</html>