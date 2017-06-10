maven(使用以下文件：pom.xml)

清空 ：clean
打包 ：install
清空eclipse配置 ：eclipse:clean
配置eclipse工程 ：alt+f5 或 eclipse:eclipse
清空myeclipse配置 ：eclipse:myeclipse-clean
配置myeclipse工程 ：eclipse:myeclipse
清空idea配置 ：idea:clean
配置idea工程 ：idea:idea
运行工程：jetty:run

gradle(使用以下文件：gradle,settings.gradle,build.gradle,gradlew.bat,gradlew)

清空 ：clean
打包 ：war
//如果在eclipse工程中执行配置eclipse工程命令时，请先关闭publiccms,publiccms-common工程，再执行下面的命令，否则eclipse会干扰Deployment Assembly设置，造成test类也被部署
清空eclipse配置 ：cleanEclipse
配置eclipse工程 ：ctrl+f5 或 eclipse
清空idea配置 ：cleanIdea
配置idea工程 ：idea
