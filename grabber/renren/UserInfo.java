/**
 * 
 */
package grabber.renren;

import sdk.renren.api.client.param.Auth;
import grabber.UserInfoProvider;

/**
 * @author zmy
 *
 */
public class UserInfo implements UserInfoProvider {

	Auth auth;

	/*
	 * http://wiki.dev.renren.com/wiki/Users.getInfo
	 */
	static final String[] FIELDS = {
		"uid",//表示用户id
		"name",//表示用户名
		"sex",//表示性别，值1表示男性；值0表示女性
		"star",//表示是否为星级用户，值“1”表示“是”；值“0”表示“不是”
		"zidou",//表示是否为vip用户，值1表示是；值0表示不是
		"vip",//表示是否为vip用户等级，前提是zidou节点必须为1
		"birthday",//表示出生时间，格式为：yyyy-mm-dd，需要自行格式化日期显示格式。注：年份60后，实际返回1760-mm-dd；70后，返回1770-mm-dd；80后，返回1780-mm-dd；90后，返回1790-mm-dd
		"email_hash",//用户经过验证的email的信息字符串：email通过了connect.registerUsers接口。字符串包含的email经过了crc32和md5的编码
		"tinyurl",//表示头像链接 50*50大小
		"headurl",//表示头像链接 100*100大小
		"mainurl",//表示头像链接 200*200大小
		"hometown_location",//表示家乡信息
		//<country>(子节点)	表示所在国家
		//<province>(子节点)	表示所在省份
		//<city>(子节点)	表示所在城市
		"work_history",
		//<work_info>	表示工作信息
		//<company_name>(子节点)	表示所在公司
		//<description>(子节点)	表示工作描述
		//<start_date>(子节点)	表示入职时间
		//<end_date>(子节点)	离职时间
		"university_history",
		//<university_info>	表示就读大学信息
		//<name>(子节点)	表示大学名
		//<year>(子节点)	表示入学时间
		//<department>(子节点)	表示学院
		"hs_history"
		//<hs_info>	表示就读高中学校信息
		//<name>(子节点)	表示高中学校名
		//<grad_year>(子节点)	表示入学时间
	};
	public String[] getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserInfo(Auth auth) {
		;
	}

}
