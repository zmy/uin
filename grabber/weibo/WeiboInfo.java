package grabber.weibo;


import java.lang.reflect.Field;
import java.util.Date;

import sdk.weibo4j.model.Status;
import sdk.weibo4j.model.User;

public class WeiboInfo {
	private String id;                      //用户UID
	private String screenName;            //微博昵称
	private String name;                  //友好显示名称，如Bill Gates,名称中间的空格正常显示(此特性暂不支持)
	private String province;                 //省份编码（参考省份编码表）
	private String city;                     //城市编码（参考城市编码表）
	private String location;              //地址
	private String description;           //个人描述
	private String url;                   //用户博客地址
	private String profileImageUrl;       //自定义图像
	private String userDomain;            //用户个性化URL
	private String gender;                //性别,m--男，f--女,n--未知
	private String followersCount;           //粉丝数
	private String friendsCount;             //关注数
	private String statusesCount;            //微博数
	private String favouritesCount;          //收藏数
	private String createdAt;               //创建时间
	private String following;            //保留字段,是否已关注(此特性暂不支持)
	private String verified;             //加V标示，是否微博认证用户
	private String verifiedType;             //认证类型
	private String allowAllActMsg;       //是否允许所有人给我发私信
	private String allowAllComment;      //是否允许所有人对我的微博进行评论
	private String followMe;             //此用户是否关注我
	private String avatarLarge;           //大头像地址
	private String onlineStatus;             //用户在线状态
//	private Status status = null;         //用户最新一条微博
	private String biFollowersCount;         //互粉数
	private String remark;                //备注信息，在查询用户关系时提供此字段。
	private String lang;                  //用户语言版本
	private String verifiedReason;		  //认证原因
	private String weihao;				  //微號
	//private String statusId;
	public WeiboInfo(User u)
	{
		this.id=u.getId();
		this.screenName=u.getScreenName();
		this.name=u.getName();
		this.province=String.valueOf(u.getProvince());
		this.city=String.valueOf(u.getCity());
		this.location=u.getLocation();
		this.description=u.getDescription();
		this.url=u.getUrl();
		this.profileImageUrl=u.getProfileImageUrl();
		this.userDomain=u.getUserDomain();
		this.gender=u.getGender();
		this.followersCount=String.valueOf(u.getFollowersCount());
		this.friendsCount=String.valueOf(u.getFriendsCount());
		this.statusesCount=String.valueOf(u.getFavouritesCount());
		this.createdAt=String.valueOf(u.getCreatedAt());
		this.following=String.valueOf(u.isFollowing());
		this.verified=String.valueOf(u.getverifiedType());
		this.verifiedType=String.valueOf(u.getverifiedType());
		this.allowAllActMsg=String.valueOf(u.isallowAllActMsg());
		this.allowAllComment=String.valueOf(u.isallowAllComment());
		this.followMe=String.valueOf(u.isFollowMe());
		this.avatarLarge=String.valueOf(u.getAvatarLarge());
		this.onlineStatus=String.valueOf(u.getonlineStatus());
		this.biFollowersCount=String.valueOf(u.getbiFollowersCount());
		this.remark=u.getRemark();
		this.lang=u.getLang();
		this.verifiedReason=u.getVerifiedReason();
		this.weihao=u.getWeihao();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getProfileImageUrl() {
		return profileImageUrl;
	}
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
	public String getUserDomain() {
		return userDomain;
	}
	public void setUserDomain(String userDomain) {
		this.userDomain = userDomain;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFollowersCount() {
		return followersCount;
	}
	public void setFollowersCount(String followersCount) {
		this.followersCount = followersCount;
	}
	public String getFriendsCount() {
		return friendsCount;
	}
	public void setFriendsCount(String friendsCount) {
		this.friendsCount = friendsCount;
	}
	public String getStatusesCount() {
		return statusesCount;
	}
	public void setStatusesCount(String statusesCount) {
		this.statusesCount = statusesCount;
	}
	public String getFavouritesCount() {
		return favouritesCount;
	}
	public void setFavouritesCount(String favouritesCount) {
		this.favouritesCount = favouritesCount;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getFollowing() {
		return following;
	}
	public void setFollowing(String following) {
		this.following = following;
	}
	public String getVerified() {
		return verified;
	}
	public void setVerified(String verified) {
		this.verified = verified;
	}
	public String getVerifiedType() {
		return verifiedType;
	}
	public void setVerifiedType(String verifiedType) {
		this.verifiedType = verifiedType;
	}
	public String getAllowAllActMsg() {
		return allowAllActMsg;
	}
	public void setAllowAllActMsg(String allowAllActMsg) {
		this.allowAllActMsg = allowAllActMsg;
	}
	public String getAllowAllComment() {
		return allowAllComment;
	}
	public void setAllowAllComment(String allowAllComment) {
		this.allowAllComment = allowAllComment;
	}
	public String getFollowMe() {
		return followMe;
	}
	public void setFollowMe(String followMe) {
		this.followMe = followMe;
	}
	public String getAvatarLarge() {
		return avatarLarge;
	}
	public void setAvatarLarge(String avatarLarge) {
		this.avatarLarge = avatarLarge;
	}
	public String getOnlineStatus() {
		return onlineStatus;
	}
	public void setOnlineStatus(String onlineStatus) {
		this.onlineStatus = onlineStatus;
	}
	public String getBiFollowersCount() {
		return biFollowersCount;
	}
	public void setBiFollowersCount(String biFollowersCount) {
		this.biFollowersCount = biFollowersCount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getVerifiedReason() {
		return verifiedReason;
	}
	public void setVerifiedReason(String verifiedReason) {
		this.verifiedReason = verifiedReason;
	}
	public String getWeihao() {
		return weihao;
	}
	public void setWeihao(String weihao) {
		this.weihao = weihao;
	}
	public String toString()
	{
		Field[] fileds=this.getClass().getDeclaredFields();
		String res="";
		for(int i=0;i<fileds.length;i++)
		{
			try{
				res+="\'"+String.valueOf(fileds[i].get(this))+"\'";
				if(i!=fileds.length-1) res+=",";
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return res;
	}
}
