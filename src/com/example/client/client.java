package com.example.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.example.server.MyHandle;

public class client {
	public static void main(String[] args) throws IOException {
		NioSocketConnector connector = new NioSocketConnector();
		connector.setHandler(new MyclientHandle());
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));
		ConnectFuture future = connector.connect(new InetSocketAddress("127.0.0.1", 9898));
		future.awaitUninterruptibly();
		IoSession ioSession = future.getSession();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		while (!(str = bufferedReader.readLine()).equals("bye")) {
			ioSession.write(str);
		}

	}

}
