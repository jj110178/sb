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

import com.liferay.live.sb.demo.NoSuchStudentException;
import com.liferay.live.sb.demo.model.Student;
import com.liferay.live.sb.demo.model.impl.StudentImpl;
import com.liferay.live.sb.demo.model.impl.StudentModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
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
 * The persistence implementation for the student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see StudentPersistence
 * @see StudentUtil
 * @generated
 */
public class StudentPersistenceImpl extends BasePersistenceImpl<Student>
	implements StudentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StudentUtil} to access the student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StudentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_YEARINSCHOOL =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByYearInSchool",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARINSCHOOL =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByYearInSchool",
			new String[] { Integer.class.getName() },
			StudentModelImpl.YEARINSCHOOL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_YEARINSCHOOL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByYearInSchool",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MAJOR = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMajor",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAJOR = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMajor",
			new String[] { String.class.getName() },
			StudentModelImpl.MAJOR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MAJOR = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMajor",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the student in the entity cache if it is enabled.
	 *
	 * @param student the student
	 */
	public void cacheResult(Student student) {
		EntityCacheUtil.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentImpl.class, student.getPrimaryKey(), student);

		student.resetOriginalValues();
	}

	/**
	 * Caches the students in the entity cache if it is enabled.
	 *
	 * @param students the students
	 */
	public void cacheResult(List<Student> students) {
		for (Student student : students) {
			if (EntityCacheUtil.getResult(
						StudentModelImpl.ENTITY_CACHE_ENABLED,
						StudentImpl.class, student.getPrimaryKey()) == null) {
				cacheResult(student);
			}
			else {
				student.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all students.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StudentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StudentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the student.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Student student) {
		EntityCacheUtil.removeResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentImpl.class, student.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Student> students) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Student student : students) {
			EntityCacheUtil.removeResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
				StudentImpl.class, student.getPrimaryKey());
		}
	}

	/**
	 * Creates a new student with the primary key. Does not add the student to the database.
	 *
	 * @param studentId the primary key for the new student
	 * @return the new student
	 */
	public Student create(long studentId) {
		Student student = new StudentImpl();

		student.setNew(true);
		student.setPrimaryKey(studentId);

		return student;
	}

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentId the primary key of the student
	 * @return the student that was removed
	 * @throws com.liferay.live.sb.demo.NoSuchStudentException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Student remove(long studentId)
		throws NoSuchStudentException, SystemException {
		return remove(Long.valueOf(studentId));
	}

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student that was removed
	 * @throws com.liferay.live.sb.demo.NoSuchStudentException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student remove(Serializable primaryKey)
		throws NoSuchStudentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Student student = (Student)session.get(StudentImpl.class, primaryKey);

			if (student == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(student);
		}
		catch (NoSuchStudentException nsee) {
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
	protected Student removeImpl(Student student) throws SystemException {
		student = toUnwrappedModel(student);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, student);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(student);

		return student;
	}

	@Override
	public Student updateImpl(com.liferay.live.sb.demo.model.Student student,
		boolean merge) throws SystemException {
		student = toUnwrappedModel(student);

		boolean isNew = student.isNew();

		StudentModelImpl studentModelImpl = (StudentModelImpl)student;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, student, merge);

			student.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StudentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((studentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARINSCHOOL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(studentModelImpl.getOriginalYearInSchool())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEARINSCHOOL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARINSCHOOL,
					args);

				args = new Object[] {
						Integer.valueOf(studentModelImpl.getYearInSchool())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEARINSCHOOL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARINSCHOOL,
					args);
			}

			if ((studentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAJOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { studentModelImpl.getOriginalMajor() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAJOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAJOR,
					args);

				args = new Object[] { studentModelImpl.getMajor() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAJOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAJOR,
					args);
			}
		}

		EntityCacheUtil.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentImpl.class, student.getPrimaryKey(), student);

		return student;
	}

	protected Student toUnwrappedModel(Student student) {
		if (student instanceof StudentImpl) {
			return student;
		}

		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setNew(student.isNew());
		studentImpl.setPrimaryKey(student.getPrimaryKey());

		studentImpl.setStudentId(student.getStudentId());
		studentImpl.setUserId(student.getUserId());
		studentImpl.setCreateDate(student.getCreateDate());
		studentImpl.setModifiedDate(student.getModifiedDate());
		studentImpl.setName(student.getName());
		studentImpl.setEnrolled(student.isEnrolled());
		studentImpl.setEnrollmentDate(student.getEnrollmentDate());
		studentImpl.setYearInSchool(student.getYearInSchool());
		studentImpl.setMajor(student.getMajor());

		return studentImpl;
	}

	/**
	 * Returns the student with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student
	 * @throws com.liferay.portal.NoSuchModelException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the student with the primary key or throws a {@link com.liferay.live.sb.demo.NoSuchStudentException} if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student
	 * @throws com.liferay.live.sb.demo.NoSuchStudentException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Student findByPrimaryKey(long studentId)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByPrimaryKey(studentId);

		if (student == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + studentId);
			}

			throw new NoSuchStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				studentId);
		}

		return student;
	}

	/**
	 * Returns the student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student, or <code>null</code> if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student, or <code>null</code> if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Student fetchByPrimaryKey(long studentId) throws SystemException {
		Student student = (Student)EntityCacheUtil.getResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
				StudentImpl.class, studentId);

		if (student == _nullStudent) {
			return null;
		}

		if (student == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				student = (Student)session.get(StudentImpl.class,
						Long.valueOf(studentId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (student != null) {
					cacheResult(student);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
						StudentImpl.class, studentId, _nullStudent);
				}

				closeSession(session);
			}
		}

		return student;
	}

	/**
	 * Returns all the students where yearInSchool = &#63;.
	 *
	 * @param yearInSchool the year in school
	 * @return the matching students
	 * @throws SystemException if a system exception occurred
	 */
	public List<Student> findByYearInSchool(int yearInSchool)
		throws SystemException {
		return findByYearInSchool(yearInSchool, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the students where yearInSchool = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param yearInSchool the year in school
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of matching students
	 * @throws SystemException if a system exception occurred
	 */
	public List<Student> findByYearInSchool(int yearInSchool, int start, int end)
		throws SystemException {
		return findByYearInSchool(yearInSchool, start, end, null);
	}

	/**
	 * Returns an ordered range of all the students where yearInSchool = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param yearInSchool the year in school
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching students
	 * @throws SystemException if a system exception occurred
	 */
	public List<Student> findByYearInSchool(int yearInSchool, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARINSCHOOL;
			finderArgs = new Object[] { yearInSchool };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_YEARINSCHOOL;
			finderArgs = new Object[] {
					yearInSchool,
					
					start, end, orderByComparator
				};
		}

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Student student : list) {
				if ((yearInSchool != student.getYearInSchool())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STUDENT_WHERE);

			query.append(_FINDER_COLUMN_YEARINSCHOOL_YEARINSCHOOL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(yearInSchool);

				list = (List<Student>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first student in the ordered set where yearInSchool = &#63;.
	 *
	 * @param yearInSchool the year in school
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student
	 * @throws com.liferay.live.sb.demo.NoSuchStudentException if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Student findByYearInSchool_First(int yearInSchool,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByYearInSchool_First(yearInSchool,
				orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("yearInSchool=");
		msg.append(yearInSchool);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the first student in the ordered set where yearInSchool = &#63;.
	 *
	 * @param yearInSchool the year in school
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Student fetchByYearInSchool_First(int yearInSchool,
		OrderByComparator orderByComparator) throws SystemException {
		List<Student> list = findByYearInSchool(yearInSchool, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student in the ordered set where yearInSchool = &#63;.
	 *
	 * @param yearInSchool the year in school
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student
	 * @throws com.liferay.live.sb.demo.NoSuchStudentException if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Student findByYearInSchool_Last(int yearInSchool,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByYearInSchool_Last(yearInSchool,
				orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("yearInSchool=");
		msg.append(yearInSchool);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the last student in the ordered set where yearInSchool = &#63;.
	 *
	 * @param yearInSchool the year in school
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Student fetchByYearInSchool_Last(int yearInSchool,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByYearInSchool(yearInSchool);

		List<Student> list = findByYearInSchool(yearInSchool, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the students before and after the current student in the ordered set where yearInSchool = &#63;.
	 *
	 * @param studentId the primary key of the current student
	 * @param yearInSchool the year in school
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student
	 * @throws com.liferay.live.sb.demo.NoSuchStudentException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Student[] findByYearInSchool_PrevAndNext(long studentId,
		int yearInSchool, OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getByYearInSchool_PrevAndNext(session, student,
					yearInSchool, orderByComparator, true);

			array[1] = student;

			array[2] = getByYearInSchool_PrevAndNext(session, student,
					yearInSchool, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getByYearInSchool_PrevAndNext(Session session,
		Student student, int yearInSchool, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENT_WHERE);

		query.append(_FINDER_COLUMN_YEARINSCHOOL_YEARINSCHOOL_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(yearInSchool);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the students where major = &#63;.
	 *
	 * @param major the major
	 * @return the matching students
	 * @throws SystemException if a system exception occurred
	 */
	public List<Student> findByMajor(String major) throws SystemException {
		return findByMajor(major, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the students where major = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param major the major
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of matching students
	 * @throws SystemException if a system exception occurred
	 */
	public List<Student> findByMajor(String major, int start, int end)
		throws SystemException {
		return findByMajor(major, start, end, null);
	}

	/**
	 * Returns an ordered range of all the students where major = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param major the major
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching students
	 * @throws SystemException if a system exception occurred
	 */
	public List<Student> findByMajor(String major, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAJOR;
			finderArgs = new Object[] { major };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MAJOR;
			finderArgs = new Object[] { major, start, end, orderByComparator };
		}

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Student student : list) {
				if (!Validator.equals(major, student.getMajor())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STUDENT_WHERE);

			if (major == null) {
				query.append(_FINDER_COLUMN_MAJOR_MAJOR_1);
			}
			else {
				if (major.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MAJOR_MAJOR_3);
				}
				else {
					query.append(_FINDER_COLUMN_MAJOR_MAJOR_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (major != null) {
					qPos.add(major);
				}

				list = (List<Student>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first student in the ordered set where major = &#63;.
	 *
	 * @param major the major
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student
	 * @throws com.liferay.live.sb.demo.NoSuchStudentException if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Student findByMajor_First(String major,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByMajor_First(major, orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("major=");
		msg.append(major);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the first student in the ordered set where major = &#63;.
	 *
	 * @param major the major
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Student fetchByMajor_First(String major,
		OrderByComparator orderByComparator) throws SystemException {
		List<Student> list = findByMajor(major, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student in the ordered set where major = &#63;.
	 *
	 * @param major the major
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student
	 * @throws com.liferay.live.sb.demo.NoSuchStudentException if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Student findByMajor_Last(String major,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByMajor_Last(major, orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("major=");
		msg.append(major);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the last student in the ordered set where major = &#63;.
	 *
	 * @param major the major
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Student fetchByMajor_Last(String major,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMajor(major);

		List<Student> list = findByMajor(major, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the students before and after the current student in the ordered set where major = &#63;.
	 *
	 * @param studentId the primary key of the current student
	 * @param major the major
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student
	 * @throws com.liferay.live.sb.demo.NoSuchStudentException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Student[] findByMajor_PrevAndNext(long studentId, String major,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getByMajor_PrevAndNext(session, student, major,
					orderByComparator, true);

			array[1] = student;

			array[2] = getByMajor_PrevAndNext(session, student, major,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getByMajor_PrevAndNext(Session session, Student student,
		String major, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENT_WHERE);

		if (major == null) {
			query.append(_FINDER_COLUMN_MAJOR_MAJOR_1);
		}
		else {
			if (major.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MAJOR_MAJOR_3);
			}
			else {
				query.append(_FINDER_COLUMN_MAJOR_MAJOR_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (major != null) {
			qPos.add(major);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the students.
	 *
	 * @return the students
	 * @throws SystemException if a system exception occurred
	 */
	public List<Student> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of students
	 * @throws SystemException if a system exception occurred
	 */
	public List<Student> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of students
	 * @throws SystemException if a system exception occurred
	 */
	public List<Student> findAll(int start, int end,
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

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STUDENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENT.concat(StudentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the students where yearInSchool = &#63; from the database.
	 *
	 * @param yearInSchool the year in school
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByYearInSchool(int yearInSchool)
		throws SystemException {
		for (Student student : findByYearInSchool(yearInSchool)) {
			remove(student);
		}
	}

	/**
	 * Removes all the students where major = &#63; from the database.
	 *
	 * @param major the major
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMajor(String major) throws SystemException {
		for (Student student : findByMajor(major)) {
			remove(student);
		}
	}

	/**
	 * Removes all the students from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Student student : findAll()) {
			remove(student);
		}
	}

	/**
	 * Returns the number of students where yearInSchool = &#63;.
	 *
	 * @param yearInSchool the year in school
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	public int countByYearInSchool(int yearInSchool) throws SystemException {
		Object[] finderArgs = new Object[] { yearInSchool };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_YEARINSCHOOL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			query.append(_FINDER_COLUMN_YEARINSCHOOL_YEARINSCHOOL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(yearInSchool);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_YEARINSCHOOL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of students where major = &#63;.
	 *
	 * @param major the major
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMajor(String major) throws SystemException {
		Object[] finderArgs = new Object[] { major };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MAJOR,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			if (major == null) {
				query.append(_FINDER_COLUMN_MAJOR_MAJOR_1);
			}
			else {
				if (major.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MAJOR_MAJOR_3);
				}
				else {
					query.append(_FINDER_COLUMN_MAJOR_MAJOR_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (major != null) {
					qPos.add(major);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MAJOR,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of students.
	 *
	 * @return the number of students
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STUDENT);

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
	 * Initializes the student persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.live.sb.demo.model.Student")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Student>> listenersList = new ArrayList<ModelListener<Student>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Student>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StudentImpl.class.getName());
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
	private static final String _SQL_SELECT_STUDENT = "SELECT student FROM Student student";
	private static final String _SQL_SELECT_STUDENT_WHERE = "SELECT student FROM Student student WHERE ";
	private static final String _SQL_COUNT_STUDENT = "SELECT COUNT(student) FROM Student student";
	private static final String _SQL_COUNT_STUDENT_WHERE = "SELECT COUNT(student) FROM Student student WHERE ";
	private static final String _FINDER_COLUMN_YEARINSCHOOL_YEARINSCHOOL_2 = "student.yearInSchool = ?";
	private static final String _FINDER_COLUMN_MAJOR_MAJOR_1 = "student.major IS NULL";
	private static final String _FINDER_COLUMN_MAJOR_MAJOR_2 = "student.major = ?";
	private static final String _FINDER_COLUMN_MAJOR_MAJOR_3 = "(student.major IS NULL OR student.major = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "student.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Student exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Student exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StudentPersistenceImpl.class);
	private static Student _nullStudent = new StudentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Student> toCacheModel() {
				return _nullStudentCacheModel;
			}
		};

	private static CacheModel<Student> _nullStudentCacheModel = new CacheModel<Student>() {
			public Student toEntityModel() {
				return _nullStudent;
			}
		};
}