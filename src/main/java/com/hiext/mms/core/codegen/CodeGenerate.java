package com.hiext.mms.core.codegen;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.hiext.mms.core.ConfigParam;
import com.hiext.mms.core.util.TemplateHelper;

/**
 * 
 * @author larry.liu
 *
 *
 * @date 2016年10月14日
 *
 * @remark 通过 ConfigParam静态文件配置的路径生成service、serviceImpl、model扩展类
 *         使用前先配置com.hiext.mms.core.common.ConfigParam类中的相关参数
 */

public class CodeGenerate {
	/**
	 * 注意传入的参数为model类名的字符串,首字母需去掉
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 普通增删改查
		 */
		 String[] arr = { "SysMenu", "SysRole","SysRoleMenu","SysUser","SysUserRole"};
		 createFile(arr);

		/**
		 * 主细增删改查
		 */
		// createFile("Apps", "AppsMenu", "AppId","app_id");

		/**
		 * 按路径一次性生成
		 */
/*		File root = new File(ConfigParam.MODEL_DIR);
		try {
			loop(root);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/*
	 * 按照传入文件名的数组列表创建java文件
	 */

	public static void createFile(String[] arr) {
		TemplateHelper dh = new TemplateHelper();
		for (int i = 0; i < arr.length; i++) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("BeanName", arr[i]);
			dataMap.put("Base", ConfigParam.BASE);
			dataMap.put("Begins", ConfigParam.BEGINS);
			dh.createDoc(ConfigParam.DIR, "ProviderTemplate.ftl",
					ConfigParam.PROVIDER_DIR + "/" + arr[i] + "Provider.java", dataMap);
			dh.createDoc(ConfigParam.DIR, "ProviderImplTemplate.ftl",
					ConfigParam.PROVIDER_IMPL_DIR + "/" + arr[i] + "ProviderImpl.java", dataMap);

			dh.createDoc(ConfigParam.DIR, "ModelExtendTemplate.ftl",
					ConfigParam.MODEL_EXTEND_DIR + "/" + ConfigParam.BEGINS + arr[i] + "Extend.java", dataMap);
			dh.createDoc(ConfigParam.DIR, "ControllerTemplate.ftl",
					ConfigParam.CONTROLLER_DIR + "/" + arr[i] + "Controller.java", dataMap);

			System.out.println(arr[i] + "创建成功------");

		}
	}

	/*
	 * 按照传入文件名的创建主细形式的java文件
	 */

	public static void createFile(String beanName, String detailName, String beanKey, String foreignKey) {
		TemplateHelper dh = new TemplateHelper();

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("BeanName", beanName);
		dataMap.put("DetailName", detailName);
		dataMap.put("BeanKey", beanKey);
		dataMap.put("ForeignKey", foreignKey);
		dataMap.put("Base", ConfigParam.BASE);
		dataMap.put("Begins", ConfigParam.BEGINS);
		dh.createDoc(ConfigParam.DIR, "DetailServiceTemplate.ftl",
				ConfigParam.SERVICE_DIR + "/" + beanName + "Service.java", dataMap);
		dh.createDoc(ConfigParam.DIR, "DetailServiceImplTemplate.ftl",
				ConfigParam.SERVICE_IMPL_DIR + "/" + beanName + "ServiceImpl.java", dataMap);
		/*dh.createDoc(ConfigParam.DIR, "ModelDetailExtendTemplate.ftl",
				ConfigParam.MODEL_EXTEND_DIR + "/" + ConfigParam.BEGINS + beanName + "Extend.java", dataMap);
		dh.createDoc(ConfigParam.DIR, "ControllerTemplate.ftl",
				ConfigParam.CONTROLLER_DIR + "/" + beanName + "Controller.java", dataMap);*/

		System.out.println(beanName + "创建成功------");
	}

	/*
	 * 按照传入文件名创建java文件
	 */

	public static void createFile(String name) {

		TemplateHelper dh = new TemplateHelper();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("BeanName", name);
		dataMap.put("Base", ConfigParam.BASE);
		dataMap.put("Begins", ConfigParam.BEGINS);
		dh.createDoc(ConfigParam.DIR, "ProviderTemplate.ftl", ConfigParam.PROVIDER_DIR + "/" + name + "Provider.java",
				dataMap);
		dh.createDoc(ConfigParam.DIR, "ProviderImplTemplate.ftl",
				ConfigParam.PROVIDER_IMPL_DIR + "/" + name + "ProviderImpl.java", dataMap);

		dh.createDoc(ConfigParam.DIR, "ModelExtendTemplate.ftl",
				ConfigParam.MODEL_EXTEND_DIR + "/" + ConfigParam.BEGINS + name + "Extend.java", dataMap);
		dh.createDoc(ConfigParam.DIR, "ControllerTemplate.ftl",
				ConfigParam.CONTROLLER_DIR + "/" + name + "Controller.java", dataMap);

		System.out.println(name + "创建成功------");
	}

	/*
	 * 按照文件名循环所有的类
	 */
	public static void loop(File folder) throws Exception {
		File[] files = folder.listFiles();
		for (int fileIndex = 0; fileIndex < files.length; fileIndex++) {
			File file = files[fileIndex];
			if (file.isDirectory()) {
				// loop(file, packageName + file.getName() + ".");
				continue;
			} else {
				if (!file.getName().equals("package-info.java")) {
					createAll(file.getName());
				}

			}
		}
	}

	/*
	 * 一次性按照model包生成所有的实现
	 * 
	 */
	public static void createAll(String filename) {
		try {
			String name = filename.substring(0, filename.length() - 5).substring(1);
			createFile(name);
			System.out.println(name);
		} catch (Exception e) {
			System.out.println("exception = " + e.getLocalizedMessage());
		}
	}

}
