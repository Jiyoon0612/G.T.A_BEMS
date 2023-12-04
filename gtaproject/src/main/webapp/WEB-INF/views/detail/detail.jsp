<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Detail-of-energy</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@48,400,0,0" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/detail_css/detail.css">
</head>
<body>
   <div class="container">
    <!-- header -->
    <%@ include file="/WEB-INF/views/header/header.jsp" %>
    <!-- main -->
    <!-- 대시보드 오늘의 날짜 % 사용량 & 예측 금액  -->
      <main>
           <h1>Detail of Energy</h1>
           <div id = "detail-menu">
           <div id="menu">
            <ul>
              <li><a href="${pageContext.request.contextPath}/chart.do" class="menu-button" data-dataset="now">Now</a></li>
              <li><a href="${pageContext.request.contextPath}/chart.do" class="menu-button" data-dataset="day">Day</a></li>
              <li><a href="${pageContext.request.contextPath}/chart.do" class="menu-button" data-dataset="week">Week</a></li>
              <li><a href="${pageContext.request.contextPath}/chart.do" class="menu-button" data-dataset="month">Month</a></li>
            </ul>
          </div>
        </div>

        <!-- 각 층별 에너지 차트 -->
        <div class="energychart">
            <div class="build-chart">
              <canvas id="myChart" width="1400" height="700"></canvas>
            </div>
            </div>


            <div class="floor-total-chart">
              <div class ="floor-tot" >
                <div class ="floor-text">
                    <h2>Energy Ratio</h2>
                <h3 id ="Floor-info">No infromation<br></h3><small><strong>Total-Ratio-EnergyChart</strong></small>
              </div>
                <div class="doughnut-chart" id="doughnutChart">
                  <canvas id="doughnutChartCanvas"></canvas>
                </div>
              </div>
            </div>
         <!-- 층별 에너지 제어 현황 -->
         <div class="data">
          <div class="datas">
            <span class="material-symbols-sharp" id="plug">power</span>
            <div class="silde_card">
              <h3>Total User Plug </h3>
              <h2 id="plugValue">No information</h2>
            </div>
          </div>
        
          <div class="datas">
            <span class="material-symbols-sharp" id="aircon">mode_fan</span>
            <div class="silde_card">
              <h3>Total User Aircon </h3>
              <h2 id="airconValue">No information</h2>
            </div>
          </div>
        
          <div class="datas">
            <span class="material-symbols-sharp" id="light">Light</span>
            <div class="silde_card">
              <h3>Total User Light </h3>
              <h2 id="lightValue">No information</h2>
            </div>
          </div>
        </div>
        
          </main>
    
          <!-- 상단 User_Profile & darkmode -->
          <div class="right">        
            <div class="top">
              <button id="menu_bar">
                <span class="material-symbols-sharp">menu</span>
              </button>
              <div class="theme-toggler">
                <span class="material-symbols-sharp active">light_mode</span>
                <span class="material-symbols-sharp">dark_mode</span>
              </div>
              <div class="profile">
                <div class="info">
                  <p><b>User</b></p>
                  <p>building</p>
                  <small class="text-muted"></small>
                </div>
            </div>
          </div>

          <div class="bn-floor">
            <div class="ex-floor">
              <span class="material-symbols-sharp">help<h3>How</h3></span>
              <video class="gif" controls loop>
                <source src="${pageContext.request.contextPath}/image/guide.mp4" type="video/mp4">
              </video>
            </div>
          </div>
          
          
          <div class="Fbuild">
          <ul>
            <li style="--i:7;" class="floor-item"><a href="#">F7</a></li>
            <li style="--i:6;" class="floor-item"><a href="#">F6</a></li>
            <li style="--i:5;" class="floor-item"><a href="#">F5</a></li>
            <li style="--i:4;" class="floor-item"><a href="#">F4</a></li>
            <li style="--i:3;" class="floor-item"><a href="#">F3</a></li>
            <li style="--i:2;" class="floor-item"><a href="#">F2</a></li>
            <li style="--i:1;" class="floor-item"><a href="#">F1</a></li>
          </ul>
        </div>       
        
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.bundle.min.js"></script> 
<script type="text/javascript" charset="utf-8" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>    
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="${pageContext.request.contextPath}/js/detail_js/floorchart.js"></script>      
<script src="${pageContext.request.contextPath}/js/script.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</body>
</html>