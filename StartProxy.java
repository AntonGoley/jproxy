package jmproxy;

import java.io.IOException;


public class StartProxy {
	
	public static void main(String[] args) throws IOException{
		
		ProxyControl proxy = new ProxyControl();
		proxy.setPort(6666);
		
		proxy.addIncludedPattern("www\\.lazada\\.vn.*");
		proxy.addExcludedPattern(".*\\.(bmp|css|js|gif|ico|jpe?g|png|swf|woff)");
		
		proxy.setRegexMatch(true);
		
		proxy.startProxy();
		
		
	}
	
	
}
