package service;

import java.util.List;

import model.Students;

//学生的业务逻辑接口
public interface StudentsDAO {
	
	//查询所有学生的资料
	public List<Students> queryAllStudents();
	
	public List<Students> queryStudents(String sid);
	
	//根据学生编号查询学生的资料
	public Students queryStudentsBySid(String sid);
	
	//添加学生资料
	public boolean addStudents(Students s);
	
	//修改学生资料
	public boolean updateStudents(Students s);
	
	//删除学生资料
	public boolean deleteStudents(String sid);
}
