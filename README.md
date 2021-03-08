# Team-Project

210308 - 팀 프로젝트 진행상황

팀원 : 민호, 진군, 도현, 시원, 진택

팀 깃허브 : https://github.com/EZEN-Project/Team-Project

- 민호: https://github.com/EZEN-Project/minho
- 진군: https://github.com/EZEN-Project/jingoon
- 도현: https://github.com/EZEN-Project/dohyun
- 시원:
- 진택:

[ 팀 회의 ]

 < memberVO 생성자 추가 및 변경 논의>
- 기본생성자와, 모든 필드가 인자로 사용된 생성자만 있음
- mnum이나 regdate, updateDate 등과 같이 DB에서 생성되는 값은 생성자에서 제외
- point와 같은 DB의 default값이 있다면 생성자에서 제외
- point의 입력값이 있다면(쿠폰이나 관리자에 의한 설정?) 메서드로 추가
- mtype은 구매회원과 관리자, 회원탈퇴등 회원의 상태를 구분할 수 있다, 회원가입시의 입력은 불필요하며, 회원상태가 변할 때 수정되어야한다.( 관리자의 회원가입은 DB에서 직접 만들어 두고, 관리자의 추가는 기능으로 추가되어야 함)
- memo는 관리자가 회원의 특이사항이나 간략한 설명을 관리자끼리 알아볼수 있게 작성할 수 있는 필드, 생성자에서 입력값은 불필요함

 <goods 테이블과 sellboard 테이블의 수정 및 변경 논의>
- 상품정보와 판매등록을 따로 등록하지 않고 상품을 등록하면 바로 판매등록으로 합쳐 사용하기로 해서 goods테이블 및 goodVO제거
- sellboard(테이블&VO) 에 상품의 정보(이미지, 가격, 이름 등등 goods에 있던 정보) 가 필요함 

 <깃허브협업>
- 각 기능을 완전히 마치고 코드를 합치기로
- 매일 작업물은 팀저장소에 개인저장소를 만들어서 올리기

 <민호 2021.03.08 >
