<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<body>
<table border="1">
    <c:forEach var="reportLine" items="${report}">
        <tr>
            <td><c:out value="${reportLine.firstName} ${reportLine.lastName}"/></td>
            <td><c:out value="${reportLine.amount}"/></td>
        </tr>
    </c:forEach>
</table>
<%--<c:forEach var="i" begin="1" end="5">--%>
<%--Item <c:out value="${i}"/><p>--%>
<%--</c:forEach>--%>
</body>
</html>