echo off

set CLASSPATH=C:/Java/jdk1.7.0_80/jre/lib/charsets.jar
set CLASSPATH=%CLASSPATH%C:/Java/jdk1.7.0_80/jre/lib/deploy.jar
set CLASSPATH=%CLASSPATH%;C:/Java/jdk1.7.0_80/jre/lib/ext/access-bridge-64.jar
set CLASSPATH=%CLASSPATH%;C:/Java/jdk1.7.0_80/jre/lib/ext/dnsns.jar
set CLASSPATH=%CLASSPATH%;C:/Java/jdk1.7.0_80/jre/lib/ext/jaccess.jar
set CLASSPATH=%CLASSPATH%;C:/Java/jdk1.7.0_80/jre/lib/ext/localedata.jar
set CLASSPATH=%CLASSPATH%;C:/Java/jdk1.7.0_80/jre/lib/ext/sunec.jar
set CLASSPATH=%CLASSPATH%;C:/Java/jdk1.7.0_80/jre/lib/ext/sunjce_provider.jar
set CLASSPATH=%CLASSPATH%;C:/Java/jdk1.7.0_80/jre/lib/ext/sunmscapi.jar
set CLASSPATH=%CLASSPATH%;C:/Java/jdk1.7.0_80/jre/lib/ext/zipfs.jar
set CLASSPATH=%CLASSPATH%;C:/Java/jdk1.7.0_80/jre/lib/javaws.jar
set CLASSPATH=%CLASSPATH%;C:/Java/jdk1.7.0_80/jre/lib/jce.jar
set CLASSPATH=%CLASSPATH%;C:/Java/jdk1.7.0_80/jre/lib/jfr.jar
set CLASSPATH=%CLASSPATH%;C:/Java/jdk1.7.0_80/jre/lib/jfxrt.jar
set CLASSPATH=%CLASSPATH%;C:/Java/jdk1.7.0_80/jre/lib/jsse.jar
set CLASSPATH=%CLASSPATH%;C:/Java/jdk1.7.0_80/jre/lib/management-agent.jar
set CLASSPATH=%CLASSPATH%;C:/Java/jdk1.7.0_80/jre/lib/plugin.jar
set CLASSPATH=%CLASSPATH%;C:/Java/jdk1.7.0_80/jre/lib/resources.jar
set CLASSPATH=%CLASSPATH%;C:/Java/jdk1.7.0_80/jre/lib/rt.jar
set CLASSPATH=%CLASSPATH%;C:/workspace/Delta/capability-framework/ExternalConfig
set CLASSPATH=%CLASSPATH%;C:/workspace/Delta/capability-framework/Frameworks/hw-framework-common/target/classes/
set CLASSPATH=%CLASSPATH%;C:/workspace/Delta/capability-framework/Frameworks/hw-framework-logging/target/classes/
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/org/springframework/spring-core/3.2.1.RELEASE/spring-core-3.2.1.RELEASE.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/org/springframework/spring-context/3.2.1.RELEASE/spring-context-3.2.1.RELEASE.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/org/springframework/spring-beans/3.2.1.RELEASE/spring-beans-3.2.1.RELEASE.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/org/springframework/spring-expression/3.2.1.RELEASE/spring-expression-3.2.1.RELEASE.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/org/springframework/spring-aop/3.2.1.RELEASE/spring-aop-3.2.1.RELEASE.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/aopalliance/aopalliance/1.0/aopalliance-1.0.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/org/aspectj/aspectjrt/1.6.11/aspectjrt-1.6.11.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/org/aspectj/aspectjweaver/1.6.11/aspectjweaver-1.6.11.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/org/slf4j/slf4j-api/1.7.5/slf4j-api-1.7.5.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/ch/qos/logback/logback-classic/1.0.13/logback-classic-1.0.13.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/ch/qos/logback/logback-core/1.0.13/logback-core-1.0.13.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/org/snmp4j/snmp4j/1.7.1/snmp4j-1.7.1.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/net/sf/joesnmp/joesnmp/0.3.4/joesnmp-0.3.4.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/org/apache/commons/commons-configuration2/2.1.1/commons-configuration2-2.1.1.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/org/apache/commons/commons-lang3/3.1/commons-lang3-3.1.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/commons-logging/commons-logging/1.2/commons-logging-1.2.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/commons-io/commons-io/2.5/commons-io-2.5.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/commons-beanutils/commons-beanutils/1.9.3/commons-beanutils-1.9.3.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/commons-collections/commons-collections/3.2/commons-collections-3.2.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/commons-jxpath/commons-jxpath/1.3/commons-jxpath-1.3.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/xerces/xercesImpl/2.11.0/xercesImpl-2.11.0.jar
set CLASSPATH=%CLASSPATH%;C:/Users/jaminhas/.m2/repository/xml-apis/xml-apis/1.4.01/xml-apis-1.4.01.jar
set CLASSPATH=%CLASSPATH%;C:/Program%20Files/JetBrains/IntelliJ%20IDEA%202017.2.1/lib/idea_rt.jar

set JAVA_HOME=C:/Java/jdk1.7.0_80
set PATH=%JAVA_HOME%/bin;%JAVA_HOME%/bin
echo

java   com.sdm.hw.common.capability.CapabilityMangerTester
