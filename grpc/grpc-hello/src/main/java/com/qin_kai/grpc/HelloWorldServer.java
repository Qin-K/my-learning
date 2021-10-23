package com.qin_kai.grpc;

import com.qin_kai.grpc.protobuf.GreeterGrpc;
import com.qin_kai.grpc.protobuf.HelloReply;
import com.qin_kai.grpc.protobuf.HelloRequest;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

/**
 * @author qinkai
 * @date 2021/7/14
 */
public class HelloWorldServer {

    private int port = 50051;
    private Server server;

    /**
     * 启动服务
     * @throws IOException
     */
    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new GreeterImpl())
                .build()
                .start();

        System.out.println("service start...");

        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                HelloWorldServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    // block 一直到退出程序
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        final HelloWorldServer server = new HelloWorldServer();
        server.start();
        server.blockUntilShutdown();
    }


    // 实现 定义一个实现服务接口的类
    private class GreeterImpl extends GreeterGrpc.GreeterImplBase {

        public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
            //获取参数
            System.out.println("收到的信息:"+req.getName());

            //这里可以放置具体业务处理代码 start

            //这里可以放置具体业务处理代码 end

            //构造返回
            HelloReply reply = HelloReply.newBuilder().setMessage(("Hello: " + req.getName())).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}