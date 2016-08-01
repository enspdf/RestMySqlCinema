package Manager;

import java.util.List;

import Entities.Movie;

public interface MovieManager {

	List<Movie> getAllMovies() throws Exception;

	void SaveMovie(Movie movie) throws Exception;

}
