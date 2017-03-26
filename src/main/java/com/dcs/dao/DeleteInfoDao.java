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

public interface DeleteInfoDao {

	void DeleteGradeInfo(GradeInfo entity);
	void DeleteClassInfo(ClassInfo entity);
	void DeletePartyBuild(PartyBuild entity);
	void DeleteGloryInfo(GloryInfo entity);
	void DeleteContestInfo(ContestInfo entity);
	void DeleteCampusActivities(CampusActivities entity);
	void DeleteMoneyInfo(MoneyInfo entity);
	void DeletePunishInfo(PunishInfo entity);
	void DeleteChangeInfo(ChangeInfo entity);
	void DeleteLectureInfo(LectureInfo entity);
	void DeleteWordInfo(WordInfo entity);
	void DeleteIndividualAchievement(IndividualAchievement entity);
	void DeleteCadresInfo(CadresInfo entity);
	void DeleteStudentReward(StudentReward entity);
	void DeleteTeacherInfo(TeacherInfo entity);
	void DeleteTeacherReward(TeacherReward entity);
	void DeleteExamineInfo(ExamineInfo entity);
	
}
