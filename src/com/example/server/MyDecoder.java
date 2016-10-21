package com.example.server;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class MyDecoder extends CumulativeProtocolDecoder {

	@Override
	protected boolean doDecode(IoSession arg0, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		// TODO Auto-generated method stub
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
				return true;
			}

		}
		in.position(startPosition);
		return false;
	}

}
