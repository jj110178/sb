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
 * The interface for the student g p a local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author dnebinger
 * @see StudentGPALocalServiceUtil
 * @see com.liferay.live.sb.demo.service.base.StudentGPALocalServiceBaseImpl
 * @see com.liferay.live.sb.demo.service.impl.StudentGPALocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface StudentGPALocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudentGPALocalServiceUtil} to access the student g p a local service. Add custom service methods to {@link com.liferay.live.sb.demo.service.impl.StudentGPALocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the student g p a to the database. Also notifies the appropriate model listeners.
	*
	* @param studentGPA the student g p a
	* @return the student g p a that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.StudentGPA addStudentGPA(
		com.liferay.live.sb.demo.model.StudentGPA studentGPA)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new student g p a with the primary key. Does not add the student g p a to the database.
	*
	* @param studentId the primary key for the new student g p a
	* @return the new student g p a
	*/
	public com.liferay.live.sb.demo.model.StudentGPA createStudentGPA(
		long studentId);

	/**
	* Deletes the student g p a with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student g p a
	* @return the student g p a that was removed
	* @throws PortalException if a student g p a with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.StudentGPA deleteStudentGPA(
		long studentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the student g p a from the database. Also notifies the appropriate model listeners.
	*
	* @param studentGPA the student g p a
	* @return the student g p a that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.StudentGPA deleteStudentGPA(
		com.liferay.live.sb.demo.model.StudentGPA studentGPA)
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
	public com.liferay.live.sb.demo.model.StudentGPA fetchStudentGPA(
		long studentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the student g p a with the primary key.
	*
	* @param studentId the primary key of the student g p a
	* @return the student g p a
	* @throws PortalException if a student g p a with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.live.sb.demo.model.StudentGPA getStudentGPA(
		long studentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the student g p as.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of student g p as
	* @param end the upper bound of the range of student g p as (not inclusive)
	* @return the range of student g p as
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.live.sb.demo.model.StudentGPA> getStudentGPAs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of student g p as.
	*
	* @return the number of student g p as
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getStudentGPAsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the student g p a in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param studentGPA the student g p a
	* @return the student g p a that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.StudentGPA updateStudentGPA(
		com.liferay.live.sb.demo.model.StudentGPA studentGPA)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the student g p a in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param studentGPA the student g p a
	* @param merge whether to merge the student g p a with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the student g p a that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.StudentGPA updateStudentGPA(
		com.liferay.live.sb.demo.model.StudentGPA studentGPA, boolean merge)
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
	* getStudentGPA: Returns the gpa for the given student in the given class.
	*
	* @param courseId
	* @param studentId
	* @return StudentGPA The gpa or <code>null</code> if it could not be calculated.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.live.sb.demo.model.StudentGPA getStudentGPA(
		long courseId, long studentId);

	/**
	* getAllStudentGPAs: Returns the list of gpas for all students.
	*
	* @return List The list of gpas.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.live.sb.demo.model.StudentGPA> getAllStudentGPAs();

	/**
	* getPoints: Returns the points for the given grade.
	*
	* @param grade
	* @return double The points.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getPoints(double grade);

	/**
	* getLetterGrade: Returns the letter grade for the given gpa value.
	*
	* @param gpa
	* @return String The letter grade.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getLetterGrade(double gpa);
}