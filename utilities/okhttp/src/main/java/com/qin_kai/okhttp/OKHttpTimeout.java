package com.qin_kai.okhttp;

import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

/**
 * @author qinkai
 * @date 2024/3/11
 */
public class OKHttpTimeout {

    public static void main(String[] args) throws IOException, InterruptedException, NoSuchAlgorithmException {
        // warmup
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
        } catch (Exception ignored) {
        }

        long startTime = System.currentTimeMillis();
        try {
            // connectTimeout
            // testConnectTimeout();
            // testReadTimeout();
            // testWriteTimeout();
            testCallTimeout();
        } finally {
            System.out.println("test cost time: " + (System.currentTimeMillis() - startTime) + "ms");
        }
    }

    private static void testCallTimeout() throws IOException {
        // 500ms 返回
        //Exception in thread "main" java.io.InterruptedIOException: timeout
        // 	at okhttp3.internal.connection.Transmitter.timeoutExit(Transmitter.java:109)
        // 	at okhttp3.internal.connection.Transmitter.maybeReleaseConnection(Transmitter.java:302)
        // 	at okhttp3.internal.connection.Transmitter.noMoreExchanges(Transmitter.java:267)
        // 	at okhttp3.RealCall.getResponseWithInterceptorChain(RealCall.java:237)
        //Exception in thread "main" java.io.InterruptedIOException: timeout
        // 	at okhttp3.internal.connection.Transmitter.timeoutExit(Transmitter.java:109)
        // 	at okhttp3.internal.connection.Transmitter.maybeReleaseConnection(Transmitter.java:302)
        // 	at okhttp3.internal.connection.Transmitter.noMoreExchanges(Transmitter.java:267)

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.SECONDS)
                .callTimeout(500, TimeUnit.MILLISECONDS)
                .build();
        client.newCall(new Request.Builder().url("http://10.10.10.10").build()).execute();
    }

    private static void testWriteTimeout() throws IOException {
        // 读取的时间，只设置读取时间，还是会等待连接超时（如果地址不能连接总时长就是连接超时）
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build();
        // 2秒左右抛超时异常?
        //Exception in thread "main" java.net.SocketTimeoutException: timeout
        // 	at okio.Okio$4.newTimeoutException(Okio.java:232)
        // 	at okio.AsyncTimeout.exit(AsyncTimeout.java:286)
        // 	at okio.AsyncTimeout$1.write(AsyncTimeout.java:184)
        //Caused by: java.net.SocketException: Socket closed
        // 	at java.net.SocketOutputStream.socketWrite(SocketOutputStream.java:118)
        // 	at java.net.SocketOutputStream.write(SocketOutputStream.java:155)

        // 如果服务端没有读流也会抛异常
        //Exception in thread "main" java.net.SocketException: Connection reset by peer: socket write error
        // 	at java.net.SocketOutputStream.socketWrite0(Native Method)
        // 	at java.net.SocketOutputStream.socketWrite(SocketOutputStream.java:111)\
        //Caused by: java.net.SocketException: Socket operation on nonsocket: configureBlocking
        // 	at java.net.DualStackPlainSocketImpl.configureBlocking(Native Method)

        // 上传文件较大，大于writeTimeout时间，不会抛异常
        Response response = client.newCall(new Request.Builder()
                .post(RequestBody.create(MediaType.parse("video/mp4"), new File("E:\\materials\\v.f30 (1).mp4")))
                .url("http://localhost:42003/writeDelay/10").build()).execute();
    }

    private static void testReadTimeout() throws IOException {
        // 读取的时间，只设置读取时间，还是会等待连接超时（如果地址不能连接总时长就是连接超时）
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(500, TimeUnit.MILLISECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .build();
        // 如果是下载视频，视频很大需要下载的时间超过readTimeout也不会超时
        // Response response = client.newCall(new Request.Builder().url("https://1500000598.vod2.myqcloud.com/6c97873evodcq1500000598/ed9887023270835015148957063/HTZk43ZdaKgA.mp4").build()).execute();
        // byte[] bytes = IOUtils.readFully(response.body().byteStream(), 1024 * 1024 * 1024);

        // 1秒左右抛超时异常
        //Exception in thread "main" java.net.SocketTimeoutException: timeout
        // 	at okio.Okio$4.newTimeoutException(Okio.java:232)
        // 	at okio.AsyncTimeout.exit(AsyncTimeout.java:286)
        // 	at okio.AsyncTimeout$2.read(AsyncTimeout.java:241)
        //Caused by: java.net.SocketTimeoutException: Read timed out
        // 	at java.net.SocketInputStream.socketRead0(Native Method)
        // 	at java.net.SocketInputStream.socketRead(SocketInputStream.java:116)
        client.newCall(new Request.Builder().url("http://localhost:42003/delay/2").build()).execute();
    }

    /**
     * connectTimeout
     * 连接超时时间：建立tcp的时间
     */
    private static void testConnectTimeout() throws IOException {
        // Exception in thread "main" java.net.SocketTimeoutException: connect timed out
        // at java.net.DualStackPlainSocketImpl.waitForConnect(Native Method)
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.MILLISECONDS)
                .build();
        client.newCall(new Request.Builder().url("http://10.10.10.10").build()).execute();
    }

    private static void testDefaultConfig() {
        OkHttpClient client = new OkHttpClient();

        // 默认10s
        //       connectTimeout = 10_000;
        //       readTimeout = 10_000;
        //       writeTimeout = 10_000;
        System.out.println("connectTimeout:" + client.connectTimeoutMillis());
        System.out.println("readTimeout:" + client.readTimeoutMillis());
        System.out.println("writeTimeout:" + client.writeTimeoutMillis());

        // 默认0s无限制
        System.out.println("callTimeout:" + client.callTimeoutMillis());

        //   public ConnectionPool() {
        //     this(5, 5, TimeUnit.MINUTES);
        //   }
        ConnectionPool connectionPool = client.connectionPool();
        System.out.println();
    }


}
