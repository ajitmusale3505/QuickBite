<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LoginFoodieExpress</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
	

<div class="page-wrapper auth-page">
    <div class="auth-card">

        <div class="auth-card-header">
            <img src="https://cdn-icons-png.flaticon.com/512/1404/1404945.png" class="brand-icon" />
            <h2 class="auth-title">Welcome Back</h2>
            <p class="subtitle">Sign in to your account</p>
        </div>

        <div class="auth-card-body">

            <%-- Error message from LoginServlet --%>
            <c:if test="${not empty msg}">
                <div class="msg-error">${msg}</div>
            </c:if>

            <form action="login" method="post" class="auth-form">

                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email" id="email" name="email"
                           placeholder="abcd@gmail.com" required />
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password"
                           placeholder="Enter Password..." required />
                </div>

                <a href="/forgot" class="forgot-link">Forgot Password?</a>

                <input type="submit" value="Sign In" class="btn-primary"/>

            </form>

            <div class="auth-footer">
                Don't have an account? <a href="register">Register Now</a>
            </div>

        </div>
    </div>
</div>

</body>
</html>