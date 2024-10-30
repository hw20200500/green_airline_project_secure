![로고2](https://github.com/seoyounglee0105/green_airline_project/assets/106488607/45885ada-932d-4640-93a8-4a84d451bb9c)




<br>

## 🚀 프로젝트 개요
- 해당 프로젝트는 보안에 취약하게 제작한 green_airline_project 프로젝트를 대상으로 시큐어 코딩을 진행한 <b>안전한 버전</b>의 웹사이트 코드입니다.
-   원래의 오픈소스 URL : https://github.com/seoyounglee0105/green_airline_project.git
-   취약한 버전의 웹 프로젝트 URL : https://github.com/hw20200500/green_airline_project.git
- 프로젝트 기간 : 2024년 10월 2일 ~ 10월 30일
- 해당 시큐어 코딩은 <b>KISA의 『주요정보통신기반시설 기술적 취약점 분석·평가 방법 상세가이드』</b>에 언급된 Web 취약점 점검 항목 및 보안설정 방법을 바탕으로 진행하였습니다.


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
<h3>01. 운영체제 명령 실행</h3>
<li>수정 대상: app.py</li>
<li>Flask의 render_template_string을 escape으로 변경하여 사용자 입력을 직접적으로 템플릿에 사용하지 않도록 함.</li>
<br>
<table>
    <tr>
        <th width="50%" vertical-align="middle">수정 전</th>
        <th width="50%" vertical-align="middle">수정 후</th>
    </tr>
    <tr>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/e37f0d8e-8663-4bdd-bc4e-37fb53384758"></td>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/33847031-ca11-4122-98a1-dd8df5df4fa8"></td>
    </tr>
</table>
<br>

<h3>02. SQL 인젝션</h3>
<li>수정 대상: src\main\resources\mapper\*.xml</li>
<li>기존의 동적 파라미터 바인딩(예: '&{keyword}')에서 정적 파라미터 바인딩(예: #{keyword})으로 변경</li>
<br>
<table>
    <tr>
        <th width="50%" vertical-align="middle">수정 전</th>
        <th width="50%" vertical-align="middle">수정 후</th>
    </tr>
    <tr>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/e4271ab9-68e4-419f-8276-635137f266d0"></td>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/1f64db92-e2d6-40e6-8474-68e3a82d6105"></td>
    </tr>
</table>
<br>

<h3>03. 정보 누출</h3>
<li>수정 대상: src/main/java/com/green/airline/handler/exception/CustomErrorReportValve.java</li>
<li>수정 전에는 400 오류가 발생할 경우 tomcat 자체의 오류 페이지가 나타나면서 tomcat 버전 노출이 되었으나, 400 오류가 발생할 경우 지정한 html 코드를 대신 출력하는 것으로 수정</li>
<br>
<table>
    <tr>
        <th width="50%" vertical-align="middle">수정 전</th>
        <th width="50%" vertical-align="middle">수정 후</th>
    </tr>
    <tr>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/062ee257-f52f-4c6c-9b06-1731c7ab9726"></td>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/835ab74e-3ff1-4c0b-844a-50acd8b9b0e5"></td>
    </tr>
</table>
<br>


<h3>04. XSS</h3>
<li>수정 대상: src/main/java/com/green/airline/controller/BoardController.java, src/main/java/com/green/airline/XssFilter.java</li>
<li>‘StringEscapeUtils.escapeHtml()’을 이용하여 모든 입력값을 단순 문자열로 저장되도록 변경</li>
<br>
<table>
    <tr>
        <th width="50%" vertical-align="middle">수정 전</th>
        <th width="50%" vertical-align="middle">수정 후</th>
    </tr>
    <tr>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/0312b742-b752-4357-b411-4cf6e0537a53"></td>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/310d5d5d-6f2a-4e01-beb9-ed915adae686"></td>
    </tr>
</table>
<br>

<h3>05. 약한 문자열 강도</h3>
<li>수정 대상: src/main/java/com/green/airline/controller/UserApiController.java, src/main/java/com/green/airline/controller/UserController.java</li>
<li>기존에는 연속된 글자로 아이디, 비밀번호를 입력하여 회원가입할 수 있었으나, 그러지 못하도록 자바에 관련 함수 및 코드 추가</li>
<li>특히 비밀번호의 경우 아이디와 동일하거나, 특수문자, 숫자, 알파벳을 모두 사용하지 않으면 회원가입 못하도록 설정</li>
<br>
<table>
    <tr>
        <th width="50%" vertical-align="middle">수정 전</th>
        <th width="50%" vertical-align="middle">수정 후</th>
    </tr>
    <tr>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/a2ba72d1-0d6f-4e5a-91ba-2896dbe23490"></td>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/2e8dcbcb-5df4-4203-9b93-2164172649d6"></td>
    </tr>
</table>
<br>


<h3>06. 불충분한 인증, 10. 불충분한 인가</h3>
<li>수정 대상: src/main/java/com/green/airline/utils/Define.java</li>
<li>관리자로 로그인 후 접근할 수 있는 페이지 목록에 공지사항 게시글 작성(/notice/write), 수정(/notice/noticeUpdate), 삭제(/notice/noticeDelete), 관리자만 접근 가능한 전체 고객의 말씀 게시글 목록(/voc/list/not/*, /voc/list/processed/*) URI 추가</li>
<br>
<table>
    <tr>
        <th width="50%" vertical-align="middle">수정 전</th>
        <th width="50%" vertical-align="middle">수정 후</th>
    </tr>
    <tr>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/e314bb7d-bfe5-4a3b-9830-eaa9010dced0"></td>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/96084c11-106c-495e-a749-2f3527dec243"></td>
    </tr>
</table>
<br>

<h3>07. 취약한 패스워드 복구</h3>
<li>수정 대상 : src/main/java/com/green/airline/controller/UserApiController.java, src/main/webapp/WEB-INF/view/user/userPwSearch.jsp</li>
<li>기존의 이메일 인증한 뒤, jsp에서 자바스크립트로 약한 문자열로 임시 비밀번호를 발급해주는 방식에서 자바 백엔드에서 랜덤 문자열로 임시 비밀번호를 발급하는 방식으로 변경</li>
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
<br>

<h3>08. 악성 콘텐츠, 13. 파일 업로드</h3>
<li>수정 대상 : src/main/java/com/green/airline/controller/BoardController.java, src/main/java/com/green/airline/controller/ImageUploadController.java</li>
<li>모든 유형의 파일이 업로드 가능했던 기존 방식에서 jpg, png, jpeg 파일만 업로드 가능하도록 수정</li>
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
<br>

<h3>11. 자동화 공격</h3>
<li>자동화 공격은 시큐어 코딩보다는 IDS/IPS를 이용하는 것이 더 효율적이기에 특별히 이와 관련된 코드를 수정하지 않았음.</li>

<br>

<h3>12. 프로세스 검증 누락</h3>
<li>수정 대상 : src/main/java/com/green/airline/controller/ProductController.java</li>
<li>/buyProduct에 접근할 때, DB에 저장된 실제 물품 가격과 전달받은 구매 물품의 가격이 일치하지 않으면 '가격 변조가 탐지되어 결제가 불가합니다.'라는 경고창 출력 후 결제 프로세스 중단하도록 수정</li>
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
<br>

<h3>14. 파일 다운로드</h3>
<li>수정 대상 : src/main/java/com/green/airline/controller/BoardController.java</li>
<li>기존에는 fileName 파라미터로 다운받을 파일의 경로를 직접 받아왔기에 다운로드 경로를 공격자가 변경할 수 있었으나, 다운받을 파일의 경로를 게시글 id로 DB에 저장되어 있는 파일의 경로를 가져와서 다운로드받아 다운로드 취약점이 발생하지 않도록 변경</li>
<br>
<table>
    <tr>
        <th width="50%" vertical-align="middle">수정 전</th>
        <th width="50%" vertical-align="middle">수정 후</th>
    </tr>
    <tr>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/155f300e-3d73-4db6-a71e-c9195f6fd5f6"/></td>
        <td width="50%" vertical-align="middle"><img src="https://github.com/user-attachments/assets/eb005724-3313-4ee3-a5de-4f8e73364a68"/></td>
    </tr>
</table>


