package com.dcs.pojo;

import com.dcs.util.AttributeBuildExcel;


public class IndividualAchievement {
	private Integer id;

	private Integer infoId;

	@AttributeBuildExcel(order=1,excelColumName="成果")
	private String achievement;

	@AttributeBuildExcel(order=2,excelColumName="获奖情况")
	private String reward;

	@AttributeBuildExcel(order=3,excelColumName="获奖时间")
	private String rewardTime;

	@AttributeBuildExcel(order=4,excelColumName="备注")
	private String remark;

	private String dataStatus;
	
	public String getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement == null ? null : achievement.trim();
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward == null ? null : reward.trim();
	}

	public String getRewardTime() {
		return rewardTime;
	}

	public void setRewardTime(String rewardTime) {
		this.rewardTime = rewardTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	@Override
	public String toString() {
		return "{achievement=成果,reward=获奖情况,rewardTime=获奖时间,remark=备注}";
	}

}