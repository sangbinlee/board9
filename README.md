# Getting Started


# https://docs.docker.com/desktop/setup/install/windows-install/

# but 5 were found:


	***************************
	APPLICATION FAILED TO START
	***************************

	Description:

	Parameter 1 of method dataSource in org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration$Hikari required a single bean, but 5 were found:
		- jdbcConnectionDetailsForBoard9Mariadb1: defined in unknown location
		- jdbcConnectionDetailsForBoard9Mysql1: defined in unknown location
		- jdbcConnectionDetailsForBoard9Oracle1: defined in unknown location
		- jdbcConnectionDetailsForBoard9Postgres1: defined in unknown location
		- jdbcConnectionDetailsForBoard9Sqlserver1: defined in unknown location

	This may be due to missing parameter name information

	Action:

	Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed

	Ensure that your compiler is configured to use the '-parameters' flag.
	You may need to update both your build tool settings as well as your IDE.
	(See https://github.com/spring-projects/spring-framework/wiki/Upgrading-to-Spring-Framework-6.x#parameter-name-retention)



# 1521 -> 15211

	Error response from daemon: Ports are not available: exposing port TCP 0.0.0.0:1521

#



org.springframework.boot.docker.compose.lifecycle.ReadinessTimeoutException: Readiness timeout of PT2M reached while waiting for services [board9-mariadb-1]




# Public key retrieval is not allowed
jdbc:mysql://localhost:3306/test_db?useSSL=false&allowPublicKeyRetrieval=true


# java.lang.IllegalArgumentException: jdbcUrl is required with driverClassName.


	#spring.datasource.maria.url=jdbc:mariadb://localhost:13306/mydatabase
	spring.datasource.maria.jdbcUrl=jdbc:mariadb://localhost:13306/mydatabase

# org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'repositoryEntityController' defined in class path resource




# oracle database and table

create user user_oracle identified by user_oracle default tablespace users temporary tablespace temp;
grant connect to user_oracle;
grant resource to user_oracle;
grant dba to user_oracle;




# 응답 json 널 필드 표시 제거
	//@JsonInclude(JsonInclude.Include.NON_NULL)// Json-응답시-Null-필드-제외


# 응답 json 필드 표시 순서

	@JsonPropertyOrder({ "id", "name", "quantity", "price" }) // json 출력 순서지정
 	@JsonPropertyOrder(alphabetic = true)

# 페이징 request 방법

	http://localhost:8080/todo?page=3&size=5&sort=id,desc



#    결과 캐스팅 에러 = mybatis 사용시

	LocalDateTimeTypeHandler



# 다중 정렬

	http://localhost:8080/todo/page
	?sort=id,desc
	&size=1000

	http://localhost:8080/todo/page
	?page=1
	&size=5
	&sort=id,desc
	&sort=name,desc
	&sort=price,desc
	&keyword=test

# sql parameter 확인 1

	logging.level.org.hibernate.type=trace

# sql parameter 확인 2

	implementation 'com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.8.0'
# jpa 쿼리 조건 넣기 - 검색어




		ExampleMatcher matcher = ExampleMatcher.matching()



# ration$PageModule$WarningLoggingModifier

	Serializing PageImpl instances as-is is not supported, meaning that there is no guarantee about the stability of the resulting JSON structure!
		For a stable JSON structure, please use Spring Data's PagedModel (globally via @EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO))
		or Spring HATEOAS and Spring Data's PagedResourcesAssembler as documented in https://docs.spring.io/spring-data/commons/reference/repositories/core-extensions.html#core.web.pageables.

# Name for argument of type [java.lang.String] not specified,
	Name for argument of type [java.lang.String] not specified, and parameter name information not available via reflection. Ensure that the compiler uses the '-parameters' flag.
		at org.springframework.web.method.annotation.AbstractNamedValueMethodArgumentResolver.updateNamedValueInfo(AbstractNamedValueMethodArgumentResolver.java:186) ~[spring-web-6.1.15-SNAPSHOT.jar:6



# crud   paging

	post
		http://localhost:8080/todo

		{
		    "name": "sangbinlee",
		    "quantity": 1000,
		    "price": 99999
		}


	get
		http://localhost:8080/todo/page?sort=id,desc&size=1000&keyword=sangbinlee
		http://localhost:8080/todo/page?page=1&size=5&sort=name,desc&sort=price,desc&keyword=test

		{}


	delete
		http://localhost:8080/todo
		{
		    "name": "sangbinlee",
		    "quantity": 1000,
		    "price": 99999
		}

# 등록 수정시 자동 세팅
	등록시 등록자, 등록일시
	수정시 수정자, 수정일지



#
#
#
#
#
#
#
# build
	gradlew build -x test

	sangb@□ֹ□2 MINGW64 /c/dev9/workspace-spring-tool-suite-4-4.26.0.RELEASE/board9 (main)
	$ ./gradlew build


	C:\dev9\workspace-spring-tool-suite-4-4.26.0.RELEASE\board9>gradle build

	> Task :compileJava
	Note: C:\dev9\workspace-spring-tool-suite-4-4.26.0.RELEASE\board9\src\main\java\com\dev9\board\api\todo\TodoRestController.java uses unchecked or unsafe operations.
	Note: Recompile with -Xlint:unchecked for details.
	OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended
	2024-11-19T01:33:01.069+09:00  INFO 15100 --- [board9] [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
	2024-11-19T01:33:01.072+09:00  INFO 15100 --- [board9] [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
	2024-11-19T01:33:01.086+09:00  INFO 15100 --- [board9] [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
	[Incubating] Problems report is available at: file:///C:/dev9/workspace-spring-tool-suite-4-4.26.0.RELEASE/board9/build/reports/problems/problems-report.html

	Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.

	You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

	For more on this, please refer to https://docs.gradle.org/8.11/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

	BUILD SUCCESSFUL in 35s
	8 actionable tasks: 7 executed, 1 up-to-date
	C:\dev9\workspace-spring-tool-suite-4-4.26.0.RELEASE\board9>







	sangb@□ֹ□2 MINGW64 /c/dev9/workspace-spring-tool-suite-4-4.26.0.RELEASE/board9 (main)
	$ ./gradlew build

	> Task :generateJava
	Schema is empty

	> Task :compileJava
	Note: C:\dev9\workspace-spring-tool-suite-4-4.26.0.RELEASE\board9\src\main\java\com\dev9\board\api\todo\TodoRestController.java uses unchecked or unsafe operations.
	Note: Recompile with -Xlint:unchecked for details.
	OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended
	2024-11-19T02:35:27.735+09:00  INFO 27924 --- [board9] [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
	2024-11-19T02:35:27.738+09:00  INFO 27924 --- [board9] [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
	2024-11-19T02:35:27.743+09:00  INFO 27924 --- [board9] [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.

	Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.

	You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

	For more on this, please refer to https://docs.gradle.org/8.10.2/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

	BUILD SUCCESSFUL in 30s
	8 actionable tasks: 8 executed

	sangb@□ֹ□2 MINGW64 /c/dev9/workspace-spring-tool-suite-4-4.26.0.RELEASE/board9 (main)
	$












# @EnableCaching
#
#
# docker build [Dockerfile]


	C:\Users\sangb>cd C:\dev9\workspace-spring-tool-suite-4-4.26.0.RELEASE\board9

	C:\dev9\workspace-spring-tool-suite-4-4.26.0.RELEASE\board9>


		docker build -t board9 .



	after	make a Dockerfile
	after run docker desktop



		C:\dev9\workspace-spring-tool-suite-4-4.26.0.RELEASE\board9>docker build -t board9 .
		[+] Building 21.1s (9/9) FINISHED                                                                                                      docker:desktop-linux
		 => [internal] load build definition from Dockerfile                                                                                                   0.0s
		 => => transferring dockerfile: 208B                                                                                                                   0.0s
		 => [internal] load metadata for docker.io/library/openjdk:17-jdk                                                                                      2.8s
		 => [auth] library/openjdk:pull token for registry-1.docker.io                                                                                         0.0s
		 => [internal] load .dockerignore                                                                                                                      0.0s
		 => => transferring context: 2B                                                                                                                        0.0s
		 => [1/3] FROM docker.io/library/openjdk:17-jdk@sha256:528707081fdb9562eb819128a9f85ae7fe000e2fbaeaf9f87662e7b3f38cb7d8                               14.7s
		 => => resolve docker.io/library/openjdk:17-jdk@sha256:528707081fdb9562eb819128a9f85ae7fe000e2fbaeaf9f87662e7b3f38cb7d8                                0.0s
		 => => sha256:a7203ca35e75e068651c9907d659adc721dba823441b78639fde66fc988f042f 187.53MB / 187.53MB                                                    13.1s
		 => => sha256:38a980f2cc8accf69c23deae6743d42a87eb34a54f02396f3fcfd7c2d06e2c5b 42.11MB / 42.11MB                                                       6.0s
		 => => sha256:de849f1cfbe60b1c06a1db83a3129ab0ea397c4852b98e3e4300b12ee57ba111 13.53MB / 13.53MB                                                       3.4s
		 => => extracting sha256:38a980f2cc8accf69c23deae6743d42a87eb34a54f02396f3fcfd7c2d06e2c5b                                                              1.1s
		 => => extracting sha256:de849f1cfbe60b1c06a1db83a3129ab0ea397c4852b98e3e4300b12ee57ba111                                                              0.3s
		 => => extracting sha256:a7203ca35e75e068651c9907d659adc721dba823441b78639fde66fc988f042f                                                              1.5s
		 => [internal] load build context                                                                                                                      2.5s
		 => => transferring context: 79.96MB                                                                                                                   2.5s
		 => [2/3] WORKDIR /app                                                                                                                                 0.2s
		 => [3/3] COPY build/libs/board9-0.0.1-SNAPSHOT.jar app.jar                                                                                            0.1s
		 => exporting to image                                                                                                                                 3.0s
		 => => exporting layers                                                                                                                                2.5s
		 => => exporting manifest sha256:7a734c132a435a0ca1dd82de9110c549062440f1f3886340d57bb576d942eacc                                                      0.0s
		 => => exporting config sha256:94b1e4696a3e9d639d8e949df7f9710dcf569b434c0831d27b739b3c3f690792                                                        0.0s
		 => => exporting attestation manifest sha256:6cc3003539f6cf2d89f0f052cc915c645cfa1dc87dbc78938f9d1d7b8201102a                                          0.0s
		 => => exporting manifest list sha256:94460a89b5d702b2b8408496dc3c776f400a5fd7c3145dc0e5af83be0602ea20                                                 0.0s
		 => => naming to docker.io/library/board9:latest                                                                                                       0.0s
		 => => unpacking to docker.io/library/board9:latest                                                                                                    0.5s

		View build details: docker-desktop://dashboard/build/desktop-linux/desktop-linux/9lnbfp3uyz8ruse9qtzbflhki

		 1 warning found (use docker --debug to expand):
		 - JSONArgsRecommended: JSON arguments recommended for ENTRYPOINT to prevent unintended behavior related to OS signals (line 8)

		C:\dev9\workspace-spring-tool-suite-4-4.26.0.RELEASE\board9>





# local docker build image 확인

![image](https://github.com/user-attachments/assets/0149a4a8-51f5-425e-aa94-63ee750604d2)



# Jenkinsfile
# github - webhook  test  - ok
# github - webhook  test  - ok
# 우분투 타임존 변경
	sangbinlee9@dev9-ubuntu24-1:/etc$ timedatectl
	               Local time: Sat 2024-12-07 02:48:53 UTC
	           Universal time: Sat 2024-12-07 02:48:53 UTC
	                 RTC time: Sat 2024-12-07 02:48:53
	                Time zone: Etc/UTC (UTC, +0000)
	System clock synchronized: yes
	              NTP service: active
	          RTC in local TZ: no
	sangbinlee9@dev9-ubuntu24-1:/etc$ timedatectl list-timezones | grep Seoul
	Asia/Seoul
	sangbinlee9@dev9-ubuntu24-1:/etc$ sudo timedatectl set-timezone Asia/Seoul
	[sudo] password for sangbinlee9:
	sangbinlee9@dev9-ubuntu24-1:/etc$ timedatectl
	               Local time: Sat 2024-12-07 11:49:44 KST
	           Universal time: Sat 2024-12-07 02:49:44 UTC
	                 RTC time: Sat 2024-12-07 02:49:44
	                Time zone: Asia/Seoul (KST, +0900)
	System clock synchronized: yes
	              NTP service: active
	          RTC in local TZ: no
	sangbinlee9@dev9-ubuntu24-1:/etc$

	sangbinlee9@dev9-ubuntu24-1:/etc$ date
	Sat Dec  7 11:50:12 AM KST 2024
	sangbinlee9@dev9-ubuntu24-1:/etc$



# jenkins timezone 변경 하기


	sangbinlee9@dev9-ubuntu24-1:~$ date
	Sat Dec  7 01:12:46 PM KST 2024
	sangbinlee9@dev9-ubuntu24-1:~$ ls -l /etc/localtime
	lrwxrwxrwx 1 root root 30 Dec  7 11:49 /etc/localtime -> /usr/share/zoneinfo/Asia/Seoul



#
