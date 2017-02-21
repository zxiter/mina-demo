package mina.demo.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientIoHandler extends IoHandlerAdapter
{
	// 这里我们使用的SLF4J作为日志门面，至于为什么在后面说明。   
	private final static Logger log = LoggerFactory.getLogger(ClientIoHandler.class);

	private String values = "";

	public ClientIoHandler(String values)
	{
		this.values = values;
	}

}
