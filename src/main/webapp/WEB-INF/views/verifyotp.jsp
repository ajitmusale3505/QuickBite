<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Verify OTP — FoodieExpress</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="page-wrapper">
    <div class="auth-card">

        <div class="auth-card-header">
            <span class="brand-icon">📱</span>
            <h2>Enter OTP</h2>
            <p class="subtitle">Check your email for the code</p>
        </div>

        <div class="auth-card-body">

            <%-- Success/info message (green) from servlet --%>
            <c:if test="${not empty msg}">
                <div class="msg-success">${msg}</div>
            </c:if>

            <p class="text-muted mb-16" style="font-size:0.9rem; text-align:center;">
                Enter the 6-digit OTP we sent to your registered email address.
            </p>

            <form action="/verify-otp" method="post">

                <div class="form-group">
                    <label for="otp" class="text-center" style="text-align:center; display:block;">
                        One-Time Password
                    </label>
                    <input type="text" id="otp" name="otp"
                           placeholder="• • • • • •"
                           maxlength="6" required />
                </div>

                <button type="submit">Verify OTP</button>

            </form>

            <div class="auth-footer">
                Didn't receive it? <a href="/forgot">Resend OTP</a>
            </div>

        </div>
    </div>
</div>

</body>
</html>
