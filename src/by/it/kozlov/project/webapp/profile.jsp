<%@page language="java" pageEncoding="utf-8" %>
<%@ include file="include/begin-html.jsp" %>


<form class="form-horizontal">
    <fieldset>
        <!-- Form Name -->
        <legend>Изменить данные</legend>

        <!-- Text input-->
        <div class="form-group">
            <div class="col-md-12">
                <h5>
                    <c:forEach items="${roles}" var="role">
                        <c:if test="${role.id==user.rolesID}">
                            ${role.role}
                        </c:if>
                    </c:forEach>
                    ${user.login}
                </h5>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="Email">Email</label>
            <div class="col-md-4">
                <input id="Email" name="Email" type="text" placeholder="${user.email}" class="form-control input-md">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Password ">Пароль</label>
            <div class="col-md-4">
                <input id="Password " name="Password " type="password" placeholder="${user.password}"
                       class="form-control input-md">

            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="City">Город</label>
            <div class="col-md-4">
                <select id="City" name="City" class="form-control">
                    <c:forEach items="${cities}" var="city">
                        <option value="${city.id}">${city.city}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Textarea -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="address">Адрес</label>
            <div class="col-md-4">
                <textarea class="form-control" id="address" name="address">${user.address}</textarea>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="phoneNumber">Номер телефона</label>
            <div class="col-md-4">
                <input id="phoneNumber" name="phoneNumber" type="text" placeholder="${user.phoneNumber}"
                       class="form-control input-md">

            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="editpassword"></label>
            <div class="col-md-4">
                <button id="editpassword" name="editpassword" class="btn btn-success">Сохранить изменения</button>
            </div>
        </div>

    </fieldset>
</form>


<%@ include file="include/end-html.jsp" %>