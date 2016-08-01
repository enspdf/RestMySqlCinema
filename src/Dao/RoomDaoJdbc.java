package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.Room;

public class RoomDaoJdbc implements RoomDao {
	
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	@Override
	public List<Room> listRoom(Connection connection) throws SQLException {
		List<Room> rooms = new ArrayList<Room>();
		preparedStatement = connection.prepareStatement("SELECT * FROM room");
		try {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Room room = new Room();
				room.setRoom_id(resultSet.getInt("room_id"));
				room.setRoom_descrption(resultSet.getString("room_description"));
				room.setCreated_at(resultSet.getTimestamp("created_at"));
				room.setActive(resultSet.getString("active"));
				rooms.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			connection.close();
		}
		
		return rooms;
	}

	@Override
	public void saveRoom(Connection connection, Room room) throws SQLException {
		int index = 1;
		preparedStatement = connection.prepareStatement("INSERT INTO room (room_description, active) VALUES (?,?)");
		preparedStatement.setString(index++, room.getRoom_descrption());
		preparedStatement.setString(index++, room.getActive());
		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

}
