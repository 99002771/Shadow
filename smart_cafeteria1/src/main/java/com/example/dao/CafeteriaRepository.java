package com.example.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Cafeteria;


@Repository
@Transactional
public class CafeteriaRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
 
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Transactional
	public Cafeteria save(Cafeteria cafeteria){
		 Session session = this.sessionFactory.getCurrentSession();
		 session.save(cafeteria);
		 return cafeteria;
	}
	
	
	public List<Cafeteria> getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Cafeteria>  cafeteriaList = session.createQuery("from Cafeteria",Cafeteria.class).getResultList();
		return cafeteriaList;
	}
	
	public Cafeteria getDetails(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cafeteria cafeteria = (Cafeteria) session.get(Cafeteria.class, id);
		return cafeteria;
	}
	
	
	
	public List<Cafeteria> getDiffTimeCountByDiningArea(Date dt) throws ParseException {
		/*List<Cafeteria> results = null;
		try {
			
			//read current time and take five min difference from curren time 
			
			
			
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Cafeteria.class);
		crit.add(Restrictions.eq("spacetype",spacetype));
		// add restriction datetime <=differencetime  and datetime >= current time 
		
		results = crit.list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return results;*/
		Session session = this.sessionFactory.getCurrentSession();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Cafeteria> results=null;
		try {
	                           
		 Calendar c = Calendar.getInstance();
	     c.setTime(dt);
	     c.add(Calendar.MINUTE, -5);
	     Date dtime = c.getTime();
	    
	      String d= (dateFormat.format(dtime));
	      
	      Date date1=dateFormat.parse(d);
	      System.out.println("Updated Date " + d);
	     //System.out.println("Updated Date " + dateFormat.format(e);
	    CriteriaBuilder cb = session.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<Cafeteria> query = cb.createQuery(Cafeteria.class);
		Root<Cafeteria> root = query.from(Cafeteria.class);
			//query.select(root).where(cb.equal(root.get("datetime"),dtime,dt));
		Predicate[] predicates = new Predicate[2];
		predicates[0] = cb.lessThanOrEqualTo(root.get("datetime"),dt );
		predicates[1] = cb.greaterThanOrEqualTo(root.get("datetime"), dtime);
		query.select(root.get("diningArea")).where(predicates);
		Query<Cafeteria> q = session.createQuery(query);
		results = q.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	     
		return results;
		
	}
	
	
	public List<Cafeteria> getDiffTimeCountByServiceArea(Date dt, String spacetype) throws ParseException {
		Session session = this.sessionFactory.getCurrentSession();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Cafeteria> results=null;
		try {
	                           
		 Calendar c = Calendar.getInstance();
	     c.setTime(dt);
	     c.add(Calendar.MINUTE, -5);
	     Date dtime = c.getTime();
	     String d= (dateFormat.format(dtime));
	     Date date1=dateFormat.parse(d);
	     
	    CriteriaBuilder cb = session.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<Cafeteria> query = cb.createQuery(Cafeteria.class);
		Root<Cafeteria> root = query.from(Cafeteria.class);
			
		Predicate[] predicates = new Predicate[3];
		predicates[0] = cb.lessThanOrEqualTo(root.get("datetime"),dt );
		predicates[1] = cb.greaterThanOrEqualTo(root.get("datetime"), dtime);
		predicates[2] = cb.equal(root.get("spacetype"), spacetype);
		query.select(root.get("peoplecount")).where(predicates);
		Query<Cafeteria> q = session.createQuery(query);
		results = q.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	     
		return results;
		
	}
	
	/*public List<Cafeteria> getCount(String spacetype) {
	    Session session = this.sessionFactory.getCurrentSession();
	    String hql;
	    if(spacetype.equals("service")) {
	       
	   
	        hql = "SELECT peoplecount from Cafeteria  where spacetype='service'";
	    }
	    else
	    {
	         hql = "SELECT peoplecount from Cafeteria where spacetype='dining'";
	    }
	    Query query = session.createQuery(hql);
	    List results = ((org.hibernate.query.Query<Cafeteria>) query).list();
	   
	    return results;
	}*/
	
	@SuppressWarnings("unchecked")
	public List<Cafeteria> getCountByServiceArea(Date dt) {
	    Session session = this.sessionFactory.getCurrentSession();
	   /* List<Cafeteria> results=session.createQuery("FROM Cafeteria")
	    		.setParameter("currentDate", dt)
	    		.list();*/
	    /*Criteria crit = session.createCriteria(Cafeteria.class);
		crit.add(Restrictions.eq("datetime",dt));*/
		CriteriaBuilder cb = session.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<Cafeteria> query = cb.createQuery(Cafeteria.class);
		Root<Cafeteria> root = query.from(Cafeteria.class);
		//query.select(root.get("serviceArea")).where(cb.equal(root.get("datetime"),dt));
		Predicate[] predicates = new Predicate[2];
		predicates[0] = cb.equal(root.get("datetime"),dt );
		predicates[1] = cb.equal(root.get("spacetype"), "service");
		query.select(root.get("peoplecount")).where(predicates);
		Query<Cafeteria> q = session.createQuery(query);
		List<Cafeteria> results = q.getResultList();
		return results;
	}
	@SuppressWarnings("unchecked")
	public List<Cafeteria> getCountByDiningArea(Date dt) {
	    Session session = this.sessionFactory.getCurrentSession();
	    CriteriaBuilder cb = session.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<Cafeteria> query = cb.createQuery(Cafeteria.class);
		Root<Cafeteria> root = query.from(Cafeteria.class);
		Predicate[] predicates = new Predicate[2];
		predicates[0] = cb.equal(root.get("datetime"),dt );
		predicates[1] = cb.equal(root.get("spacetype"), "dining");
		query.select(root.get("peoplecount")).where(predicates);
		//query.select(root.get("spacetype")).where(cb.equal(root.get("datetime"),dt));
		Query<Cafeteria> q = session.createQuery(query);
		List<Cafeteria> results = q.getResultList();
		return results;
	}

	@SuppressWarnings("unchecked")
	public List<Cafeteria> findAllByDatetimeBetween(Date startdate, Date enddate) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Cafeteria> results=session.createQuery("FROM Cafeteria AS c WHERE c.datetime BETWEEN :startdate AND :enddate ")
		.setParameter("startdate", startdate)
		.setParameter("enddate", enddate)
		.list();
		return results;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Cafeteria> findPeopleCountForDateRange(Date startdate, Date enddate) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Cafeteria> results=session.createQuery("SELECT peoplecount FROM Cafeteria AS c WHERE c.datetime BETWEEN :startdate AND :enddate ")
		.setParameter("startdate", startdate)
		.setParameter("enddate", enddate)
		.list();
		return results;
		
	}
	
	/*public List<Cafeteria> getTimeForDate(Date datetime) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Cafeteria.class);
		crit.add(Restrictions.eq("datetime",datetime));
		List<Cafeteria> results = crit.list();
		return results;
	}*/
	

	


}
