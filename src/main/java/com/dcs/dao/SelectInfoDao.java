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

public interface SelectInfoDao {
	
	void SelectGradeInfo(GradeInfo entity);
	void SelectClassInfo(ClassInfo entity);
	void SelectPartyBuild(PartyBuild entity);
	void SelectGloryInfo(GloryInfo entity);
	void SelectContestInfo(ContestInfo entity);
	void SelectCampusActivities(CampusActivities entity);
	void SelectMoneyInfo(MoneyInfo entity);
	void SelectPunishInfo(PunishInfo entity);
	void SelectChangeInfo(ChangeInfo entity);
	void SelectLectureInfo(LectureInfo entity);
	void SelectWordInfo(WordInfo entity);
	void SelectIndividualAchievement(IndividualAchievement entity);
	void SelectCadresInfo(CadresInfo entity);
	void SelectStudentReward(StudentReward entity);
	void SelectTeacherInfo(TeacherInfo entity);
	void SelectTeacherReward(TeacherReward entity);
	void SelectExamineInfo(ExamineInfo entity);
	
}
