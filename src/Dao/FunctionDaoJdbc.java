package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.Function;

public class FunctionDaoJdbc implements FunctionDao {
	
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	@Override
	public List<Function> getAllFunctions(Connection connection) throws SQLException {
		List<Function> listFunctions = new ArrayList<Function>();
		preparedStatement = connection.prepareStatement("SELECT * FROM function f INNER JOIN room r ON r.room_id = f.room_id INNER JOIN movies m ON m.movie_id = f.movie_id");
		try {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Function function = new Function();
				function.getMovie().setMovie_id(resultSet.getInt("movie_id"));
				function.getMovie().setMovie_name(resultSet.getString("movie_name"));
				
				function.getRoom().setRoom_id(resultSet.getInt("room_id"));
				function.getRoom().setRoom_descrption(resultSet.getString("room_descrption"));
				
				function.setFunction_id(resultSet.getInt("function_id"));
				function.setFunction_name(resultSet.getString("function_name"));
				function.setFunction_hour(resultSet.getDate("function_hour"));
				
				listFunctions.add(function);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return listFunctions;
	}

	@Override
	public void saveFunction(Connection connection, Function function) throws SQLException {
		int index = 1;
		preparedStatement = connection.prepareStatement("INSERT INTO function (function_name, function_hour, movie_id, room_id) VALUES (?,?,?,?)");
		preparedStatement.setString(index++, function.getFunction_name());
		preparedStatement.setDate(index++, function.getFunction_hour());
		preparedStatement.setInt(index++, function.getMovie().getMovie_id());
		preparedStatement.setInt(index++, function.getRoom().getRoom_id());
		
		try {
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();			
		} finally {
			connection.close();
		}
	}

}
