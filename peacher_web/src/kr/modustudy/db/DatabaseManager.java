package kr.modustudy.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DatabaseManager {
	
	private static DatabaseManager instance;
	SqlSessionFactory sqlSessionFactory;

	public DatabaseManager() {
		String resource = "kr/modustudy/db/mybatis-config.xml";
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
	
	public void deleteTestInfo(String testId) {
		SqlSession session = sqlSessionFactory.openSession();
		
		if("".equals(testId) || testId==null) {
			return;
		}
        
		try{
			session.insert("deleteTestInfo", Integer.parseInt(testId));
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public boolean checkTestInfo(String grade, String year, String month) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = 0;
		
		TestInfo ti = new TestInfo();
		ti.setGrade(Integer.parseInt(grade));
		ti.setYear(Integer.parseInt(year));
		ti.setMonth(Integer.parseInt(month));
		try{
			Mapper mapper = session.getMapper(Mapper.class);
			result = mapper.selectCountTestInfo(ti);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return result>0;
	}
	
	public List<TestInfo> selectTestInfo(String grade, String year) {
		List<TestInfo> tiList = new ArrayList<TestInfo>();
		TestInfo ti = new TestInfo();
		SqlSession session = sqlSessionFactory.openSession();

		try{
			Mapper mapper = session.getMapper(Mapper.class);
			if(!"".equals(grade) && grade != null) {
				ti.setGrade(Integer.parseInt(grade));
				if(!"".equals(year) && year != null) {
					ti.setYear(Integer.parseInt(year));
					tiList = mapper.selectTestInfoListByGradeAndYear(ti);
				} else {
					tiList = mapper.selectTestInfoListByGrade(ti);
				}
			} else {
				if(!"".equals(year) && year != null) {
					ti.setYear(Integer.parseInt(year));
					tiList = mapper.selectTestInfoListByYear(ti);
				} else {
					tiList = mapper.selectTestInfoList(ti);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return tiList;
	}
	
	public void insertTestInfo(String grade, String year, String month, String auth) {
		SqlSession session = sqlSessionFactory.openSession();
		
		if("".equals(grade) || grade==null) {
        	return;
        }
        
        if("".equals(year) || year==null) {
        	return;
        }
        
        if("".equals(month) || month==null) {
        	return;
        }
        
        if("".equals(auth) || auth==null) {
        	return;
        }

        if(checkTestInfo(grade, year, month)) {
        	return;
        }
        
        TestInfo ti = new TestInfo();
        ti.setGrade(Integer.parseInt(grade));
        ti.setYear(Integer.parseInt(year));
        ti.setMonth(Integer.parseInt(month));
        ti.setAuth(auth);
        
		try{
			session.insert("insertTestInfo", ti);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
