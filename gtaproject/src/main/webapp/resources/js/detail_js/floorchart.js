let floorItems = document.querySelectorAll('.Fbuild .floor-item');
let selectedFloorText = '';
let currentDataset = 'now';
let chart;

let floorInfoElement = document.getElementById('Floor-info');
let plugValueElement = document.getElementById('plugValue');
let airconValueElement = document.getElementById('airconValue');
let lightValueElement = document.getElementById('lightValue');


function getRandomValue(min, max) {
  return Math.floor(Math.random() * (max - min + 1) + min);
}
// 랜덤값을 위한 수학정의 --> 값 변경시 필수 제거!

floorItems.forEach(floorItem => {
  floorItem.addEventListener('click', function(event) {
    event.preventDefault();
    
    resetFloorEffects();
    this.classList.add('selected');

    selectedFloorText = this.textContent.trim().replace('F', '');
    // console.log(selectedFloorText);
    // 선택한 층을 담는 변수
    
    floorInfoElement.textContent = `${selectedFloorText}Floor_Energy`;
    //floor 에 따라 <h3 id ="Floor-info"> text 바뀌기

    plugValueElement.textContent = `${getRandomValue(5000, 10000)}W`;
    airconValueElement.textContent = `${getRandomValue(2000, 4000)}W`;
    lightValueElement.textContent = `${getRandomValue(1000, 3000)}W`;
    //층별 정보가 들어옴

    updateChart();// 일~월별,층별 차트 그리기
    addFloorChart(selectedFloorText);//층별 차트 그리기
  });
});

function resetFloorEffects() {
  floorItems.forEach(floorItem => {
    floorItem.classList.remove('selected');
  });
}

function clearCanvas()
{
    // canvas
    var cnvs = document.getElementById('myCanvas');
    // context
    var ctx = canvas.getContext('2d');

    // 픽셀 정리
    ctx.clearRect(0, 0, cnvs.width, cnvs.height);
    // 컨텍스트 리셋
    ctx.beginPath();
}

// 특정 층에 대한 데이터를 가져오는 함수가 있다고 가정
function fetchDataForFloor(floor) {

  if (floor === '1') {
    return {
      Plug: 67,
      Light: 23,
      aircon: 10,
    };
  } else {
    // 선택한 층이 없거나 잘못된 경우 null 반환
    return null;
  }
}

/* 원 차트 */

const floorCharts = [];

function addFloorChart(floor) {
  const existingCanvas = document.getElementById('doughnutChartCanvas');

  if (existingCanvas) {
    // 기존 차트가 있으면 삭제
    if (floorCharts.length > 0) {
      floorCharts.forEach(chart => {
        chart.destroy();
      });
      floorCharts.length = 0; // 배열 비우기
    }

    // 랜덤 데이터 생성
    const newData = generateRandomData(3, floor); // 3은 데이터 항목의 개수
    const newChart = new Chart(existingCanvas, {
      type: 'doughnut',
      data: {
        labels: ["Plug", "Aircon", "Light"],
        datasets: [
          {
            data: newData,
            backgroundColor: ["#e15449", "#22194D", "#dddd"],
            borderWidth: 0,
            borderRadius: 7,
          },
        ],
      },
      options: {
        cutout: '78%',
        hover: { mode: null },
        plugins: {
          legend: {
            display: true,
          },
          tooltip: {
            enabled: false,
          },
          datalabels: {
            display: true,
            color: 'white',
            backgroundColor: function (context) {
              return context.dataset.backgroundColor;
            },
            borderRadius: 7,
            font: {
              weight: 'bold',
            },
            formatter: function (value, context) {
              return Math.round(value) + '%';
            },
          },
        },
      },
    });

    // 각 차트를 배열에 저장
    floorCharts.push(newChart);
  }
}


