<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

        <c:forEach items="${catalogs}" var="catalog">
            <p><b><c:out value="${catalog.catalogName}"/></b></p>

            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">№</th>
                        <th scope="col">Категория</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${categories}" var="category">
                        <c:if test="${category.catalog_id==catalog.id}">
                            <tr>
                                <td>${category.id}</td>
                                <td><a id="${category.id}" href="do?command=category&categoryId=${category.id}">
                                        ${category.categoryName}</a>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
        </c:forEach>


<p>Cmd ERROR: ${error}</p>
<p>Cmd Message: ${message}</p>
<br><br><br><br><br><br><br><br><br>

<%@ include file="include/end-html.jsp" %>