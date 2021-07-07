package com.qin_kai.couchbase.hello;

import com.couchbase.client.CouchbaseClient;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qinkai
 * @date 2021/7/7
 */
public class Main {

    public static void main(String[] args) throws Exception {
        List<URI> uris = new ArrayList<URI>();
        uris.add(URI.create("https://10.228.131.2:8091"));
        CouchbaseClient couchbaseClient = new CouchbaseClient(uris, "default", "");
//        couchbaseClient.add("test", "test").get();
//        Boolean test = couchbaseClient.add("test", "{\"test\":\"test\"}").get();
        Boolean setResult = couchbaseClient.set("test","{\"test\":\"test\"}").get();
        System.out.println(setResult);
    }

}
