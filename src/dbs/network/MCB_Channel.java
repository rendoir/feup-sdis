package DBS.Network;

import DBS.Message.Message;

import java.io.IOException;

public class MCB_Channel extends M_Channel {
    /**
     * Class that connects and listens to a multicast
     *
     * @param address multicast address
     * @param port    multicast port
     * @throws IOException
     */
    public MCB_Channel(String address, int port){
        super(address, port);
    }

    @Override
    protected void handleRequest(Message message){
        System.out.println(message.toString());
    }
}