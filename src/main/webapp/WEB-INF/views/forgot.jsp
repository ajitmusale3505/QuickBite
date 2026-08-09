<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password — FoodieExpress</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/forgot.css">
</head>
<body>

<div class="page-wrapper auth-page">
    <div class="auth-card">

        <div class="auth-card-header">
            <img src="https://cdn-icons-png.flaticon.com/512/3064/3064197.png" class="brand-icon"/>
            <h2 class="auth-title">Forgot Password</h2>
            <p class="subtitle">We'll help you get back in</p>
        </div>

        <div class="auth-card-body">

            <!-- STEP INDICATOR -->
            <div class="step-indicator">
                <div class="step-dot ${step == 'email' ? 'active' : 'done'}"></div>
                <div class="step-dot ${step == 'otp' ? 'active' : (step == 'reset' ? 'done' : '')}"></div>
                <div class="step-dot ${step == 'reset' ? 'active' : ''}"></div>
            </div>

            <c:if test="${not empty msg}">
                <div class="msg-error">${msg}</div>
            </c:if>

            <c:choose>

                <c:when test="${step == 'email'}">
                    <p class="info-text">
                        Enter your registered email address. We'll send you an OTP.
                    </p>
                    <form action="/send-otp" method="post" class="auth-form">
                        <div class="form-group">
                            <label>Email Address</label>
                            <input type="email" name="email"
                                   placeholder="abcd@gmail.com" required />
                        </div>
                        <button type="submit" class="btn-primary">Send OTP</button>
                    </form>
                </c:when>

                <c:when test="${step == 'otp'}">
                    <p class="info-text">
                        Enter the 6-digit OTP sent to your email.
                    </p>
                    <form action="/verify-otp" method="post" class="auth-form">
                        <div class="form-group">
                            <label>One-Time Password</label>
                            <input type="text" name="otp"
                                   placeholder="• • • • • •" maxlength="6" required />
                        </div>
                        <button type="submit" class="btn-primary">Verify OTP</button>
                    </form>
                </c:when>

                <c:when test="${step == 'reset'}">
                    <p class="info-text">
                        Choose a strong new password for your account.
                    </p>
                    <form action="/reset-password" method="post" class="auth-form">
                        <div class="form-group">
                            <label>New Password</label>
                            <input type="password" name="password"
                                   placeholder="Enter new password" required />
                        </div>
                        <button type="submit" class="btn-primary">Reset Password</button>
                    </form>
                </c:when>

            </c:choose>

            <div class="auth-footer">
                Remembered it? <a href="login">Back to Sign In</a>
            </div>

        </div>
    </div>
</div>

</body>
</html>