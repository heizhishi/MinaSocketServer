package com.example.server;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class MyTextLineDecoder implements ProtocolDecoder {

	@Override
	public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		int startPosition = in.position();
		while (in.hasRemaining()) {
			byte b = in.get();
			if (b == '\n') {
				int currentPosition = in.position();
				int limit = in.limit();
				in.position(startPosition);
				in.limit(currentPosition);
				IoBuffer ioBuffer = in.slice();
				byte[] dest = new byte[ioBuffer.limit()];
				ioBuffer.get(dest);
				String str = new String(dest);
				out.write(str);
				in.position(currentPosition);
				in.limit(limit);

			}
		}

	}

	@Override
	public void dispose(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void finishDecode(IoSession arg0, ProtocolDecoderOutput arg1) throws Exception {
		// TODO Auto-generated method stub

	}

}
