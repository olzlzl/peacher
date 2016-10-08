package kr.modustudy.db;

import java.util.ArrayList;

public interface Mapper {
	int selectCountTestInfo(TestInfo ti);
	void insertTestInfo(TestInfo ti);
	ArrayList<TestInfo> selectTestInfoList(TestInfo ti);
	ArrayList<TestInfo> selectTestInfoListByGrade(TestInfo ti);
	ArrayList<TestInfo> selectTestInfoListByYear(TestInfo ti);
	ArrayList<TestInfo> selectTestInfoListByGradeAndYear(TestInfo ti);
}
