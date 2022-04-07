package tda.darkarmy.ngomanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tda.darkarmy.ngomanagement.model.Task;
import tda.darkarmy.ngomanagement.service.TaskService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/tasks")
@RestController
@AllArgsConstructor
public class TaskController
{
	private TaskService taskService;

	@GetMapping("/")
	public ResponseEntity<?> findAllTasks(){
		return ResponseEntity.status(200).body(taskService.findAllTask());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.status(200).body(taskService.findById(id));
	}

	@PostMapping("/create")
	public ResponseEntity<?> createTask(@RequestBody Task task){
		return ResponseEntity.status(200).body(taskService.createTask(task));
	}

}
