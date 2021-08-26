package escuelaing.edu.co.lab2.data;

import java.util.HashMap;


import org.springframework.stereotype.Service;

import escuelaing.edu.co.lab2.service.TaskService;
@Service
public class TaskServiceHashMap  implements TaskService{
	private HashMap<String, Task> taskHashMap = new HashMap<String,Task>();
	@Override
	public Task create(Task task) {
		// TODO Auto-generated method stub
		taskHashMap.put(task.getId(), task);
        return task;
	}

	@Override
	public Task findById(String id) {
		// TODO Auto-generated method stub
		if(taskHashMap.containsKey(id)) {
			return taskHashMap.get(id);
		}else {
			return null;
		}
	}

	@Override
	public HashMap<String, Task> all() {
		// TODO Auto-generated method stub
		return taskHashMap;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		taskHashMap.remove(id);
	}

	@Override
	public Task update(Task task, String taskId) {
		// TODO Auto-generated method stub
		taskHashMap.put(taskId,task);
		return task;
	}

}
