package grabber.weibo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import sdk.weibo4j.Friendships;
import sdk.weibo4j.Users;
import sdk.weibo4j.model.User;
import sdk.weibo4j.model.UserWapper;
import sdk.weibo4j.model.WeiboException;

public class WeiboCrawl implements Runnable{
	private String accesstoken;
	private String name;
	private WeiboDataBase wbdb;
	private String uid;
	private List<String> mylist;
	private Friendships fm;
	final int limit=100000;
	public WeiboCrawl(String accesstoken,String name,WeiboDataBase wbdb,String uid)
	{
		this.accesstoken=accesstoken;
		this.name=name;
		this.wbdb=wbdb;
		this.uid=uid;
		this.mylist=new LinkedList<String>();
		this.fm=new Friendships();
		fm.setToken(accesstoken);
		init();
	}
	public void sleep(int time)
	{
		try {
			Thread.currentThread().sleep(time);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void init()
	{
		Users um = new Users();
		User user=null;
		um.client.setToken(accesstoken);
		try {
			user = um.showUserById(uid);
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		//wbdb.insert(new WeiboInfo(user));
		mylist.add(uid);
	}
	public UserWapper getFriendsWapper(String uid)throws WeiboException
	{
		UserWapper users=null;
		try {
			users = fm.getFriendsByID(uid);
		} catch (WeiboException e) {
			e.printStackTrace();
			throw e;
		}
		return users;
	}
	public UserWapper getFollowesWapper (String uid) throws WeiboException
	{
		UserWapper users=null;
		try {
			users = fm.getFollowersById(uid);
		} catch (WeiboException e) {
			e.printStackTrace();
			throw e;
		}
		return users;
	}
	public void listAdd(String uid)
	{
		if(mylist.size()>limit)
			return;
		mylist.add(uid);
	}
	public void run()
	{
		Random r=new Random(new Date().getTime());
		while(true)
		{
			int now=(r.nextInt()%mylist.size()+mylist.size())%mylist.size();
			String id=mylist.get(now);
			mylist.remove(now);
			try{
				UserWapper users=getFriendsWapper(uid);
				for(User u : users.getUsers())
				{
				//	wbdb.insert(new WeiboInfo(u));
					System.out.println(new WeiboInfo(u).toString());
					listAdd(u.getId());
				}
				users=getFollowesWapper(uid);
				for(User u:users.getUsers())
				{
				//	wbdb.insert(new WeiboInfo(u));
					listAdd(u.getId());
				}
			}catch(WeiboException e)
			{
				e.printStackTrace();
				System.out.println(name+"出现错误，休息一会儿");
				sleep(1000);
			}
		}
	}
}
