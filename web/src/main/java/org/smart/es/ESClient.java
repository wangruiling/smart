package org.smart.es;

import org.elasticsearch.Version;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;

import java.util.concurrent.CountDownLatch;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * @author: wangrl
 * @Date: 2016-03-12 15:49
 */
public class ESClient {
    private static volatile Thread keepAliveThread;
    private static volatile CountDownLatch keepAliveLatch;
    private Node node;
    private Client client;

    public static void main(String[] args) {
        ESClient esClient = new ESClient();
        esClient.init();
        keepAliveLatch = new CountDownLatch(1);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                ESClient.keepAliveLatch.countDown();
            }
        });
        keepAliveThread = new Thread(new Runnable() {
            public void run() {
                try {
                    ESClient.keepAliveLatch.await();
                } catch (InterruptedException var2) {
                    ;
                }

            }
        }, "elasticsearch[keepAlive/" + Version.CURRENT + "]");
        keepAliveThread.setDaemon(false);
        keepAliveThread.start();
    }

    public void init() {
        node = nodeBuilder().clusterName("elasticSearch").client(true).node();
        client = node.client();
    }

    public void destory() {
        closeClient();
        node.close();
    }

    public void closeClient() {
        client.close();
    }
}
