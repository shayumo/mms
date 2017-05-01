package com.hiext.mms.core.codegen;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.hiext.mms.core.util.TemplateHelper;


/**
 * 
 * @author larry.liu
 *
 *
 * @date 2016年10月14日
 *
 * @remark (现在已经不使用)通过bp.properties配置文件配置的路径生成service、serviceImpl、model扩展类
 */

public class CodeGenerateDemo {

	private static Properties prop = null;
	static {
		prop = new Properties();
		// 设置properties文件路径,以src为根路径(bp.properties 处于src根目录下)
		InputStream in = CodeGenerateDemo.class.getResourceAsStream("/bp.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			System.out.println("读取配置文件失败----");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
        //普通增删改查
//		String[] arr = { "Apps" };
//	    createFile(arr);
	
		//主细增删改查
//		createFile("Apps", "AppsMenu", "AppId");
//		System.out.println("template.dir="+getValue("template.dir"));
	}

	/**
	 * 根据传入的KEY获取配置文件中对应的值
	 * 
	 * @param key
	 * @return
	 */
	public static String getDir(String key) {
		String value = "";
		value = prop.getProperty("template." + key).trim();
		System.out.println(key + "=" + value);
		return value;
	}
	
	public static String getValue(String key) {
		String value = "";
		value = prop.getProperty(key).trim();
		System.out.println(key + "=" + value);
		return value;
	}

	/*
	 * 按照传入文件名的数组列表创建java文件
	 */

	public static void createFile(String[] arr) {
		TemplateHelper dh = new TemplateHelper();
		for (int i = 0; i < arr.length; i++) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("BeanName", arr[i]);
			dh.createDoc(getDir("dir"), "ServiceTemplate.ftl", getDir("serviceDir") + "/" + arr[i] + "Service.java",
					dataMap);
			dh.createDoc(getDir("dir"), "ServiceImplTemplate.ftl",
					getDir("serviceImplDir") + "/" + arr[i] + "ServiceImpl.java", dataMap);
		
			dh.createDoc(getDir("dir"), "ModelExtendTemplate.ftl",
					getDir("modelExtendDir") + "/B" + arr[i] + "Extend.java", dataMap);

		}
	}

	/*
	 * 按照传入文件名的创建主细形式的java文件
	 */

	public static void createFile(String beanName, String detailName, String foreignKey) {
		TemplateHelper dh = new TemplateHelper();

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("BeanName", beanName);
		dataMap.put("DetailName", detailName);
		dataMap.put("ForeignKey", foreignKey);
		dh.createDoc(getDir("dir"), "DetailServiceTemplate.ftl", getDir("serviceDir") + "/" + beanName + "Service.java",
				dataMap);
		dh.createDoc(getDir("dir"), "DetailServiceImplTemplate.ftl",
				getDir("serviceImplDir") + "/" + beanName + "ServiceImpl.java", dataMap);
		dh.createDoc(getDir("dir"), "ModelDetailExtendTemplate.ftl",
				getDir("modelExtendDir") + "/B" + beanName + "Extend.java", dataMap);

	}

	/*
	 * 按照传入文件名创建java文件
	 */

	public static void createFile(String name) {

		TemplateHelper dh = new TemplateHelper();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("BeanName", name);
		dh.createDoc(getDir("dir"), "ServiceTemplate.ftl", getDir("serviceDir") + "/" + name + "Service.java", dataMap);
		dh.createDoc(getDir("dir"), "ServiceImplTemplate.ftl",
				getDir("serviceImplDir") + "/" + name + "ServiceImpl.java", dataMap);
		// dh.createDoc(getDir("dir"), "DetailServiceTemplate.ftl",
		// getDir("serviceDir") +"/"+ name + "Service.java", dataMap);
		// dh.createDoc(getDir("dir"), "DetailServiceImplTemplate.ftl",
		// getDir("serviceImplDir") +"/" + name + "ServiceImpl.java",
		// dataMap);
		dh.createDoc(getDir("dir"), "ModelExtendTemplate.ftl", getDir("modelExtendDir") + "/B" + name + "Extend.java",
				dataMap);

	}

	/*
	 * 按照文件名循环所有的类
	 */
	public static void loop(File folder, String packageName) throws Exception {
		File[] files = folder.listFiles();
		for (int fileIndex = 0; fileIndex < files.length; fileIndex++) {
			File file = files[fileIndex];
			if (file.isDirectory()) {
				// loop(file, packageName + file.getName() + ".");
				continue;
			} else {
				createAll(file.getName());
			}
		}
	}

	/*
	 * 一次性按照model包生成所有的实现
	 * 
	 */
	public static void createAll(String filename) {
		try {
			String name = filename.substring(0, filename.length() - 5);
			createFile(name);
			System.out.println(name);
		} catch (Exception e) {
			System.out.println("exception = " + e.getLocalizedMessage());
		}
	}

}
