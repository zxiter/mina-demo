package mina.demo.client;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class MyClient
{

	public static void main(String[] args)
	{
		IoConnector connector = new NioSocketConnector();
		connector.setConnectTimeoutMillis(30000);

		connector.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"),
						LineDelimiter.WINDOWS.getValue(), LineDelimiter.WINDOWS.getValue())));

		connector.setHandler(new ClientIoHandler("你好！/r\'/n\' 大家好！"));
		ConnectFuture future = connector.connect(new InetSocketAddress("localhost", 9123));
		future.addListener(new IoFutureListener<IoFuture>()
		{

			@Override
			public void operationComplete(IoFuture future)
			{
				IoSession ioSession = future.getSession();

				while (true)
				{
					ioSession.write("sdf");

				}
				/*System.out.println("time" + ioSession.getLastWriterIdleTime());
				System.out.println("-------------");*/
			}
		});

		System.out.println("+++++++++++");
	}
}
