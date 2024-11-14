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
## board9
