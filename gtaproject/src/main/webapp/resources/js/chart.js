const ctx = document.getElementById('myChart');
let currentDataset = 'now'; // 현재 선택된 데이터셋
let chart; // 차트 인스턴스를 저장하기 위한 변수

function updateChart(dataset) {
  let labels = [];
  let yesterdayData = [];
  let todayData = [];
  let totalModelData = [];

  $.ajax({
    url: '/chart.do',
    type: 'post',
    contentType: 'application/json',
    data: JSON.stringify({ dataset: dataset }),
    success: function (responseData) {

      // 데이터 처리
      labels.length = 0;
      yesterdayData.length = 0;
      todayData.length = 0;
      totalModelData.length = 0;

      for (const item of responseData) {
        labels.push(item.label);
        yesterdayData.push(item.yesterdayData);
        todayData.push(item.todayData);
        totalModelData.push(item.totalModelData);
      }

      // 차트 업데이트
      updateChartWithMultipleDatasets(dataset, labels, yesterdayData, todayData, totalModelData);
    },
    error: function () {
      alert('실패');
    },
  });
}

function updateChartWithMultipleDatasets(dataset, labels, yesterdayData, todayData, totalModelData) {
  // 차트가 생성되었는지 확인
  if (chart) {
    // 차트가 이미 생성된 경우 데이터 및 옵션 업데이트
    chart.data.labels = labels;
    chart.data.datasets[0].data = yesterdayData;
    chart.data.datasets[1].data = todayData;
    chart.data.datasets[2].data = totalModelData;

    // 차트 업데이트
    chart.update();
  } else {
    // 차트가 생성되지 않은 경우 초기화
    chart = new Chart(ctx, {
      type: 'bar', // 막대 그래프로 초기화
      data: {
        labels: labels,
        datasets: [
          {
            label: 'Yesterday Data',
            data: yesterdayData,
            backgroundColor: 'rgba(128, 128, 128, 0.7)',
            borderColor: 'rgba(128, 128, 128, 1)',
            borderWidth: 1,
          },
          {
            label: 'Today Data',
            data: todayData,
            backgroundColor: 'rgba(54, 162, 235, 0.7)',
            borderColor: 'rgba(54, 162, 235, 1)',
            borderWidth: 2,
          },
          {
            label: 'Total Model Data',
            data: totalModelData,
            fill: false,
            borderColor: 'rgba(255, 206, 86, 1)',
            borderWidth: 2,
            type: 'line', // 선형 차트로 변경
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
              text: dataset.charAt(0).toUpperCase() + dataset.slice(1),
            },
            ticks: {
              callback: function (value, index, values) {
                // X 축 각 레이블에 대한 동적 콜백 설정
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

// 페이지 로드 시 초기 차트 생성
updateChart('month');

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

// 초기 상태로 'month' 버튼이 선택되도록 설정
document.querySelector('.menu-button[data-dataset="month"]').classList.add('selected');

// Resize 이벤트 리스너 추가
window.addEventListener('resize', () => {
  // 차트 크기 업데이트
  if (chart) {
    chart.resize();
  }
});

/* 건물 전체 기기별 에너지 사용량 */

//var doughnut = new Chart(ctx2, config);
