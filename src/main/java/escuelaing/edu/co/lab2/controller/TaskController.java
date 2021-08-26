package escuelaing.edu.co.lab2.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import escuelaing.edu.co.lab2.data.Task;
import escuelaing.edu.co.lab2.service.TaskService;

@RestController
@RequestMapping("/v1/user")
public class TaskController {
	private final TaskService taskService;

	public TaskController(@Autowired TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping
   public ResponseEntity<HashMap<String, Task>> all()
   {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(taskService.all());
        }catch(Exception e) {
    	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
   }

	@GetMapping( "/{id}" )
   public ResponseEntity<Task> findById( @PathVariable String id )
   {
      //TODO implement this method using UserService
		try {
			return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));
        }catch(Exception e) {
    	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
   }

	@PostMapping
   public ResponseEntity<Task> create( @RequestBody Task task)
   {
        //TODO implement this method using UserService
		try {
			return ResponseEntity.status(HttpStatus.OK).body(taskService.create(task));
        }catch(Exception e) {
    	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
   }

	@PutMapping( "/{id}" )
   public ResponseEntity<Task> update( @RequestBody Task task, @PathVariable String id )
   {
        //TODO implement this method using UserService
		try {
			return ResponseEntity.status(HttpStatus.OK).body(taskService.update(task,id));
        }catch(Exception e) {
    	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
   }

	@DeleteMapping( "/{id}" )
   public ResponseEntity<Boolean> delete( @PathVariable String id )
   {
        //TODO implement this method using UserService
		try {
			taskService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(Boolean.TRUE);
        }catch(Exception e) {
    	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }     
   }
}