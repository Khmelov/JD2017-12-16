<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<br>
<div class="container">
<form class="form-horizontal" action="do?command=CreateAd" method="post">
    <fieldset>

        <!-- Create Ad -->
        <legend>Create Ad</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Title">Title</label>
            <div class="col-md-4">
                <input id="Title" name="Title" type="text" placeholder="" class="form-control input-md" required="">
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="category_ID">Category</label>
            <div class="col-md-4">
                <select id="category_ID" name="category_ID" class="form-control">
                    <option value="1">Smartphone</option>
                    <option value="2">Laptop</option>
                    <option value="3">TV</option>
                    <option value="4">Game Console</option>
                    <option value="5">Games</option>
                </select>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="SmallDesc">Small Description</label>
            <div class="col-md-4">
                <input id="SmallDesc" name="SmallDesc" type="text" placeholder="" class="form-control input-md"
                       required="">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Description">Description</label>
            <div class="col-md-4">
                <input id="Description" name="Description" type="text"placeholder="" class="form-control input-md"
                       required="">
            </div>
        </div>


        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Price">Price</label>
            <div class="col-md-2">
                <input id="Price" name="Price" type="text" placeholder="" class="form-control input-md">
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