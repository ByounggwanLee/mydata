# Mydata

## 개발내용

### 1. 개발환경 정의
    a. Java 1.8
    b. Oracle 19c
    c. 개발툴 Spring Tool Suit4
    d. Framework : Spring Boot 2.7.1
   
### 2. Spring Boot Project생성
    a. Naming Convention 표준적용
        1) 디렉토리 생성
        2) 파일 생성
	  
    b. exception 및 Log 표준적용
        1) 오류에 따른 Mydata 응답메세지 표준적용
        2) slf4j을 이용한 로그모델 적용
	  
    c. Online 표준 Process 정의
        1) Controller -> Service -> Legacy(Feign)
        2) Controller -> Service -> JPA
        3) Controller -> Service -> MyBatis
	  
    d. 처리결과 DB저장 Model 적용(JPA) : Domain / Entity - Repository
    
    e. Join 및 Complex Query Model 적용(JPA) : Domain / Mybatis, Resource / mapper 
    
    f. Swagger을 이용한 테스트 화면 제공 
        1) 기능별 테스트
        2) Version별 테스트 
    
    g. 주석표준 적용	 

## DOCKER
### runOracle.bat
``` 
echo off
REM docker network create dev-net
REM -------------------------------
REM PULL IMAGE
REM -------------------------------
REM docker pull doctorkirk/oracle-19c
REM docker pull jaspeen/oracle-xe-11g


REM -------------------------------
REM run IMAGE
REM 
REM * KO16KSC5601
REM   완성형 한글- 일반적으로 많이 사용되며 2350자의 한글, 4888자의 한자, 히라카나, 카타카나, 영문 및 각종 기호를 포함하고 있음.  (한글바이트: 2byte)
REM
REM * KO16MSWIN949
REM   조합형 한글- 완성형을 포함하여 11172자의 한글을 표현함 (한글바이트: 2byte)
REM
REM * AL32UTF8 
REM   Unicode의 CES 중 하나- 11172자의 한글을 지원 (한글바이트: 3byte)
REM -------------------------------
docker run --name oracle --network dev-net -d -p 1521:1521 -e TZ=Asia/Seoul -e ORACLE_SID=ORAMYDATA -e ORACLE_PWD=Qudrhks2! -e ORACLE_CHARACTERSET=AL32UTF8 -v D:\Docker\mount\oracle\oradata:/opt/oracle/oradata doctorkirk/oracle-19c
REM docker run --name oracle --network dev-net -d -p 1521:1521 -e TZ=Asia/Seoul -v D:\Docker\mount\oracle\oradata:/u01/app/oracle/oradata -v D:\Docker\mount\oracle\dbs:/u01/app/oracle/dbs jaspeen/oracle-xe-11g
```
