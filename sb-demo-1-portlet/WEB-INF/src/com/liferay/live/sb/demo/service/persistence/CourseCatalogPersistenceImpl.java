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

import com.liferay.live.sb.demo.NoSuchCourseCatalogException;
import com.liferay.live.sb.demo.model.CourseCatalog;
import com.liferay.live.sb.demo.model.impl.CourseCatalogImpl;
import com.liferay.live.sb.demo.model.impl.CourseCatalogModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the course catalog service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see CourseCatalogPersistence
 * @see CourseCatalogUtil
 * @generated
 */
public class CourseCatalogPersistenceImpl extends BasePersistenceImpl<CourseCatalog>
	implements CourseCatalogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CourseCatalogUtil} to access the course catalog persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CourseCatalogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CourseCatalogModelImpl.ENTITY_CACHE_ENABLED,
			CourseCatalogModelImpl.FINDER_CACHE_ENABLED,
			CourseCatalogImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CourseCatalogModelImpl.ENTITY_CACHE_ENABLED,
			CourseCatalogModelImpl.FINDER_CACHE_ENABLED,
			CourseCatalogImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseCatalogModelImpl.ENTITY_CACHE_ENABLED,
			CourseCatalogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the course catalog in the entity cache if it is enabled.
	 *
	 * @param courseCatalog the course catalog
	 */
	public void cacheResult(CourseCatalog courseCatalog) {
		EntityCacheUtil.putResult(CourseCatalogModelImpl.ENTITY_CACHE_ENABLED,
			CourseCatalogImpl.class, courseCatalog.getPrimaryKey(),
			courseCatalog);

		courseCatalog.resetOriginalValues();
	}

	/**
	 * Caches the course catalogs in the entity cache if it is enabled.
	 *
	 * @param courseCatalogs the course catalogs
	 */
	public void cacheResult(List<CourseCatalog> courseCatalogs) {
		for (CourseCatalog courseCatalog : courseCatalogs) {
			if (EntityCacheUtil.getResult(
						CourseCatalogModelImpl.ENTITY_CACHE_ENABLED,
						CourseCatalogImpl.class, courseCatalog.getPrimaryKey()) == null) {
				cacheResult(courseCatalog);
			}
			else {
				courseCatalog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all course catalogs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CourseCatalogImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CourseCatalogImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course catalog.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CourseCatalog courseCatalog) {
		EntityCacheUtil.removeResult(CourseCatalogModelImpl.ENTITY_CACHE_ENABLED,
			CourseCatalogImpl.class, courseCatalog.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CourseCatalog> courseCatalogs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CourseCatalog courseCatalog : courseCatalogs) {
			EntityCacheUtil.removeResult(CourseCatalogModelImpl.ENTITY_CACHE_ENABLED,
				CourseCatalogImpl.class, courseCatalog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new course catalog with the primary key. Does not add the course catalog to the database.
	 *
	 * @param courseCatalogId the primary key for the new course catalog
	 * @return the new course catalog
	 */
	public CourseCatalog create(long courseCatalogId) {
		CourseCatalog courseCatalog = new CourseCatalogImpl();

		courseCatalog.setNew(true);
		courseCatalog.setPrimaryKey(courseCatalogId);

		return courseCatalog;
	}

	/**
	 * Removes the course catalog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param courseCatalogId the primary key of the course catalog
	 * @return the course catalog that was removed
	 * @throws com.liferay.live.sb.demo.NoSuchCourseCatalogException if a course catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CourseCatalog remove(long courseCatalogId)
		throws NoSuchCourseCatalogException, SystemException {
		return remove(Long.valueOf(courseCatalogId));
	}

	/**
	 * Removes the course catalog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course catalog
	 * @return the course catalog that was removed
	 * @throws com.liferay.live.sb.demo.NoSuchCourseCatalogException if a course catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCatalog remove(Serializable primaryKey)
		throws NoSuchCourseCatalogException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CourseCatalog courseCatalog = (CourseCatalog)session.get(CourseCatalogImpl.class,
					primaryKey);

			if (courseCatalog == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseCatalogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(courseCatalog);
		}
		catch (NoSuchCourseCatalogException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CourseCatalog removeImpl(CourseCatalog courseCatalog)
		throws SystemException {
		courseCatalog = toUnwrappedModel(courseCatalog);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, courseCatalog);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(courseCatalog);

		return courseCatalog;
	}

	@Override
	public CourseCatalog updateImpl(
		com.liferay.live.sb.demo.model.CourseCatalog courseCatalog,
		boolean merge) throws SystemException {
		courseCatalog = toUnwrappedModel(courseCatalog);

		boolean isNew = courseCatalog.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, courseCatalog, merge);

			courseCatalog.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(CourseCatalogModelImpl.ENTITY_CACHE_ENABLED,
			CourseCatalogImpl.class, courseCatalog.getPrimaryKey(),
			courseCatalog);

		return courseCatalog;
	}

	protected CourseCatalog toUnwrappedModel(CourseCatalog courseCatalog) {
		if (courseCatalog instanceof CourseCatalogImpl) {
			return courseCatalog;
		}

		CourseCatalogImpl courseCatalogImpl = new CourseCatalogImpl();

		courseCatalogImpl.setNew(courseCatalog.isNew());
		courseCatalogImpl.setPrimaryKey(courseCatalog.getPrimaryKey());

		courseCatalogImpl.setCourseCatalogId(courseCatalog.getCourseCatalogId());
		courseCatalogImpl.setUserId(courseCatalog.getUserId());
		courseCatalogImpl.setCreateDate(courseCatalog.getCreateDate());
		courseCatalogImpl.setModifiedDate(courseCatalog.getModifiedDate());
		courseCatalogImpl.setName(courseCatalog.getName());
		courseCatalogImpl.setDescription(courseCatalog.getDescription());
		courseCatalogImpl.setMajor(courseCatalog.getMajor());
		courseCatalogImpl.setCreditHours(courseCatalog.getCreditHours());

		return courseCatalogImpl;
	}

	/**
	 * Returns the course catalog with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course catalog
	 * @return the course catalog
	 * @throws com.liferay.portal.NoSuchModelException if a course catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCatalog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the course catalog with the primary key or throws a {@link com.liferay.live.sb.demo.NoSuchCourseCatalogException} if it could not be found.
	 *
	 * @param courseCatalogId the primary key of the course catalog
	 * @return the course catalog
	 * @throws com.liferay.live.sb.demo.NoSuchCourseCatalogException if a course catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CourseCatalog findByPrimaryKey(long courseCatalogId)
		throws NoSuchCourseCatalogException, SystemException {
		CourseCatalog courseCatalog = fetchByPrimaryKey(courseCatalogId);

		if (courseCatalog == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + courseCatalogId);
			}

			throw new NoSuchCourseCatalogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				courseCatalogId);
		}

		return courseCatalog;
	}

	/**
	 * Returns the course catalog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course catalog
	 * @return the course catalog, or <code>null</code> if a course catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCatalog fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the course catalog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param courseCatalogId the primary key of the course catalog
	 * @return the course catalog, or <code>null</code> if a course catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CourseCatalog fetchByPrimaryKey(long courseCatalogId)
		throws SystemException {
		CourseCatalog courseCatalog = (CourseCatalog)EntityCacheUtil.getResult(CourseCatalogModelImpl.ENTITY_CACHE_ENABLED,
				CourseCatalogImpl.class, courseCatalogId);

		if (courseCatalog == _nullCourseCatalog) {
			return null;
		}

		if (courseCatalog == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				courseCatalog = (CourseCatalog)session.get(CourseCatalogImpl.class,
						Long.valueOf(courseCatalogId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (courseCatalog != null) {
					cacheResult(courseCatalog);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CourseCatalogModelImpl.ENTITY_CACHE_ENABLED,
						CourseCatalogImpl.class, courseCatalogId,
						_nullCourseCatalog);
				}

				closeSession(session);
			}
		}

		return courseCatalog;
	}

	/**
	 * Returns all the course catalogs.
	 *
	 * @return the course catalogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CourseCatalog> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<CourseCatalog> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<CourseCatalog> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<CourseCatalog> list = (List<CourseCatalog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COURSECATALOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSECATALOG.concat(CourseCatalogModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CourseCatalog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CourseCatalog>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the course catalogs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CourseCatalog courseCatalog : findAll()) {
			remove(courseCatalog);
		}
	}

	/**
	 * Returns the number of course catalogs.
	 *
	 * @return the number of course catalogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COURSECATALOG);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the course catalog persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.live.sb.demo.model.CourseCatalog")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CourseCatalog>> listenersList = new ArrayList<ModelListener<CourseCatalog>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CourseCatalog>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CourseCatalogImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CoursePersistence.class)
	protected CoursePersistence coursePersistence;
	@BeanReference(type = CourseCatalogPersistence.class)
	protected CourseCatalogPersistence courseCatalogPersistence;
	@BeanReference(type = CourseStudentPersistence.class)
	protected CourseStudentPersistence courseStudentPersistence;
	@BeanReference(type = InstructorPersistence.class)
	protected InstructorPersistence instructorPersistence;
	@BeanReference(type = StudentPersistence.class)
	protected StudentPersistence studentPersistence;
	@BeanReference(type = StudentGPAPersistence.class)
	protected StudentGPAPersistence studentGPAPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_COURSECATALOG = "SELECT courseCatalog FROM CourseCatalog courseCatalog";
	private static final String _SQL_COUNT_COURSECATALOG = "SELECT COUNT(courseCatalog) FROM CourseCatalog courseCatalog";
	private static final String _ORDER_BY_ENTITY_ALIAS = "courseCatalog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CourseCatalog exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CourseCatalogPersistenceImpl.class);
	private static CourseCatalog _nullCourseCatalog = new CourseCatalogImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CourseCatalog> toCacheModel() {
				return _nullCourseCatalogCacheModel;
			}
		};

	private static CacheModel<CourseCatalog> _nullCourseCatalogCacheModel = new CacheModel<CourseCatalog>() {
			public CourseCatalog toEntityModel() {
				return _nullCourseCatalog;
			}
		};
}