package service;

import java.util.List;

import model.Teachers;

public interface TeachersDAO {
	public List<Teachers> queryAllTeachers();
	
	//根据老师编号查询老师的资料
	public Teachers queryTeachersByTid(String tid);
	
	//添加老师资料
	public boolean addTeachers(Teachers t);
	
	//修改老师资料
	public boolean updateTeachers(Teachers t);
	
	//删除老师资料
	public boolean deleteTeachers(String tid);
}
