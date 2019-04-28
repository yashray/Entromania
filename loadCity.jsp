<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="list" value="${sessionScope.view_city }"></c:set>
<c:set var="len" value="${function:length(list) }"></c:set>

[<c:forEach items="${sessionScope.view_city }" var="i" varStatus="j">{"cityId":"${i.c_id }","cityName":"${i.city }"}
<c:if test="${len ne j.count }">,</c:if></c:forEach>]