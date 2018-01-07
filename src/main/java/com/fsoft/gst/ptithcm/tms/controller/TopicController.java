/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fsoft.gst.ptithcm.tms.model.Course;
import com.fsoft.gst.ptithcm.tms.model.Topic;
import com.fsoft.gst.ptithcm.tms.service.CourseService;
import com.fsoft.gst.ptithcm.tms.service.TopicService;

/**
 * The Class TopicController.
 *
 * @author Thy Dinh Jun 13, 2017
 */

@Controller
@RequestMapping(value = { "/topic" })
public class TopicController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(TopicController.class);

	/** The course service. */
	@Autowired
	private CourseService courseService;

	/** The topic service. */
	@Autowired
	private TopicService topicService;

	/**
	 * List topic.
	 *
	 * @param model
	 *            the model
	 * @param courseId
	 *            the course id
	 * @return the string
	 */
	@RequestMapping(value = { "/list-topic/{courseId}" }, method = RequestMethod.GET)
	public String listTopic(ModelMap model, @PathVariable("courseId") String courseId) {
		LOGGER.info("Topic");
		Course course = courseService.findById(courseId);
		List<Topic> topicNew = topicService.findAllTopicNew(courseId);
		List<Topic> topicCompleted = topicService.findAllTopicCompleted(courseId);
		model.addAttribute("course", course);
		model.addAttribute("topicNew", topicNew);
		model.addAttribute("topicCompleted", topicCompleted);
		return "staff-topic";
	}

	/**
	 * Creates the category.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = { "/create-topic" }, method = RequestMethod.GET)
	public String createCategory(ModelMap model) {
		LOGGER.info("crate topic");
		List<Topic> listTopic = topicService.findAllTopic();
		model.addAttribute("listtopic", listTopic);
		return "staff-topic";
	}

}
