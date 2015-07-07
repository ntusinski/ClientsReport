<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<body>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Shopping amount</td>
        <td>Most expensive orders</td>
    </tr>
    <c:forEach var="reportLine" items="${report}">
        <tr>
            <td><c:out value="${reportLine.firstName} ${reportLine.lastName}"/></td>
            <td><c:out value="${reportLine.amount}"/></td>
            <td>
                <c:forEach var="order" items="${reportLine.mostExpensiveOrders}">
                    <fmt:formatDate type="date" value="${order.orderDate}"/>
                    <c:out value="- ${order.amount}"/>
                    <br>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>