package com.thd.springboot.restfulws.test03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
@RestController
public class FormRestServiceImpl implements FormRestService {
	
	static Map<String,Form> formMap = Collections.synchronizedMap(new HashMap<String,Form>());
	
	static{
		for(int i = 0 , j = 10 ; i < j ; i++){
			Form f = new Form();
			f.setId(""+i);
			f.setName("name_" + i);
			f.setAuthor("author_" + i);
			f.setCustomTemplate("customTemplate_" + i);
			f.setDescription("description_" + i);
			f.setPublishDate("publishDate_" + i);
			f.setTitle("title_" + i);
			f.setUpdateDate("updateDate_" + i);
			
			FormRestServiceImpl.formMap.put(String.valueOf(i),f);
		}
	}
	
	public List<Form> getFormList() {
		return new ArrayList<Form>(formMap.values());
		
	}

}
