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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link InstructorLocalService}.
 * </p>
 *
 * @author    dnebinger
 * @see       InstructorLocalService
 * @generated
 */
public class InstructorLocalServiceWrapper implements InstructorLocalService,
	ServiceWrapper<InstructorLocalService> {
	public InstructorLocalServiceWrapper(
		InstructorLocalService instructorLocalService) {
		_instructorLocalService = instructorLocalService;
	}

	/**
	* Adds the instructor to the database. Also notifies the appropriate model listeners.
	*
	* @param instructor the instructor
	* @return the instructor that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Instructor addInstructor(
		com.liferay.live.sb.demo.model.Instructor instructor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instructorLocalService.addInstructor(instructor);
	}

	/**
	* Creates a new instructor with the primary key. Does not add the instructor to the database.
	*
	* @param instructorId the primary key for the new instructor
	* @return the new instructor
	*/
	public com.liferay.live.sb.demo.model.Instructor createInstructor(
		long instructorId) {
		return _instructorLocalService.createInstructor(instructorId);
	}

	/**
	* Deletes the instructor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param instructorId the primary key of the instructor
	* @return the instructor that was removed
	* @throws PortalException if a instructor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Instructor deleteInstructor(
		long instructorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _instructorLocalService.deleteInstructor(instructorId);
	}

	/**
	* Deletes the instructor from the database. Also notifies the appropriate model listeners.
	*
	* @param instructor the instructor
	* @return the instructor that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Instructor deleteInstructor(
		com.liferay.live.sb.demo.model.Instructor instructor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instructorLocalService.deleteInstructor(instructor);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _instructorLocalService.dynamicQuery();
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instructorLocalService.dynamicQuery(dynamicQuery);
	}

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
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _instructorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instructorLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instructorLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.live.sb.demo.model.Instructor fetchInstructor(
		long instructorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instructorLocalService.fetchInstructor(instructorId);
	}

	/**
	* Returns the instructor with the primary key.
	*
	* @param instructorId the primary key of the instructor
	* @return the instructor
	* @throws PortalException if a instructor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Instructor getInstructor(
		long instructorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _instructorLocalService.getInstructor(instructorId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _instructorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the instructors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of instructors
	* @param end the upper bound of the range of instructors (not inclusive)
	* @return the range of instructors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Instructor> getInstructors(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instructorLocalService.getInstructors(start, end);
	}

	/**
	* Returns the number of instructors.
	*
	* @return the number of instructors
	* @throws SystemException if a system exception occurred
	*/
	public int getInstructorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instructorLocalService.getInstructorsCount();
	}

	/**
	* Updates the instructor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param instructor the instructor
	* @return the instructor that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Instructor updateInstructor(
		com.liferay.live.sb.demo.model.Instructor instructor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instructorLocalService.updateInstructor(instructor);
	}

	/**
	* Updates the instructor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param instructor the instructor
	* @param merge whether to merge the instructor with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the instructor that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Instructor updateInstructor(
		com.liferay.live.sb.demo.model.Instructor instructor, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instructorLocalService.updateInstructor(instructor, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _instructorLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_instructorLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _instructorLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public InstructorLocalService getWrappedInstructorLocalService() {
		return _instructorLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedInstructorLocalService(
		InstructorLocalService instructorLocalService) {
		_instructorLocalService = instructorLocalService;
	}

	public InstructorLocalService getWrappedService() {
		return _instructorLocalService;
	}

	public void setWrappedService(InstructorLocalService instructorLocalService) {
		_instructorLocalService = instructorLocalService;
	}

	private InstructorLocalService _instructorLocalService;
}