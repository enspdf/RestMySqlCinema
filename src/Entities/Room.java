package Entities;

import java.sql.Timestamp;

public class Room {

	private int room_id;
	private String room_descrption;
	private Timestamp created_at;
	private String active;

	public Room(int room_id, String room_descrption, Timestamp created_at, String active) {
		super();
		this.room_id = room_id;
		this.room_descrption = room_descrption;
		this.created_at = created_at;
		this.active = active;
	}

	public Room() {
		super();
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getRoom_descrption() {
		return room_descrption;
	}

	public void setRoom_descrption(String room_descrption) {
		this.room_descrption = room_descrption;
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

	@Override
	public String toString() {
		return "Room [room_id=" + room_id + ", room_descrption=" + room_descrption + ", created_at=" + created_at
				+ ", active=" + active + "]";
	}

}
