<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal" action="do?command=Catalog" method="post">
    <fieldset>

    <p>${catalog_table}</p>

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
                        <tr>
                            <td>${category.id}</td>
                            <td><a id="${category.id}" href="do?command=category">${category.categoryName}</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:forEach>

    </fieldset>
</form>

<p>Cmd ERROR: ${error}</p>
<p>Cmd Message: ${message}</p>
<br><br><br><br><br><br><br><br><br>

<%@ include file="include/end-html.jsp" %>