package com.hiext.mms.core;

public class ConfigParam {
    /**
     * BASE参数配置为包名中bp后面的模块分类名
     */
	public static final String BASE = "admin";
	/**
	 * BEGINS参数配置为model类名的首字母,必须大写
	 */
	public static final String BEGINS = "";
	// 模板文件 地址
	public static final String TEMPLATE_PATH = "/src/main/resources/template/java";
	//生成dao的目录
	public static final String DAO_PATH = "/src/main/java/com/hiext/mms/" + BASE + "/dao";
	//生成service接口的目录
	public static final String SERVICE_PATH = "/src/main/java/com/hiext/mms/" + BASE + "/service";
	//生成service实现的目录
	public static final String SERVICE_IMPL_PATH = "/src/main/java/com/hiext/mms/" + BASE + "/service/impl";
	//生成拓展实体对象的目录
	public static final String EXTEND_PATH = "/src/main/java/com/hiext/mms/" + BASE + "/model/extend";
	//生成controller的目录
	public static final String CONTROLLER_PATH = "/src/main/java/com/hiext/mms/" + BASE + "/controller";
	//生成model的目录
	public static final String MODEL_PATH = "/src/main/java/com/hiext/mms/" + BASE + "/model";
	//生成服务接口的目录
	public static final String PROVIDER_PATH = "/src/main/java/com/hiext/mms/" + BASE + "/provider";
	//生成服务接口实现的的目录
	public static final String PROVIDER_IMPL_PATH = "/src/main/java/com/hiext/mms/" + BASE + "/provider/impl";

	public static final String DIR = System.getProperty("user.dir") + TEMPLATE_PATH;
	public static final String SERVICE_DIR = System.getProperty("user.dir") + SERVICE_PATH;
	public static final String MODEL_EXTEND_DIR = System.getProperty("user.dir") + EXTEND_PATH;
	public static final String SERVICE_IMPL_DIR = System.getProperty("user.dir") + SERVICE_IMPL_PATH;
	public static final String DAO_DIR = System.getProperty("user.dir") + DAO_PATH;
	public static final String CONTROLLER_DIR = System.getProperty("user.dir") + CONTROLLER_PATH;
	public static final String MODEL_DIR = System.getProperty("user.dir") + MODEL_PATH;
	public static final String PROVIDER_DIR = System.getProperty("user.dir") + PROVIDER_PATH;
	public static final String PROVIDER_IMPL_DIR = System.getProperty("user.dir") + PROVIDER_IMPL_PATH;

}
