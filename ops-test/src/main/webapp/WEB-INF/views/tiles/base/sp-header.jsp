<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html >
<head>
<title>OPS365 Application</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv='cache-control' content='no-cache'>
<meta http-equiv='expires' content='0'>
<meta http-equiv='pragma' content='no-cache'>
<link rel="stylesheet"	href='<c:url value="/resources/theme1/css/bootstrap.min.css"></c:url>' />
<link rel="stylesheet" 	href='<c:url value="/resources/css/ionicons/css/ionicons.min.css"></c:url>'/>

<link rel="stylesheet"	href='<c:url value="/resources/css/jquery-jvectormap-1.2.2.css"></c:url>' />

<link rel="stylesheet"	href='<c:url value="/resources/theme1/font-awesome-4.7.0/css/font-awesome.min.css"></c:url>' />
<%-- <link rel="stylesheet"	href='<c:url value="/resources/theme1/css/ripples.min.css"></c:url>' />
<link rel="stylesheet"	href='<c:url value="/resources/theme1/css/main.css"></c:url>' />
<link rel="stylesheet"	href='<c:url value="/resources/theme1/css/responsive.css"></c:url>' /> --%>
<link rel="stylesheet"	href='<c:url value="/resources/theme1/css/animate.min.css"></c:url>' />

<link rel="stylesheet" href='<c:url value="/resources/theme1/css/jquery-editable-select.min.css"></c:url>' />
<link rel="stylesheet" href='<c:url value="/resources/theme1/css/datepicker3.css"></c:url>' />
<%-- <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap-datetimepicker.min.css"></c:url>' /> --%>


<link rel="stylesheet"	href='<c:url value="/resources/dist/css/AdminLTE.min.css"></c:url>' />
<%-- <link rel="stylesheet"	href='<c:url value="/resources/theme1/css/style.css"></c:url>' /> --%>
<link rel="stylesheet"	href='<c:url value="/resources/dist/css/skins/skin-black-light.min.css"></c:url>' />

 <script type="text/javascript" src='<c:url value="/resources/theme1/chart/jsapi.js"></c:url>'></script>
<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/jquery-2.1.4.min.js"></c:url>'></script>
<script type="text/javascript"  src='<c:url value="/resources/theme1/js/bootstrap-datepicker.js"></c:url>'></script>

<script type="text/javascript"  src='<c:url value="/resources/theme1/js/jquery-editable-select.js"></c:url>'></script>

<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/tether.min.js"></c:url>'></script>
<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/bootstrap.min.js"></c:url>'></script>
<script type="text/javascript" 	src='https://adminlte.io/themes/AdminLTE/bower_components/fastclick/lib/fastclick.js'></script>

<script type="text/javascript" 	src='<c:url value="/resources/dist/js/adminlte.min.js"></c:url>'></script>
<script type="text/javascript" 	src='<c:url value="/resources/dist/js/app.js"></c:url>'></script>

<%-- <script type="text/javascript" 	src='<c:url value="/resources/theme1/js/transition.js"></c:url>'></script>

<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/ripples.min.js"></c:url>'></script>
<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/material.min.js"></c:url>'></script>

<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/jquery.mmenu.min.all.js"></c:url>'></script>
<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/count-to.js"></c:url>'></script>
<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/jquery.inview.min.js"></c:url>'></script>
<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/classie.js"></c:url>'></script>
<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/jquery.nav.js"></c:url>'></script>
<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/smooth-on-scroll.js"></c:url>'></script>
<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/smooth-scroll.js"></c:url>'></script>
<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/main.js"></c:url>'></script>
<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/mdb.min.js"></c:url>'></script>
<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/wow.js"></c:url>'></script>
--%>

<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/angular.min.js"></c:url>'></script>
<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/jstorage.js"></c:url>'></script>
<script type="text/javascript"  src='<c:url value="/resources/theme1/js/angucomplete-alt.js"></c:url>'></script>
<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/app-main.js"></c:url>'></script>
 <script type="text/javascript" src="<c:url value="/resources/theme1/js/moment.min.js"></c:url>"></script>
<script type="text/javascript" 	src='<c:url value="/resources/theme1/js/jstorage.js"></c:url>'></script>

<script type="text/javascript" src='<c:url value="/resources/js/sockjs.min.js"></c:url>'></script>
 <script type="text/javascript" src='<c:url value="/resources/js/stomp.min.js"></c:url>'></script>
 <script type="text/javascript" src="<c:url value="/resources/theme1/pms/websocket.js"></c:url>"></script>

