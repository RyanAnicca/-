package tw.leonchen.model;

import java.util.Date;

public class Room {

	private int id;
	private String name;
	private String size;
	private Date date;

	public Room(int id, String name, String size) {
		this.id = id;
		this.name = name;
		this.size = size;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Room() {
	}

}
