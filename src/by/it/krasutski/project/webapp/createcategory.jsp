<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<br>
<div class="container">
    <div class="page-header">
        <h2>Create Category</h2>
    </div>
    <br>
<form class="form-horizontal" action="do?command=CreateCategory" method="post">
    <fieldset>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Name">Category Name</label>
            <div class="col-md-4">
                <input id="Name" name="Name" type="text" placeholder="" class="form-control input-md">
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-outline-primary">Submit</button>
            </div>
        </div>

    </fieldset>
</form>

<p>Cmd Message: ${message}</p>
</div>
<%@ include file="include/end-html.jsp" %>