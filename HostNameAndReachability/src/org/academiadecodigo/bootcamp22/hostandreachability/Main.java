package org.academiadecodigo.bootcamp22.hostandreachability;

import java.io.IOException;
import java.net.InetAddress;

public class Main {

    public static void main(String[] args) {

        final String HOST_NAME = "giphy.com";
        final  int TIMEOUT = 10000;

        try {

            InetAddress inetAdress = InetAddress.getByName(HOST_NAME);
            System.out.println("Host name: " + HOST_NAME);
            System.out.println("IP Adress: " + inetAdress.getHostAddress());
            System.out.println("Reachable : " + inetAdress.isReachable(TIMEOUT));
        }catch (IOException e){
            System.err.println(e.getMessage());
        }

    }
}
