package Manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import Dao.RoomDaoJdbc;
import Entities.Room;
import Util.Database;

public class RoomManagerImpl extends Database implements RoomManager {

	RoomDaoJdbc Dao = new RoomDaoJdbc();

	@Override
	public List<Room> getAllRooms() throws Exception {
		List<Room> roomList = new ArrayList<Room>();
		Connection connection = this.getConnection();
		try {
			roomList = Dao.listRoom(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roomList;
	}

	@Override
	public void saveRoom(Room room) throws Exception {
		Connection connection = this.getConnection();
		try {
			Dao.saveRoom(connection, room);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
