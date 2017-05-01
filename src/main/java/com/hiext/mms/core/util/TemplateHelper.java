package com.hiext.mms.core.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class TemplateHelper {
	private Configuration configuration = null;

	@SuppressWarnings("deprecation")
	public TemplateHelper() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
	}

	public void createDoc(String dir, String fileName, String savePath, Map<String, Object> sDate) {

		Template t = null;
		try {
			// 取模板的路径
			configuration.setDirectoryForTemplateLoading(new File(dir));
			// 设置异常处理
			configuration.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
			// 设置木板的路径文件
			t = configuration.getTemplate(fileName);

		} catch (IOException e) {
			e.printStackTrace();
		}
		// 输出文档路径及名称
		File outFile = new File(savePath);
		Writer out = null;
		try {
			// 设置编码格式
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			// 套用模板，替换变量
			t.process(sDate, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
