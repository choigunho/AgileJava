package sis.studentinfo;

public class Course {
	private String department;
	private String number;
	
	public Course(String department, String number) {
		this.department = department;
		this.number = number;
	}
	
	public String getDepartment() {
		return department;
	}

	public String getNumber() {
		return number;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (this.getClass() != object.getClass())
			return false;
		Course that = (Course) object;
		return
				this.department.equals(that.department) && 
				this.number.equals(that.number);
	}
	
	@Override
	public int hashCode() {
		final int hashMultiplier = 41;
		int result = 7;
		result = result * hashMultiplier + department.hashCode();
//		System.out.println("department.hashCode(): " + department.hashCode());
		result = result * hashMultiplier + number.hashCode();
//		System.out.println(result);
		return result;
	}
}
