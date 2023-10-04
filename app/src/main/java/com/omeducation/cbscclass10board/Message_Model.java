package com.omeducation.cbscclass10board;


public class Message_Model {

    public String stundet_name;
    public String student_Message;
    public String msg_Time;

    public Message_Model() {
    }

    public Message_Model(String stundet_name, String student_Message, String msg_Time) {
        this.stundet_name = stundet_name;
        this.student_Message = student_Message;
        this.msg_Time = msg_Time;
    }

    public String getStundet_name() {
        return stundet_name;
    }

    public void setStundet_name(String stundet_name) {
        this.stundet_name = stundet_name;
    }

    public String getStudent_Message() {
        return student_Message;
    }

    public void setStudent_Message(String student_Message) {
        this.student_Message = student_Message;
    }

    public String getMsg_Time() {
        return msg_Time;
    }

    public void setMsg_Time(String msg_Time) {
        this.msg_Time = msg_Time;
    }
}

