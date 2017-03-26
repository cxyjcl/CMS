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

public interface UpdateInfoDao {

	void UpdateGradeInfo(GradeInfo entity);
	void UpdateClassInfo(ClassInfo entity);
	void UpdatePartyBuild(PartyBuild entity);
	void UpdateGloryInfo(GloryInfo entity);
	void UpdateContestInfo(ContestInfo entity);
	void UpdateCampusActivities(CampusActivities entity);
	void UpdateMoneyInfo(MoneyInfo entity);
	void UpdatePunishInfo(PunishInfo entity);
	void UpdateChangeInfo(ChangeInfo entity);
	void UpdateLectureInfo(LectureInfo entity);
	void UpdateWordInfo(WordInfo entity);
	void UpdateIndividualAchievement(IndividualAchievement entity);
	void UpdateCadresInfo(CadresInfo entity);
	void UpdateStudentReward(StudentReward entity);
	void UpdateTeacherInfo(TeacherInfo entity);
	void UpdateTeacherReward(TeacherReward entity);
	void UpdateExamineInfo(ExamineInfo entity);
	
}
