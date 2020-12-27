<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>userHeader</title>
<meta name="description" content="">
<meta name="author" content="">

<link rel="shortcut icon" href="<%=request.getContextPath() %>/test/img/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="<%=request.getContextPath() %>/test/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72" href="<%=request.getContextPath() %>/test/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114" href="<%=request.getContextPath() %>/test/img/apple-touch-icon-114x114.png">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/test/fonts/font-awesome/css/font-awesome.css">

<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath() %>/test/css/mystyle.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/test/css/nivo-lightbox/nivo-lightbox.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/test/css/nivo-lightbox/default.css">
<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,600,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Dancing+Script:400,700" rel="stylesheet">
</head>
<body id="user-container">
		
	  <div class="recipe-box">
	  <a href="recipeList?userNo=${user.userNo}">
	  <div class="hrefbox">
	  <div class="element-label">
	    <div class="modal-table"><div class="modal-cell"><div class="modal-box">
	         레시피
		</div></div></div>
	  </div>
	  
	  <div class="element-size">
	    <div class="modal-table"><div class="modal-cell"><div class="modal-box">
	    ${recipeSize} </div></div></div>
	  </div>
	  	</div>
	  	</a>
	  </div>
	  	
	  
	  <div class="follower-box">
	  <a href="followerList?userNo=${user.userNo}">
	  <div class="hrefbox">
	  <div class="element-label">
	    <div class="modal-table"><div class="modal-cell"><div class="modal-box">
	       팔로워   
	    </div></div></div>
	  </div>
	  <div class="element-size">
	    <div class="modal-table"><div class="modal-cell"><div class="modal-box">
	    ${followerSize}</div></div></div>
	  </div>
	  </div>
	  </a>
	  </div>
	  
	  
	  
	  <div class="following-box">
	  <a href="followingList?userNo=${user.userNo}">
	  <div class="hrefbox">
	  <div class="element-label">
	    <div class="modal-table"><div class="modal-cell"><div class="modal-box">
            팔로잉
      </div></div></div>
	  </div>
	  <div class="element-size">
	    <div class="modal-table"><div class="modal-cell"><div class="modal-box">
	    ${followingSize}</div></div></div>
	  </div>
	  </div>
	  </a>
	  </div>
</body>
</html>