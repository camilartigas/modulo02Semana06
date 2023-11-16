package com.camila.projetoSemana06.projetoSemana06.repository;

import ch.qos.logback.core.status.Status;
import com.camila.projetoSemana06.projetoSemana06.model.Task;
import jakarta.annotation.Priority;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class TaskRepository {
    private List<Task> taskList = new ArrayList<>();//cria uma lista vazia que pode armazenar objetos do tipo Task

    private final AtomicLong taskIdCounter = new AtomicLong(1); // Inicializa o contador com 1

    //salva tarefa na lista
    public Task saveTask(Task task) {

        // Gera um ID unico para a tarefa antes de salvar
        Long taskId = generateUniqueTaskId();
        task.setId(taskId);

        taskList.add(task);
        return task;
    }


    //deleta tarefa
    public void removeTaskById(Long id) {
        taskList.removeIf(task -> task.getId().equals(id));
    }


    //retorna o que tem salvo na lista
    public List<Task> getAllTasks() {
        return taskList;
    }


    //retorna uma lista de tarefa por status
    public List<Task> getTasksByStatus(Status status) {
        return taskList.stream()//permite o uso de operacoes funcionais como filter, map, collect
                .filter(task -> task.getStatus() == status)//filtra apenas as tarefas que tem o status igual ao status fornecido como parametro.
                .collect(Collectors.toList()); //os elementos filtrados voltam em uma lista.
    }


    //filtra as tarefas com base na prioridade especificada
    public List<Task> getTasksByPriority(Priority priority) {
        return taskList.stream()
                .filter(task -> task.getPriority() == priority)
                .collect(Collectors.toList());
    }


    //filtra as tarefas com base no nome do responsavel
    public List<Task> getTasksByAssignee(String assignee) {
        return taskList.stream()
                .filter(task -> task.getAssignee().equalsIgnoreCase(assignee))
                .collect(Collectors.toList());
    }

    // Método privado para gerar um ID único
    private Long generateUniqueTaskId() {
        return taskIdCounter.getAndIncrement(); // Obtem o proximo valor do contador e o incrementa
    }
}
