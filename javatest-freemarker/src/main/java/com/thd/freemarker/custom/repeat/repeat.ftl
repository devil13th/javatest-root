<#assign x = 1>   
  
一个参数：   
<@repeat count=4; >   
  Test ${x}
  <#assign x = x + 1>   
</@repeat>   
  
二个参数：   
<@repeat count=3 hr=true>   
  Test   
</@repeat>
  
循环单个变量：   
<@repeat count=3; cnt>   
  ${cnt}. Test   
</@repeat> 

循环多个变量：   
<@repeat count=bean.age; x,y>   
  ${x}.${y.name}|${y.age}|${y.sex?string}    
</@repeat>

${bean.age}
