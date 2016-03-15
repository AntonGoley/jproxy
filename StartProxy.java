package jproxy;

import java.io.IOException;


/**
 * Commandline proxy for recording HTTP(S) trafic. 
 * Must be restarted before each recording session. 
 */

public class StartProxy {
	
	public static void main(String[] args) throws IOException{
		
		int port = 6666;
		String patternInclude = "www\\.lazada\\.com\\.ph.*";
		String patternExclude = ".*\\.(bmp|css|js|gif|ico|jpe?g|png|swf|woff)";
		//String patternExclude = ".*\\.(bmp|css|gif|ico|jpe?g|png|swf|woff)";
		String sessionDir = "ph_desktop";
		
		// TODO: add command line parser
		
		if (args.length == 0 ) {
			System.out.println("Usage: jproxy.jar [session dir name] [port] [filter include pattern] [filter exclude pattern]");
			
		}
		
		if (args.length == 1){
			sessionDir = args[0];
		}
		
		if (args.length > 1){
			sessionDir = args[0];
			try {
				port = Integer.valueOf(args[1]);
			} catch (NumberFormatException e){
				System.out.println("Failed to parse port value");
				return;
			}
			
			if (args.length > 2){
				patternInclude = args[2];
			}
			

			if (args.length > 3){
				patternInclude = args[2];
			}
		}
		
		
		ProxyControl proxy = new ProxyControl();
		ProxyControl.setSessionDir(sessionDir);

		proxy.setPort(port);
		
		proxy.addIncludedPattern(patternInclude);
		proxy.addExcludedPattern(patternExclude);
		
		proxy.setRegexMatch(true);
		
		proxy.startProxy();
		
		
	}
	
	
}
