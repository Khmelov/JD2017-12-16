<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="row">
    <b>
        <div class=col-md-1>ID</div>
        <div class=col-md-2>Имя</div>
        <div class=col-md-2>Пароль</div>
        <div class=col-md-2>Email</div>
        <div class=col-md-2>Роль</div>
    </b>
</div>
<br>


<c:forEach items="${users}" var="user">
    <br>
    <div class="row">
        <form class="update-user-${user.id}" action="do?command=EditUsers" method=POST>
            <b>
                <div class=col-md-1>
                    <input id="id1" class="form-control input-md" name="id"
                           value="${user.id}"/>
                </div>
                <div class=col-md-2>
                    <input id="login" class="form-control input-md" name="login"
                           value="${user.login}"/>
                </div>
                <div class=col-md-2>
                    <input id="password" class="form-control input-md" name="password"
                           value="${user.password}"/>
                </div>
                <div class=col-md-2>
                    <input id="email" class="col-md-2 form-control input-md" name="email"
                           value="${user.email}"/>
                </div>

                <div class=col-md-2>
                    <select id="role" name="fk_Role" class="form-control">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.id}" role=${role.id} ${role.id==user.fk_Role?"selected":""}>
                                    ${role.role}
                            </option>
                        </c:forEach>
                    </select>
                </div>


                <div class=col-md-1>
                    <button id="Update" name="Update" class="btn btn-success">
                        Обновить
                    </button>
                </div>

            </b>
        </form>
        <form class="form-user-${user.id}" action="do?command=EditUsers" method=POST>
            <b>
                 <input type="hidden" name="id" value="${user.id}"/>
                <div class=col-md-1>
                    <button id="Delete" name="Delete" class="btn btn-danger">
                        Удалить
                    </button>
                </div>

            </b>
        </form>
    </div>

</c:forEach>

<%@ include file="include/end-html.jsp" %>


