package com.qin_kai.grpc;

import com.qin_kai.grpc.protobuf.GreeterGrpc;
import com.qin_kai.grpc.protobuf.HelloReply;
import com.qin_kai.grpc.protobuf.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;

/**
 * @author qinkai
 * @date 2021/7/14
 */
public class HelloWorldClient {

    private final ManagedChannel channel; //一个gRPC信道
    private final GreeterGrpc.GreeterBlockingStub blockingStub;//阻塞/同步 存根

    //初始化信道和存根
    public HelloWorldClient(String host,int port){
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext(true));
    }

    /** Construct client for accessing RouteGuide server using the existing channel. */
    private HelloWorldClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    //客户端方法
    public  void greet(String name){
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response;
        try {
            response = blockingStub.sayHello(request);
        } catch (StatusRuntimeException e) {
            System.out.println("RPC调用失败:"+e.getMessage());
            return;
        }
        System.out.println("服务器返回信息:"+response.getMessage());
    }

    public static void main(String[] args) throws InterruptedException {
        HelloWorldClient client = new HelloWorldClient("127.0.0.1",30051);
        try {
            for(int i=0;i<5;i++){
                client.greet("world:"+i);
            }
        }finally {
            client.shutdown();
        }
    }
}
