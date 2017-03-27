package com.dcs.pojo;

public class GradeInfo {
	private Integer id;

	private String infoId;

	private String classroom;

	private Integer people;

	private Integer male;

	private Integer female;

	private Integer partyMember;

	private Integer activist;

	private String teacher;

	private String monitor;

	private String leagueSecretary;

	private String studiesCommissary;

	private String sportsCommissary;

	private String affairCommissary;

	private String organizationCommissary;

	private String publicityCommissary;

	private String psychologicalCommissary;

	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId == null ? null : infoId.trim();
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom == null ? null : classroom.trim();
	}

	public Integer getPeople() {
		return people;
	}

	public void setPeople(Integer people) {
		this.people = people;
	}

	public Integer getMale() {
		return male;
	}

	public void setMale(Integer male) {
		this.male = male;
	}

	public Integer getFemale() {
		return female;
	}

	public void setFemale(Integer female) {
		this.female = female;
	}

	public Integer getPartyMember() {
		return partyMember;
	}

	public void setPartyMember(Integer partyMember) {
		this.partyMember = partyMember;
	}

	public Integer getActivist() {
		return activist;
	}

	public void setActivist(Integer activist) {
		this.activist = activist;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher == null ? null : teacher.trim();
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor == null ? null : monitor.trim();
	}

	public String getLeagueSecretary() {
		return leagueSecretary;
	}

	public void setLeagueSecretary(String leagueSecretary) {
		this.leagueSecretary = leagueSecretary == null ? null : leagueSecretary.trim();
	}

	public String getStudiesCommissary() {
		return studiesCommissary;
	}

	public void setStudiesCommissary(String studiesCommissary) {
		this.studiesCommissary = studiesCommissary == null ? null : studiesCommissary.trim();
	}

	public String getSportsCommissary() {
		return sportsCommissary;
	}

	public void setSportsCommissary(String sportsCommissary) {
		this.sportsCommissary = sportsCommissary == null ? null : sportsCommissary.trim();
	}

	public String getAffairCommissary() {
		return affairCommissary;
	}

	public void setAffairCommissary(String affairCommissary) {
		this.affairCommissary = affairCommissary == null ? null : affairCommissary.trim();
	}

	public String getOrganizationCommissary() {
		return organizationCommissary;
	}

	public void setOrganizationCommissary(String organizationCommissary) {
		this.organizationCommissary = organizationCommissary == null ? null : organizationCommissary.trim();
	}

	public String getPublicityCommissary() {
		return publicityCommissary;
	}

	public void setPublicityCommissary(String publicityCommissary) {
		this.publicityCommissary = publicityCommissary == null ? null : publicityCommissary.trim();
	}

	public String getPsychologicalCommissary() {
		return psychologicalCommissary;
	}

	public void setPsychologicalCommissary(String psychologicalCommissary) {
		this.psychologicalCommissary = psychologicalCommissary == null ? null : psychologicalCommissary.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	@Override
	public String toString() {
		return "GradeInfo [id=" + id + ", infoId=" + infoId + ", classroom=" + classroom + ", people=" + people
				+ ", male=" + male + ", female=" + female + ", partyMember=" + partyMember + ", activist=" + activist
				+ ", teacher=" + teacher + ", monitor=" + monitor + ", leagueSecretary=" + leagueSecretary
				+ ", studiesCommissary=" + studiesCommissary + ", sportsCommissary=" + sportsCommissary
				+ ", affairCommissary=" + affairCommissary + ", organizationCommissary=" + organizationCommissary
				+ ", publicityCommissary=" + publicityCommissary + ", psychologicalCommissary="
				+ psychologicalCommissary + ", remark=" + remark + "]";
	}

}