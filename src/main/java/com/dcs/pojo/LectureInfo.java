package com.dcs.pojo;

import com.dcs.util.AttributeBuildExcel;


public class LectureInfo {
	private Integer id;

	private Integer infoId;

	@AttributeBuildExcel(order=1,excelColumName="场次")
	private String play;

	@AttributeBuildExcel(order=2,excelColumName="时间")
	private String time;

	@AttributeBuildExcel(order=3,excelColumName="地点")
	private String place;

	@AttributeBuildExcel(order=4,excelColumName="主题")
	private String object;

	@AttributeBuildExcel(order=5,excelColumName="主讲人")
	private String talker;

	@AttributeBuildExcel(order=6,excelColumName="参加人员")
	private String participants;

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

	public String getPlay() {
		return play;
	}

	public void setPlay(String play) {
		this.play = play == null ? null : play.trim();
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place == null ? null : place.trim();
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object == null ? null : object.trim();
	}

	public String getTalker() {
		return talker;
	}

	public void setTalker(String talker) {
		this.talker = talker == null ? null : talker.trim();
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants == null ? null : participants.trim();
	}

	@Override
	public String toString() {
		return "{play=场次,time=时间,time=级别,place=地点,object=主题"
				+"talker=主讲人,participants=参加人员}";
	}

}