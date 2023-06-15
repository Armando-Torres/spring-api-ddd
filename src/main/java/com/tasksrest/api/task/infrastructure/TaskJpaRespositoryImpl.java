package com.tasksrest.api.task.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tasksrest.api.shared.domain.Task;
import com.tasksrest.api.shared.domain.TaskRepository;
import com.tasksrest.api.shared.domain.exception.NotFoundTaskException;
import com.tasksrest.api.shared.domain.vo.TasksFilters;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


@Repository
public class TaskJpaRespositoryImpl implements TaskRepository {
    
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TaskJpaRepository jpaRepository;
    
    @Override
    public List<Task> findAllWithCriteria(TasksFilters filters) {
        TypedQuery<Task> query = this.createQueryFindAllWithCriteria(filters);

        List<Task> results = query.getResultList();

        return results;
    }

    private TypedQuery<Task> createQueryFindAllWithCriteria(TasksFilters filters) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Task> cr = cb.createQuery(Task.class);
        Root<Task> root = cr.from(Task.class);
        cr.select(root);
        
        List<Predicate> criteria = new ArrayList<Predicate>();

        if (filters.getName() != null) {
            Predicate name = cb.like(root.get("name"), String.format("%%%s%%", filters.getName()));
            criteria.add(name);
        }
                
        if (filters.getDesc() != null) {
            Predicate desc = cb.like(root.get("description"), String.format("%%%s%%", filters.getDesc()));
            criteria.add(desc);
        }
                
        if (filters.getStatus() != null) {
            Predicate status = cb.equal(root.get("status"), filters.getStatus().getValue());
            criteria.add(status);
        }

        if (criteria.size() > 0) {
            cr.where(cb.and(criteria.toArray(new Predicate[0])));
        }

        TypedQuery<Task> query = entityManager.createQuery(cr);

        query.setFirstResult(filters.getPagination().getPage());
        query.setMaxResults(filters.getPagination().getSize());

        return query;
    }

    @Override
    public Task save(Task task) {
        return this.jpaRepository.save(task);
    }

    @Override
    public Task findById(Integer id) {
        Task task = null;

        try {
            task = this.jpaRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            new NotFoundTaskException(String.format("Task with id <%d> not found", id));
        }

        return task;
    }
}
