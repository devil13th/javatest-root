package com.thd.zip.ant;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

public class ZipCompressorByAnt {
	private File zipFile;  
	  
    public ZipCompressorByAnt(String pathName) {  
        zipFile = new File(pathName);  
    }  
    public void compress(String srcPathName) {  
        File srcdir = new File(srcPathName);  
        if (!srcdir.exists()){
        	throw new RuntimeException(srcPathName + "不存在！");  
        }  
        Project prj = new Project();
        Zip zip = new Zip();  
        zip.setEncoding("UTF-8");
        zip.setProject(prj);  
        zip.setDestFile(zipFile);  
        FileSet fileSet = new FileSet();  
        fileSet.setProject(prj);  
        fileSet.setDir(srcdir);  
        zip.addFileset(fileSet);  
        zip.execute();
    }
    
    public static void main(String[] args){
    	
    	ZipCompressorByAnt ant = new ZipCompressorByAnt("D:\\1234.zip");
    	ant.compress("C://apache-tomcat-6.0.35//webapps//EPasApp//tmp//01590-PM-320300-NJ-002//ff808081430911ec0145e004ac7f44af//ae72a721826de55034203760ec3a5cab//download");
    	System.out.println("压缩完成");
    }
    
    
	/**
	 * @param inputFileName
	 *            输入一个文件夹
	 * @param zipFileName
	 *            输出一个压缩文件夹，打包后文件名字
	 * @throws Exception
	 */
	public OutputStream zip(String inputFileName, String zipFileName)throws Exception {
		return zip(zipFileName, new File(inputFileName));
	}

	private OutputStream zip(String zipFileName, File inputFile)throws Exception {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
				zipFileName));
		out.setEncoding("GBK");     // 解决linux乱码 根据linux系统的实际编码设置,可以使用命令
									// vi/etc/sysconfig/i18n 查看linux的系统编码
		zip(out, inputFile, "");
		out.close();
		return out;
	}

	private void zip(ZipOutputStream out, File f, String base)throws Exception {
		if (f.isDirectory()) { // 判断是否为目录
			File[] fl = f.listFiles();
			// out.putNextEntry(new org.apache.tools.zip.ZipEntry(base + "/"));
			// out.putNextEntry(new ZipEntry(base + "/"));
			ZipEntry zipEntry = new ZipEntry(base
					+ System.getProperties().getProperty("file.separator"));
			zipEntry.setUnixMode(755);// 解决linux乱码
			out.putNextEntry(zipEntry);
			// base = base.length() == 0 ? "" : base + "/";
			base = base.length() == 0 ? "" : base
					+ System.getProperties().getProperty("file.separator");
			for (int i = 0; i < fl.length; i++) {
				zip(out, fl[i], base + fl[i].getName());
			}
		} else { // 压缩目录中的所有文件
					// out.putNextEntry(new
					// org.apache.tools.zip.ZipEntry(base));
			ZipEntry zipEntry = new ZipEntry(base);
			zipEntry.setUnixMode(644);// 解决linux乱码
			out.putNextEntry(zipEntry);
			FileInputStream in = new FileInputStream(f);
			byte[] b = new byte[1024 * 5];
            int len;
			while ((len = in.read(b)) != -1) {
				out.write(b,0,len);
			}
			in.close();
		}
	}
}
