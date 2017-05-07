# PublicCMS 2017 Preview

## 获取可运行程序

https://git.oschina.net/sanluan/PublicCMS-war
https://github.com/sanluan/PublicCMS-war

## 获取稳定版源码

https://git.oschina.net/sanluan/PublicCMS
https://github.com/sanluan/PublicCMS
https://code.csdn.net/zyyy358/publiccms

## 参与研发(预览版)

https://git.oschina.net/sanluan/PublicCMS-preview
https://github.com/sanluan/PublicCMS-preview

## 相关下载及文档(知识库)

https://github.com/sanluan/PublicCMS-lib
https://git.oschina.net/sanluan/PublicCMS-lib

### 预览版更新

框架升级:

1. Freemarker 2.3.26-incubating
1. Jackson 2.8.8
1. Spring 4.3.8.RELEASE
1. Spring Boot 1.5.3.RELEASE

BUG修复:

1. CMS部署路径有空格时配置错误
1. 导入数据库脚本乱码
1. 内容列表没有子内容模型新建按钮
1. 网站文件列表中查看文件路径错误
1. 高版本Mysql打印警告信息修复
1. 推荐位匿名投稿错误
1. 删除分类后父分类childIds不为空错误
1. 模板帮助getDateNumber错误
1. 分类类型删除提示有分类已使用错误

新增功能:

1. 前台推荐位投稿管理
1. 内容投稿
1. 内容投稿模板帮助
1. 启动命令指定数据目录位置

其他提升:

1. 删除cms_content_tag表及相关代码
1. 界面修改、字体行距等调大
1. 将数据库配置文件位置改为数据目录下
1. 将包名改为org.publiccms,将com.sanluan包独立到publiccms-common工程

