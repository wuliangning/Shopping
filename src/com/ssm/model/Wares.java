package com.ssm.model;

public class Wares {

	 private String id;
	 private String wareName;
	 private String wareDate;
	 private String wareWhere;
	 private String wareMoney;
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWareName() {
		return wareName;
	}
	public void setWareName(String wareName) {
		this.wareName = wareName;
	}
	public String getWareDate() {
		return wareDate;
	}
	public void setWareDate(String wareDate) {
		this.wareDate = wareDate;
	}
	public String getWareWhere() {
		return wareWhere;
	}
	public void setWareWhere(String wareWhere) {
		this.wareWhere = wareWhere;
	}
	public String getWareMoney() {
		return wareMoney;
	}
	public void setWareMoney(String wareMoney) {
		this.wareMoney = wareMoney;
	}

	@Override
	public String toString() {
		return "Wares{" +
				"id='" + id + '\'' +
				", wareName='" + wareName + '\'' +
				", wareDate='" + wareDate + '\'' +
				", wareWhere='" + wareWhere + '\'' +
				", wareMoney='" + wareMoney + '\'' +
				'}';
	}
}
