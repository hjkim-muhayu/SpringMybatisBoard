"# SpringMybatisBoard" 

1. create MySQL table
=====================================
create table board (
	no		int auto_increment primary key,
	title		varchar(255),
	contents	longtext character set utf8 not null,
	create_date	datetime,
	modify_date	datetime,
	PRIMARY KEY (no)
)


2. Add DB Resource Info in server.xml
=====================================
	  	<Resource 
			name="jdbc/mysql"
			auth="Container"
			type="javax.sql.DataSource"
			username="X"
			password="Y"
			driverClassName="com.mysql.jdbc.Driver"
			url="jdbc:mysql://localhost:3306/mysql"
			maxActive="15"
			maxIdle="3"/>

3. index
========================================
http://~~/SpringMybatisBoard/index.do