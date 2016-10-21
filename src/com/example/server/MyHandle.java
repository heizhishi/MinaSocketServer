package com.example.server;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class MyHandle extends IoHandlerAdapter {

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(session, cause);
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.inputClosed(session);
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageReceived(session, message);
		String responce = (String) message;
		System.out.println("-----messageReceived-----");
		System.out.println(session.hashCode() + ":" + responce);
		session.write("replyToClient:" + responce);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageSent(session, message);
		System.out.println("-----messageSent-----");
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionClosed(session);
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionCreated(session);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.sessionIdle(session, status);
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionOpened(session);
	}

}
