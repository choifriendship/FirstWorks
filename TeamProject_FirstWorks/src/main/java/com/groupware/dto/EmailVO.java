
package com.groupware.dto;


public class EmailVO {
	private String senderName;// 諛쒖?���씤
	private String senderMail; //諛쒖?���옄 �씠硫붿?��
	private String receiveMail; //�닔�떊�옄 �씠硫붿?��
	private String title; //�젣紐�
	private String content; //�궡�슜
	
	
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderMail() {
		return senderMail;
	}
	public void setSenderMail(String senderMail) {
		this.senderMail = senderMail;
	}
	public String getReceiveMail() {
		return receiveMail;
	}
	public void setReceiveMail(String receiveMail) {
		this.receiveMail = receiveMail;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		
		 return "EmailVO [senderName=" + senderName + ", senderMail=" + senderMail + ", receiveMail=" + receiveMail
	                + ", title=" + title + ", content=" + content + "]";
	}
	
}
