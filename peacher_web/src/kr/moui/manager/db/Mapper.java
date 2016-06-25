package kr.moui.manager.db;

public interface Mapper {
	ManagerInfo selectManagerInfoByUserId(String userId);
	StudentInfo searchStudentInfo(String query);
}
