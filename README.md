**主要技术选型：**
1. SpringMVC+SpringDataJpa+EasyUI
2. H2 Database
3. Web Manager
4. Ckeditor-4.5.6
5. Echarts-2.2.7
6. Ztree
7. Bootstrap



1、http://localhost:5678/imark/html/index  网站访问页面  
2、http://localhost:5678/imark             后台访问地址  
3、http://localhost:5678/imark/html/ifly   演示网站地址  
4、http://localhost:5678/imark/html/content 演示网站后端  

_一、关于数据库：_  
系统采用内嵌数据库H2,使用jetty:run启动时自行进行启动,数据库文件存放位置为当前用户下 database/imark.mv.db  
1、若在Window系统下：  
C:\Users\wyc\database\imark.mv.db  
2、若在 Linux操作系统下：  
/home/wuyechun/database/imark.mv.db  

_二、关于模板引擎：_
1、管理页面采用EasyUI; 如：http://localhost:5678/imark/views/system/user  
2、网站页面使用Freemarker; 如：http://localhost:5678/imark/html/index  

