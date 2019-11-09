package com.ssm.model;

public class Member {

	    private String id;
	    private String loginName;
	    private String pwd;
	    private String nickName;
	    private int age;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getLoginName() {
			return loginName;
		}
		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getNickName() {
			return nickName;
		}
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}

	@Override
	public String toString() {
		return "Member{" +
				"id='" + id + '\'' +
				", loginName='" + loginName + '\'' +
				", pwd='" + pwd + '\'' +
				", nickName='" + nickName + '\'' +
				", age=" + age +
				'}';
	}
}
