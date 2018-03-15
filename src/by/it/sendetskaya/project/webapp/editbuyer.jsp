<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>




<div class="container">
    <div class="row">
            <div class=col-md-1>ID</div>
            <div class=col-md-2>Имя</div>
            <div class=col-md-2>Пароль</div>
            <div class=col-md-2>Email</div>
            <div class=col-md-2>Роль</div>
    </div>
</div>

<div class="container">
    <c:forEach items="${buyers}" var="buyer">
            <form class="update-user-${buyer.id}" action="do?command=EditBuyer" method=POST>
                <div class="row">
                    <div class=col-md-1>
                        <input id="id" class="form-control input-md" name="ID"
                               value="${buyer.id}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="nickname" class="form-control input-md" name="Nickname"
                               value="${buyer.nickname}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="password" class="form-control input-md" name="Password"
                               value="${buyer.password}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="email" class="form-control input-md" name="Email"
                               value="${buyer.email}"/>
                    </div>

                    <div class=col-md-2>
                        <select id="role" name="FK_roles" class="form-control">
                            <c:forEach items="${roles}" var="role">
                                <option value="${role.id}" role=${role.id} ${role.id==buyer.fk_roles?"selected":""}>
                                        ${role.role}
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class=col-md-1>
                        <button id="Update" value="Update" name="Update" class="btn btn-success">
                            Обновить
                        </button>
                    </div>

                    <div class=col-md-1>
                        <button id="Delete" value="Delete" name="Delete" class="btn btn-danger">
                            Удалить
                        </button>
                    </div>
                </div>
            </form>
    </c:forEach>
</div>

<%@ include file="include/end-html.jsp" %>


