package com.lxm.demo.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.lxm.demo.beans.Blue;
import com.lxm.demo.beans.Car;

public class MyImportSelector implements ImportSelector{

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{Blue.class.getName(),Car.class.getName()};
	}

}
