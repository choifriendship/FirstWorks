package com.groupware.service;

import java.util.List;

import com.groupware.dto.EmailDTO;

public interface EmailService {
	
	
	public void send(EmailDTO email); //���� ����
	
	public List<EmailDTO> getList(); //��ü ���� Ȯ�� 
	
	
	
	public List<EmailDTO> receiveList(EmailDTO dto);//받은 메일함
	public int receiveListcount(EmailDTO dto);
	
	public List<EmailDTO> sendList(EmailDTO dto);//보낸 메일함
	public int sendListcount(EmailDTO dto);

	public EmailDTO detail(int mailnum);//�󼼺���
	public void readupdate(int mailnuml); //����Ȯ��

	public void reply(EmailDTO email);//����

	public List<EmailDTO> unreadlist(EmailDTO dto);// �� ���� ������
	
	public int count(EmailDTO dto);//������ ���� ��

	//�Խñ� ����  ��� ����
	//public void delete(String mailnum);
	
	//public void delete(Integer mailnum);
	
	//�Խñ� ������ �Ⱥ��̰� 
	public void delupdate(int mailnum);

	//���������Կ��� ������ ����Ʈ Ȯ�� 
	public List<EmailDTO> deleteview(EmailDTO dto);

	public int revoke(int mailnum);//������� ��� ����

	public void restore(int mailnum);









	



	
}
