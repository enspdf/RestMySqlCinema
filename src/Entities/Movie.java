package Entities;

import java.sql.Timestamp;

public class Movie {

	private int movie_id;
	private String movie_name;
	private Timestamp created_at;
	private String active;

	public Movie(int movie_id, String movie_name, Timestamp created_at, String active) {
		super();
		this.movie_id = movie_id;
		this.movie_name = movie_name;
		this.created_at = created_at;
		this.active = active;
	}

	public Movie() {
		super();
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
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
		return "Movie [movie_id=" + movie_id + ", movie_name=" + movie_name + ", created_at=" + created_at + ", active="
				+ active + "]";
	}

}
