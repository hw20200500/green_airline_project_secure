![로고2](https://github.com/seoyounglee0105/green_airline_project/assets/106488607/45885ada-932d-4640-93a8-4a84d451bb9c)




<br>

## 🚀 프로젝트 개요
- 해당 프로젝트는 보안에 취약하게 제작한 green_airline_project 프로젝트를 대상으로 시큐어 코딩을 진행한 <b>안전한 버전</b>의 웹사이트 코드입니다.
-   원래의 오픈소스 URL : https://github.com/seoyounglee0105/green_airline_project.git
-   취약한 버전의 웹 프로젝트 URL : https://github.com/hw20200500/green_airline_project.git
- 프로젝트 기간 : 2024년 10월 2일 ~ 


<br> 



## 1️⃣ 발견된 취약점
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
<head>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        td {
            width: 50%;
            text-align: center;
            vertical-align: middle;
            padding: 10px;
            border: 1px solid #ddd;
        }
    </style>
</head>
<h3>01. 운영체제 명령 실행</h3>
<p>- 수정 대상: app.py</p>
<p>Flask의 render_template_string을 render_template으로 변경</p>
<img src="https://github.com/user-attachments/assets/318dd94b-6cf3-4742-8326-a250caa95aff" alt="Original Code">

<table>
    <tr>
        <th width="50%" vertical-align="middle">수정 전</th>
        <th width="50%" vertical-align="middle">수정 후</th>
    </tr>
    <tr>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/e37f0d8e-8663-4bdd-bc4e-37fb53384758" alt="Before Change"></td>
        <td width="50%" vertical-align="middle">수정 후 이미지</td>
    </tr>
</table>

<h3>02. SQL 인젝션</h3>
<p>- 수정 대상: src\main\resources\mapper\*.xml</p>
<p>기존의 동적 파라미터 바인딩(예: '&{keyword}')에서 정적 파라미터 바인딩(예: #{keyword})으로 변경</p>

<table>
    <tr>
        <th width="50%" vertical-align="middle">수정 전</th>
        <th width="50%" vertical-align="middle">수정 후</th>
    </tr>
    <tr>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/e4271ab9-68e4-419f-8276-635137f266d0" alt="Before Change SQL Injection"></td>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/1f64db92-e2d6-40e6-8474-68e3a82d6105" alt="After Change SQL Injection"></td>
    </tr>
</table>

<h3>03. 정보 누출</h3>
<p>- 수정 대상: src/main/java/com/green/airline/handler/GlobalExceptionHandler.java</p>
<p>모든 오류에 대해 지정한 오류 페이지(layout/errorPage)로 이동하도록 변경</p>

<h3>04. XSS</h3>
<p>- 수정 대상: src/main/java/com/green/airline/controller/BoardController.java, src/main/java/com/green/airline/XssFilter.java</p>
<p>‘StringEscapeUtils.escapeHtml()’을 이용하여 모든 입력값을 단순 문자열로 저장되도록 변경</p>

<table>
    <tr>
        <th width="50%" vertical-align="middle">수정 전</th>
        <th width="50%" vertical-align="middle">수정 후</th>
    </tr>
    <tr>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/0312b742-b752-4357-b411-4cf6e0537a53" alt="Before Change XSS"></td>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/310d5d5d-6f2a-4e01-beb9-ed915adae686" alt="After Change XSS"></td>
    </tr>
</table>

<h3>05. 약한 문자열 강도</h3>
<p>- 수정 대상: </p>

<table>
    <tr>
        <th width="50%" vertical-align="middle">수정 전</th>
        <th width="50%" vertical-align="middle">수정 후</th>
    </tr>
    <tr>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/0312b742-b752-4357-b411-4cf6e0537a53" alt="Before Change Weak String"></td>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/310d5d5d-6f2a-4e01-beb9-ed915adae686" alt="After Change Weak String"></td>
    </tr>
</table>

<h3>06. 불충분한 인증, 10. 불충분한 인가</h3>
<p>- 수정 대상: src/main/java/com/green/airline/utils/Define.java</p>
<p>관리자로 로그인 후 접근할 수 있는 페이지 목록에 공지사항 게시글 작성(/notice/write), 수정(/notice/noticeUpdate), 삭제(/notice/noticeDelete), 관리자만 접근 가능한 전체 고객의 말씀 게시글 목록(/voc/list/not/*, /voc/list/processed/*) URI 추가</p>

<table>
    <tr>
        <th width="50%" vertical-align="middle">수정 전</th>
        <th width="50%" vertical-align="middle">수정 후</th>
    </tr>
    <tr>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/e314bb7d-bfe5-4a3b-9830-eaa9010dced0" alt="Before Change Insufficient Authorization"></td>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/96084c11-106c-495e-a749-2f3527dec243" alt="After Change Insufficient Authorization"></td>
    </tr>
</table>

<h3>07. 취약한 패스워드 복구</h3>
- 수정 대상 : src/main/java/com/green/airline/controller/UserApiController.java, src/main/webapp/WEB-INF/view/user/userPwSearch.jsp
- 기존의 이메일 인증한 뒤, jsp에서 자바스크립트로 약한 문자열로 임시 비밀번호를 발급해주는 방식에서 자바 백엔드에서 랜덤 문자열로 임시 비밀번호를 발급하는 방식으로 변경
<br>
<table>
    <tr>
        <th width="50%" vertical-align="middle">수정 전</th>
        <th width="50%" vertical-align="middle">수정 후</th>
    </tr>
    <tr>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/a7756017-3a03-4ca2-a53c-6817afe023c5"/></td>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/994d789f-6af2-4bef-8ed1-922f19dd6d47"/></td>
    </tr>
</table>

<h3>08. 악성 콘텐츠, 13. 파일 업로드</h3>
- 수정 대상 : src/main/java/com/green/airline/controller/BoardController.java, src/main/java/com/green/airline/controller/ImageUploadController.java
- 모든 유형의 파일이 업로드 가능했던 기존 방식에서 jpg, png, jpeg 파일만 업로드 가능하도록 수정
<br>
<table>
    <tr>
        <th  width="50%" vertical-align="middle">수정 전</th>
        <th  width="50%" vertical-align="middle">수정 후</th>
    </tr>
    <tr>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/01bab206-699d-4e0f-8dde-9f4d67c73130"/></td>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/4cabbc8c-a374-4344-a0dc-059a2ac58fef"/></td>
    </tr>
</table>

<h3>11. 자동화 공격</h3>
<p>- 수정 대상 :</p>
<br>
<table>
    <tr>
        <th width="50%" vertical-align="middle">수정 전</th>
        <th width="50%" vertical-align="middle">수정 후</th>
    </tr>
    <tr>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/17fbda86-f5e3-4b2a-a95b-2f1d09ef5576"/></td>
        <td width="50%" vertical-align="middle"><img src=""/></td>
    </tr>
</table>

<h3>12. 프로세스 검증 누락</h3>
- 수정 대상 : src/main/java/com/green/airline/controller/ProductController.java
- /buyProduct에 접근할 때, DB에 저장된 실제 물품 가격과 전달받은 구매 물품의 가격이 일치하지 않으면 '가격 변조가 탐지되어 결제가 불가합니다.'라는 경고창 출력 후 결제 프로세스 중단하도록 수정
<br>
<table>
    <tr>
        <th width="50%" vertical-align="middle">수정 전</th>
        <th width="50%" vertical-align="middle">수정 후</th>
    </tr>
    <tr>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/32745158-9d37-43a8-8738-8438441f01dd"/></td>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/10b558b3-b4b4-47ad-bebf-54e201c7d500"/></td>
    </tr>
</table>

<h3>14. 파일 다운로드</h3>
- 수정 대상 :
<br>
<table>
    <tr>
        <th width="50%" vertical-align="middle">수정 전</th>
        <th width="50%" vertical-align="middle">수정 후</th>
    </tr>
    <tr>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/155f300e-3d73-4db6-a71e-c9195f6fd5f6"/></td>
        <td width="50%" vertical-align="middle"><img src=""/></td>
    </tr>
</table>


