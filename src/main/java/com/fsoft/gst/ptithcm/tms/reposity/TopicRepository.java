package com.fsoft.gst.ptithcm.tms.reposity;

import java.util.Date;
import java.util.List;

import com.fsoft.gst.ptithcm.tms.model.Topic;
import com.fsoft.gst.ptithcm.tms.model.Users;

// TODO: Auto-generated Javadoc
/**
 * The Interface TopicRepository.
 */
public interface TopicRepository extends GenericRepository<String, Topic> {

	/**
	 * Find all topic new.
	 *
	 * @param courseId
	 *            the course id
	 * @return the list
	 */
	List<Topic> findAllTopicNew(String courseId);

	/**
	 * Find all topic completed.
	 *
	 * @param courseId
	 *            the course id
	 * @return the list
	 */
	List<Topic> findAllTopicCompleted(String courseId);

	/**
	 * Find all topic.
	 *
	 * @param courseId
	 *            the course id
	 * @param user
	 *            the user
	 * @return the list
	 */
	List<Topic> findAllTopic(String courseId, Users user);

	/**
	 * Find all topic by trainer.
	 *
	 * @param trainerId the trainer id
	 * @return the list
	 */
	List<Topic> findAllTopicByTrainer(String trainerId);

	/**
	 * Gets the trainer.
	 *
	 * @param topicId
	 *            the topic id
	 * @return the trainer
	 */
	Users getTrainer(String topicId);

	/**
	 * Find all trainer.
	 * 
	 * @param date
	 *            the date
	 * @return the list
	 */
	List<Users> findAllTrainer(Date date);
	
	List<Topic> findTopicByTrainerID(String id);
	
	List<Topic> findAllTopicNew();
	
	List<Topic> findAllTopicCompletedByTrainerID(String id);

}
