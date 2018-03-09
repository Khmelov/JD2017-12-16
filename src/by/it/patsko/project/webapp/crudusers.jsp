<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>



<div class="container">
    <div class="row">
         <div class=col-md-1>ID</div>
         <div class=col-md-2>Логин</div>
         <div class=col-md-2>Пароль</div>
         <div class=col-md-2>Email</div>
         <div class=col-md-2>Роль</div>
    </div>
</div>

<div class="container">
    <c:forEach items="${users}" var="user">
            <form class="update-user-${user.id}" action="do?command=crudusers" method=POST>
                <div class="row">
                    <div class=col-md-1>
                        <input id="id" class="form-control input-md" name="id"
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
                        <input id="email" class="form-control input-md" name="email"
                               value="${user.email}"/>
                    </div>

                    <div class=col-md-2>
                        <select id="roles_id" name="roles_id" class="form-control">
                            <c:forEach items="${roles}" var="role">
                                <option value="${role.id}" role=${role.id} ${role.id==user.roles_id?"selected":""}>
                                        ${role.role}
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <button id="Update" value="Update" name="Update" class="btn btn-success">
                        Обновить
                    </button>

                    <button id="Delete" value="Delete" name="Delete" class="btn btn-danger">
                        Удалить
                    </button>
                </div>
            </form>
            <br>
    </c:forEach>
    <br><br>

    <p>
      <button class="btn btn-success btn-lg" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
        Create
      </button>
    </p>
    <div class="collapse" id="collapseExample">
        <div class="card card-body">
            <div class="container">
                <div class="row">
                     <div class=col-md-1>ID</div>
                     <div class=col-md-2>Логин</div>
                     <div class=col-md-2>Пароль</div>
                     <div class=col-md-2>Email</div>
                     <div class=col-md-2>Роль</div>
                </div>
            </div>

            <form class="create-catalog" action="do?command=crudusers" method=POST>
               <div class="row">
                   <div class=col-md-1>
                       <input id="id" class="form-control input-md" name="id"
                              value="0"/>
                   </div>
                   <div class=col-md-2>
                       <input id="login" class="form-control input-md" name="login"/>
                   </div>
                   <div class=col-md-2>
                       <input id="password" class="form-control input-md" name="password"/>
                   </div>
                   <div class=col-md-2>
                       <input id="email" class="form-control input-md" name="email"/>
                   </div>

                   <div class=col-md-2>
                       <select id="roles_id" name="roles_id" class="form-control">
                           <c:forEach items="${roles}" var="role">
                               <option value="${role.id}" role=${role.id} "selected"}>
                                       ${role.role}
                               </option>
                           </c:forEach>
                       </select>
                   </div>

                   <button id="Create" value="Create" name="Create" class="btn btn-success">
                       ok
                   </button>
               </div>
            </form>
        </div>
    </div>
</div>



<%@ include file="include/end-html.jsp" %>


