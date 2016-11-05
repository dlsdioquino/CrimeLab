<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <div id="adminfooter">
        <p>Crime Laboratory Database Administrator<br>
            <span class="glyphicon glyphicon-copyright-mark"></span> 2015</p>
    </div>
</sec:authorize>

<sec:authorize access="!hasRole('ROLE_ADMIN')">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 footer-box ">
                <h4>About Crime Lab SRS</h4>
                <p> Crime Laboratory SRS aims to automate the storage, retrieval and management of documents; moreover, the report production/making is also automated and all of this is done through a web application. 
                        The application allows crime lab personnel to upload requests via scanner.
                        Uploaded requests and test reports could then be tagged with words related to it, which provides easier retrieval of the document when searched for, or help in filtering documents to see for any possible case correlation. 
                        
                 </p>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12 ">
                <div class="footer-border"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-7 footer-copyright">
                <p> <span class="glyphicon glyphicon-copyright-mark"></span> Copyright 2015 </p>
            </div>
            <div class="col-sm-5 footer-social ">
                <a href="https://www.facebook.com/pnp.latrinidad?fref=ts" target="_blank"><i class="fa fa-facebook-square"></i></a>
                <a href="http://www.procor.pnp.gov.ph/" target="_blank"><i class="fa fa-map-marker"></i></a>
            </div>
        </div>

    </div>
    
    
     
   
</sec:authorize>