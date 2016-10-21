package com.example.server;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaServer {

	public static void main(String[] args) {
		try {
			NioSocketAcceptor acceptor = new NioSocketAcceptor();
			acceptor.setHandler(new MyHandle());
			acceptor.getFilterChain().addLast("Codec", new ProtocolCodecFilter(new MyFactory()));
			acceptor.bind(new InetSocketAddress(9898));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
