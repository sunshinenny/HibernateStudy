# HibernateStudy
## 遇到的问题与解决
1. [java.lang.NoClassDefFoundError: javax/persistence/EntityListeners](https://stackoverflow.com/questions/31668779/java-lang-noclassdeffounderror-javax-persistence-entitylisteners)

	错误提示
	``` java
	java.lang.NoClassDefFoundError: javax/persistence/EntityListeners
	```

	> Click Here to download hibernate-jpa-2.0-api-1.0.1.Final.jar and put it into the project library, your application will work fine.
	>

2. [执行save操作报错](https://stackoverflow.com/questions/27104239/org-hibernate-hibernateexception-the-database-returned-no-natively-generated-id)
解决办法
	1. [根据错误提示寻找问题解决](https://stackoverflow.com/questions/27104239/org-hibernate-hibernateexception-the-database-returned-no-natively-generated-id)

	``` java
	org.hibernate.HibernateException: The database returned no natively generated identity value
	```
	> You forget to use the auto_increment in Your database table. The Table table definition some thing like the below format,
	>
	> ``` sql
	CREATE TABLE EMPLOYEE (
	ID INT AUTO_INCREMENT,
	FIRST_NAME VARCHAR(20),
	LAST_NAME VARCHAR(20),
	SALARY INT,
	PRIMARY KEY (ID)
	) ENGINE=InnoDB;
	```
	2. [Navigat中设置主键自动增长解决问题](https://blog.csdn.net/u011101498/article/details/51823401)
> 在添加或变更表结构时, 把 id 字段设置为整型, 下面的选项就会出现 auto increment 的选择框, 勾选中就可以了。
