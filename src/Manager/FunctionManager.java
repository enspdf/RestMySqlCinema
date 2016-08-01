package Manager;

import java.util.List;

import Entities.Function;

public interface FunctionManager {
	
	List<Function> getAllFunctions() throws Exception;
	
	void saveFunction(Function function) throws Exception;

}
