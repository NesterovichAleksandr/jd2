package by.pvt.mvc.repo;

import by.pvt.mvc.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class DepartmentDaoImpl {

    @Autowired
    private EntityManager em;

    public void register(Department department) {
        em.persist(department);
    }

    public List<Department> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Department> criteria = cb.createQuery(Department.class);
        Root<Department> departmentRoot = criteria.from(Department.class);

        criteria.select(departmentRoot).orderBy(cb.asc(departmentRoot.get("name")));
        return em.createQuery(criteria).getResultList();
    }

    public Department findById(Long id) {
        return em.find(Department.class, id);
    }
}
