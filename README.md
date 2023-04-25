# Getting Started

## 기존 프로젝트 README.md 참조용으로 복사하였습니다.
- jar파일 떨궈주시면 자동으로 배포 되게 설정하였습니다.

- DB 사용이 필요한 경우 아래 환경변수 사용하는 것으로 셋팅하시면 배포 후 파드가 DB접근이 가능합니다.
- Kubernetes에서는 pod 정상여부를 체그 하기 때문에 "/healthy" 경로의 헬스체크 컨트롤로가 필요합니다.

## 하단부터 기존 프로젝트 README.md 내용입니다.
## 로컬 환경 구성

로컬 Yogig-Giglink Spring boot 환경 구성
## General Project Structure

```bash
├─┬ ba_scp/                                     # Directory for 디아모 library
│ ├─ dev/                                       # Directory for 개발용 디아모 key
│ └─ prd/                                       # Directory for 운영용 디아모 key
├─ libs                                         # Directory for external jars
├─┬ src/main/
├─ .gitlab-ci.yml                               # git lab ci file link
├─ build.gradle                                 # gradle build file
└─ Dockerfile                                   # docker build sh in CICD
```

### VS Code
IDE 설치
- VS Code(https://code.visualstudio.com/)
- 중요 단말 망에서는 https://gitlab.hldevops.com/gep/tools/devtools

### VS Code Extensions

개발을 위한 필수 Extention

- Spring Initializr Java Support - 스프링 프로젝트 만들때 템플릿
- Spring Boot Extension Pack - 스프링 개발에 필요한 익스텐션
- Spring Boot Tools - boot configuration
- Java Dependency Viewer - 의존성, 참조
- Debugger for Java - 자바 디버깅
- Java Extension Pack - 인기있는 자바 익스텐션 모음
- Language Support for Java by Red Hat - 코드 네비게이션, 리팩토링 등 생산성 향상
- Java Test Runner - JUnit등 테스트 실행
- Gradle Language Support - Gradle
- Gradle Task - Gradle Build
- Lombok Annotations Support for VS Code - 롬복

### CI
소스관리
- Git Client 설치
- Gitlab 권한 신청
- Gitlab 소스코드 clone : git clone https://gitlab.hldevops.com/gep/backend/gep-gig.git

### Branch 전략
- Infra에서 제공하는 CICD 가이드를 따름
- feature/develop/stage/master 가 기본 Branch
- feature는 jira issue할당 받으면 develop에서 분기하여 생성
- 운영 반영 전 bugfix, 운영 반영 후 hotfix branch 생성
- naming rule -> (master|stage|develop|develop2|(revert|cherry-pick)-[a-z0-9_/]+|[0-9]+-(issue|feature|feature2|bugfix|hotfix)-[-a-z0-9_/]+)
- 예시) issue번호-feature-issue제목, 103-feature-member-login

### Swagger

API 관리

- http://localhost:7070/swagger-ui.html

### Docker 설치

로컬 DB 사용 시(Windows10 && Ram 8G필요)

- Docker for window(https://hub.docker.com/editions/community/docker-ce-desktop-windows)

### DB 접속정보
mysql

### Local DB
Local DB 구성

### openjdk 1.11 설치
Open JDK 설치

- jdk다운로드 및 로컬 설치 : https://jdk.java.net/archive/ ( 11.0.8)
- 예시 설치 JAVA_HOME : D:/openjdk/openjdk-11.0.2_windows-x64_bin/jdk-11.0.6
- visual studio code 세팅
  - .vscode -> settings.json 클릭 후

```
"java.home": "D:/openjdk/openjdk-11.0.8_windows-x64_bin/jdk-11.0.8",
추가
```

- 위의 세팅을 했음에도 java를 인지못하는 경우
  - C:\Users\skrho\AppData\Roaming\Code\User\settings.json 항목을 찾아 코드 추가

```
"java.home": "D:/openjdk/openjdk-11.0.8_windows-x64_bin/jdk-11.0.8",
추가
```

- 그외 JAVA_HOME과 PATH 추가는 환경변수를 활용함(GIT Bash 또는 WSL, CMD는 환경변수에 따라 동작함)

### 테스트 테이블 및 데이터

flyway사용으로 아래의 자동 테이블 및 저장 데이터 생성

```
CREATE TABLE `city` (
	`ID` INT(11) NOT NULL AUTO_INCREMENT,
	`Name` CHAR(35) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`CountryCode` CHAR(3) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`District` CHAR(20) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`Population` INT(11) NOT NULL DEFAULT '0',
	PRIMARY KEY (`ID`) USING BTREE
)
COLLATE='latin1_swedish_ci'
ENGINE=MyISAM
AUTO_INCREMENT=4080
;

INSERT IGNORE INTO `city` (`ID`, `Name`, `CountryCode`, `District`, `Population`) VALUES
	(1, 'Kabul', 'AFG', 'Kabol', 1780000),
	(2, 'Qandahar', 'AFG', 'Qandahar', 237500),
	(3, 'Herat', 'AFG', 'Herat', 186800),
	(4, 'Mazar-e-Sharif', 'AFG', 'Balkh', 127800),
	(5, 'Amsterdam', 'NLD', 'Noord-Holland', 731200),
	(6, 'Rotterdam', 'NLD', 'Zuid-Holland', 593321),
	(7, 'Haag', 'NLD', 'Zuid-Holland', 440900),
	(8, 'Utrecht', 'NLD', 'Utrecht', 234323),
	(9, 'Eindhoven', 'NLD', 'Noord-Brabant', 201843),
	(10, 'Tilburg', 'NLD', 'Noord-Brabant', 193238),
	(11, 'Groningen', 'NLD', 'Groningen', 172701),
	(12, 'Breda', 'NLD', 'Noord-Brabant', 160398),
	(13, 'Apeldoorn', 'NLD', 'Gelderland', 153491),
	(14, 'Nijmegen', 'NLD', 'Gelderland', 152463),
	(15, 'Enschede', 'NLD', 'Overijssel', 149544),
	(16, 'Haarlem', 'NLD', 'Noord-Holland', 148772);
```

### aws config 파일 생성

1. 경로

- 폴더 경로 : ~/.aws
- 파일명 : config

2. 내용

```
[default]
region = ap-northeast-2
```

### aws credential 파일 생성

1. 경로

- 폴더 경로 : ~/.aws
- 파일명 : credentials

2. 내용

```
[default]
aws_access_key_id = 키id값
aws_secret_access_key = 키값
```

### 기동

1. 로컬 db container 기동

2. spring boot 기동


3. health check
   - GET, http://localhost:8081/healthy
   - 응답, 200 OK, {"status": "UP"}

---

## 중요 단말망 개발 PC 환경 세팅


### 개발 PC권한 제한에 따른 프로그램 설치 방법



