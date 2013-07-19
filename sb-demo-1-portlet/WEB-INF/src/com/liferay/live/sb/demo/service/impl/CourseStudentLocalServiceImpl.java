/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.live.sb.demo.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.live.sb.demo.model.CourseStudent;
import com.liferay.live.sb.demo.service.base.CourseStudentLocalServiceBaseImpl;
import com.liferay.live.sb.demo.service.persistence.CourseStudentPK;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the course student local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.live.sb.demo.service.CourseStudentLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author dnebinger
 * @see com.liferay.live.sb.demo.service.base.CourseStudentLocalServiceBaseImpl
 * @see com.liferay.live.sb.demo.service.CourseStudentLocalServiceUtil
 */
public class CourseStudentLocalServiceImpl extends CourseStudentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link com.liferay.live.sb.demo.service.CourseStudentLocalServiceUtil} to access the course student local service.
	 */
	private static final Log logger = LogFactoryUtil.getLog(CourseStudentLocalServiceImpl.class);

	/**
	 * findByCourseId
	 * 
	 * @param courseId
	 * @return List The list of course students.
	 * @throws SystemException
	 */
	public List<CourseStudent> findByCourseId(final long courseId) throws SystemException {
		return courseStudentPersistence.findByCourseId(courseId);
	}

	/**
	 * findByStudentId
	 * 
	 * @param studentId
	 * @return List The list of course students.
	 * @throws SystemException
	 */
	public List<CourseStudent> findByStudentId(final long studentId) throws SystemException {
		return courseStudentPersistence.findByStudentId(studentId);
	}

	/**
	 * getCourseStudent: Returns the course student.
	 * 
	 * @param courseId
	 * @param studentId
	 * @return CourseStudent The course student or <code>null</code>.
	 */
	public CourseStudent getCourseStudent(final long courseId, final long studentId) {
		final CourseStudentPK pk = new CourseStudentPK(studentId, courseId);

		CourseStudent cs = null;

		try {
			cs = getCourseStudent(pk);
		} catch (final PortalException e) {
			logger.error("Error retrieving course student: " + e.getMessage(), e);
		} catch (final SystemException e) {
			logger.error("Error retrieving course student: " + e.getMessage(), e);
		}

		return cs;
	}

	/**
	 * addCourseStudent: Adds a course student indirectly.
	 * 
	 * @param courseId
	 * @param studentId
	 * @param grade
	 * @param userId
	 * @return boolean
	 * @throws SystemException
	 */
	public boolean addNewCourseStudent(final Long courseId, final Long studentId, final Double grade, final Long userId) throws SystemException {

		final CourseStudentPK pk = new CourseStudentPK(studentId, courseId);

		final CourseStudent cs = createCourseStudent(pk);

		cs.setCreateDate(new Date());
		cs.setGrade(grade);
		cs.setModifiedDate(new Date());
		cs.setUserId(userId);

		addCourseStudent(cs);

		return true;
	}

	/**
	 * updateCourseStudent: Updates a course student indirectly.
	 * 
	 * @param courseId
	 * @param studentId
	 * @param grade
	 * @param userId
	 * @return boolean
	 * @throws SystemException
	 * @throws PortalException
	 */
	public boolean updateExistingCourseStudent(final Long courseId, final Long studentId, final Double grade, final Long userId) throws SystemException, PortalException {

		final CourseStudentPK pk = new CourseStudentPK(studentId, courseId);

		final CourseStudent cs = getCourseStudent(pk);

		if (cs == null) {
			return addNewCourseStudent(courseId, studentId, grade, userId);
		}

		cs.setGrade(grade);
		cs.setModifiedDate(new Date());
		cs.setUserId(userId);

		updateCourseStudent(cs, true);

		return true;
	}

	/**
	 * deleteCourseStudent: Deletes the course student indirectly.
	 * 
	 * @param courseId
	 * @param studentId
	 * @return boolean
	 * @throws SystemException
	 * @throws PortalException
	 */
	public boolean deleteExistingCourseStudent(final Long courseId, final Long studentId) throws SystemException, PortalException {
		final CourseStudentPK pk = new CourseStudentPK(studentId, courseId);

		deleteCourseStudent(pk);

		return true;
	}
}
