package com.accesshr.emsbackend.EmployeeController.TaskController;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.accesshr.emsbackend.Entity.Task;
import com.accesshr.emsbackend.Service.TaskService.*;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;



  @RestController

  @CrossOrigin
  @RequestMapping("apis/employees")
public class TaskController {
    @Autowired
    public TaskJpaService taskService;

    @GetMapping(value="/tasks",produces = "application/json")
    public ArrayList<Task> gettTasks(){
        return taskService.getTasks();
    }

    @GetMapping(value="/tasks/{taskId}",produces = "application/json")

    public Task getTaskById(@PathVariable int taskId){
      return taskService.getTaskById(taskId);
    }

    @GetMapping(value="/tasksAssignedBy/{email}",produces = "application/json")

    public List<Task> getTaskAssignedBy(@PathVariable String email){
      return taskService.getTasksAssignedForm(email);
    }

    @GetMapping(value="/tasksAssignedTo/{email}",produces = "application/json")

    public List<Task> getTaskAssignedTo(@PathVariable String email){
      return taskService.getTasksAssignedTo(email);
    }

    @GetMapping(value="/tasksCount/{email}",produces = "application/json")

    public int countOfTasks(@PathVariable String email){
      return taskService.countOfTasks(email);
    }

    @PostMapping(value="/tasks",produces = "application/json")

    public Task addTask(@RequestBody Task task){
      return taskService.addTask(task);
    }

    @PutMapping(value="/tasks/{taskId}",produces = "application/json")

    public Task updateTask(@PathVariable int taskId,@RequestBody Task task){
      return taskService.updateTask(taskId,task);
    }

    @DeleteMapping(value="/tasks/{taskId}",produces = "application/json")

    public void deleteTask(@PathVariable int taskId){
      taskService.deleteTask(taskId);
    }

    @GetMapping(value="/OverdueTasks/AssignedFrom/{email}",produces = "application/json")
    public List getOverDueTasksAssignedFrom(@PathVariable String email) {
        return taskService.getOverDueTasksAssignedFrom(email);
    }

    @GetMapping(value="/PendingTasks/AssignedFrom/{email}",produces = "application/json")
    public List getPendingTasksAssignedFrom(@PathVariable String email) {
        return taskService.getPendingTasksAssignedFrom(email);
    }

    @GetMapping(value="/CompletedTasks/AssignedFrom/{email}",produces = "application/json")
    public List getCompletedTasksAssignedFrom(@PathVariable String email) {
        return taskService.getCompletedTasksAssignedFrom(email);
    }

    @GetMapping(value="/OverdueTasks/PersonId/{personId}",produces = "application/json")
    public List getOverDuePersonEmail(@PathVariable String personId) {
        return taskService.getOverDueTasksPersonId(personId);
    }

    @GetMapping(value="/PendingTasks/PersonId/{personId}",produces = "application/json")
    public List getPendingPersonEmail(@PathVariable String personId) {
        return taskService.getPendingTasksPersonId(personId);
    }

    @GetMapping(value="/CompletedTasks/PersonId/{personId}",produces = "application/json")
    public List getCompletedTasksPersonId(@PathVariable String personId) {
        return taskService.getCompletedTasksPersonId(personId);
    }

    @GetMapping(value="/TasksDetails/PersonId/{personId}",produces = "application/json")
    public HashMap<String,Integer> getTasksEfficiency(@PathVariable String personId) {
        return taskService.getTasksEfficiency(personId);
    }
    

}

