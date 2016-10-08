package kr.modustudy.analysis;

import kr.modustudy.db.DatabaseManager;

public class TestAnalyzer {
	
	String grade;
	String year;
	String month;
	String incorrectNumber;
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getIncorrectNumber() {
		return incorrectNumber;
	}

	public void setIncorrectNumber(String incorrectNumber) {
		this.incorrectNumber = incorrectNumber;
	}

	public boolean checkTestInfo(String grade, String year, String month) {
		
		if("".equals(grade) || grade==null) {
			return false;
		}

		if("".equals(year) || year==null) {
			return false;
		}
		
		if("".equals(month) || month==null) {
			return false;
		}
		
		this.grade = grade;
		this.year = year;
		this.month = month;
		
		return DatabaseManager.getInstance().checkTestInfo(grade, year, month); 
	}
	
	public void setIncorrectNumberList(String incorrectNumber) {
		
	}
	
	public void setAnalysisData() {
		
	}
}
