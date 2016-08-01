package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Entities.Movie;

public interface MovieDao {
	
	List<Movie> listMovies(Connection connection) throws SQLException;
	
	void saveMovie(Connection connection, Movie movie) throws SQLException;

}
