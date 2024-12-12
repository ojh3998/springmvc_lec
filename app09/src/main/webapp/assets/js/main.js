/**
 *  파일명 : main.js
 *
 */

function getContextPath() {
	const url = location.href; 						 /* http://localhost:8080/app09/main.do */
	const host = location.host; 					 /* locathost:8080 */
	const begin = url.indexOf(host) + host.length;   /* 7 + 14 = 21                    : contextPath 의 시작 인덱스 */ 
	const end = url.indexOf('/', begin + 1);	     /* 22번째 인덱스부터 찾아라  = 27 : Mapping의 시작 인덱스 */
	const contextPath = url.substring(begin, end);   /* 인덱스 begin부터 인덱스 end 이전까지 */
	return contextPath;
} 


function toMain() {
  const logo = document.getElementById('logo');
  logo.addEventListener('click', (event) => {
    location.href = getContextPath() + '/main.do';
  })
}

onload = () => {
	toMain();
}
