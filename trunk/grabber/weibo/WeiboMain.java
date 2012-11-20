package grabber.weibo;


import java.io.IOException;

import sdk.weibo4j.model.WeiboException;

public class WeiboMain implements Runnable {
	final int userAccountLimit=4;
	public void run()
	{
		WeiboDataBase wbdb=new WeiboDataBase();
		for(int i=0;i<userAccountLimit;i++)
		{
			WeiboLogin wblg=new WeiboLogin();
			try {
				wblg.weiboLogin();
			} catch (WeiboException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new WeiboCrawl(wblg.getAccesstoken(),"Thread No."+String.valueOf(i),wbdb,wblg.getUid()).run();
		}
	}
	public static void main(String []args)
	{
		new WeiboMain().run();
	}
}
