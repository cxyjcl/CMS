package com.dcs.service.excel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.dcs.pojo.TeacherReward;

public class mainTest {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		// **************** 测试ExcelCadresInfo *********************
		// ArrayList<CadresInfo> cadresInfoList = new ArrayList<CadresInfo>();
		// CadresInfo cadresInfo = new CadresInfo();
		// cadresInfoList.add(cadresInfo);
		// CadresInfo cadresInfo1 = new CadresInfo();
		// cadresInfoList.add(cadresInfo1);
		// ExcelCadresInfo excelCadresInfo = new ExcelCadresInfo();
		// excelCadresInfo.download(cadresInfoList);

		// **************** 测试ExcelCampusActivities *********************
		// ArrayList<CampusActivities> campusActivitiesList = new
		// ArrayList<CampusActivities>();
		// CampusActivities campusActivities = new CampusActivities();
		// campusActivitiesList.add(campusActivities);
		// ExcelCampusActivities excelCampusActivities = new
		// ExcelCampusActivities();
		// excelCampusActivities.download(campusActivitiesList);

		// **************** 测试ExcelChangeInfo *********************
		// ArrayList<ChangeInfo> changeInfoList = new ArrayList<ChangeInfo>();
		// ChangeInfo changeInfo = new ChangeInfo();
		// changeInfoList.add(changeInfo);
		// ExcelChangeInfo excelChangeInfo = new ExcelChangeInfo();
		// excelChangeInfo.download(changeInfoList);

		// **************** 测试ExcelClassInfo *********************
		// ArrayList<ClassInfo> classInfoList = new ArrayList<ClassInfo>();
		// ClassInfo classInfo = new ClassInfo();
		// classInfoList.add(classInfo);
		// ExcelClassInfo excelClassInfo = new ExcelClassInfo();
		// excelClassInfo.download(classInfoList);

		// **************** 测试ExcelContestInfo *********************
		// ArrayList<ContestInfo> contestInfoList = new
		// ArrayList<ContestInfo>();
		// ContestInfo contestInfo = new ContestInfo();
		// contestInfoList.add(contestInfo);
		// ExcelContestInfo excelContestInfo = new ExcelContestInfo();
		// excelContestInfo.download(contestInfoList);

		// **************** 测试ExcelExamineInfo *********************
		// ArrayList<ExamineInfo> examineInfoList = new
		// ArrayList<ExamineInfo>();
		// ExamineInfo examineInfo = new ExamineInfo();
		// examineInfoList.add(examineInfo);
		// ExcelExamineInfo excelExamineInfo = new ExcelExamineInfo();
		// excelExamineInfo.download(examineInfoList);

		// **************** 测试ExcelGloryInfo *********************
		// ArrayList<GloryInfo> gloryInfoList = new ArrayList<GloryInfo>();
		// GloryInfo gloryInfo = new GloryInfo();
		// gloryInfoList.add(gloryInfo);
		// ExcelGloryInfo excelGloryInfo = new ExcelGloryInfo();
		// excelGloryInfo.download(gloryInfoList);

		// **************** 测试ExcelGradeInfo *********************
		// ArrayList<GradeInfo> gradeInfoList = new ArrayList<GradeInfo>();
		// GradeInfo gradeInfo = new GradeInfo();
		// gradeInfoList.add(gradeInfo);
		// ExcelGradeInfo excelGradeInfo = new ExcelGradeInfo();
		// excelGradeInfo.download(gradeInfoList);

		// **************** 测试ExcelIndividualAchievement *********************
		// ArrayList<IndividualAchievement> individualAchievementList = new
		// ArrayList<IndividualAchievement>();
		// IndividualAchievement individualAchievement = new
		// IndividualAchievement();
		// individualAchievementList.add(individualAchievement);
		// ExcelIndividualAchievement excelIndividualAchievement = new
		// ExcelIndividualAchievement();
		// excelIndividualAchievement.download(individualAchievementList);

		// **************** 测试ExcelLectureInfo *********************
		// ArrayList<LectureInfo> lectureInfoList = new
		// ArrayList<LectureInfo>();
		// LectureInfo lectureInfo = new LectureInfo();
		// lectureInfoList.add(lectureInfo);
		// ExcelLectureInfo excelLectureInfo = new ExcelLectureInfo();
		// excelLectureInfo.download(lectureInfoList);

		// **************** 测试ExcelMoneyInfo *********************
		// ArrayList<MoneyInfo> moneyInfoList = new ArrayList<MoneyInfo>();
		// MoneyInfo moneyInfo = new MoneyInfo();
		// moneyInfoList.add(moneyInfo);
		// ExcelMoneyInfo excelMoneyInfo = new ExcelMoneyInfo();
		// excelMoneyInfo.download(moneyInfoList);

		// **************** 测试ExcelPartyBuild *********************
		// ArrayList<PartyBuild> partyBuildList = new ArrayList<PartyBuild>();
		// PartyBuild partyBuild = new PartyBuild();
		// partyBuildList.add(partyBuild);
		// ExcelPartyBuild excelPartyBuild = new ExcelPartyBuild();
		// excelPartyBuild.download(partyBuildList);

		// **************** 测试ExcelPunishInfo *********************
		// ArrayList<PunishInfo> punishInfoList = new ArrayList<PunishInfo>();
		// PunishInfo punishInfo = new PunishInfo();
		// punishInfoList.add(punishInfo);
		// ExcelPunishInfo excelPunishInfo = new ExcelPunishInfo();
		// excelPunishInfo.download(punishInfoList);

		// **************** 测试ExcelStudentReward *********************
		// ArrayList<StudentReward> studentRewardList = new
		// ArrayList<StudentReward>();
		// StudentReward studentReward = new StudentReward();
		// studentRewardList.add(studentReward);
		// ExcelStudentReward excelStudentReward = new ExcelStudentReward();
		// excelStudentReward.download(studentRewardList);

		// **************** 测试ExcelTeacherInfo *********************
		// ArrayList<TeacherInfo> teacherInfoList = new
		// ArrayList<TeacherInfo>();
		// TeacherInfo teacherInfo = new TeacherInfo();
		// teacherInfoList.add(teacherInfo);
		// ExcelTeacherInfo excelTeacherInfo = new ExcelTeacherInfo();
		// excelTeacherInfo.download(teacherInfoList);

		// **************** 测试ExcelTeacherReward *********************
		ArrayList<TeacherReward> teacherRewardList = new ArrayList<TeacherReward>();
		TeacherReward teacherReward = new TeacherReward();
		teacherRewardList.add(teacherReward);
		ExcelTeacherReward excelTeacherReward = new ExcelTeacherReward();
		excelTeacherReward.download(teacherRewardList);

	}
}
