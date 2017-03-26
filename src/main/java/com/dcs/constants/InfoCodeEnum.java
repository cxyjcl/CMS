package com.dcs.constants;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * ClassName: InfoCodeEnum
 * @Description: TODO
 * @author pohoulong
 * @date 2017年3月25日 下午1:41:25
 */
public enum InfoCodeEnum {
	
	//辅导员
	GradeInfo("10001", "GradeInfoServiceImpl.class"),//年级信息名单
	ClassInfo("10002", "ClassInfoServiceImpl.class"),//班级信息名单
	PartyBuild("10003", "PartyBuildServiceImpl.class"),//年级本学期党建学生名单
	GloryInfo("10004", "GloryInfoServiceImpl.class"),//年级各种荣誉名单
	ContestInfo("10005","ContestInfoServiceImpl.class"),//年级各种学科竞赛获奖名单
	CampusActivities("10006","CampusActivitiesServiceImpl.class"),//各种校园文化活动获奖名单
	MoneyInfo("10007","MoneyInfoServiceImpl.class"),//年级奖、助学金名单
	PunishInfo("10008","PunishInfoServiceImpl.class"),//年级受处分学生名单
	ChangeInfo("10009","ChangeInfoServiceImpl.class"),//年级学籍异动学生名单和原因
	LectureInfo("10010","LectureInfoServiceImpl.class"),//年级讲座统计表,学院讲座汇总表
	PlanConclusion("10011","WordInfoServiceImpl.class"),//工作计划及总结
	GraduateDispatch("10012","WordInfoServiceImpl.class"),//毕业生派遣方案（毕业年级）
	IndividualAchievements("10013","IndividualAchievementServiceImpl.class"),//个人成果及获奖情况
	
	//分团委
	CadresInfo("20001","CadresInfoServiceImpl.class"),//分团委、学生会、协会人员名单
	StudentReward("20002","StudentRewardServiceImpl.class"),//学生荣誉名单（团委）
	TotalActivities("20003","WordInfoServiceImpl.class"),//学期开展活动汇总表及方案
	
	//学工办
	TeacherInfo("30001","TeacherInfoServiceImpl.class"),//班主任人员名单
	SendingFile("30002","WordInfoServiceImpl.class"),//本学期发文文件
	TeacherReward("30003","TeacherRewardServiceImpl.class"),//教师表彰名单
	dutyFile("30004","WordInfoServiceImpl.class"),//学期值班表
	ExamineInfo("30005","ExamineInfoServiceImpl.class"),//年度辅导员、班主任测评汇总表
	JobFile("30006","WordInfoServiceImpl.class"),//就业质量年度报告
	ReportUpload("30007","WordInfoServiceImpl.class");//新闻报道上传情况
	
	private String code;
	private final String value;

	InfoCodeEnum(String code, String v) {
		this.code = code;
		value = v;
	}

	public String value() {
		return value;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	public static InfoCodeEnum fromCode(String code) {
		for (InfoCodeEnum c : InfoCodeEnum.values()) {
			if (StringUtils.equals(c.getCode(), code)) {
				return c;
			}
		}
		throw new IllegalArgumentException(code + "");
	}
	
	public static void main(String[] args) {
		InfoCodeEnum c = fromCode("10001");
		System.out.println(c.getValue());
	}
	
}
