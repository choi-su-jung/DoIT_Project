package qna.model.vo;

import java.util.Date;

public class Reply {
	private int reply_no;
	private String reply_content;
	private Date create_date;
	private Date modify_date;
	private int board_no;
	private String status;
	private int user_no;
	private String nickName;
	private int notice_no;
	private String profile_img;
	

	public Reply() {}
	
	
	public Reply(int reply_no, String reply_content, Date create_date, Date modify_date, int user_no, String nickName,
			int notice_no) {
		super();
		this.reply_no = reply_no;
		this.reply_content = reply_content;
		this.create_date = create_date;
		this.modify_date = modify_date;
		this.user_no = user_no;
		this.nickName = nickName;
		this.notice_no = notice_no;
	}

	
	

	public Reply(int reply_no, String reply_content, Date create_date, Date modify_date, int board_no, int user_no,
			String nickName, String profile_img) {
		super();
		this.reply_no = reply_no;
		this.reply_content = reply_content;
		this.create_date = create_date;
		this.modify_date = modify_date;
		this.board_no = board_no;
		this.user_no = user_no;
		this.nickName = nickName;
		this.profile_img = profile_img;
	}




public Reply(int reply_no, String reply_content, Date create_date, Date modify_date, int user_no, String nickName,
			int notice_no, String profile_img) {
		super();
		this.reply_no = reply_no;
		this.reply_content = reply_content;
		this.create_date = create_date;
		this.modify_date = modify_date;
		this.user_no = user_no;
		this.nickName = nickName;
		this.notice_no = notice_no;
		this.profile_img = profile_img;
	}


public Reply(int reply_no, String reply_content, Date create_date, Date modify_date, int board_no, int user_no,
			String nickName) {
		super();
		this.reply_no = reply_no;
		this.reply_content = reply_content;
		this.create_date = create_date;
		this.modify_date = modify_date;
		this.board_no = board_no;
		this.user_no = user_no;
		this.nickName = nickName;
	}



public int getReply_no() {
	return reply_no;
}

public void setReply_no(int reply_no) {
	this.reply_no = reply_no;
}

public String getReply_content() {
	return reply_content;
}

public void setReply_content(String reply_content) {
	this.reply_content = reply_content;
}

public Date getCreate_date() {
	return create_date;
}


public void setCreate_date(Date create_date) {
	this.create_date = create_date;
}


public Date getModify_date() {
	return modify_date;
}


public void setModify_date(Date modify_date) {
	this.modify_date = modify_date;
}


public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public int getBoard_no() {
	return board_no;
}

public void setBoard_no(int board_no) {
	this.board_no = board_no;
}

public int getUser_no() {
	return user_no;
}

public void setUser_no(int user_no) {
	this.user_no = user_no;
}

public int getNotice_no() {
	return notice_no;
}

public void setNotice_no(int notice_no) {
	this.notice_no = notice_no;
}

public String getNickName() {
	return nickName;
}


public void setNickName(String nickName) {
	this.nickName = nickName;
}

public String getProfile_img() {
	return profile_img;
}

public void setProfile_img(String profile_img) {
	this.profile_img = profile_img;
}




@Override
public String toString() {
	return "Reply [reply_no=" + reply_no + ", reply_content=" + reply_content + ", create_date=" + create_date
			+ ", modify_date=" + modify_date  + ", board_no=" + board_no + ", status="
			+ status + ", user_no=" + user_no + ", nickName=" + nickName + ", notice_no=" + notice_no + ", profile_img="
			+ profile_img + "]";
}


	
}
