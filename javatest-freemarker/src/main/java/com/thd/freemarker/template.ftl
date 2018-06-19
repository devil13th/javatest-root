<#--定义变量-->
<#assign doller = "${"> <#-- 创建变量doller-->  
${doller}  --- 定义的特殊字符变量 ,输出${doller}

<#--#是数字-->
输入的文本是：#{no}


<#--$是字符串-->
输入的文本是：${str}

<#--循环的使用-->
<#list a as item> 
	${item_index+1}:${item}

	<#if item_has_next>
		,
	</#if>
</#list>


<#list 1.._x as x> 
	#{x},
</#list>

<#list userList as item> 
	${item_index+1}:${item.name}|${item.sex}

	<#if item_has_next>
		,
	</#if>
</#list>




<#-- 属性 -->
姓名:${user.name}
性别:${user.sex}
<#-- 判断 -->
<#if b>Wow!</#if> 

<#if str=="hello word">${str}</#if>

<#assign age=99>
<#if (age>60)>老年人 
<#elseif (age>40)>中年人 
<#elseif (age>20)>青年人 
<#else> 少年人 
</#if> 

<#-- 截取字符串 -->
${longStr}长度:${longStr?length}
${longStr}截取前三个字符：${longStr?substring(0, 3)}

<#-- 如果字符串的长度大于4 则截取 -->
<#assign test = longStr?length>
<#if (test>4) >
${longStr?substring(0, 4)}...
</#if>

<#-- map类型 -->
${map.a}



