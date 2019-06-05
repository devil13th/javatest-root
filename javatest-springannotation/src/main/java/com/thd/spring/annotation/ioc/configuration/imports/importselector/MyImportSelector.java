package com.thd.spring.annotation.ioc.configuration.imports.importselector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.thd.spring.annotation.ioc.configuration.imports.importbeandefinitionregistrar.Fruit",
				"com.thd.spring.annotation.ioc.configuration.imports.importbeandefinitionregistrar.Animal",
				"com.thd.spring.annotation.ioc.configuration.imports.importbeandefinitionregistrar.Person"};
	}

}
