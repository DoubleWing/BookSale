package com.example.booksale.webUtils;

import com.example.booksale.model.User;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkHttpUtils {

    private static OkHttpClient okHttpClient;
    //同步处理
    private static OkHttpClient getOkHttpClient() {
        synchronized (OkHttpUtils.class) {
            if (okHttpClient == null) {
                okHttpClient = new OkHttpClient();
            }
        }
        return okHttpClient;
    }

    public static void sendOkHttpRequest(String url, User user, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        //使用Ggon将user对象转为json
        String params = new Gson().toJson(user);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, params);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        client.newCall(request).enqueue(callback);

    }


    //使用Post方式向服务器上提交数据并获取返回提示数据
    public static void sendOkHttpResponse(final String address, final RequestBody requestBody, final okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
//        JSONObject object;
        Request request = new Request.Builder()
                .url(address).post(requestBody).build();
        client.newCall(request).enqueue(callback);
    }














}










































