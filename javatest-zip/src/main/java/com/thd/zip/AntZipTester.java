package com.thd.zip;

import java.io.File;

import junit.framework.TestCase;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;
import org.junit.Test;

public class AntZipTester extends TestCase {
	@Test
	public void test01() {
		
		String srcPathName = "E://test";
		String sourcePath = "E://a.zip";
		
		File zipFile = new File(sourcePath);
		
		File srcdir = new File(srcPathName);
		if (!srcdir.exists()){
			throw new RuntimeException(srcPathName + "不存在！");
		}
		Project prj = new Project();
		Zip zip = new Zip();
		zip.setProject(prj);
		zip.setDestFile(zipFile);
		FileSet fileSet = new FileSet();
		fileSet.setProject(prj);
		fileSet.setDir(srcdir);
		// fileSet.setIncludes("**/*.java"); 包括哪些文件或文件夹
		// eg:zip.setIncludes("*.java");
		// fileSet.setExcludes(...); 排除哪些文件或文件夹
		zip.addFileset(fileSet);

		zip.execute();

	}
}
