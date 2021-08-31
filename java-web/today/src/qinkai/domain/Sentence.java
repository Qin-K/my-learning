package qinkai.domain;

import java.util.Date;

public class Sentence {
	private int id;
	private Date date;
	private String weather;
	private String mood;
	private String info;
	private String uName;
	
	public Sentence() {
		super();
	}
	
	public Sentence( Date date, String weather, String mood, String info, String uName) {
		super();
		this.date = date;
		this.weather = weather;
		this.mood = mood;
		this.info = info;
		this.uName = uName;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getMood() {
		return mood;
	}
	public void setMood(String mood) {
		this.mood = mood;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	
}
