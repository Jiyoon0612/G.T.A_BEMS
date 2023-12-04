var isToggled = true; // 변경 여부를 추적하는 플래그

function toggleEnergyValue() {
//var thisData = document.getElementById("energyValue").innerText;
var newValue;






//플래그에 따라 값 변경
  if (isToggled) {
	    newValue = parseInt(parseFloat(thisEnergy) * 112.94).toLocaleString(); // 1kwh당 한국돈 112.94원 을 곱하고 숫자뒤에 "원"을 붙여줬다
	    newValue ="💵"+newValue.toString();
	  } else {
		  newValue = thisEnergy+"(Kwh)";
	  }
  
  
  // 값 설정
  document.getElementById("energyValue").innerText = newValue;

  // 플래그 반전
  isToggled = !isToggled;
}

/*현재 날짜 가져오기 */
function getCurrentDate() {
    var currentDate = new Date();
    var options = { year: 'numeric', month: 'long', day: 'numeric' };
    return currentDate.toLocaleDateString('en-US', options);
  }

  // HTML 문서에 현재 날짜를 표시
  document.getElementById('currentDate').innerText =  getCurrentDate();

  