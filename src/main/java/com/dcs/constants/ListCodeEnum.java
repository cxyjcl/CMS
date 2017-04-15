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
	_PartyBuild("10003", "t_party_build","PartyBuild","年级本学期党建学生名单.xls"),//年级本学期党建学生名单
	_GloryInfo("10004", "t_glory_info","GloryInfo","年级各种荣誉名单.xls"),//年级各种荣誉名单
	_ContestInfo("10005","t_contest_info","ContestInfo","学科竞赛统计表.xls"),//年级各种学科竞赛获奖名单
	_CampusActivities("10006","t_campus_activities","CampusActivities","校园活动获奖名单模板.xls"),//各种校园文化活动获奖名单
	_MoneyInfo("10007","t_money_info","MoneyInfo","年级奖、助学金名单.xls"),//年级奖、助学金名单
	_PunishInfo("10008","t_punish_info","PunishInfo","年级受处分学生名单.xls"),//年级受处分学生名单
	_ChangeInfo("10009","t_change_info","ChangeInfo","年级学籍异动学生名单和原因.xls"),//年级学籍异动学生名单和原因
	_LectureInfo("10010","t_lecture_info","LectureInfo","机械工程学院讲座统计表.xls"),//年级讲座统计表,学院讲座汇总表
	_PlanConclusion("10011","t_word_info","WordInfo",""),//工作计划及总结
	_GraduateDispatch("10012","t_word_info","WordInfo",""),//毕业生派遣方案（毕业年级）
	_IndividualAchievement("10013","t_individual_achievement","IndividualAchievement","个人成果及获奖情况.xls"),//个人成果及获奖情况
	
	//分团委
	_CadresInfo("20001","t_cadres_info","CadresInfo","各组织学生干部名单表模板.xls"),//分团委、学生会、协会人员名单
	_StudentReward("20002","t_studentReward","StudentReward","学生荣誉名单（团委）.xls"),//学生荣誉名单（团委）
	_TotalActivities("20003","t_word_info","WordInfo","");//学期开展活动汇总表及方案
	
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