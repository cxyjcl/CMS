package com.dcs.dao;

import com.dcs.pojo.CadresInfo;
import com.dcs.pojo.CampusActivities;
import com.dcs.pojo.ChangeInfo;
import com.dcs.pojo.ClassInfo;
import com.dcs.pojo.ContestInfo;
import com.dcs.pojo.ExamineInfo;
import com.dcs.pojo.GloryInfo;
import com.dcs.pojo.GradeInfo;
import com.dcs.pojo.IndividualAchievement;
import com.dcs.pojo.LectureInfo;
import com.dcs.pojo.MoneyInfo;
import com.dcs.pojo.PartyBuild;
import com.dcs.pojo.PunishInfo;
import com.dcs.pojo.StudentReward;
import com.dcs.pojo.TeacherInfo;
import com.dcs.pojo.TeacherReward;
import com.dcs.pojo.WordInfo;

public interface InsertInfoDao {
	
	void InsertGradeInfo(GradeInfo entity);
	void InsertClassInfo(ClassInfo entity);
	void InsertPartyBuild(PartyBuild entity);
	void InsertGloryInfo(GloryInfo entity);
	void InsertContestInfo(ContestInfo entity);
	void InsertCampusActivities(CampusActivities entity);
	void InsertMoneyInfo(MoneyInfo entity);
	void InsertPunishInfo(PunishInfo entity);
	void InsertChangeInfo(ChangeInfo entity);
	void InsertLectureInfo(LectureInfo entity);
	void InsertWordInfo(WordInfo entity);
	void InsertIndividualAchievement(IndividualAchievement entity);
	void InsertCadresInfo(CadresInfo entity);
	void InsertStudentReward(StudentReward entity);
	void InsertTeacherInfo(TeacherInfo entity);
	void InsertTeacherReward(TeacherReward entity);
	void InsertExamineInfo(ExamineInfo entity);
	
}
