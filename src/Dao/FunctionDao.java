package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Entities.Function;

public interface FunctionDao {
	
	List<Function> getAllFunctions(Connection connection) throws SQLException;
	
	void saveFunction(Connection connection, Function function) throws SQLException;

}
