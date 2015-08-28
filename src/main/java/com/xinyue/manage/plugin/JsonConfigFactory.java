package com.xinyue.manage.plugin;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * author lzc
 */
public class JsonConfigFactory {
	private static JsonConfig instance = null;

	public static synchronized JsonConfig getInstance() {
		if (instance == null) {
//			System.out.println("初始化");
			instance = new JsonConfig();
			register(instance);
		}
		return instance;
	}

	private static void register(JsonConfig jsonConfig) {
		// 如果double类型为null，想输出null，那就注册double.class
		jsonConfig.registerJsonValueProcessor(Double.class,
				new JsonValueProcessor() {
					// 这个方法不用管
					public Object processArrayValue(Object value,
							JsonConfig arg1) {
						return value;
					}

					// 修改此方法就可以
					public Object processObjectValue(String key, Object value,
							JsonConfig arg2) {
						// 如果vlaue为null，就返回"",不为空就返回他的值，
						if (value == null) {
							return "";
						}
						return value;
					}
				});
		// 地下是注册Integer类型的，详细就不说了，和上面一样，如果有其他类型，就按照此方法在注册
//		jsonConfig.registerJsonValueProcessor(Integer.class,
//				new JsonValueProcessor() {
//					public Object processArrayValue(Object value,
//							JsonConfig arg1) {
//						return value;
//					}
//
//					public Object processObjectValue(String key, Object value,
//							JsonConfig arg2) {
//						if (value == null) {
//							return "";
//						}
//						return value;
//					}
//				});

	}

}
