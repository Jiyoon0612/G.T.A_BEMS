<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_join_css/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_join_css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_join_css/login.css">
    <title>GTA:login</title>
  </head>
  <body>
    <div class="content">
      <div class="container">
        <div class="row">
          <div class="col-md-6 order-md-2">
            <img src="${pageContext.request.contextPath}/image/GTA_loginPage.png" alt="Image" class="img-fluid">
          </div>
          <div class="col-md-6 contents">
            <div class="row justify-content-center">
              <div class="col-md-8">
                <div class="mb-4">
                  <h3>Sign In to <strong>GTA</strong></h3>
                  <p class="mb-4">Manage your building more efficiently.</p>
                </div>
                <form id="loginForm" action="/login.do" method="post">
                  <div class="form-group first">
                    <label for="name">Username</label>
                    <input type="text" class="form-control" id="name" name="memId">
                  </div>
                  <div class="form-group last mb-4">
                    <label for="pwd">Password</label>
                    <input type="password" class="form-control" id="pwd" name="memPw">
                  </div>
                  
                  <div class="d-flex mb-5 align-items-center">
                    <label class="control control--checkbox mb-0">
                      <span class="caption">Remember id</span>
                      <input type="checkbox" id="idSaveCheck"/>
                      <div class="control__indicator"></div>
                    </label>
                    <span class="ml-auto"><a href="/join" class="forgot-pass">Sing Up</a></span> 
                  </div>
  
                  <input type="submit" value="Log In" class="btn text-white btn-block btn-primary" >
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  
  

  
    <script src="${pageContext.request.contextPath}/js/login_join_js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/login_join_js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/login_join_js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/login_join_js/login.js"></script>
  </body>
</html>