<style>
	 thead {
		background-color: #bfbfbf;
		color: White;
	    height: 20px;
	}
	 .alert-success {
	
   			display:table;
    		background-color: rgb(122, 221, 0) !important;
    		border-color:#fff !important
    		
    }
    .alert-danger {
      	display:table;
   		 background-color: rgba(237, 73, 10, 0.92) !important;
   		 border-color:#fff !important
    		
    }
   
    .alert{
        padding: 7px;
            margin-bottom: 0px;
            border: 0px solid transparent !important;
    }
    .alert .close{
        color: #000 !important;
   		 opacity: 2.2 !important;
    }
   .alert-dismissable .close {
    position: relative;
    top: -2px;
    color: inherit;
      margin-right: 19px;
} 

.navbar-custom-menu .nav>li>a>.label {
   position: absolute;
    top: 7px;
    right: 4px;
    text-align: center;
    font-size: 14px;
    padding: 4px 5px;
    line-height: .9;
}

.content {
    min-height: 250px;
    padding: 0px;
    margin-right: auto;
    margin-left: auto;
    padding-left: 15px;
    padding-right: 15px;
}


.loader,
        .loader:after {
            border-radius: 50%;
            width: 10em;
            height: 10em;
        }
        .loader {            
            margin: 250px auto;
            font-size: 10px;
            position: relative;
            text-indent: -9999em;
            border-top: 1.1em solid rgba(255, 255, 255, 0.2);
            border-right: 1.1em solid rgba(255, 255, 255, 0.2);
            border-bottom: 1.1em solid rgba(255, 255, 255, 0.2);
            border-left: 1.1em solid #ffffff;
            -webkit-transform: translateZ(0);
            -ms-transform: translateZ(0);
            transform: translateZ(0);
            -webkit-animation: load8 1.1s infinite linear;
            animation: load8 1.1s infinite linear;
        }
        @-webkit-keyframes load8 {
            0% {
                -webkit-transform: rotate(0deg);
                transform: rotate(0deg);
            }
            100% {
                -webkit-transform: rotate(360deg);
                transform: rotate(360deg);
            }
        }
        @keyframes load8 {
            0% {
                -webkit-transform: rotate(0deg);
                transform: rotate(0deg);
            }
            100% {
                -webkit-transform: rotate(360deg);
                transform: rotate(360deg);
            }
        }
        #loadingDiv {
            position:absolute;;
            top: 52px;
   			 left: 0px;
            width:100%;
            height:100%;
            background-color:#000;
              opacity: 0.7;
   z-index: 9999;
   text-align: center;
        }

</style>
<script type="text/javascript">
/* $(window).on('load', function(){
  setTimeout(removeLoader, 2000); //wait for page load PLUS two seconds.
}); */
$(function () {
	 $('i').each(function (i, e) {
		    var label;
		    switch ($(e).attr('id')) {
		        
		        case 'inc':
		            label = 'Incident';
		            break;
		        
		    }
		    $(e).tooltip({ 'trigger': 'focus', 'title': label });
		});
	})

function removeLoader(){
    $( "#loadingDiv" ).fadeOut(500, function() {
      // fadeOut complete. Remove the loading div
     // $( "#loadingDiv" ).remove(); //makes page more lightweight 
  });  
}
</script>
</head>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
	 <header class="main-header">
	 <a href class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"> <img src="${contextPath}/resources/img/logo.png" style="width: 100%;"></span>
      <span class="logo-lg"><img src="${contextPath}/resources/img/sigma.png" style="width: 100%; margin-top: 0px;"></span>
    </a>
    <nav class="navbar navbar-static-top">
		<a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
            
      </a>
      
      <div >
        <ul class="nav navbar-nav">
        <li class="dropdown notifications-menu">
        <a><span >For support enquiries contact: info@sigmasurge.com</span></a>
        </li>
        </ul>
        </div>
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="${contextPath}/resources/img/swadhin.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">${savedsp.spName}</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="${contextPath}/resources/img/swadhin.jpg" class="img-circle" alt="User Image">
                <p style="color: #000">
                 ${savedsp.spName}
                  <small> ${savedsp.role}</small>
                </p>
              </li>
                <li class="user-footer">
                <div class="pull-right">
                  <a href="${contextPath}/logout" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </nav>
	</nav>
	</header>
    <aside class="main-sidebar">
    <section class="sidebar">
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${contextPath}/resources/img/swadhin.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p >${user.firstName}  ${user.lastName}</p>
         
        </div>
      </div>
      <ul class="sidebar-menu" data-widget="tree">
          <li>
          <a href="${contextPath}/sp/incident/details"><i class="fa fa-ticket" aria-hidden="true" data-toggle="tooltip" data-placement="right"  id="inc"></i> 
            <span>Incident</span>
          </a>
        </li>
      </ul>
    </section>
  </aside>
  
   
