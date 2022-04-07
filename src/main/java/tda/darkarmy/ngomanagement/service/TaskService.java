package tda.darkarmy.ngomanagement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tda.darkarmy.ngomanagement.model.Task;
import tda.darkarmy.ngomanagement.repository.TaskRepository;
import tda.darkarmy.ngomanagement.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class TaskService {
	private TaskRepository taskRepository;
	private UserRepository userRepository;

	public Task createTask(Task task){
		return  taskRepository.save(task);
	}

	public Task updateTask(Long id, Task task) throws Exception
	{
		Task task1 = taskRepository.getById(id);
		if(task1==null) throw new Exception("Task not found");
		task1.setTaskDescription(task.getTaskDescription());
		task1.setTaskName(task.getTaskName());
		return taskRepository.save(task1);
	}

	public String deleteTask(Long id) throws Exception
	{
		Task task1 = taskRepository.getById(id);
		if(task1==null) throw new Exception("Task not found");
		taskRepository.deleteById(id);

		return "Task deleted successfully";

	}

	public Task addVolunteers(Long taskId, Set<Long> volunteers) throws Exception
	{
		Task task1 = taskRepository.getById(taskId);
		if(task1==null) throw new Exception("Task not found");
		return task1;
	}

	public List<Task> findAllTask() {
		return taskRepository.findAll();
	}

	public Optional<Task> findById(Long id){
		return taskRepository.findById(id);
	}
}
