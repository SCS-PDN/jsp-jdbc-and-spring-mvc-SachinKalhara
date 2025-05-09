<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Login</h2>
<form action="login" method="post">
    Email: <input type="text" name="email"><br/>
    Password: <input type="password" name="password"><br/>
    <input type="submit" value="Login">
</form>
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
