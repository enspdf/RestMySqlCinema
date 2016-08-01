package Manager;

import java.util.List;

import Entities.Room;

public interface RoomManager {
	
	List<Room> getAllRooms() throws Exception;
	
	void saveRoom(Room room) throws Exception;

}
