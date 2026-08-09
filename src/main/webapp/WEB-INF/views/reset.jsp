<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password — FoodieExpress</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
</head>
<body>

<div class="page-wrapper auth-page">
    <div class="auth-card">

        <div class="auth-card-header">
            <img src="https://cdn-icons-png.flaticon.com/512/3064/3064155.png" class="brand-icon"/>
            <h2 class="auth-title">Reset Password</h2>
            <p class="subtitle">Create a new secure password</p>
        </div>

        <div class="auth-card-body">

            <c:if test="${not empty msg}">
                <div class="msg-error">${msg}</div>
            </c:if>

            <form action="/reset" method="post" class="auth-form">

                <div class="form-group">
                    <label for="password">New Password</label>
                    <input type="password" id="password" name="password"
                           placeholder="Enter new password" required />
                </div>

                <button type="submit" class="btn-primary">
                    Reset Password
                </button>

            </form>

            <div class="auth-footer">
                <a href="login">← Back to Login</a>
            </div>

        </div>
    </div>
</div>

</body>
</html>