package com.appdev.asm.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import com.appdev.asm.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RoleDetailDAO {
	 @Autowired
	    private EntityManager entityManager;
	 
	    public List<String> getRoleNames(Integer userID) {
	        String sql = "Select ur.roleDetail.roleName from " + UserRole.class.getName() + " ur " //
	                + " where ur.appUser.userID = :userID ";
	 
	        Query query = this.entityManager.createQuery(sql, String.class);
	        query.setParameter("userID", userID);
	        return query.getResultList();
	    }
}
