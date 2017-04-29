package com.dcs.pojo;

public class RegularMember {
    private Integer id;

    private Integer infoId;

    private String code;

    private String partyName;

    private String name;

    private String sex;

    private String nation;

    private String birthday;

    private String idCard;

    private String classroom;

    private String profession;

    private String studentLevel;

    private String probationaryMemberDate;

    private String regularPartyMemberDate;

    private String dataStatus;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName == null ? null : partyName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom == null ? null : classroom.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel == null ? null : studentLevel.trim();
    }

    public String getProbationaryMemberDate() {
        return probationaryMemberDate;
    }

    public void setProbationaryMemberDate(String probationaryMemberDate) {
        this.probationaryMemberDate = probationaryMemberDate == null ? null : probationaryMemberDate.trim();
    }

    public String getRegularPartyMemberDate() {
        return regularPartyMemberDate;
    }

    public void setRegularPartyMemberDate(String regularPartyMemberDate) {
        this.regularPartyMemberDate = regularPartyMemberDate == null ? null : regularPartyMemberDate.trim();
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus == null ? null : dataStatus.trim();
    }
}