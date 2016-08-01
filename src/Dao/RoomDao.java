package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Entities.Room;

public interface RoomDao {

	List<Room> listRoom(Connection connection) throws SQLException;

	void saveRoom(Connection connection, Room room) throws SQLException;

}
