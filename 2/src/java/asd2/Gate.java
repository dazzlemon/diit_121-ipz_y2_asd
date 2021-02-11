package asd2;

import py4j.GatewayServer;

/**
 * Input point for Py4J
 */
public class Gate {
    public static void main(String[] args) {
        var app = new Gate();
        var server = new GatewayServer(app);
        server.start();
    }
}
