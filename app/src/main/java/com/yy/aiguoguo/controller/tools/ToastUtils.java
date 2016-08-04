package com.yy.aiguoguo.controller.tools;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by yyan on 2016/8/4 0003.
 */
public class ToastUtils {
	private Toast toast;
	private Context context;

	public ToastUtils(Context context) {
		this.context = context;
	}

	/**
	 * 显示提示信息
	 * 
	 * @param str
	 */
	public void showToast(String str) {
		if (toast != null) {
			toast.cancel();
			toast = Toast.makeText(context, str, Toast.LENGTH_SHORT);
			toast.show();
		} else {
			toast = Toast.makeText(context, str, Toast.LENGTH_SHORT);
			toast.show();
		}
	}

	public void cancel() {
		if (toast != null) {
			toast.cancel();
		}
	}
}