- 마이페이지 구현시작
- 회원정보 수정 구현, 테스트 오류, 실수로 클래스를 이중으로 넣어서 controller 인식 못함 진군님 도움으로 해결
- 이후 ava.lang.NumberFormatException 발생,반환형을vo가아닌 list로 되어있어 수정후 구현완료
![3](https://user-images.githubusercontent.com/72857217/110302297-6ec92080-803c-11eb-91b7-7351ba0c18e2.png)


 <도현 2021.03.08>
- 판매 게시글 등록 기능 구현시작
- 판매정보VO정보, 썸네일 이미지까지 등록은 무사히 구현.
![4](https://user-images.githubusercontent.com/72857217/110302323-7688c500-803c-11eb-8fec-c47d1888a32f.png)


 <진군 2021.03.08>
- 상품을 장바구니에 등록 :  이미 장바구니에 담긴 상품은 개수가 증가하고, 처음 담는 상품은 장바구니에 추가
- 장바구니의 상품 삭제 :  장바구니 삭제 후 장바구니에 상품태그를 삭제하고, 장바구니 총 가격을 갱신
- 장바구니 상품 개수 증감 : 장바구니 상품의 구매개수를 변경, 상품의 총가격과 장바구니 총 가격을 수정&갱신
- 장바구니의 총 상품 가격 표시
- 장바구니의 목록을 버튼 배지로 표현
![화면 캡처 2021-03-08 175755](https://user-images.githubusercontent.com/72857217/110302365-82748700-803c-11eb-8103-ebc8cb54bc6c.png)

 <진택 2021.03.08>
- MemberMapper .interface  
- MemberDAO .class  
- MemberService .class 
- MemberController .class
- 회원가입 home.jsp
- login창을 보여주는 login.jsp 
- login후에 등장하는 main.jsp


----


210305 - 팀 프로젝트 진행상황

팀원 : 민호, 진군, 도현, 시원, 진택
깃허브 : https://github.com/EZEN-Project/Team-Project

 < 팀 회의 >

- 기존 소스코드를 활용해서 수정하는 방향으로 기능을 나누어 프로젝트를 진행하려 했지만 중간중간 수정코드가 다른 기능에 영향을 미치고 그때그때 변경 하여 서로 수정하기 바빠서 정작 본인의 진행상황이나 방향이 햇갈리고 시간도 오래 걸려서 처음 계획단계에서부터 다시 시작하기로 함

- 텍스트로하는 의사전달에 서로 이해하는 바가 달라서 디스코드를 이용해서 음성과, 그림판& 표를 활용해서 모두 이해하는 바가 일치하도록 토의

- 기존 코딩 방향 철회, 새로운 계획 수립

- 메인 페이지를 시작점으로 (서로가 이해하기 쉽도록) 구현 기능(page)에 대한 버튼을 만들고 각 기능을 담당해서 구현



 < 기능 구상 >

- 쇼핑 몰 시스템 (단일판매자)

- 기능 목록: 회원, 로그인, 상품, 상품평, 장바구니, 주문내역, 게시판(Q&A), 장바구니

- 회원 : 회원정보를 입력하여 회원가입, 수정, 탈퇴 / 회원목록을 조회, 수정, 삭제

- 로그인 : 아이디-비밀번호를 입력하여 로그인 / 관리자회원과 일반회원을 구분

- 상품 : 상품목록조회, 상품상세조회, 장바구니담기 / 상품을 등록, 수정, 삭제

- 장바구니 : 장바구니에 담긴 상품목록보기, 상품 빼기, 상품수량변경, 결제가격계산 /

- 주문내역 : 결제한 과거 내역을 조회, 결제상품 상세보기, 결제내역 삭제 / 

- 상품평 : 상품 상세 조회에서 댓글

- Q&A : 상품 상세 조회에서 게시판   
![unknown](https://user-images.githubusercontent.com/72857217/110096697-8a84ba80-7de1-11eb-8a75-7762c7132679.png)

 <기능 목록(1차)>
- 장바구니, 마이페이지, 상품게시판, 로그인, 회원가입  

 < 팀원별 1차 구현 >

- 민호 : 마이페이지

- 진군 : 장바구니(기능) 

- 도현 : 상품게시판

- 진택, 시원 : 회원가입, 로그인

----

210304 - 팀 프로젝트 진행상황

팀원 : 민호, 진군, 도현, 시원, 진택
깃허브 : https://github.com/EZEN-Project/Team-Project

팀 회의
- 기본 기능 분담해 합치고 나머지 기능들 다시 분담하기, 화면 구성별로 구현할 기능 토의, 토의 결과로 DB 테이블 만들기

민호 - 페이징
도현 - 판매등록
진군 - 댓글, 파일업로드
진택 - 검색
시원 - 가입, 로그인

쇼핑몰 구분: 단일 판매자의 브랜드몰
기본기능 : 보드(판매 등록), 댓글, 회원가입(멤버), 로그인, 검색, 페이징(보드), 페이징(검색), 파일업로드 
공통 추가기능 : 마이페이지(판매/구매 현황보기, 잔액/충전)
판매자 추가기능 : 상품 등록/CRUD, 판매등록/CRUD, 
	- 누적 판매액/판매건수, 매출(일/월/년)/이익/마진률-> 차트화
구매자 추가기능 : 장바구니/결제(버튼)

- 상품 등록 CRUD
판매자가 판매할 제품의 정보를 입력하여 DB에 저장
= 파일업로드(이미지)

- 판매 등록(보드) CRUD
판매자가 등록한 상품과 제품 설명(상세페이지, 게시글내용)을 입력하여 DB에 저장하고 게시판 페이지에 출력, 매진됐을때 . count==0-> 썸네일 변경(미리설정된) -> 결제불가
(제목, 내용, 작성시간, 상품정보, 결제버튼, 장바구니추가)
= 검색, 페이징, 후기(댓글reply)

- 후기(spring reply)
판매 게시글 본문에 후기탭 상품에 대한 댓글을 추가
= 페이징, 이미지(파일업로드테이블 댓글번호컬럼)

- 회원가입
구매자의 회원가입, 주소api사용, email추가
 -- 추후 email인증/핸드폰인증 추가

- 로그인 interceptor
인증 : 구매, 판매등록, 후기작성, 비밀번호변경

- 장바구니

- 검색
후기 검색, 게시글 검색, 등록 상품 검색...

- 페이징
게시글 페이징, 후기 페이징, 게시글 검색 페이징, 등록 상품 검색 페이징...

- 파일 업로드
후기, 게시글, 상품 등록

- 비밀번호 찾기/변경하기 (로그인 기능 추가 후)
일단 email로 확인 (추후 인증방법추가)

- 마이페이지(판매자)
상품을 등록하고 게시글(판매)를 등록, 판매에 대한 정산결과, 매출(일,월,년)/이익/마진률 - 차트보기, 
단일 상품의 대한 누적 판매횟수/판매액, 총 상품에 대한 누적판매액/판매횟수

- 마이페이지(구매자)
장바구니 : 게시글에서 장바구니 추가 상품 목록과 상품가격 출력, 결제불가(+판매상품 갯수 체크) 제외, (결제)를 했을 때 총 상품 가격 합산
결제 : 포인트를 이용해 결제/ ( 판매테이블에 저장 )
충전 : 로그인/권한 인증 후 충전 진행(test max, min, 0 )
본인 쓴 후기: 목록(페이징)-> 판매게시물로 이동 

--- 테이블 생성

 제품 정보
- 제품번호
- 제품명
- 원가
- 제품 가격(판매가)
- 작성일
- 수정일

 회원정보 정보 테이블
- 회원번호
- id(email)
- pw
- 회원이름
- 전화번호
- 주소
- 가입일
- 수정일
- 생년월일
- 포인트(결제 대용)
- 회원유형(구매자/회원탈퇴/마스터)

판매 정보 테이블
- 판매 번호 
- 제품번호
- 구매자no
- 판매일

 보드 테이블
- 번호
- 제목
- 작성자
- 내용
- 조회수
- 판매개수설정
- 판매상품

create table goods(
gnum number(6) primary key,
name varchar2(300) not null,
cost number(10) DEFAULT 0,
price number(10) DEFAULT 0,
writedate DATE DEFAULT SYSDATE,
updatedate DATE DEFAULT SYSDATE,
)
create table member(
mnum number(6) primary key,
id varchar2(10) not null,
email varchar2(20) not null,
pw varchar2(15) not null,
name varchar2(12) not null,
phone number(15) not null,
address varchar2(300) not null,
regdate DATE DEFAULT SYSDATE,
updatedate DATE DEFAULT SYSDATE,
birth date not null,
point number(10) DEFAULT 0,
type number(10) not null,
memo varchar2(100)
)
create table board(
bnum number(6) primary key,
title varchar2(300) not null,
writer varchar2(300) not null,
content varchar2(300) not null,
veiwcnt number(6) default 0,
bcount number(6) default 1,
goods varchar2(300) not null
)
create table sell(
snum number(6) primary key,
gnum number(6),
bmnum number(6),
sellDate date default sysdate,
constraint fk_sell_bmnum foreign key(bmnum) references goods(gnum)
)

----

210303 - 팀 프로젝트 진행상황

팀원 : 민호, 진군, 도현, 시원, 진택
깃허브 : https://github.com/EZEN-Project/Team-Project

팀 회의

* 컨셉 정하기(하나의 카테고리)
의류, 신발, 정육, 소고기 - 단품쇼핑몰 컨셉을 소고기로 정함
![화면 캡처 2021-03-03 110036](https://user-images.githubusercontent.com/72857217/109778622-604bc500-7c48-11eb-8dbf-29e38cf0056c.png)

* 여러 쇼핑몰 사이트 참고, ui구성, uri구성, 메뉴구성, 뷰목록 등을 참고
 게시물을 눌렀을 때 보여질 정보, 기능 들
![화면 캡처 2021-03-03 174849](https://user-images.githubusercontent.com/72857217/109779218-11eaf600-7c49-11eb-86cb-1dda6f029b98.png)

* 장바구니 구성
담는 기능, 장바구니에 체크 물품 가격 합산, 결제(포인트), 삭제, 추가

* 화면 구성
로그인, 회원정보, 장바구니 
검색 바
상단 네비게이션 바(상품,Q&A게시판)
판매이미지(carousel)를 화면 중앙
![1](https://user-images.githubusercontent.com/72857217/109778589-588c2080-7c48-11eb-90c4-418275a127c3.png)


* 테이블 구성과 추가할 기능들
판매삼품 정보 테이블, 회원정보 테이블, 판매 테이블, 보드테이블,  댓글 테이블(Q&A), 페이징 테이블, 
- 검색 시 RUD 적용방법을 새로운 view를 활용&이전 view를 사용할지 정하기
- 장바구니 테이블 추가, 파일(이미지) 테이블 추가
- 오라클 DB계정 새로 생성 통일(  project/project )
- 깃허브 협업 툴로 sourcetreeapp 사용
- 깃허브와 소스트리 오류 잡기
- 스프링 프로젝트 기본 구성통일 해서 모두 같은 프로젝트로 통일해서 프로젝트 시작
![unknown](https://user-images.githubusercontent.com/72857217/109778616-5f1a9800-7c48-11eb-9dd5-e91b943c4ae6.png)

* 현재 추가할 수 있는 기능들
- 누적 구매액/구매건, 누적 판매액/판매건, 일/월/년(매출)
- 최근판매증가상품, 최단기간 최다판매

* 판매상품과 보드를 어떻게 구성할지
- 1. 판매상품 등록 후 게시글 등록 시 판매상품 정보 추가
- 2. 판매상품과 보드를 통합해서 판매상품 등록이 곧 게시글등록으로
