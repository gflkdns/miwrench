package com.miqt.miwrenchlib;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;


public class MAppUtils {
    /**
     * 使用系统浏览器的下载功能下载Apk并且更新
     * @param context
     * @param url
     */
    public static void downLoadApkFromSystem(Context context, String url) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(url);
        intent.setData(content_url);
        context.startActivity(intent);
    }
}
