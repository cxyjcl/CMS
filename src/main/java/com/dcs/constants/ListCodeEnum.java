package com.dcs.constants;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * ClassName: InfoCodeEnum
 * @author pohoulong
 * @date 2017年3月25日 下午1:41:25
 */
public enum ListCodeEnum {
	
	//辅导员
	_GradeInfo("10001", "t_grade_info","GradeInfo","年级信息一览表.xls"),//年级信息名单
	_ClassInfo("10002", "t_class_info","ClassInfo","学生班级信息一览表.xls"),//班级信息名单
	_ApplicationMember("10003", "t_application_member","ApplicationMember","积极分子名单.xls"),//积极分子名单
	_GloryInfo("10004", "t_glory_info","GloryInfo","年级各种荣誉名单.xls"),//年级各种荣誉名单
	_ContestInfo("10005","t_contest_info","ContestInfo","学科竞赛统计表.xls"),//年级各种学科竞赛获奖名单
	_CampusActivities("10006","t_campus_activities","CampusActivities","校园活动获奖名单模板.xls"),//各种校园文化活动获奖名单
	_MoneyInfo("10007","t_money_info","MoneyInfo","年级奖、助学金名单.xls"),//年级奖、助学金名单
	_PunishInfo("10008","t_punish_info","PunishInfo","年级受处分学生名单.xls"),//年级受处分学生名单
	_ChangeInfo("10009","t_change_info","ChangeInfo","年级学籍异动学生名单和原因.xls"),//年级学籍异动学生名单和原因
	_LectureInfo("10010","t_lecture_info","LectureInfo","机械工程学院讲座统计表.xls"),//年级讲座统计表,学院讲座汇总表
	_PlanConclusion("10011","t_word_info","WordInfo","工作计划及总结.doc"),//工作计划及总结
	_GraduateDispatch("10012","t_word_info","WordInfo","毕业生派遣方案（毕业年级）.doc"),//毕业生派遣方案（毕业年级）
	_IndividualAchievement("10013","t_individual_achievement","IndividualAchievement","个人成果及获奖情况.xls"),//个人成果及获奖情况
	_PartyLecture("10014", "t_party_lecture","PartyLecture","上党校学生名单.xls"),//上党校学生名单
	_ProbationaryMember("10015", "t_probationary_member","ProbationaryMember","预备党员名单.xls"),//预备党员名单
	_RegularMember("10016", "t_regular_member","RegularMember","正式党员名单.xls"),//正式党员名单
	
	//分团委
	_CadresInfo("20001","t_cadres_info","CadresInfo","各组织学生干部名单表模板.xls"),//分团委、学生会、协会人员名单
	_StudentReward("20002","t_student_reward","StudentReward","学生荣誉名单（团委）.xls"),//学生荣誉名单（团委）
	_TotalActivities("20003","t_activities","Activities","学期开展活动汇总表及方案.xls"),//学期开展活动汇总表及方案
	
	//学工办
	_StudentInfo("30001","t_word_info","WordInfo","学期学生信息一览表.doc"),//学期学生信息一览表
	_PartyBuildFile("30002","t_word_info","WordInfo","党建发文文件.doc"),//党建发文文件
	_StudentWorkFile("30003","t_word_info","WordInfo","学生工作文件.doc"),//学生工作文件
	_PartyStudentFile("30004","t_word_info","WordInfo","本学期党员转正、预备党员、积极分子、上党校学生汇总名单.doc"),//本学期党员XXX汇总名单
	_MoneyFile("30005","t_word_info","WordInfo","各类奖助学金汇总名单.doc"),//各类奖助学金汇总名单
	_CHANGEFile("30006","t_word_info","WordInfo","年度学生学籍异动情况汇总.doc"),//年度学生学籍异动情况汇总
	_StudentRewardFile("30007","t_word_info","WordInfo","学生表彰名单.doc"),//学生表彰名单
	_TeacherRewardFile("30008","t_word_info","WordInfo","教师表彰名单.doc"),//教师表彰名单
	_JOBFILE("30009","t_word_info","WordInfo","学期值班表.doc"),//学期值班表
	_TESTFile("30010","t_word_info","WordInfo","年度辅导员、班主任测评汇总表.doc"),//年度辅导员、班主任测评汇总表
	_EMPLOYMENTQUALITY("30011","t_word_info","WordInfo","就业质量年度报告.doc"),//就业质量年度报告
	_LectureInfoFile("30012","t_word_info","WordInfo",""),//学院讲座汇总表
	_WORKPLAN("30013","t_word_info","WordInfo","工作计划及总结.doc"),//工作计划及总结
	_newsFile("30014","t_word_info","WordInfo","新闻上传情况.doc"),//新闻上传情况
	_IndividualAchievementFile("30015","t_word_info","WordInfo","个人成果及获奖情况.doc");//个人成果及获奖情况
	
	private final String code;
	private final String value;
	private String instance;
	private String excelName;
	
	ListCodeEnum(String code, String v , String instance,String excelName) {
		this.code = code;
		value = v;
		this.instance = instance;
		this.excelName = excelName;
	}
	
	

	public String getInstance() {
		return instance;
	}



	public void setInstance(String instance) {
		this.instance = instance;
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
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	

	public String getExcelName() {
		return excelName;
	}



	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}



	public static ListCodeEnum fromCode(String code) {
		for (ListCodeEnum c : ListCodeEnum.values()) {
			if (StringUtils.equals(c.getCode(), code)) {
				return c;
			}
		}
		throw new IllegalArgumentException(code + "");
	}
}