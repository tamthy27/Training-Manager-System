/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.controller.ajax;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsoft.gst.ptithcm.tms.commonUltil.Constants;
import com.fsoft.gst.ptithcm.tms.commonUltil.DateUtil;
import com.fsoft.gst.ptithcm.tms.commonUltil.DeleteConstants;
import com.fsoft.gst.ptithcm.tms.commonUltil.LogUltil;
import com.fsoft.gst.ptithcm.tms.controller.CategoryController;
import com.fsoft.gst.ptithcm.tms.model.Course;
import com.fsoft.gst.ptithcm.tms.model.ProfileUser;
import com.fsoft.gst.ptithcm.tms.model.TraineeCourse;
import com.fsoft.gst.ptithcm.tms.model.TraineeCourseId;
import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.service.CourseService;
import com.fsoft.gst.ptithcm.tms.service.TraineeCourseService;
import com.fsoft.gst.ptithcm.tms.service.UsersService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * The Class CourseControllerAjax.
 * @author NVTT Jun 13, 2017
 */
@RestController
@RequestMapping(value = { "/course" })
public class CourseControllerAjax {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(CategoryController.class);

	/** The course service. */
	@Autowired
	private CourseService courseService;

	/** The trainee course service. */
	@Autowired
	private TraineeCourseService traineeCourseService;

	/** The user service. */
	@Autowired
	private UsersService userService;

	/**
	 * List course new.
	 *
	 * @param categoryId
	 *            the category id
	 * @return the string
	 */
	@RequestMapping(value = { "/list-course-new/{categoryId}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String listCourseNew(@PathVariable("categoryId") String categoryId) {
		LOGGER.info("list new Course");
		List<Course> category = courseService.findCourseNewStatus(categoryId, false);
		List<String> temp = new ArrayList<>();
		for (Course cat : category) {
			temp.add(cat.toString());
		}
		return new Gson().toJson(temp);
	}

	/**
	 * List course processing.
	 *
	 * @param categoryId
	 *            the category id
	 * @return the string
	 */
	@RequestMapping(value = { "/list-course-processing/{categoryId}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String listCourseProcessing(@PathVariable("categoryId") String categoryId) {
		LOGGER.info("list new Course");

		List<Course> category = courseService.findCourseProcessingStatus(categoryId, false);
		List<String> temp = new ArrayList<>();
		for (Course cat : category) {
			temp.add(cat.toString());
		}
		return new Gson().toJson(temp);
	}

	/**
	 * List course completed.
	 *
	 * @param categoryId
	 *            the category id
	 * @return the string
	 */
	@RequestMapping(value = { "/list-course-completed/{categoryId}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String listCourseCompleted(@PathVariable("categoryId") String categoryId) {
		LOGGER.info("list new Course");
		List<Course> category = courseService.findCourseCompletedStatus(categoryId, false);
		List<String> temp = new ArrayList<>();
		for (Course cat : category) {
			temp.add(cat.toString());
		}
		return new Gson().toJson(temp);
	}

	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 * @param type
	 *            the type
	 * @return the string
	 */
	@RequestMapping(value = { "/delete/{id}/{type}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String delete(@PathVariable("id") String id, @PathVariable("type") String type) {

		Course course = null;
		if (DeleteConstants.DELETE_HARD.equals(type)) {
			course = courseService.delete(id);
		} else if (DeleteConstants.DELETE_SORT.equals(type)) {

			course = courseService.deleteLogic(id);
		}

		String result = "";
		try {
			result = course.toString();
		} catch (Exception e) {

		}
		return result;
	}

	/**
	 * List course by category.
	 *
	 * @param categoryId
	 *            the category id
	 * @return the string
	 */
	@RequestMapping(value = { "/list-course-category/{categoryId}" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String listCourseByCategory(@PathVariable("categoryId") String categoryId) {
		LOGGER.info("list new Course");
		List<Course> category = courseService.findAllCourseByCategory(categoryId, false);
		List<String> temp = new ArrayList<>();
		for (Course cat : category) {
			temp.add(cat.toString());
		}
		return new Gson().toJson(temp);
	}

	/**
	 * Adds the course.
	 *
	 * @param course
	 *            the course
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 * @return the string
	 */
	@RequestMapping(value = { "/add-course" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String addCourse(@RequestBody Course course, @RequestParam("start") String start, @RequestParam("end") String end) {
		Course entity = null;
		if (course != null) {
			try {
				course.setStartDate(DateUtil.string2Date(start, Constants.DATE_FORMAT));
				course.setEndDate(DateUtil.string2Date(end, Constants.DATE_FORMAT));
				course.setLog(LogUltil.newLog());

			} catch (ParseException e) {
				e.printStackTrace();
			}

			entity = courseService.addNewCourse(course);

		}
		return entity.toString();
	}

	/**
	 * Edits the course.
	 *
	 * @param course
	 *            the course
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 * @return the string
	 */
	@RequestMapping(value = { "/edit-course" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String editCourse(@RequestBody Course course, @RequestParam("start") String start, @RequestParam("end") String end) {
		Course entity = null;
		if (course != null) {
			try {
				course.setStartDate(DateUtil.string2Date(start, Constants.DATE_FORMAT));
				course.setEndDate(DateUtil.string2Date(end, Constants.DATE_FORMAT));
				course.setLog(LogUltil.newLog());

			} catch (ParseException e) {
				e.printStackTrace();
			}

			entity = courseService.addNewCourse(course);

		}
		return entity.toString();
	}

	
	/**
	 * Removes the trainee.
	 *
	 * @param userId the user id
	 * @param courseId the course id
	 * @return the int
	 */
	@RequestMapping(value = { "/remove-trainee/{userId}/{courseId}" })
	@ResponseBody
	public int removeTrainee(@PathVariable("userId") Integer userId, @PathVariable("courseId") String courseId) {
		return traineeCourseService.remove(userId, courseId);
	}
	
	@RequestMapping(value = { "/remove-all-trainee/{courseId}" })
	@ResponseBody
	public int removeAllTrainee( @RequestBody List<String>  listUser, @PathVariable("courseId") String courseId) {
		int count = 0;
		for (String id : listUser) {
			try {
				traineeCourseService.remove(Integer.parseInt(id), courseId);
				count++;
			} catch (Exception e) {
				LOGGER.error(e);
			}
		}
		return count;
	}
	
	/**
	 * Adds the trainee.
	 * @param userId the user id
	 * @param courseId the course id
	 * @return the string
	 */
	@RequestMapping(value = { "/add-trainee/{userId}/{courseId}" }, method = RequestMethod.POST)
	@ResponseBody
	public String addTrainee(@PathVariable("userId") Integer userId, @PathVariable("courseId") String courseId) {
		Users trainee = userService.findById(userId);
		Course course = courseService.findById(courseId);
		if (trainee != null && course != null) {
			TraineeCourse traineeCourse = new TraineeCourse();
			TraineeCourseId traineeCourseId = new TraineeCourseId(trainee.getId(), course.getCourseId());
			traineeCourse.setId(traineeCourseId);
			traineeCourse.setCourse(course);
			traineeCourse.setUsers(trainee);
			traineeCourseService.insertTraineeCourse(traineeCourse);
		}
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("userID", trainee.getId());
		jsonObject.addProperty("username", trainee.getUsername());
		for (ProfileUser profile : trainee.getProfileUsers()) {
			jsonObject.addProperty(profile.getProfile().getName(), profile.getValue());
		}
		return jsonObject.toString();
	}
}
