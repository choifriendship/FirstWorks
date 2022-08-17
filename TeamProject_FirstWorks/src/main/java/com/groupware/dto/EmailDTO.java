package com.groupware.dto;

import java.sql.Date;



import lombok.Data;

@Data
public class EmailDTO {
	private int mailnum;//���Ϲ�ȣ
	private int memnum;// �����ȣ -> �ܷ�Ű
	private String sendermail; //�߽��� �̸���
	private String receivemail; //������ �̸���
	private String title; //����
	private String content; //����
	private Date registerDate;//�����
	private int readck; //�������� üũ 0������ 1����
	private int delck; //�Խñ� ���� (-> �Ⱥ��̰��ϴ°ɷ�) 0�Խñ� ���̰� 1 �Խñ� �Ⱥ��̰� 
	private int offset;
	private int pagesize;
	private int page;
	
	public void execute() { //offset 실행
		offset=(page-1)*pagesize;
	}

	
	
	
	//������ �Խñ� �о������ (1) -> delete ���� �ʰ� delck 1�� ������Ʈ �ؼ� �����Ը� �Ⱥ��̰�
	//������ �Խñ��� ���� �ʾ������ (0) ->db ������ ���� 

	

	

}
