package Manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import Dao.MovieDaoJdbc;
import Entities.Movie;
import Util.Database;

public class MovieManagerImpl extends Database implements MovieManager {

	MovieDaoJdbc Dao = new MovieDaoJdbc();

	@Override
	public List<Movie> getAllMovies() throws Exception {
		List<Movie> movies = new ArrayList<Movie>();
		Connection connection = this.getConnection();
		try {
			movies = Dao.listMovies(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	@Override
	public void SaveMovie(Movie movie) throws Exception {
		Connection connection = this.getConnection();
		try {
			Dao.saveMovie(connection, movie);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
