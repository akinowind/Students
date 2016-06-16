package service;

import java.util.List;

import model.Students;

//ѧ����ҵ���߼��ӿ�
public interface StudentsDAO {
	
	//��ѯ����ѧ��������
	public List<Students> queryAllStudents();
	
	public List<Students> queryStudents(String sid);
	
	//����ѧ����Ų�ѯѧ��������
	public Students queryStudentsBySid(String sid);
	
	//���ѧ������
	public boolean addStudents(Students s);
	
	//�޸�ѧ������
	public boolean updateStudents(Students s);
	
	//ɾ��ѧ������
	public boolean deleteStudents(String sid);
}
