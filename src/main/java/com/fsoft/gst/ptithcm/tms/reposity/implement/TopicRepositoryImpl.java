package com.fsoft.gst.ptithcm.tms.reposity.implement;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.gst.ptithcm.tms.commonUltil.RoleUtil;
import com.fsoft.gst.ptithcm.tms.model.Topic;
import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.reposity.TopicRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class TopicRepositoryImpl.
 */
@Repository("topicRepository")
@Transactional
@EnableTransactionManagement
@SuppressWarnings("unchecked")
public class TopicRepositoryImpl extends AbstractRepository<String, Topic> implements TopicRepository {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.reposity.implement.AbstractRepository#
	 * findByProperty(java.lang.String, java.lang.Object)
	 */
	/*
	 * @see com.fsoft.gst.ptithcm.tms.reposity.implement.AbstractRepository#
	 * findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<Topic> findByProperty(String propertyName, Object value) {
		Criteria crit = getSession().createCriteria(Topic.class, "topic");
		crit.createAlias("topic.log", "log");
		crit.add(Restrictions.eq("log.flagDelete", false));
		return crit.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.reposity.implement.AbstractRepository#
	 * findProperty(java.lang.String, java.lang.Object)
	 */
	/*
	 * @see com.fsoft.gst.ptithcm.tms.reposity.implement.AbstractRepository#
	 * findProperty(java.lang.String, java.lang.Object)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.reposity.implement.AbstractRepository#
	 * findProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<Topic> findProperty(String property, Object value) {
		String strQuery = " from Topic topic where topic." + property + " = '" + value + "' and topic.log.flagDelete = false "
				+ "  ORDER BY topic.time ASC";
		Query query = getSession().createQuery(strQuery);
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.TopicRepository#findAllTopicNew(java.
	 * lang.String)
	 */
	/*
	 * @see com.fsoft.gst.ptithcm.tms.reposity.TopicRepository#
	 * findAllTopicNew(java.lang.String)
	 */
	@Override
	public List<Topic> findAllTopicNew(String courseId) {
		String strQuery = " from Topic topic where topic.course = '" + courseId + "' " + " and topic.time > :date"
										+ " and topic.log.flagDelete = false  ORDER BY topic.time ASC";
		Query query = getSession().createQuery(strQuery);
		query.setParameter("date", new Date());
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.TopicRepository#findAllTopicCompleted(
	 * java.lang.String)
	 */
	/*
	 * @see com.fsoft.gst.ptithcm.tms.reposity.TopicRepository#
	 * findAllTopicCompleted(java.lang.String)
	 */
	@Override
	public List<Topic> findAllTopicCompleted(String courseId) {
		String strQuery = " from Topic topic where topic.course = '" + courseId + "' and topic.time <= :date"
				+ " and topic.log.flagDelete = false  ORDER BY topic.time ASC";
		Query query = getSession().createQuery(strQuery);
		query.setParameter("date", new Date());
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.TopicRepository#getTrainer(java.lang.
	 * String)
	 */
	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.TopicRepository#getTrainer(java.lang.
	 * String)
	 */
	@Override
	public Users getTrainer(String topicId) {
		String strQuery = "select topic.users from Topic topic where topic.topicId = '" + topicId + "'"
				+ " and topic.log.flagDelete = false  ORDER BY topic.time ASC" ;
		Query query = getSession().createQuery(strQuery);
		return (Users) query.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.TopicRepository#findAllTrainer(java.
	 * util.Date)
	 */
	@Override
	public List<Users> findAllTrainer(Date date) {
		String strQuery = "from Users user where user.role = '" + RoleUtil.ROLE_TRAINER.getRoleUtil() + "'"
				+ " and user.id NOT IN (select topic.users.id from Topic topic where " + " topic.users.id = user.id " + " and topic.log.flagDelete = false"
				+ " and topic.time = :date )" + " and user.log.flagDelete = false  ORDER BY topic.time ASC";
		Query query = getSession().createQuery(strQuery);
		query.setParameter("date", date);
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.TopicRepository#findAllTopic(java.lang
	 * .String, com.fsoft.gst.ptithcm.tms.model.Users)
	 */
	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.TopicRepository#findAllTopic(java.lang
	 * .String, com.fsoft.gst.ptithcm.tms.model.Users)
	 */
	@Override
	public List<Topic> findAllTopic(String courseId, Users user) {
		String strQuery = " from Topic topic where topic.course = '" + courseId + "' " + " and topic.users = '" + user.getId()
				+ "' and topic.log.flagDelete = false  ORDER BY topic.time ASC";
		Query query = getSession().createQuery(strQuery);
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.TopicRepository#findAllTopicByTrainer(
	 * java.lang.String)
	 */
	@Override
	public List<Topic> findAllTopicByTrainer(String trainerId) {
		String strQuery = " from Topic topic where topic.users.id = '" + trainerId + "' " + " and topic.users.role = '" + RoleUtil.ROLE_TRAINER.getRoleUtil()
				+ "' and topic.log.flagDelete = false  ORDER BY topic.time ASC";
		Query query = getSession().createQuery(strQuery);
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.reposity.TopicRepository#findTopicByTrainerID(
	 * java.lang.String)
	 */
	@Override
	public List<Topic> findTopicByTrainerID(String id) {
		String strQuery = " from Topic topic where topic.users = '" + id + "' " + " and topic.time > :date "
				+ " and topic.log.flagDelete = false ORDER BY topic.time ASC ";
		Query query = getSession().createQuery(strQuery);
		query.setParameter("date", new Date());
		return query.list();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.reposity.TopicRepository#findAllTopicNew()
	 */
	@Override
	public List<Topic> findAllTopicNew() {
		String strQuery = " from Topic topic where topic.time > :date" + " and topic.log.flagDelete = false  ORDER BY topic.time ASC";
		Query query = getSession().createQuery(strQuery);
		query.setParameter("date", new Date());
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsoft.gst.ptithcm.tms.reposity.TopicRepository#
	 * findAllTopicCompletedByTrainerID(java.lang.String)
	 */
	@Override
	public List<Topic> findAllTopicCompletedByTrainerID(String id) {
		String strQuery = " from Topic topic where topic.users = '" + id + "' and topic.time <= :date "
				+ "  and topic.log.flagDelete = false ORDER BY topic.time ASC";
		Query query = getSession().createQuery(strQuery);
		query.setParameter("date", new Date());
		return query.list();
	}

}
