package escuelaing.edu.co.lab2.service;


import java.util.HashMap;
import java.util.List;

import escuelaing.edu.co.lab2.data.Task;




public interface TaskService
{
    Task create( Task task );

    Task findById( String id );
    
    HashMap<String, Task> all();

    void deleteById( String id );

    Task update( Task task, String id );
}
