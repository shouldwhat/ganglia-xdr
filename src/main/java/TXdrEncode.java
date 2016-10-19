import java.io.IOException;

import org.acplt.oncrpc.OncRpcException;
import org.acplt.oncrpc.XdrBufferEncodingStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TXdrEncode
{
	public static void main(String[] args)
	{
		try
		{
			new TXdrEncode().test();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void test() throws OncRpcException, IOException
	{
		initialize();
		
		openXdrEncodeStream();
		doXdrEncode();
		closeXdrEncodeStream();
		
		checkEncodedBuffer();
	}

	private void checkEncodedBuffer()
	{
		logger.debug("***** maked buffer = {}", xdr.getXdrData());
		logger.debug("***** maked buffer length = {}", xdr.getXdrLength());
	}

	private void openXdrEncodeStream() throws OncRpcException, IOException
	{
		xdr.beginEncoding(null, 0);
	}

	private void closeXdrEncodeStream() throws OncRpcException, IOException
	{
		xdr.endEncoding();
	}

	private void doXdrEncode() throws OncRpcException, IOException
	{
		MyStruct mystruct = this.createMyStruct();
		
		xdr.xdrEncodeInt(mystruct.getAge());
		xdr.xdrEncodeString(mystruct.getName());
		xdr.xdrEncodeInt(mystruct.getPhone());
	}

	private MyStruct createMyStruct()
	{
		return new MyStruct();
	}

	private void initialize() throws OncRpcException, IOException
	{
		xdr = new XdrBufferEncodingStream(MAX_BUFFER_SIZE);
	}
	
	private XdrBufferEncodingStream xdr = null;
	
	/* *************************************************************************************************************************** */
	private static final int MAX_BUFFER_SIZE = 1024;
	
	private Logger logger = LoggerFactory.getLogger(TXdrEncode.class);
}
