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

package com.liferay.live.sb.demo.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the course student local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author dnebinger
 * @see CourseStudentLocalServiceUtil
 * @see com.liferay.live.sb.demo.service.base.CourseStudentLocalServiceBaseImpl
 * @see com.liferay.live.sb.demo.service.impl.CourseStudentLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CourseStudentLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CourseStudentLocalServiceUtil} to access the course student local service. Add custom service methods to {@link com.liferay.live.sb.demo.service.impl.CourseStudentLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the course student to the database. Also notifies the appropriate model listeners.
	*
	* @param courseStudent the course student
	* @return the course student that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent addCourseStudent(
		com.liferay.live.sb.demo.model.CourseStudent courseStudent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new course student with the primary key. Does not add the course student to the database.
	*
	* @param courseStudentPK the primary key for the new course student
	* @return the new course student
	*/
	public com.liferay.live.sb.demo.model.CourseStudent createCourseStudent(
		com.liferay.live.sb.demo.service.persistence.CourseStudentPK courseStudentPK);

	/**
	* Deletes the course student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseStudentPK the primary key of the course student
	* @return the course student that was removed
	* @throws PortalException if a course student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent deleteCourseStudent(
		com.liferay.live.sb.demo.service.persistence.CourseStudentPK courseStudentPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the course student from the database. Also notifies the appropriate model listeners.
	*
	* @param courseStudent the course student
	* @return the course student that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent deleteCourseStudent(
		com.liferay.live.sb.demo.model.CourseStudent courseStudent)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.live.sb.demo.model.CourseStudent fetchCourseStudent(
		com.liferay.live.sb.demo.service.persistence.CourseStudentPK courseStudentPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course student with the primary key.
	*
	* @param courseStudentPK the primary key of the course student
	* @return the course student
	* @throws PortalException if a course student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.live.sb.demo.model.CourseStudent getCourseStudent(
		com.liferay.live.sb.demo.service.persistence.CourseStudentPK courseStudentPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the course students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of course students
	* @param end the upper bound of the range of course students (not inclusive)
	* @return the range of course students
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.live.sb.demo.model.CourseStudent> getCourseStudents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course students.
	*
	* @return the number of course students
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCourseStudentsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the course student in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param courseStudent the course student
	* @return the course student that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent updateCourseStudent(
		com.liferay.live.sb.demo.model.CourseStudent courseStudent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the course student in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param courseStudent the course student
	* @param merge whether to merge the course student with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the course student that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent updateCourseStudent(
		com.liferay.live.sb.demo.model.CourseStudent courseStudent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	/**
	* findByCourseId
	*
	* @param courseId
	* @return List The list of course students.
	* @throws SystemException
	*/
	public java.util.List<com.liferay.live.sb.demo.model.CourseStudent> findByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* findByStudentId
	*
	* @param studentId
	* @return List The list of course students.
	* @throws SystemException
	*/
	public java.util.List<com.liferay.live.sb.demo.model.CourseStudent> findByStudentId(
		long studentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* getCourseStudent: Returns the course student.
	*
	* @param courseId
	* @param studentId
	* @return CourseStudent The course student or <code>null</code>.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.live.sb.demo.model.CourseStudent getCourseStudent(
		long courseId, long studentId);

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
	public boolean addNewCourseStudent(java.lang.Long courseId,
		java.lang.Long studentId, java.lang.Double grade, java.lang.Long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public boolean updateExistingCourseStudent(java.lang.Long courseId,
		java.lang.Long studentId, java.lang.Double grade, java.lang.Long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* deleteCourseStudent: Deletes the course student indirectly.
	*
	* @param courseId
	* @param studentId
	* @return boolean
	* @throws SystemException
	* @throws PortalException
	*/
	public boolean deleteExistingCourseStudent(java.lang.Long courseId,
		java.lang.Long studentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}