function updateChart() {
  const labels = Array.from({ length: 30 }, (_, index) => `${index + 1}min`);

  let newData;
  let backgroundColor;
  let borderColor;
  let borderWidth;
  let xAxisTitle;

  for (let floor = 1; floor <= 7; floor++) {
    if (parseInt(selectedFloorText) === floor) {
      switch (currentDataset) {
        case 'now':
          newData = generateRandomData(30, floor);
          backgroundColor = 'rgba(54, 162, 235, 0.7)';
          borderColor = 'rgba(54, 162, 235, 1)';
          borderWidth = 2;
          xAxisTitle = 'Now';
          break;
        case 'day':
          newData = generateRandomData(30, floor);
          backgroundColor = 'rgba(128, 128, 128, 0.7)';
          borderColor = 'rgba(128, 128, 128, 1)';
          borderWidth = 1;
          xAxisTitle = 'Day';
          break;
        case 'week':
          newData = generateRandomData(30, floor);
          backgroundColor = 'rgba(255, 206, 86, 0.7)';
          borderColor = 'rgba(255, 206, 86, 1)';
          borderWidth = 1;
          xAxisTitle = 'Week';
          break;
        case 'month':
          newData = generateRandomData(30, floor);
          backgroundColor = 'rgba(75, 192, 192, 0.7)';
          borderColor = 'rgba(75, 192, 192, 1)';
          borderWidth = 1;
          xAxisTitle = 'Month';
          break;
        default:
          newData = [];
          backgroundColor = '';
          borderColor = '';
          borderWidth = 0;
          xAxisTitle = '';
      }
    }
  }
 // 차트가 생성되었는지 확인
  if (chart) {
     // 차트가 이미 생성된 경우 데이터 및 옵션 업데이트
    chart.data.labels = labels;
    chart.data.datasets[0].data = newData;
    chart.data.datasets[0].backgroundColor = backgroundColor;
    chart.data.datasets[0].borderColor = borderColor;
    chart.data.datasets[0].borderWidth = borderWidth;
    // 차트 옵션 업데이트
    chart.options.scales.x.title.text = xAxisTitle;// X 축 이름 업데이트
    
    // 차트 업데이트
    chart.update();
    
  } else {
    chart = new Chart(document.getElementById('myChart'), {
      type: 'line',
      data: {
        labels: labels,
        datasets: [
          {
            label: currentDataset.charAt(0).toUpperCase() + currentDataset.slice(1),
            data: newData,
            backgroundColor: backgroundColor,
            borderColor: borderColor,
            borderWidth: borderWidth,
          },
        ],
      },
      options: {
        scales: {
          y: {
            beginAtZero: true,
            title: {
              display: true,
              text: '에너지 사용량',
            },
          },
          x: {
            title: {
              display: true,
              text: xAxisTitle,
            },
            ticks: {
              callback: function (value, index, values) {
                switch (currentDataset) {
                  case 'now':
                    return `${value}min`;
                  case 'day':
                    return `${value}h`;
                  case 'week':
                    return `${value}d`;
                  case 'month':
                    return `${value}m`;
                  default:
                    return value;
                }
              },
            },
          },
        },
      },
    });
  }
}

function generateRandomData(numPoints, floor) {
  const data = [];
  for (let i = 0; i < numPoints; i++) {
    // 각 층에 대한 랜덤 데이터 생성
    data.push(Math.floor(Math.random() * 3000) + floor * 1000);
  }
  return data;
}


// 페이지 로드 시 초기 차트 생성
updateChart('now');

// 각 버튼에 대한 이벤트 리스너 추가
const menuButtons = document.querySelectorAll('.menu-button');

menuButtons.forEach(button => {
  button.addEventListener('click', (event) => {
    event.preventDefault(); // 기본 동작 중단
    currentDataset = button.getAttribute('data-dataset');
    updateChart(currentDataset);

    // 선택된 버튼에 클래스를 추가하여 시각적으로 표시
    menuButtons.forEach(btn => btn.classList.remove('selected'));
    button.classList.add('selected');

    // 차트 크기 업데이트
    if (chart) {
      chart.resize();
    }
  });
});


/* 기기별 아이콘 클릭시 사용량 슬라이드 */ 
$(function(){
  $('.datas span').on('click', function() {
    $(this).toggleClass('clicked');
    // 클릭된 span 태그의 부모 요소 중에 'silde_card' 클래스를 가진 것에 slideToggle을 적용
    $(this).closest('.datas').find('.silde_card').slideToggle('fast');
  });
}(jQuery));