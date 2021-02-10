package asd2;

import py4j.GatewayServer;

public class Gate {
    public static void main(String[] args) {
        var app = new Gate();
        // app is now the gateway.entry_point
        var server = new GatewayServer(app);
        server.start();
    }
}
