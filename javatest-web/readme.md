[toc]
# eclipse+maven�web��Ŀ

## ǰ��

��maven��������ʲô����ʲô�ô���

��maven�����ǿ��Է���ͳһ�Ľ���jar������jar���汾������������Ŀ�����Լ���ģ�鿪������ع��ܡ�mavenʹ�õúã���Ŀ�����ٶȾͻ�ɱ�����������֮����ĿԽ��Խ������maven�����ơ�

## �������

- Eclipse JavaEE IDE���汾���ţ�Mars.2Release (4.5.2)
- apache-maven-3.3.9
- JDK1.7
- apache-tomcat-7.0.29��

## maven��װ����

��ѹ��apache-maven-3.3.9-bin.tar.gz�����أ���ͼ��ʾ  
![](readmeimgs/01.png)  

### ���û�������(����㲻�����뿪������������Ŀ���˴��Ǳ���)��  
![](readmeimgs/02.png)  

![](readmeimgs/03.png)  

��conf/settings.xml�ļ�����������

#### ���ñ��زֿ�λ��

![](readmeimgs/04.png)  

#### ��������ֿ⾵���
������jar�������ؾ���(�������ð���Ͱ͵ľ��������ٶȳ���)

![](readmeimgs/05.png) 

#### ����maven��ز���

�������һ������maven����ͼ��ʾ:  
![](readmeimgs/06.png) 

Ȼ������UserSettings:
![](readmeimgs/07.png)

������������tomcat  
����˵� File -> new -> other...
�ڵ����Ľ������ҵ�server,��ͼ��ʾ  
![](readmeimgs/21.png)
ѡ��tomcat,�������û������Ҫ����(���add),���úú���Finish,����ͼ
![](readmeimgs/22.png)

������tomcat����ͼ 
![](readmeimgs/23.png)

��server˫��tomcat���Խ�����������
- Publishing : ��Ŀ�������ͣ������޸ĺ󷢲�(Automatically publish when resources change)
- Timeouts �� ��Ŀ������ʱ����
- Ports �� ����˿ں�����

�������þ����ֵ�server.xml��(���Ŀ¼�˵���Servers/Tomcat v... /server.xml)


Ok,���ù����ʹ˽���

## Eclipse+Maven����webapp��Ŀ

1������eclipse���Ҽ�new������other������ͼ�ҵ�maven project
![](readmeimgs/09.png)

2��ѡ��maven project����ʾ����maven��Ŀ�Ĵ��ڣ���ѡ��ͼ��ʾ��Create a simple project���ź����skip archetype selection��ʾ�����Ǽܣ��Ǽܱ�ʾһЩ����ģ�壬�������ǲ�ʹ��ģ����Ӽ򵥡�  
![](readmeimgs/10.png)

3������maven��Ŀ�Ļ�����Ϣ�������web���̣���Packaging������Ҫѡ��war������ͼ��ʾ��  
![](readmeimgs/11.png)

4�����maven��Ŀ�Ĵ�����������Ӧ��maven��Ŀ�����������ʾ��
![](readmeimgs/12.png)  

�������֮����Ŀ�ᱨ����������ΪwebappĿ¼��û��web.xml��������������web�������濽��WEB-INFĿ¼�������ɣ���ɺ���ͼ��  
![](readmeimgs/13.png) 

����������ʧ��

5������������������δ��뵽pom.xml���棬����ȷ����Ŀ��jdk����汾��

```
<build>
   <plugins>
     <plugin>
       <groupId>org.apache.maven.plugins</groupId>
       <artifactId>maven-compiler-plugin</artifactId>
       <version>3.5.1</version>
        <configuration>
         <source>1.7</source>
         <target>1.7</target>
         <encoding>utf-8</encoding>
       </configuration>
     </plugin>
   </plugins>
</build>
```
��ͼ��ʾ��

![](readmeimgs/14.png) 

��ʱ����Ŀ�ֻᱨ������������ɺ���Ҫִ��һ�θ�����Ŀ���õĶ�����ѡ����Ŀ --> �Ҽ� -->Maven --> Update Project��eclipseluna �汾��helios ��indigo �汾ѡ�� Update Project Configuration�����������֮�󣬴�����ʧ��jdk�汾Ҳ���Ĺ����ˣ���ͼ��ʾ��

![](readmeimgs/15.png) 

6����pom.xml�����jar������

�������spring-core,Ӧ����
```
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>3.2.2.RELEASE</version>
</dependency>
```
��֪��д��ô�죿 �ٶ�����maven spring-core repository    Ȼ��ѡ���Աߵİ汾��,��ͼ��ʾ��

![](readmeimgs/16.png) 

���3.2.2���Ϳ���ֱ�Ӹ��Ƴ�����

![](readmeimgs/17.png) 

��¼��spring+springmvc+mybatis���Ͽ�������������

