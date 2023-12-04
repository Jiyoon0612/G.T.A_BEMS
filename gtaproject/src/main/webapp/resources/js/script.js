let menuBtn = document.querySelector('#menu_bar');
let themeToggler = document.querySelector('.theme-toggler');

menuBtn.addEventListener('click',()=>{
       sideMenu.style.display = "block"
})

themeToggler.addEventListener('click',()=>{
     document.body.classList.toggle('dark-theme-variables')
     themeToggler.querySelector('span:nth-child(1)').classList.toggle('active');
     themeToggler.querySelector('span:nth-child(2)').classList.toggle('active');
})

//fetch('./header/header.html')
//  .then(response => response.text())
//  .then(html => {
//    document.getElementById('header-container').innerHTML = html;
//  });