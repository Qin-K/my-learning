package com.qin_kai.githubsizemonitor.util;

import okhttp3.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 基于okhttp3的http访问工具
 *
 * @author qinkai
 * @date 2020/11/25
 */
public class OkHttpUtil {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * 超时时间等参数设置
     */
    private static final int CONNECT_TIMEOUT = 60;
    private static final int READ_TIMEOUT = 100;
    private static final int WRITE_TIMEOUT = 60;

    /**
     * HTTP实例
     */
    private static OkHttpClient client;

    static {
        initHttpClient();
    }

    /**
     * 初始化HTTP客户端
     */
    private static void initHttpClient() {
        // 进行数据初始化
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                // 设置读取超时时间
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                // 设置写的超时时间
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                // 设置连接超时时间
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                // 使用连接池
                .connectionPool(pool());
        client = builder.build();
    }

    /**
     * 使用连接池，复用HTTP/HTTPS连接
     */
    private static ConnectionPool pool() {
        return new ConnectionPool(100, 5, TimeUnit.MINUTES);
    }

    /**
     * 发送POST请求，请求体使用json格式
     */
    public static String post(String url, String json) throws Exception {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new RuntimeException("http请求失败,url=" + url + " code=" + response.code());
            }
        }
    }

    /**
     * 发送POST请求，请求体使用json格式，添加请求头
     */
    public static String post(String url, String json, Map<String, String> headers) throws Exception {
        RequestBody body = RequestBody.create(JSON, json);
        Request.Builder builder = new Request.Builder();
        // 添加请求头
        if (headers != null) {
            headers.forEach(builder::addHeader);
        }
        Request request = builder.url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new RuntimeException("http请求失败,url=" + url + " code=" + response.code());
            }
        }
    }

    /**
     * 发送get请求
     */
    public static String get(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new RuntimeException("http请求失败,url=" + url + " code=" + response.code());
            }
        }
    }


    /**
     * 发送get请求，并且添加请求参数
     */
    public static String get(String url, Map<String, String> params) throws Exception {
        HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
        // 构造请求的queryString
        if (params != null) {
            params.forEach(httpBuilder::addQueryParameter);
        }
        Request request = new Request.Builder()
                .url(httpBuilder.build())
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new RuntimeException("http请求失败,url=" + url + "参数params=" + params + " code=" + response.code());
            }
        }
    }


}