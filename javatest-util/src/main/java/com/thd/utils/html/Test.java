/** 
 * Class Description:########
 * Date : 2016年9月13日 下午11:15:19
 * Auth : wanglei 
*/  

package com.thd.utils.html;

public class Test {
	public static void main(String[] args){
		String str = MyHtmlUtils.htmlEscape("μΦ 王磊μΦ \"\"</div>","UTF-8");
		System.out.println(str);
		
		String str2 = MyHtmlUtils.htmlEscape("μΦ 王磊μΦ \"\"</div>");
		System.out.println(str2);
		
		String str3 = MyHtmlUtils.htmlUnescape("&lt;div&gt;&mu;&Phi; 王磊&mu;&Phi; &quot;&quot;&lt;/div&gt;");
		System.out.println(str3);
	}
}
