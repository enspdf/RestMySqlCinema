package Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;

import Entities.Function;
import Entities.Movie;
import Entities.Room;
import Manager.FunctionManagerImpl;
import Manager.MovieManagerImpl;
import Manager.RoomManagerImpl;

@Path("api")
public class Services {
	MovieManagerImpl movieManager = new MovieManagerImpl();
	RoomManagerImpl roomManager = new RoomManagerImpl();
	FunctionManagerImpl functionManager = new FunctionManagerImpl();

	@GET
	@Path("movies")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getallMovies() throws Exception {
		List<Movie> listMovies = new ArrayList<Movie>();
		listMovies = movieManager.getAllMovies();
		String response = new JSONArray(listMovies).toString();
		return Response.status(200).entity(response).build();
	}

	@POST
	@Path("movies")
	public Response saveMovie(@FormParam("movie_name") String movie_name, @FormParam("active") String active)
			throws Exception {
		Movie movie = new Movie();
		movie.setMovie_name(movie_name);
		movie.setActive(active);
		movieManager.SaveMovie(movie);
		return Response.status(201).entity("Movie " + movie_name + " saved successfull").build();
	}

	@GET
	@Path("rooms")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRooms() throws Exception {
		List<Room> listRooms = new ArrayList<Room>();
		listRooms = roomManager.getAllRooms();
		String response = new JSONArray(listRooms).toString();
		return Response.status(200).entity(response).build();
	}

	@POST
	@Path("rooms")
	public Response saveRoom(@FormParam("room_description") String room_description, @FormParam("active") String active)
			throws Exception {
		Room room = new Room();
		room.setRoom_descrption(room_description);
		room.setActive(active);
		roomManager.saveRoom(room);
		return Response.status(201).entity("Room " + room_description + " was saved successfull").build();
	}

	@GET
	@Path("functions")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllFunctions() throws Exception {
		List<Function> listFunctions = new ArrayList<Function>();
		listFunctions = functionManager.getAllFunctions();
		String response = new JSONArray(listFunctions).toString();
		return Response.status(200).entity(response).build();
	}

	@POST
	@Path("functions")
	public Response saveFunction(@FormParam("function_name") String function_name, @FormParam("movie_id") int movie_id, @FormParam("room_id") int room_id) throws Exception {
		 Function function = new Function();
		 function.setFunction_name(function_name);
//		 function.setFunction_hour(function_hour);
		 function.getMovie().setMovie_id(movie_id);
		 function.getRoom().setRoom_id(room_id);
		 functionManager.saveFunction(function);
		return Response.status(201).entity("Function " + function_name + " was saved successfull").build();
	}

}
