<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

        <div class="alert alert-danger" role="alert">
            <p><b>${error}</b></p>
            <p>
                  <a data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                    press for details
                  </a>
            </p>
            <div class="collapse" id="collapseExample">
                  <div class="card card-body">
                        <p>${error_details}</p>
                  </div>
            </div>

        </div>

<!--<p>Cmd ERROR: ${error}</p>
<p>Cmd Message: ${message}</p>-->

<%@ include file="include/end-html.jsp" %>


