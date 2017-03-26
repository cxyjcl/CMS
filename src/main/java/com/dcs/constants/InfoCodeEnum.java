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
	GradeInfo("10001", "GradeInfo"),//年级信息名单
	ClassInfo("10002", "ClassInfo"),//班级信息名单
	PartyBuild("10003", "PartyBuild"),//年级本学期党建学生名单
	GloryInfo("10004", "GloryInfo"),//年级各种荣誉名单
	ContestInfo("10005","ContestInfo"),//年级各种学科竞赛获奖名单
	CampusActivities("10006","CampusActivities"),//各种校园文化活动获奖名单
	MoneyInfo("10007","MoneyInfo"),//年级奖、助学金名单
	PunishInfo("10008","PunishInfo"),//年级受处分学生名单
	ChangeInfo("10009","ChangeInfo"),//年级学籍异动学生名单和原因
	LectureInfo("10010","LectureInfo"),//年级讲座统计表,学院讲座汇总表
	PlanConclusion("10011","WordInfo"),//工作计划及总结
	GraduateDispatch("10012","WordInfo"),//毕业生派遣方案（毕业年级）
	IndividualAchievement("10013","IndividualAchievement"),//个人成果及获奖情况
	
	//分团委
	CadresInfo("20001","CadresInfo"),//分团委、学生会、协会人员名单
	StudentReward("20002","StudentReward"),//学生荣誉名单（团委）
	TotalActivities("20003","WordInfo"),//学期开展活动汇总表及方案
	
	//学工办
	TeacherInfo("30001","TeacherInfo"),//班主任人员名单
	SendingFile("30002","WordInfo"),//本学期发文文件
	TeacherReward("30003","TeacherReward"),//教师表彰名单
	dutyFile("30004","WordInfo"),//学期值班表
	ExamineInfo("30005","ExamineInfo"),//年度辅导员、班主任测评汇总表
	JobFile("30006","WordInfo"),//就业质量年度报告
	ReportUpload("30007","WordInfo");//新闻报道上传情况
	
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