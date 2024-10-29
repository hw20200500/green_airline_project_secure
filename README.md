![로고2](https://github.com/seoyounglee0105/green_airline_project/assets/106488607/45885ada-932d-4640-93a8-4a84d451bb9c)




<br>

## 🚀 프로젝트 개요
- 해당 프로젝트는 보안에 취약하게 제작한 green_airline_project 프로젝트를 대상으로 시큐어 코딩을 진행한 <b>안전한 버전</b>의 웹사이트 코드입니다.
-   원래의 오픈소스 URL : https://github.com/seoyounglee0105/green_airline_project.git
-   취약한 버전의 웹 프로젝트 URL : https://github.com/hw20200500/green_airline_project.git
- 프로젝트 기간 : 2024년 10월 2일 ~ 


<br> 



## 1️⃣ 발견된 취약점점
<table>
    <thead>
        <tr>
            <th>No.</th>
            <th>발견된 취약점</th>
            <th>영향도</th>
            <th>CVSS</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>01</td>
            <td>운영체제 명령 실행</td>
            <td>Critical</td>
            <td>10.0</td>
        </tr>
        <tr>
            <td>02</td>
            <td>SQL 인젝션</td>
            <td>Critical</td>
            <td>9.4</td>
        </tr>
        <tr>
            <td>03</td>
            <td>정보 누출</td>
            <td>Medium</td>
            <td>5.3</td>
        </tr>
        <tr>
            <td>04</td>
            <td>크로스사이트 스크립팅</td>
            <td>Critical</td>
            <td>8.1</td>
        </tr>
        <tr>
            <td>05</td>
            <td>약한 문자열 강도</td>
            <td>Medium</td>
            <td>6.5</td>
        </tr>
        <tr>
            <td>06</td>
            <td>불충분한 인증</td>
            <td>High</td>
            <td>7.5</td>
        </tr>
        <tr>
            <td>07</td>
            <td>취약한 패스워드 복구</td>
            <td>Medium</td>
            <td>4.8</td>
        </tr>
        <tr>
            <td>08</td>
            <td>악성 콘텐츠</td>
            <td>Medium</td>
            <td>4.3</td>
        </tr>
        <tr>
            <td>09</td>
            <td>크로스사이트 리퀘스트 변조(CSRF)</td>
            <td>High</td>
            <td>8.0</td>
        </tr>
        <tr>
            <td>10</td>
            <td>불충분한 인가</td>
            <td>High</td>
            <td>8.2</td>
        </tr>
        <tr>
            <td>11</td>
            <td>자동화 공격</td>
            <td>Medium</td>
            <td>5.3</td>
        </tr>
        <tr>
            <td>12</td>
            <td>프로세스 검증 누락</td>
            <td>High</td>
            <td>7.2</td>
        </tr>
        <tr>
            <td>13</td>
            <td>파일 업로드</td>
            <td>Critical</td>
            <td>10.0</td>
        </tr>
        <tr>
            <td>14</td>
            <td>파일 다운로드</td>
            <td>High</td>
            <td>8.6</td>
        </tr>
        <tr>
            <td>15</td>
            <td>관리자 페이지 노출</td>
            <td>Medium</td>
            <td>5.3</td>
        </tr>
    </tbody>
</table>

    
<br>

## 2️⃣ 시큐어 코딩 결과

01. 운영체제 명령 실행
   - 수정 대상 : app.py
   ![image](https://github.com/user-attachments/assets/318dd94b-6cf3-4742-8326-a250caa95aff)

02. SQL 인젝션
   - 수정 대상 : src\main\resources\mapper\*.xml
   - 기존의 동적 파라미터 바인딩(예: '&{keyword}')에서 정적 파라미터 바인딩(예: #{keyword})으로 변경

     [수정 결과]
     ![image](https://github.com/user-attachments/assets/1f64db92-e2d6-40e6-8474-68e3a82d6105)

03. 정보 누출
   - 수정 대상 : src/main/java/com/green/airline/handler/GlobalExceptionHandler.java
   - 모든 오류에 대해서 지정한 오류 페이지(layout/errorPage)로 이동하도록 변경

04. XSS
   - 수정 대상 : src/main/java/com/green/airline/controller/BoardController.java, src/main/java/com/green/airline/XssFilter.java
   - 'tringEscapeUtils.escapeHtml()'을 이용하여 모든 입력한 값을 단순 문자열로 저장되도록 변경

     [수정 결과]
     ![image](https://github.com/user-attachments/assets/310d5d5d-6f2a-4e01-beb9-ed915adae686)

05. 약한 문자열 강도
   - 수정 대상 : 

<br>

## 3️⃣ 기능 구분

#### Member

* 소셜 로그인 API, 항공권 예매 기능, 결제 및 환불 API
* 기내 서비스 조회 기능, 서비스 신청 기능, 여행일지 조회 기능
* 구글 맵 API, 마일리지 숍 구매 기능, 네이버 이메일 SMTP 프로토콜

#### Manager
* 대시보드 조회, 회원관리, 항공권 관리 및 조회, 서비스 신청 관리 및 조회
* 여행일지 관리 및 조회, 마일리지 숍 관리 및 조회, 고객센터 관리 및 조회

<br>


## 4️⃣ 환경구축 가이드
<a src="">윈도우 환경구축 가이드</a>
<a src="">리눅스 환경구축 가이드</a>
