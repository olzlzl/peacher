package kr.moui.manager.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DatabaseManager {
	
	private static DatabaseManager instance;
	SqlSessionFactory sqlSessionFactory;

	public DatabaseManager() {
		String resource = "kr/edenschool/manager/db/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static DatabaseManager getInstance() {
		if(instance == null) {
			instance = new DatabaseManager();
		}
		return instance;
	}
	
	public ManagerInfo selectManagerInfoByUserId(String userId) {
		SqlSession session = sqlSessionFactory.openSession();
		ManagerInfo mi = null;
		try{
			Mapper mapper = session.getMapper(Mapper.class);
			mi = mapper.selectManagerInfoByUserId(userId);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return mi;
	}
	
	public StudentInfo searchStudentInfo(String query) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentInfo si = null;
		try{
			Mapper mapper = session.getMapper(Mapper.class);
			si = mapper.searchStudentInfo("%" + query + "%");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return si;
	}

	public List<StudentInfo> searchStudentInfoList(String query) {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentInfo> siList = null;
		try{
			siList = session.selectList("searchStudentInfo", "%" + query + "%");
			for(StudentInfo i : siList) {
				System.out.println(i.getStudentName());
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return siList;
	}
}
