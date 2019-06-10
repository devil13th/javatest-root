package com.thd.spring.annotation.ioc.registbean.test02imports.importselector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.thd.spring.annotation.ioc.registbean.test02imports.importbeandefinitionregistrar.Fruit",
				"com.thd.spring.annotation.ioc.registbean.test02imports.importbeandefinitionregistrar.Animal",
				"com.thd.spring.annotation.ioc.registbean.test02imports.importbeandefinitionregistrar.Person"};
	}

}
