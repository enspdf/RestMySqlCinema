package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.Movie;

public class MovieDaoJdbc implements MovieDao {
	
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	@Override
	public List<Movie> listMovies(Connection connection) throws SQLException {
		List<Movie> movies = new ArrayList<Movie>();
		preparedStatement = connection.prepareStatement("SELECT * FROM movies");
		try {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movie movie = new Movie();
				movie.setMovie_id(resultSet.getInt("movie_id"));
				movie.setMovie_name(resultSet.getString("movie_name"));
				movie.setCreated_at(resultSet.getTimestamp("created_at"));
				movie.setActive(resultSet.getString("active"));
				movies.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return movies;
	}

	@Override
	public void saveMovie(Connection connection, Movie movie) throws SQLException {
		int index = 1;
		preparedStatement = connection.prepareStatement("INSERT INTO movies (movie_name, active) VALUES (?,?)");
		preparedStatement.setString(index++, movie.getMovie_name());
		preparedStatement.setString(index++, movie.getActive());
		try {
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

}
