package com.dcs.pojo;

public class IndividualAchievements {
    private Integer id;

    private Integer infoId;

    private String project;

    private String contestLevel;

    private String contestName;

    private String contestGrade;

    private String rewarder;

    private String grade;

    private String remark;

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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project == null ? null : project.trim();
    }

    public String getContestLevel() {
        return contestLevel;
    }

    public void setContestLevel(String contestLevel) {
        this.contestLevel = contestLevel == null ? null : contestLevel.trim();
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName == null ? null : contestName.trim();
    }

    public String getContestGrade() {
        return contestGrade;
    }

    public void setContestGrade(String contestGrade) {
        this.contestGrade = contestGrade == null ? null : contestGrade.trim();
    }

    public String getRewarder() {
        return rewarder;
    }

    public void setRewarder(String rewarder) {
        this.rewarder = rewarder == null ? null : rewarder.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}