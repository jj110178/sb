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

package com.liferay.live.sb.demo.service.persistence;

import com.liferay.live.sb.demo.model.CourseCatalog;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the course catalog service. This utility wraps {@link CourseCatalogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see CourseCatalogPersistence
 * @see CourseCatalogPersistenceImpl
 * @generated
 */
public class CourseCatalogUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(CourseCatalog courseCatalog) {
		getPersistence().clearCache(courseCatalog);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CourseCatalog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CourseCatalog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CourseCatalog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CourseCatalog update(CourseCatalog courseCatalog,
		boolean merge) throws SystemException {
		return getPersistence().update(courseCatalog, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CourseCatalog update(CourseCatalog courseCatalog,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(courseCatalog, merge, serviceContext);
	}

	/**
	* Caches the course catalog in the entity cache if it is enabled.
	*
	* @param courseCatalog the course catalog
	*/
	public static void cacheResult(
		com.liferay.live.sb.demo.model.CourseCatalog courseCatalog) {
		getPersistence().cacheResult(courseCatalog);
	}

	/**
	* Caches the course catalogs in the entity cache if it is enabled.
	*
	* @param courseCatalogs the course catalogs
	*/
	public static void cacheResult(
		java.util.List<com.liferay.live.sb.demo.model.CourseCatalog> courseCatalogs) {
		getPersistence().cacheResult(courseCatalogs);
	}

	/**
	* Creates a new course catalog with the primary key. Does not add the course catalog to the database.
	*
	* @param courseCatalogId the primary key for the new course catalog
	* @return the new course catalog
	*/
	public static com.liferay.live.sb.demo.model.CourseCatalog create(
		long courseCatalogId) {
		return getPersistence().create(courseCatalogId);
	}

	/**
	* Removes the course catalog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseCatalogId the primary key of the course catalog
	* @return the course catalog that was removed
	* @throws com.liferay.live.sb.demo.NoSuchCourseCatalogException if a course catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.CourseCatalog remove(
		long courseCatalogId)
		throws com.liferay.live.sb.demo.NoSuchCourseCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(courseCatalogId);
	}

	public static com.liferay.live.sb.demo.model.CourseCatalog updateImpl(
		com.liferay.live.sb.demo.model.CourseCatalog courseCatalog,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(courseCatalog, merge);
	}

	/**
	* Returns the course catalog with the primary key or throws a {@link com.liferay.live.sb.demo.NoSuchCourseCatalogException} if it could not be found.
	*
	* @param courseCatalogId the primary key of the course catalog
	* @return the course catalog
	* @throws com.liferay.live.sb.demo.NoSuchCourseCatalogException if a course catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.CourseCatalog findByPrimaryKey(
		long courseCatalogId)
		throws com.liferay.live.sb.demo.NoSuchCourseCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(courseCatalogId);
	}

	/**
	* Returns the course catalog with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param courseCatalogId the primary key of the course catalog
	* @return the course catalog, or <code>null</code> if a course catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.CourseCatalog fetchByPrimaryKey(
		long courseCatalogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(courseCatalogId);
	}

	/**
	* Returns all the course catalogs.
	*
	* @return the course catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.live.sb.demo.model.CourseCatalog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the course catalogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of course catalogs
	* @param end the upper bound of the range of course catalogs (not inclusive)
	* @return the range of course catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.live.sb.demo.model.CourseCatalog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the course catalogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of course catalogs
	* @param end the upper bound of the range of course catalogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of course catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.live.sb.demo.model.CourseCatalog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the course catalogs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of course catalogs.
	*
	* @return the number of course catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CourseCatalogPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CourseCatalogPersistence)PortletBeanLocatorUtil.locate(com.liferay.live.sb.demo.service.ClpSerializer.getServletContextName(),
					CourseCatalogPersistence.class.getName());

			ReferenceRegistry.registerReference(CourseCatalogUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CourseCatalogPersistence persistence) {
	}

	private static CourseCatalogPersistence _persistence;
}