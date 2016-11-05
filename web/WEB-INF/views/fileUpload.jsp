<%-- 
    Document   : fileUpload
    Created on : Mar 19, 2015, 12:37:21 AM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="uploadFiles" action="uploadFile" method="POST" id="uploadFilesForm" enctype="multipart/form-data">
          <div class="form-group">
            <label for="file">File Upload</label>
            <input type="file" id="file" placeholder="Upload File">
            <p class="help-block">.jpg, .png, .pdf, .docx, ...</p>
            <button type="submit" class="btn btn-primary">Upload</button>
          </div>
        </form>
    </body>
</html>
