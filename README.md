# HibernateStudy
## 遇到的问题与解决
### ~ [java.lang.NoClassDefFoundError: javax/persistence/EntityListeners](https://stackoverflow.com/questions/31668779/java-lang-noclassdeffounderror-javax-persistence-entitylisteners)
> Click Here to download hibernate-jpa-2.0-api-1.0.1.Final.jar and put it into the project library, your application will work fine.
>

## 补充一些错误提示
**在执行save操作时**
``` java
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into hibernatetest.userinfo (password) values (?)
Exception runned
org.hibernate.HibernateException: The database returned no natively generated identity value
	at org.hibernate.id.IdentifierGeneratorHelper.getGeneratedIdentity(IdentifierGeneratorHelper.java:86)
	at org.hibernate.id.IdentityGenerator$GetGeneratedKeysDelegate.executeAndExtract(IdentityGenerator.java:97)
	at org.hibernate.id.insert.AbstractReturningDelegate.performInsert(AbstractReturningDelegate.java:56)
	at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2346)
	at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2853)
	at org.hibernate.action.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:71)
	at org.hibernate.engine.ActionQueue.execute(ActionQueue.java:273)
	at org.hibernate.event.def.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:320)
	at org.hibernate.event.def.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:203)
	at org.hibernate.event.def.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:129)
	at org.hibernate.event.def.DefaultSaveOrUpdateEventListener.saveWithGeneratedOrRequestedId(DefaultSaveOrUpdateEventListener.java:210)
	at org.hibernate.event.def.DefaultSaveEventListener.saveWithGeneratedOrRequestedId(DefaultSaveEventListener.java:56)
	at org.hibernate.event.def.DefaultSaveOrUpdateEventListener.entityIsTransient(DefaultSaveOrUpdateEventListener.java:195)
	at org.hibernate.event.def.DefaultSaveEventListener.performSaveOrUpdate(DefaultSaveEventListener.java:50)
	at org.hibernate.event.def.DefaultSaveOrUpdateEventListener.onSaveOrUpdate(DefaultSaveOrUpdateEventListener.java:93)
	at org.hibernate.impl.SessionImpl.fireSave(SessionImpl.java:713)
	at org.hibernate.impl.SessionImpl.save(SessionImpl.java:701)
	at org.hibernate.impl.SessionImpl.save(SessionImpl.java:697)
	at com.Test.saveToDatabase(Test.java:33)
	at com.Test.main(Test.java:13)
```
**Database-code**
``` sql
SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userId` int(255) NOT NULL DEFAULT '0',
  `password` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'placeSuccess');
```
