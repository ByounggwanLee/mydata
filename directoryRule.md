# 개발 디렉토리 구조
```
  com
    └─mydata
        ├─base : 상속(extends)되는 파일 디렉토리
        ├─config : 환경설정 파일 디렉토리
        ├─controller : Controller 디렉토리
        ├─domain : DB 관련 디렉토리
        │  ├─entity : JPA Entity Directory
        │  ├─mybatis : Mybatis에서 사용되는 File Directory( DAO, DTO )
        │  ├─repository : JPA Repository Directory
        │  └─service : DB 서비스 디렉토리
        ├─exception : 예외처리 관련 디렉토리
        ├─sample : Lagacy Restful API Sample 디렉토리
        └─service : Mydata API 서비스 디렉토리
            ├─common : 공통 서비스 디렉토리
            │  ├─apis : API 목록 조회
            │  ├─consents : 전송요구 내역 조회
            │  └─oauth : 개별/통합인증
            │      ├─authorize : 인가코드 발급 요청
            │      ├─revoke : 접근토큰 폐
            │      └─token : 개별인증 접근토큰 발급요청 및 갱신
            └─insu : 보험 정보
                ├─consents
                ├─db
                │  └─basic
                ├─dc
                │  ├─basic
                │  ├─detail
                │  ├─transactions
                ├─insurances : 보험 목록 조회
                │  ├─basic : 보험 기본정보 조회
                │  ├─car
                │  │  └─transactions : 자동차보험 거래내역 조회
                │  ├─contracts : 피보험자 물, 일반보험 기본정보 조회
                │  ├─coverages : 피보험자 물, 일반 보장정보 조회
                │  ├─general
                │  │  ├─basic
                │  │  ├─contracts
                │  │  ├─coverages
                │  │  └─transactions
                │  ├─payment
                │  └─transactions
                ├─insured
                │  ├─basic
                │  ├─car
                │  ├─contracts
                │  ├─coverages
                │  └─general
                │     ├─basic
                │     ├─contracts
                │     └─coverages
                ├─irps
                │  ├─basic
                │  ├─detail
                │  └─transactions
                └─loans
                    ├─basic
                    ├─detail
                    └─transactions
```