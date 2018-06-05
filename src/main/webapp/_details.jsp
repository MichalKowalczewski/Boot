
    <div id="emailModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

     <!-- Modal content-->
     <form:form method="POST" modelAttribute="user" class="form-control">
     <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Edit Email</h4>
        </div>
        <div class="modal-body">
            <spring:bind path="portalUserEmail">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="portalUserEmail" class="form-control" placeholder="Email"></form:input>
                    <form:errors path="portalUserEmail"></form:errors>
                </div>
            </spring:bind>
        </div>
        <div class="modal-footer">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
     </div>
     </form:form>
  </div>
  </div>
