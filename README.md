# Spring Study

### 토비 스프링 3.1 을 보면서 코딩하고 있습니다. (~~CD가 없어서 책만 보면서 코딩 중~~) 

## 기본적인 개발 환경

- STS Version : 3.9.4.RELEASE
- JDK Version : 1.8.0_151

## 프로젝트 생성 방법

- `File > New > Project` 에서 `Maven Project` 선택
- `Archetype`은 `maven-archetype-webapp` 선택

## 설정

- 프로젝트 우클릭 > `Build Path` > `Configure Build Path...` > Java Build Path 메뉴에서 Libaries 탭 선택 > JRE System Library 1.8로 변경

## 일반적인 POM.xml (예제 Case에 따라 dependency 추가될 수 있음))

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.wooyoung</groupId>
  <artifactId>toby-vol1</artifactId>
  <packaging>war</packaging>
  <version>0.0.1-SNAPSHOT</version>
  <name>toby-vol1 Maven Webapp</name>
  <url>http://maven.apache.org</url>
  <dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-beans</artifactId>
			<version>5.0.6.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>5.0.6.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>5.0.6.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-expression</artifactId>
			<version>5.0.6.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>5.0.6.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-test</artifactId>
			<version>5.0.6.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.46</version>
		</dependency>
	</dependencies>
	<build>
		<finalName>toby_spring</finalName>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.1</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
					<encoding>utf-8</encoding>
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>

```