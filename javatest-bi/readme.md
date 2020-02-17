# BI说明

# 准备

## 安装jar到maven

进入到jar目录下打开install-jar-to-local.bat文件，将里面的内容一行行的执行以下，不可双击执行，因为双击只能执行第一行

## 配置文件

src/main/resources/config/application.yml

配置rtf相关信息

```
# bi文件相关设置
rtf:
  rtfTemplateFolderPath: D:/deleteme/rtfTemplate  # rtf模板文件位置
  targetFolderPath: D:/deleteme/target            # 生成的最终pdf存放位置
  tempFolderPath: D:/deleteme/temp                # 生成pdf中间文件存放位置
  xdoFilePath: D:/deleteme/xdo.cfg                # 自动生成的配置文件存放位置
  fontFolderPath: D:/deleteme/font                # 字体文件存放位置
```



## 拷贝文件

src/main/java/com/thd/bi/template目录下的rtf模板放到上述配置文件中的rtf.rtfTemplateFolderPath目录下

## 创建目录
创建上述配置文件中的目录

## 启动项目
执行 src/main/java/com/thd/bi/BiApplication.java

## 访问

打开浏览器输入 http://127.0.0.1:8899/bi/bi/auditDoc 即可生成pdf

