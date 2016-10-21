package com.example.server;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class MyFactory implements ProtocolCodecFactory {
	private MyTextLineDecoder myTextLineDecoder;
	private MyTextLineEncoder myTextLineEncoder;
	private MyDecoder myDecoder;

	public MyFactory() {
		myTextLineDecoder = new MyTextLineDecoder();
		myTextLineEncoder = new MyTextLineEncoder();
		myDecoder = new MyDecoder();
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		return myDecoder;
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		return myTextLineEncoder;
	}

}
