package com.yy.aiguoguo.controller.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by yyan on 2016/8/3 0003.
 */
public class SharedPreferencesUtil {

	private static Editor saveEditor;
	private static SharedPreferences saveInfo;
	/**
	 * 用户名
	 */
	public String USER_NAME = "user_name";
	/**
	 * 用户密码
	 */
	public String USER_PASSWORD = "user_password";

	public SharedPreferencesUtil(Context context) {
		if (saveInfo == null && context != null) {
			saveInfo = context.getSharedPreferences("cmcc_omp",
					Context.MODE_PRIVATE);
			saveEditor = saveInfo.edit();
		}
	}

	/**
	 * 获取String数据
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		return saveInfo.getString(key, "");
	}

	/**
	 * 保存String数据
	 * @param key
	 * @param value
	 */
	public void saveValue(String key, String value) {
		saveEditor.putString(key, value);
		saveEditor.commit();
	}

	/**
	 * 获取int数据
	 * @param key
	 * @return
	 */
	public int getIntValue(String key) {
		return saveInfo.getInt(key, -1);
	}

	/**
	 * 保存int数据
	 * @param key
	 * @param value
	 */
	public void saveIntValue(String key, int value) {
		saveEditor.putInt(key, value);
		saveEditor.commit();
	}
}
