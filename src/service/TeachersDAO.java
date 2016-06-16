package service;

import java.util.List;

import model.Teachers;

public interface TeachersDAO {
	public List<Teachers> queryAllTeachers();
	
	//������ʦ��Ų�ѯ��ʦ������
	public Teachers queryTeachersByTid(String tid);
	
	//�����ʦ����
	public boolean addTeachers(Teachers t);
	
	//�޸���ʦ����
	public boolean updateTeachers(Teachers t);
	
	//ɾ����ʦ����
	public boolean deleteTeachers(String tid);
}
