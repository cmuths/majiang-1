mvn eclipse:eclipse -DdownloadSources=true

#代码生成
java -jar mybatis-generator-core-1.3.2.jar -configfile generatorConfig.xml  -overwrite