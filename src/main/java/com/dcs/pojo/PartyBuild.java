package com.dcs.pojo;


public class PartyBuild {
	private Integer id;

	private Integer infoId;

	private Integer studentId;

	private String name;

	private String classroom;

	private String sex;

	private String partyBranch;

	private String birthday;

	private String probationaryPartyMemberDate;

	private String regularPartyMemberDate;

	private String nation;

	private String idCard;

	private String numParty;

	private String dataStatus;
	
	private String partyNature;
	
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

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom == null ? null : classroom.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public String getPartyBranch() {
		return partyBranch;
	}

	public void setPartyBranch(String partyBranch) {
		this.partyBranch = partyBranch == null ? null : partyBranch.trim();
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday == null ? null : birthday.trim();
	}

	public String getProbationaryPartyMemberDate() {
		return probationaryPartyMemberDate;
	}

	public void setProbationaryPartyMemberDate(String probationaryPartyMemberDate) {
		this.probationaryPartyMemberDate = probationaryPartyMemberDate;
	}

	public String getRegularPartyMemberDate() {
		return probationaryPartyMemberDate;
	}

	public void setRegularPartyMemberDate(String probationaryPartyMemberDate) {
		this.probationaryPartyMemberDate = probationaryPartyMemberDate;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation == null ? null : nation.trim();
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard == null ? null : idCard.trim();
	}

	public String getNumParty() {
		return numParty;
	}

	public void setNumParty(String numParty) {
		this.numParty = numParty == null ? null : numParty.trim();
	}
	
	public String getPartyNature() {
		return partyNature;
	}

	public void setPartyNature(String partyNature) {
		this.partyNature = partyNature;
	}

	@Override
	public String toString() {
		return "{studentId=学号,name=姓名,classroom=班级,sex=性别,"
				+"partyBranch=党支部,birthday=出生年月,probationaryPartyMemberString=成为预备党员时间,"
				+ "regularPartyMemberDate=转正时间"
				+ ",nation=民族,idCard=身份证号码,numParty=党校期数,partyNature=党员性质}";
	}

}