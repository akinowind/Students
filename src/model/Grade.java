package model;

public class Grade {
	private String id; 		//id ��̬����
	private String sid; //ѧ����ѧ��
	private String sname;   //ѧ������
	private String classInfo; //�༶
	private String tid; //��ʦ��
	
	public Grade(){
		
	}
	public Grade(String id,String sid,String sname,String classInfo,String tid){
		this.id = id;
		this.sid = sid;
		this.sname = sname;
		this.classInfo = classInfo;
		this.tid = tid;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getClassInfo() {
		return classInfo;
	}
	public void setClassInfo(String classInfo) {
		this.classInfo = classInfo;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	
	
}
