package Entities;

import java.sql.Date;
import java.sql.Timestamp;

public class Function {

	private int function_id;
	private String function_name;
	private Date function_hour;
	private Timestamp created_at;
	private String active;
	private Movie movie;
	private Room room;

	public Function(int function_id, String function_name, Date function_hour, Timestamp created_at, String active,
			Movie movie, Room room) {
		super();
		this.function_id = function_id;
		this.function_name = function_name;
		this.function_hour = function_hour;
		this.created_at = created_at;
		this.active = active;
		this.movie = movie;
		this.room = room;
	}

	public Function() {
		super();
	}

	public int getFunction_id() {
		return function_id;
	}

	public void setFunction_id(int function_id) {
		this.function_id = function_id;
	}

	public String getFunction_name() {
		return function_name;
	}

	public void setFunction_name(String function_name) {
		this.function_name = function_name;
	}

	public Date getFunction_hour() {
		return function_hour;
	}

	public void setFunction_hour(Date function_hour) {
		this.function_hour = function_hour;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Movie getMovie() {
		if (movie == null) {
			movie = new Movie();
		}
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Room getRoom() {
		if (room == null) {
			room = new Room();
		}
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Function [function_id=" + function_id + ", function_name=" + function_name + ", function_hour="
				+ function_hour + ", created_at=" + created_at + ", active=" + active + ", movie=" + movie + ", room="
				+ room + "]";
	}

}
