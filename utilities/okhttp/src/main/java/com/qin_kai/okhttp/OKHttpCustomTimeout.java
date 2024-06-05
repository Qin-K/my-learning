package com.qin_kai.okhttp;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * https://github.com/square/retrofit/issues/2561#issuecomment-345641958
 * @author qinkai
 * @date 2024/3/11
 */
public class OKHttpCustomTimeout {
    public static final String CONNECT_TIMEOUT = "I_CONNECT_TIMEOUT";
    public static final String READ_TIMEOUT = "I_READ_TIMEOUT";
    public static final String WRITE_TIMEOUT = "I_WRITE_TIMEOUT";

    public static OkHttpClient buildClient() {
        Interceptor timeoutInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                int connectTimeout = chain.connectTimeoutMillis();
                int readTimeout = chain.readTimeoutMillis();
                int writeTimeout = chain.writeTimeoutMillis();

                String connectNew = request.header(CONNECT_TIMEOUT);
                String readNew = request.header(READ_TIMEOUT);
                String writeNew = request.header(WRITE_TIMEOUT);

                if (!StringUtils.isEmpty(connectNew)) {
                    connectTimeout = Integer.parseInt(connectNew);
                }
                if (!StringUtils.isEmpty(readNew)) {
                    readTimeout = Integer.parseInt(readNew);
                }
                if (!StringUtils.isEmpty(writeNew)) {
                    writeTimeout = Integer.parseInt(writeNew);
                }

                Request.Builder builder = request.newBuilder();
                builder.removeHeader(CONNECT_TIMEOUT);
                builder.removeHeader(READ_TIMEOUT);
                builder.removeHeader(WRITE_TIMEOUT);
                return chain
                        .withConnectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                        .withReadTimeout(readTimeout, TimeUnit.MILLISECONDS)
                        .withWriteTimeout(writeTimeout, TimeUnit.MILLISECONDS)
                        .proceed(builder.build());
            }
        };
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(timeoutInterceptor)
                .build();
    }


    public static void main(String[] args) throws IOException {
        OkHttpClient client = buildClient();

        long startTime = System.currentTimeMillis();
        Request request = new Request.Builder()
                .url("http://10.10.10.10")
                // .addHeader(CONNECT_TIMEOUT, "200")
                .build();
        try {
            Response response = client.newCall(request).execute();
        } finally {
            System.out.println("cost Time:" + (System.currentTimeMillis() - startTime) + "ms");
        }
    }

}
