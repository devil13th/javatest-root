package com.thd.freemarker.custom.repeat;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.SimpleNumber;
import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateNumberModel;

/**
 * FreeMarker 自定义标签实现重复输出内容体。
 * 
 * 
 * 参数: count: 重复的次数，必须的且非负整数。 hr: 设置是否输出HTML标签 "hr" 元素. Boolean. 可选的默认为fals.
 * 
 * 
 * 循环变量: 只有一个，可选的. 从1开始。
 * 
 * 
 */

public class RepeatDirective implements TemplateDirectiveModel {
	
	//定义2个标签属性
	
	private static final String PARAM_NAME_COUNT = "count";   
	private static final String PARAM_NAME_HR = "hr";   

	/**
	 * @param env
	 * @param params:标签中属性与属性值
	 * @param loopVars : 标签中自定义变量
	 * @param body
	 */
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {

		// --------------------------------------------- 处理参数
		// ---------------------------------------------
		int countParam = 0;
		boolean countParamSet = false;
		boolean hrParam = false;
		
		System.out.println("=================== 开始  =========================");
		//===================  属性验证开始  ============================//
		// 迭代标签的参数
		Iterator paramIter = params.entrySet().iterator();
		
		//验证标签参数
		while (paramIter.hasNext()) {
			Map.Entry ent = (Map.Entry) paramIter.next();
			String paramName = (String) ent.getKey();
			System.out.println("验证属性：" + paramName);
			TemplateModel paramValue = (TemplateModel) ent.getValue();
			
			//如果属性是"count"
			if (paramName.equals(PARAM_NAME_COUNT)) {
				//如果属性的值不是TemplateNumberModel(数值类型)的实例化对象
				if (!(paramValue instanceof TemplateNumberModel)) {
					throw new TemplateModelException("The \"" + PARAM_NAME_HR + "\" parameter " + "must be a number.");
				}
				//类型转换成int
				countParam = ((TemplateNumberModel) paramValue).getAsNumber().intValue();
				countParamSet = true;
				//如果属性值<0
				if (countParam < 0) {
					throw new TemplateModelException("The \"" + PARAM_NAME_HR+ "\" parameter " + "can't be negative.");
				}
			//如果属性是"hr"
			} else if (paramName.equals(PARAM_NAME_HR)) {
				//如果属性值不是TemplateBooleanModel(boolean类型)的实例化对象
				if (!(paramValue instanceof TemplateBooleanModel)) {
					throw new TemplateModelException("The \"" + PARAM_NAME_HR+ "\" parameter " + "must be a boolean.");
				}
				//类型转换成boolean
				hrParam = ((TemplateBooleanModel) paramValue).getAsBoolean();
			} else {
				throw new TemplateModelException("Unsupported parameter: "+ paramName);
			}
		}
		
		
		if (!countParamSet) {   
			throw new TemplateModelException("The required \""     + PARAM_NAME_COUNT + "\" paramter" + "is missing.");   
		}   
		
		
		/**
		 * <@repeat count=3; x,y>   
		 *	  ${x}.${y}  
		 *	</@repeat> 
		 */
		//循环参数不能超过2个 上面例子中的x和y
		if (loopVars.length > 2) {
			throw new TemplateModelException("At most one loop variable is allowed.");   
		}  
		System.out.println("loopVars:" + loopVars.length);
		//===================  属性验证结束  ============================//
		
		
		
		//===================  真正开始处理输出内容
		Writer out = env.getOut();   
		if (body != null) {   
			for (int i = 0; i < countParam; i++) {   
				// 输出  <hr> 如果 参数hr 设置为true   
				if (hrParam && i != 0) {   
						out.write("<hr>");
				}   
				// 设置循环变量  
				if (loopVars.length == 1) {   
						loopVars[0] = new SimpleNumber(i + 1);   
				}
				
				if (loopVars.length == 2) {   
					RepeatBean rb = new RepeatBean();
					rb.setAge(i);
					rb.setName("name_" + i);
					rb.setSex(true);
					loopVars[0] = new BeansWrapper().wrap(i + 1 + "_x");
					loopVars[1] = new BeansWrapper().wrap(rb);
				} 
				
				
				// 执行标签内容(same as <#nested> in FTL). 
				body.render(env.getOut());   
			}   
		}  

	}

}
