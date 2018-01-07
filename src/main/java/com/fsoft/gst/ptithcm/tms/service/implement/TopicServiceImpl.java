/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.service.implement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.gst.ptithcm.tms.commonUltil.SessionUtil;
import com.fsoft.gst.ptithcm.tms.model.Topic;
import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.reposity.TopicRepository;
import com.fsoft.gst.ptithcm.tms.service.TopicService;

// TODO: Auto-generated Javadoc
/**
 * The Class TopicServiceImpl.
 *
 * @author Thy Dinh Jun 13, 2017
 */

@Service("topicService")
@Transactional
public class TopicServiceImpl implements TopicService {
	/** The reposity. */
	@Autowired
	private TopicRepository reposity;

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#saveTopic(com.fsoft.gst.ptithcm.tms.model.Topic)
	 */
	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.TopicService#saveTopic(com.fsoft.gst.
	 * ptithcm.tms.model.Topic)
	 */
	@Override
	public Topic saveTopic(Topic topic) {
		return reposity.save(topic);
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#delete(java.lang.String)
	 */
	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.TopicService#delete(java.lang.String)
	 */
	@Override
	public Topic delete(String unique) {
		Topic entity = reposity.getByKey(unique);
		if (entity != null) {
			reposity.delete(entity);
		}
		return entity;
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#deleteLogic(java.lang.String)
	 */
	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.TopicService#deleteLogin(java.lang.
	 * String)
	 */
	@Override
	public Topic deleteLogic(String unique) {
		Topic entity = reposity.getByKey(unique);
		if (entity != null) {
			entity.getLog().setLastModifiedBy(SessionUtil.getUserSession());
			entity.getLog().setLastModifiedDate(new Date());
			entity.getLog().setFlagDelete(true);
			reposity.update(entity);
		}
		return entity;
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#update(com.fsoft.gst.ptithcm.tms.model.Topic)
	 */
	/*
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#update(com.fsoft.gst.
	 * ptithcm.tms.model.Topic)
	 */
	@Override
	public Topic update(Topic topic) {
		Topic entity = reposity.getByKey(topic.getTopicId());
		if (entity != null) {
			entity.setName(topic.getName());
			entity.setDescription(topic.getDescription());
			entity.setTime(topic.getTime());
			entity.getLog().setLastModifiedBy(SessionUtil.getUserSession());
			entity.getLog().setLastModifiedDate(new Date());
			reposity.update(entity);
		}
		return entity;
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#findAllTopic()
	 */
	/*
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#findAllTopic()
	 */
	@Override
	public List<Topic> findAllTopic() {
		return reposity.findByProperty("log.flagDelete", false);
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#findlike(java.lang.String, java.lang.String, java.lang.String)
	 */
	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.TopicService#findlike(java.lang.String)
	 */
	@Override
	public List<Topic> findlike(String att, String key, String mode) {
		if (mode.equals("1")) {
			return reposity.findLike(att, key);
		} else {
			if (mode.equals("2")) {
				return reposity.findStartWith(att, key);
			} else {
				return reposity.findByProperty2(att, key);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#findAllTopic(java.lang.String)
	 */
	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.TopicService#findAllTopic(java.lang.
	 * String)
	 */
	@Override
	public List<Topic> findAllTopic(String courseId) {
		return reposity.findByProperty("course", courseId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.TopicService#findAllTopic(java.lang.
	 * String, com.fsoft.gst.ptithcm.tms.model.Users)
	 */
	@Override
	public List<Topic> findAllTopic(String courseId, Users user) {
		return reposity.findAllTopic(courseId, user);
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#findAllTopicNew(java.lang.String)
	 */
	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.TopicService#findAllTopicNew(java.lang.
	 * String)
	 */
	@Override
	public List<Topic> findAllTopicNew(String courseId) {
		return reposity.findAllTopicNew(courseId);
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#findAllTopicCompleted(java.lang.String)
	 */
	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.TopicService#findAllTopicCompleted(java
	 * .lang.String)
	 */
	@Override
	public List<Topic> findAllTopicCompleted(String courseId) {
		return reposity.findAllTopicCompleted(courseId);
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#findById(java.lang.String)
	 */
	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.TopicService#findById(java.lang.String)
	 */
	@Override
	public Topic findById(String topicId) {
		return reposity.getByKey(topicId);
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#getTrainer(java.lang.String)
	 */
	/*
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#getTrainer(java.lang.
	 * String)
	 */
	@Override
	public Users getTrainer(String topicId) {
		return reposity.getTrainer(topicId);
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#findAllTrainer(java.util.Date)
	 */
	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.TopicService#findAllTrainer(java.util.
	 * Date)
	 */
	@Override
	public List<Users> findAllTrainer(Date date) {
		return reposity.findAllTrainer(date);
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#assignTrainer(com.fsoft.gst.ptithcm.tms.model.Topic)
	 */
	/*
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.TopicService#assignTrainer(com.fsoft.
	 * gst.ptithcm.tms.model.Topic)
	 */
	@Override
	public Users assignTrainer(Topic topic) {
		reposity.update(topic);
		return topic.getUsers();
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#getTopicByTrainerId(java.lang.String)
	 */
	@Override
	public List<Topic> getTopicByTrainerId(String id) {
		return reposity.findTopicByTrainerID(id);
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#findAllTopicNew()
	 */
	@Override
	public List<Topic> findAllTopicNew() {
		return reposity.findAllTopicNew();
	}

	/* (non-Javadoc)
	 * @see com.fsoft.gst.ptithcm.tms.service.TopicService#getTopicCompletedByTrainerId(java.lang.String)
	 */
	@Override
	public List<Topic> getTopicCompletedByTrainerId(String id) {
		return reposity.findAllTopicCompletedByTrainerID(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fsoft.gst.ptithcm.tms.service.TopicService#findAllTopicByTrainer(java
	 * .lang.String)
	 */
	@Override
	public List<Topic> findAllTopicByTrainer(String trainerId) {
		return reposity.findAllTopicByTrainer(trainerId);
	}
}