```
<dependencies>

    <!--spring3.2.2 start-->

    <dependency>

    <groupId>org.springframework</groupId>

    <artifactId>spring-core</artifactId>

    <version>3.2.2.RELEASE</version>

    </dependency>

    <dependency>

        <groupId>org.springframework</groupId>

        <artifactId>spring-beans</artifactId>

        <version>3.2.2.RELEASE</version>

    </dependency>

    <dependency>

        <groupId>org.springframework</groupId>

        <artifactId>spring-context</artifactId>

        <version>3.2.2.RELEASE</version>

    </dependency>

    <dependency>

        <groupId>org.springframework</groupId>

        <artifactId>spring-aop</artifactId>

        <version>3.2.2.RELEASE</version>

    </dependency>

    <dependency>

        <groupId>org.springframework</groupId>

        <artifactId>spring-expression</artifactId>

        <version>3.2.2.RELEASE</version>

    </dependency>

    <dependency>

        <groupId>org.springframework</groupId>

        <artifactId>spring-web</artifactId>

        <version>3.2.2.RELEASE</version>

    </dependency>

    <dependency>

        <groupId>org.springframework</groupId>

        <artifactId>spring-webmvc</artifactId>

        <version>3.2.2.RELEASE</version>

    </dependency>

    <dependency>

        <groupId>org.springframework</groupId>

        <artifactId>spring-tx</artifactId>

        <version>3.2.2.RELEASE</version>

    </dependency>

    <dependency>

        <groupId>org.springframework</groupId>

        <artifactId>spring-jdbc</artifactId>

        <version>3.2.2.RELEASE</version>

    </dependency>

    <dependency>

        <groupId>aopalliance</groupId>

        <artifactId>aopalliance</artifactId>

        <version>1.0</version>

    </dependency>

    <dependency>

        <groupId>org.aspectj</groupId>

        <artifactId>aspectjweaver</artifactId>

        <version>1.6.2</version>

    </dependency>

    <!-- spring3.2.2end-->

   

    <!-- ��־��start -->

    <dependency>

        <groupId>org.slf4j</groupId>

        <artifactId>slf4j-api</artifactId>

        <version>1.7.5</version>

    </dependency>

    <dependency>

        <groupId>org.slf4j</groupId>

        <artifactId>slf4j-log4j12</artifactId>

        <version>1.7.5</version>

    </dependency>

    <dependency>

        <groupId>log4j</groupId>

        <artifactId>log4j</artifactId>

        <version>1.2.17</version>

    </dependency>

    <dependency>

        <groupId>commons-logging</groupId>

        <artifactId>commons-logging</artifactId>

        <version>1.1.3</version>

    </dependency>

    <!-- ��־��end -->

   

    <!-- mybatis��ذ� start -->

    <dependency>

        <groupId>org.mybatis</groupId>

        <artifactId>mybatis</artifactId>

        <version>3.2.2</version>

    </dependency>

    <dependency>

        <groupId>org.mybatis</groupId>

        <artifactId>mybatis-spring</artifactId>

        <version>1.2.0</version>

    </dependency>

    <dependency>

        <groupId>asm</groupId>

        <artifactId>asm</artifactId>

        <version>3.3.1</version>

    </dependency>

    <dependency>

        <groupId>cglib</groupId>

        <artifactId>cglib</artifactId>

        <version>2.2.2</version>

    </dependency>

    <!-- mybatis��ذ� end -->

   

    <!-- mysql���������� -->

    <dependency>

        <groupId>mysql</groupId>

        <artifactId>mysql-connector-java</artifactId>

        <version>5.1.26</version>

    </dependency>

    <!-- jstl��ǩ�� -->

    <dependency>

        <groupId>jstl</groupId>

        <artifactId>jstl</artifactId>

        <version>1.2</version>

    </dependency>

    <!-- �ֽ������ -->

    <dependency>

        <groupId>org.javassist</groupId>

        <artifactId>javassist</artifactId>

        <version>3.17.1-GA</version>

    </dependency>

    <!-- ����Ͱ�json������ -->

    <dependency>

        <groupId>com.alibaba</groupId>

        <artifactId>fastjson</artifactId>

        <version>1.1.15</version>

    </dependency>

    <!-- ����Ͱ�druid���ӳ� -->

    <dependency>

        <groupId>com.alibaba</groupId>

        <artifactId>druid</artifactId>

        <version>1.0.9</version>

    </dependency>

    <!-- jsp and servlet start -->

    <dependency>

       <groupId>javax.servlet</groupId>

       <artifactId>servlet-api</artifactId>

       <version>2.5</version>

       <scope>provided</scope>

    </dependency>

    <dependency>

       <groupId>javax.servlet.jsp</groupId>

       <artifactId>jsp-api</artifactId>

       <version>2.1</version>

       <scope>provided</scope>

    </dependency>

    <!--jsp and servlet end -->

  </dependencies>

==============================================================
```

����������ú�maven webapp��Ŀ�����ú��ˡ�

7.��дԴ���뼰�����ļ�����ɺ�ṹ��ͼ��ʾ��
![](readmeimgs/18.png)   
ҳ����������棺
![](readmeimgs/19.png)

�󹦸�ɣ�����������tomcat���У��һ�servers����ѡ��Add and Remove������ͼ��ʾ��
![](readmeimgs/24.png)
  

![](readmeimgs/20.png)

����tomcat��

�����������http://127.0.0.1:8080/[��Ŀ����]�Ϳ��Է�����
��Ŀ���ƿ���ͨ��server.xml�ļ�Context��ǩ��path���Բ鿴
> <Context docBase="javatest-web" path="/javatest-web" reloadable="true" source="org.eclipse.jst.jee.server:javatest-web"/></Host> 


## �Ȳ���

������Ŀ��ʱ������޸�����Ŀ��Դ���룬��������������񣬷ǳ������㣬���Խ���Ŀ�Ȳ�����tomcat�£�˫�������ѡ��Modulesѡ����Խ�������

ѡ����Ŀ -> ���Edit -> �����Ĵ�����ȥ��Auto reloading enabledǰ��Ĺ� (Ҳ���Ըô���������Path(��Ŀ���ʵĸ�Ŀ¼))

![](readmeimgs/25.png)



