<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=MyAds" method="get">
    <fieldset>

        <!-- Create Ad -->
        <legend>My ads</legend>

        <div class="card text-white bg-primary mb-3" style="max-width: 20rem;">
            <div class="card-header">Title</div>
            <div class="card-body">
                <h4 class="card-title">Category</h4>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            </div>
        </div>


        <div class="card text-white bg-primary mb-3" style="max-width: 20rem;">
            <div class="card-header">Title</div>
            <div class="card-body">
                <h4 class="card-title">Category</h4>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            </div>
        </div>


    </fieldset>
</form>

<p>Cmd My ads: ${message}</p>

<%@ include file="include/end-html.jsp" %>