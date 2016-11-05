<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html>
<html lang="en"> 
   <head>
    <title><c:if test="${not empty pageTitle}">${pageTitle} - </c:if>Crime Laboratory Database</title>
     
     <sec:csrfMetaTags />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="shortcut icon" href="/CrimeLab/img/logo.ico" type="image/x-icon" />

    <link href="/CrimeLab/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="/CrimeLab/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
    <link href="/CrimeLab/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/CrimeLab/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="/CrimeLab/css/dataTables.bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="/CrimeLab/css/animate.css" rel="stylesheet" type="text/css"/>
    <link href="/CrimeLab/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
    <link href="/CrimeLab/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="/CrimeLab/css/flexslider.css">
    <link rel="stylesheet" href="/CrimeLab/css/media-queries.css">
    <link rel="stylesheet" href="/CrimeLab/css/jquery.dataTables.css">
    
     <sec:authorize access="hasRole('ROLE_ADMIN')">
         <link href="/CrimeLab/css/adminstyle.css" rel="stylesheet" type="text/css"/>
     </sec:authorize>
     <sec:authorize access="!hasRole('ROLE_ADMIN')">
         <link href="/CrimeLab/css/normal.css" rel="stylesheet" type="text/css"/>
     </sec:authorize>
     
     <script src="/CrimeLab/js/jquery-1.11.2.min.js" type="text/javascript"></script>
     <script src="/CrimeLab/js/moment.min.js" type="text/javascript"></script>
     <script src="/CrimeLab/js/bootstrap.min.js" type="text/javascript"></script>
     <script src="/CrimeLab/js/jquery.dataTables.min.js" type="text/javascript"></script>
     <script src="/CrimeLab/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
     <script src="/CrimeLab/js/jquery.blockUI.js" type="text/javascript"></script>
     <script src="/CrimeLab/js/tinymce/tinymce.min.js" type="text/javascript"></script>
     <script src="/CrimeLab/js/enscroll-0.6.1.min.js" type="text/javascript"></script>
     <script src="/CrimeLab/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
     <script src="/CrimeLab/js/bootstrap-switch.min.js" type="text/javascript"></script>
     
    <script src="/CrimeLab/js/bootstrap-hover-dropdown.min.js"></script>
    <script src="/CrimeLab/js/jquery.backstretch.min.js"></script>
    <script src="/CrimeLab/js/wow.min.js"></script>
    <script src="/CrimeLab/js/retina-1.1.0.min.js"></script>
    <script src="/CrimeLab/js/jquery.flexslider-min.js"></script>
    <script src="/CrimeLab/js/jflickrfeed.min.js"></script>
    <script src="/CrimeLab/js/masonry.pkgd.min.js"></script>
    <script src="/CrimeLab/js/jquery.ui.map.min.js"></script>
    <script src="/CrimeLab/js/scripts.js"></script>
    <script src="/CrimeLab/js/jquery.form-validator.min.js" type="text/javascript"></script>
    <script src="/CrimeLab/js/file.js" type="text/javascript"></script>    
     <script src="/CrimeLab/js/tabpane.js" type="text/javascript"></script>
     <script src="/CrimeLab/js/bootbox.min.js" type="text/javascript"></script>
     <sec:authorize access="isAuthenticated() && !hasRole('ROLE_ADMIN')">
         <script src="/CrimeLab/js/heartbeat.js" type="text/javascript"></script>
     </sec:authorize>
 </head>
 <body>
     <div id="header"><tiles:insertAttribute name="header" /></div>
     <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div id="menu"><tiles:insertAttribute name="nav" /></div>
        <div class="row">
            <div class="col-xs-10 col-xs-offset-1">
                <div id="body"><tiles:insertAttribute name="body" /></div>
            </div>
        </div>
     </sec:authorize>
     <sec:authorize access="isAuthenticated() && !hasRole('ROLE_ADMIN')">
         <div class="row">
             <div class="col-xs-10 col-xs-offset-1">
                 <div id="body"><tiles:insertAttribute name="body" /></div>
             </div>
         </div>
     </sec:authorize>
     <sec:authorize access="!isAuthenticated()">
        <div class="row">
            <div class="col-xs-10 col-xs-offset-1">
                <div id="body"><tiles:insertAttribute name="body" /></div>
            </div>
        </div>
     </sec:authorize>
     <div id="footer"><tiles:insertAttribute name="footer" /></div>
     
     <noscript>
        Please enable Javascript on your browser for this site to work properly.
     </noscript>
     
     <script type="text/javascript">
         $("#logbtn").click(function(e){
             e.preventDefault();
             
             $("form[name='logoutForm']").submit();
         });
     </script>
 </body> 
</html>