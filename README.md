![로고2](https://github.com/seoyounglee0105/green_airline_project/assets/106488607/45885ada-932d-4640-93a8-4a84d451bb9c)




<br>

## 🚀 프로젝트 개요
- 해당 프로젝트는 기존의 오픈소스를 바탕으로 취약점 진단 및 모의해킹을 진행하기 위해 일부 기능을 더 보안에 취약하게 수정한 프로젝트입니다.
  원래의 오픈소스 URL : https://github.com/seoyounglee0105/green_airline_project.git
- 프로젝트 기간 : 2024년 8월 31일 ~ 


<br> 



## 1️⃣ 프로젝트 구조

<details>
    <summary>⚡️ 구조 자세히 살펴보기</summary>
    
    📦src
     ┗ 📂main
       ┣ 📂java
       ┃ ┗ 📂com
       ┃   ┗ 📂green
       ┃     ┗ 📂airline
       ┃       ┃ ┣ 📂config
       ┃       ┃ ┗ 📂controller
       ┃       ┣ 📂dto
       ┃       ┃ ┣ 📂kakao
       ┃       ┃ ┣ 📂nation
       ┃       ┃ ┣ 📂request
       ┃       ┃ ┗ 📂response
       ┃       ┣ 📂enums
       ┃       ┣ 📂handler
       ┃       ┃ ┗ 📂exception
       ┃       ┣ 📂repository
       ┃       ┃ ┣ 📂interfaces
       ┃       ┃ ┗ 📂model
       ┃       ┣ 📂service
       ┃       ┗ 📂utils
       ┣ 📂resources
       ┃ ┣ 📂db
       ┃ ┣ 📂mapper
       ┃ ┗ 📂static
       ┃   ┣ 📂css
       ┃   ┃ ┗ 📂summerNote
       ┃   ┃   ┗ 📂font
       ┃   ┣ 📂images
       ┃   ┃ ┣ 📂airplane
       ┃   ┃ ┣ 📂baggage
       ┃   ┃ ┣ 📂board
       ┃   ┃ ┣ 📂gifticon
       ┃   ┃ ┣ 📂in_flight
       ┃   ┃ ┣ 📂like
       ┃   ┃ ┣ 📂product
       ┃   ┃ ┗ 📂ticket
       ┃   ┗ 📂js
       ┃     ┗ 📂summerNote
       ┃       ┗ 📂lang
       ┗ 📂webapp
         ┗ 📂WEB-INF
           ┗ 📂view
             ┣ 📂baggage
             ┣ 📂board
             ┣ 📂faq
             ┣ 📂in_flight
             ┣ 📂layout
             ┣ 📂manager
             ┣ 📂mileage
             ┣ 📂myPage
             ┣ 📂notice
             ┣ 📂ticket
             ┣ 📂user
             ┗ 📂voc

    
</details>
    
<br>

## 2️⃣ 프로젝트 개요

* 핵심 기능이 많으며 실무에서 활용할 수 있는 기능이 포함된 것들 중, 예약, 환불, 외부 API를 활용할 수 있는 항공권 예약 사이트
* 기존의 오픈소스에서 챗봇 기능을 추가가

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


## 4️⃣ SiteMap
<br>

<table>
<tr>
 <td>User</td>
 <td>Manager</td>
 </tr>
<tr>
<td><img src="https://github.com/seoyounglee0105/green_airline_project/assets/105858187/872e19cf-262f-48aa-bd3a-338e88208be6"></td>
<td><img src="https://github.com/seoyounglee0105/green_airline_project/assets/105858187/faa63d99-e44c-49d5-adf1-66d1dff62262"></td>
</tr>
</table>

<br>

## 6️⃣ 주요 기능

#### 항공권 예약 - 스케줄 선택
- 왕복/편도 선택
- 출발지/도착지 입력 시 자동 완성 기능 제공
- 전체 공항 조회
- 탑승일 선택
- 탑승 인원 선택 (성인/유아/소아)
- 좌석 등급 선택
- 나이 계산기
- 옵션 선택 후, 스케줄 출력 (잔여 n석, 매진, 미운영)

#### 항공권 예약 - 좌석 선택
- 선택한 스케줄에 운항하는 항공기의 종류에 따라 좌석 배치가 다르게 나타남
- 선택한 좌석 등급이 아닌 좌석 선택 불가능
- 예약되지 않은 좌석만 선택 가능
- 운항시간, 국내선/국제선, 탑승객 유형, 좌석 등급에 따라 가격 계산

#### 항공권 예약 - 결제
- 탑승객 정보 입력
- 카카오페이 또는 마일리지로 결제 가능
- 결제 완료 시 문자 발송 (CoolSMS API)
- 회원 등급에 따른 적립 비율로 적립 예정 마일리지 추가
- 적립된 마일리지는 탑승일 다음 날부터 사용 가능

#### 항공권 환불
- 탑승일 이전인 경우 환불 신청 가능
- 환불 수수료 부과 (국제선/국내선, 탑승일까지 며칠 이전인지에 따라 결정됨)

#### 마일리지샵 구매
- 정렬 기능 (가격 높은 순, 가격 낮은 순)
- 페이징 처리
- 검색 기능 (브랜드, 상품명)
- 상품별 재고량 부여
- 구매 시 이메일로 기프티콘 이미지 발송
- 기프티콘 유효기간 1년 부여
- 마일리지샵 이용 내역 페이지에서 환불 가능

<br>

<table>
<tr>
  <td>항공권 예약/환불 (카카오페이)</td>
  <td>마일리지샵 구매 (이메일 SMTP)</td>
</tr>
<tr>
  <td><img src="https://github.com/seoyounglee0105/green_airline_project/assets/106488607/1cd653da-4adf-4cd9-a653-24aed68336c2/img.gif"></td>
  <td><img src="https://github.com/seoyounglee0105/green_airline_project/assets/106488607/8021f046-485e-486f-9862-15098df8aa41/img.gif"></td>
</tr>
</table>

<br>

## 7️⃣ 기능 - 회원

#### 회원가입
- 아이디 중복 확인
- 비밀번호 확인 
- Validation 처리
- 주소 찾기 (DAUM 우편번호 찾기 API)
- 국적 선택 (국가 코드 오픈 API)

#### 로그인
- 카카오 소셜 로그인 (OAuth 2.0 프로토콜)
- 일반 로그인
- 아이디/비밀번호 찾기 (이메일 SMTP 프로토콜)

#### 회원 정보
- 회원 정보 변경
- 비밀번호 변경

#### 예약 이후 서비스
- 노선에 따라 제공받을 수 있는 기내 서비스 조회
- 특별 기내식 조회 및 신청
- 위탁 수하물 조회 및 신청

#### 여행일지
- 게시글 CRUD
- 조회수 & 좋아요 수에 기반한 인기 게시글 선정
- MODAL을 이용한 게시글 상세 내용 출력
- 조회수 중복 방지 (쿠키 활용)
- 로그인 시에만 좋아요 버튼 활성화
- 페이징 처리

#### 공항 위치 조회
- 구글 맵 API 활용

#### 마일리지
- 마일리지샵 구매/환불
- 마일리지 조회
- 누적 탑승 마일리지에 따라 회원 등급 변동

#### 고객센터
- 공지사항 조회
- 자주 묻는 질문 조회
- 고객의 말씀 작성

<br>
