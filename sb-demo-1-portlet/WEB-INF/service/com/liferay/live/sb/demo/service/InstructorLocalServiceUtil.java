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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the instructor local service. This utility wraps {@link com.liferay.live.sb.demo.service.impl.InstructorLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author dnebinger
 * @see InstructorLocalService
 * @see com.liferay.live.sb.demo.service.base.InstructorLocalServiceBaseImpl
 * @see com.liferay.live.sb.demo.service.impl.InstructorLocalServiceImpl
 * @generated
 */
public class InstructorLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.live.sb.demo.service.impl.InstructorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the instructor to the database. Also notifies the appropriate model listeners.
	*
	* @param instructor the instructor
	* @return the instructor that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Instructor addInstructor(
		com.liferay.live.sb.demo.model.Instructor instructor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addInstructor(instructor);
	}

	/**
	* Creates a new instructor with the primary key. Does not add the instructor to the database.
	*
	* @param instructorId the primary key for the new instructor
	* @return the new instructor
	*/
	public static com.liferay.live.sb.demo.model.Instructor createInstructor(
		long instructorId) {
		return getService().createInstructor(instructorId);
	}

	/**
	* Deletes the instructor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param instructorId the primary key of the instructor
	* @return the instructor that was removed
	* @throws PortalException if a instructor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Instructor deleteInstructor(
		long instructorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteInstructor(instructorId);
	}

	/**
	* Deletes the instructor from the database. Also notifies the appropriate model listeners.
	*
	* @param instructor the instructor
	* @return the instructor that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Instructor deleteInstructor(
		com.liferay.live.sb.demo.model.Instructor instructor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteInstructor(instructor);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.liferay.live.sb.demo.model.Instructor fetchInstructor(
		long instructorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchInstructor(instructorId);
	}

	/**
	* Returns the instructor with the primary key.
	*
	* @param instructorId the primary key of the instructor
	* @return the instructor
	* @throws PortalException if a instructor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Instructor getInstructor(
		long instructorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getInstructor(instructorId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.liferay.live.sb.demo.model.Instructor> getInstructors(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getInstructors(start, end);
	}

	/**
	* Returns the number of instructors.
	*
	* @return the number of instructors
	* @throws SystemException if a system exception occurred
	*/
	public static int getInstructorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getInstructorsCount();
	}

	/**
	* Updates the instructor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param instructor the instructor
	* @return the instructor that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Instructor updateInstructor(
		com.liferay.live.sb.demo.model.Instructor instructor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateInstructor(instructor);
	}

	/**
	* Updates the instructor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param instructor the instructor
	* @param merge whether to merge the instructor with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the instructor that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Instructor updateInstructor(
		com.liferay.live.sb.demo.model.Instructor instructor, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateInstructor(instructor, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static InstructorLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					InstructorLocalService.class.getName());

			if (invokableLocalService instanceof InstructorLocalService) {
				_service = (InstructorLocalService)invokableLocalService;
			}
			else {
				_service = new InstructorLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(InstructorLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(InstructorLocalService service) {
	}

	private static InstructorLocalService _service;
}