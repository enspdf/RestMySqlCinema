package Manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import Dao.FunctionDaoJdbc;
import Entities.Function;
import Util.Database;

public class FunctionManagerImpl extends Database implements FunctionManager {
	
	FunctionDaoJdbc Dao = new FunctionDaoJdbc();

	@Override
	public List<Function> getAllFunctions() throws Exception {
		List<Function> functions = new ArrayList<Function>();
		Connection connection = this.getConnection();
		return functions;
	}

	@Override
	public void saveFunction(Function function) throws Exception {
		Connection connection = this.getConnection();
		
	}

}
