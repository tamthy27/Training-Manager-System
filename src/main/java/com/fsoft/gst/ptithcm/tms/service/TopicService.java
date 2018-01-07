/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.service;

import java.util.Date;
import java.util.List;

import com.fsoft.gst.ptithcm.tms.model.Topic;
import com.fsoft.gst.ptithcm.tms.model.Users;

/**
 * The Interface TopicService.
 * @author Thy Dinh Jun 13, 2017
 */
public interface TopicService {

	/**
	 * Find by id.
	 * 
	 * @param topicId
	 *            the topic id
	 * @return the topic
	 */
	Topic findById(String topicId);

	/**
	 * Save topic.
	 *
	 * @param topic
	 *            the topic
	 * @return the topic
	 */
	Topic saveTopic(Topic topic);

	/**
	 * Delete.
	 *
	 * @param unique
	 *            the unique
	 * @return the topic
	 */
	Topic delete(String unique);

	/**
	 * Delete login.
	 *
	 * @param unique
	 *            the unique
	 * @return the topic
	 */
	Topic deleteLogic(String unique);

	/**
	 * Update.
	 *
	 * @param topic
	 *            the topic
	 * @return the topic
	 */
	Topic update(Topic topic);

	/**
	 * Find all topic.
	 *
	 * @return the list
	 */
	List<Topic> findAllTopic();

	/**
	 * Find all topic.
	 *
	 * @param courseId
	 *            the course id
	 * @return the list
	 */
	List<Topic> findAllTopic(String courseId);
	
	/**
	 * Find all topic by trainer.
	 *
	 * @param trainerId the trainer id
	 * @return the list
	 */
	List<Topic> findAllTopicByTrainer(String trainerId);
	
	/**
	 * Find all topic.
	 * @param courseId the course id
	 * @param user the user
	 * @return the list
	 */
	List<Topic> findAllTopic(String courseId,Users user);
	
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
	 * Findlike.
	 *
	 * @param att
	 *            the att
	 * @param key
	 *            the key
	 * @param mode
	 *            the mode
	 * @return the list
	 */
	List<Topic> findlike(String att, String key, String mode);

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
	 * @param date the date
	 * @return the list
	 */
	List<Users> findAllTrainer(Date date);

	/**
	 * Assign trainer.
	 * 
	 * @param topic
	 *            the topic
	 * @return the users
	 */
	Users assignTrainer(Topic topic);
	
	
	List<Topic> getTopicByTrainerId(String id);
	
	List<Topic> findAllTopicNew();
	
	List<Topic>  getTopicCompletedByTrainerId(String id);
	
}
