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

package com.liferay.live.sb.demo.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.live.sb.demo.model.Course;
import com.liferay.live.sb.demo.service.CourseCatalogLocalService;
import com.liferay.live.sb.demo.service.CourseLocalService;
import com.liferay.live.sb.demo.service.CourseStudentLocalService;
import com.liferay.live.sb.demo.service.InstructorLocalService;
import com.liferay.live.sb.demo.service.StudentGPALocalService;
import com.liferay.live.sb.demo.service.StudentLocalService;
import com.liferay.live.sb.demo.service.persistence.CourseCatalogPersistence;
import com.liferay.live.sb.demo.service.persistence.CoursePersistence;
import com.liferay.live.sb.demo.service.persistence.CourseStudentPersistence;
import com.liferay.live.sb.demo.service.persistence.InstructorPersistence;
import com.liferay.live.sb.demo.service.persistence.StudentGPAPersistence;
import com.liferay.live.sb.demo.service.persistence.StudentPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the course local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.live.sb.demo.service.impl.CourseLocalServiceImpl}.
 * </p>
 *
 * @author dnebinger
 * @see com.liferay.live.sb.demo.service.impl.CourseLocalServiceImpl
 * @see com.liferay.live.sb.demo.service.CourseLocalServiceUtil
 * @generated
 */
public abstract class CourseLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements CourseLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.live.sb.demo.service.CourseLocalServiceUtil} to access the course local service.
	 */

	/**
	 * Adds the course to the database. Also notifies the appropriate model listeners.
	 *
	 * @param course the course
	 * @return the course that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Course addCourse(Course course) throws SystemException {
		course.setNew(true);

		return coursePersistence.update(course, false);
	}

	/**
	 * Creates a new course with the primary key. Does not add the course to the database.
	 *
	 * @param courseId the primary key for the new course
	 * @return the new course
	 */
	public Course createCourse(long courseId) {
		return coursePersistence.create(courseId);
	}

	/**
	 * Deletes the course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param courseId the primary key of the course
	 * @return the course that was removed
	 * @throws PortalException if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Course deleteCourse(long courseId)
		throws PortalException, SystemException {
		return coursePersistence.remove(courseId);
	}

	/**
	 * Deletes the course from the database. Also notifies the appropriate model listeners.
	 *
	 * @param course the course
	 * @return the course that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Course deleteCourse(Course course) throws SystemException {
		return coursePersistence.remove(course);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Course.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return coursePersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return coursePersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return coursePersistence.findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return coursePersistence.countWithDynamicQuery(dynamicQuery);
	}

	public Course fetchCourse(long courseId) throws SystemException {
		return coursePersistence.fetchByPrimaryKey(courseId);
	}

	/**
	 * Returns the course with the primary key.
	 *
	 * @param courseId the primary key of the course
	 * @return the course
	 * @throws PortalException if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course getCourse(long courseId)
		throws PortalException, SystemException {
		return coursePersistence.findByPrimaryKey(courseId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return coursePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @return the range of courses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Course> getCourses(int start, int end)
		throws SystemException {
		return coursePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of courses.
	 *
	 * @return the number of courses
	 * @throws SystemException if a system exception occurred
	 */
	public int getCoursesCount() throws SystemException {
		return coursePersistence.countAll();
	}

	/**
	 * Updates the course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param course the course
	 * @return the course that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Course updateCourse(Course course) throws SystemException {
		return updateCourse(course, true);
	}

	/**
	 * Updates the course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param course the course
	 * @param merge whether to merge the course with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the course that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Course updateCourse(Course course, boolean merge)
		throws SystemException {
		course.setNew(false);

		return coursePersistence.update(course, merge);
	}

	/**
	 * Returns the course local service.
	 *
	 * @return the course local service
	 */
	public CourseLocalService getCourseLocalService() {
		return courseLocalService;
	}

	/**
	 * Sets the course local service.
	 *
	 * @param courseLocalService the course local service
	 */
	public void setCourseLocalService(CourseLocalService courseLocalService) {
		this.courseLocalService = courseLocalService;
	}

	/**
	 * Returns the course persistence.
	 *
	 * @return the course persistence
	 */
	public CoursePersistence getCoursePersistence() {
		return coursePersistence;
	}

	/**
	 * Sets the course persistence.
	 *
	 * @param coursePersistence the course persistence
	 */
	public void setCoursePersistence(CoursePersistence coursePersistence) {
		this.coursePersistence = coursePersistence;
	}

	/**
	 * Returns the course catalog local service.
	 *
	 * @return the course catalog local service
	 */
	public CourseCatalogLocalService getCourseCatalogLocalService() {
		return courseCatalogLocalService;
	}

	/**
	 * Sets the course catalog local service.
	 *
	 * @param courseCatalogLocalService the course catalog local service
	 */
	public void setCourseCatalogLocalService(
		CourseCatalogLocalService courseCatalogLocalService) {
		this.courseCatalogLocalService = courseCatalogLocalService;
	}

	/**
	 * Returns the course catalog persistence.
	 *
	 * @return the course catalog persistence
	 */
	public CourseCatalogPersistence getCourseCatalogPersistence() {
		return courseCatalogPersistence;
	}

	/**
	 * Sets the course catalog persistence.
	 *
	 * @param courseCatalogPersistence the course catalog persistence
	 */
	public void setCourseCatalogPersistence(
		CourseCatalogPersistence courseCatalogPersistence) {
		this.courseCatalogPersistence = courseCatalogPersistence;
	}

	/**
	 * Returns the course student local service.
	 *
	 * @return the course student local service
	 */
	public CourseStudentLocalService getCourseStudentLocalService() {
		return courseStudentLocalService;
	}

	/**
	 * Sets the course student local service.
	 *
	 * @param courseStudentLocalService the course student local service
	 */
	public void setCourseStudentLocalService(
		CourseStudentLocalService courseStudentLocalService) {
		this.courseStudentLocalService = courseStudentLocalService;
	}

	/**
	 * Returns the course student persistence.
	 *
	 * @return the course student persistence
	 */
	public CourseStudentPersistence getCourseStudentPersistence() {
		return courseStudentPersistence;
	}

	/**
	 * Sets the course student persistence.
	 *
	 * @param courseStudentPersistence the course student persistence
	 */
	public void setCourseStudentPersistence(
		CourseStudentPersistence courseStudentPersistence) {
		this.courseStudentPersistence = courseStudentPersistence;
	}

	/**
	 * Returns the instructor local service.
	 *
	 * @return the instructor local service
	 */
	public InstructorLocalService getInstructorLocalService() {
		return instructorLocalService;
	}

	/**
	 * Sets the instructor local service.
	 *
	 * @param instructorLocalService the instructor local service
	 */
	public void setInstructorLocalService(
		InstructorLocalService instructorLocalService) {
		this.instructorLocalService = instructorLocalService;
	}

	/**
	 * Returns the instructor persistence.
	 *
	 * @return the instructor persistence
	 */
	public InstructorPersistence getInstructorPersistence() {
		return instructorPersistence;
	}

	/**
	 * Sets the instructor persistence.
	 *
	 * @param instructorPersistence the instructor persistence
	 */
	public void setInstructorPersistence(
		InstructorPersistence instructorPersistence) {
		this.instructorPersistence = instructorPersistence;
	}

	/**
	 * Returns the student local service.
	 *
	 * @return the student local service
	 */
	public StudentLocalService getStudentLocalService() {
		return studentLocalService;
	}

	/**
	 * Sets the student local service.
	 *
	 * @param studentLocalService the student local service
	 */
	public void setStudentLocalService(StudentLocalService studentLocalService) {
		this.studentLocalService = studentLocalService;
	}

	/**
	 * Returns the student persistence.
	 *
	 * @return the student persistence
	 */
	public StudentPersistence getStudentPersistence() {
		return studentPersistence;
	}

	/**
	 * Sets the student persistence.
	 *
	 * @param studentPersistence the student persistence
	 */
	public void setStudentPersistence(StudentPersistence studentPersistence) {
		this.studentPersistence = studentPersistence;
	}

	/**
	 * Returns the student g p a local service.
	 *
	 * @return the student g p a local service
	 */
	public StudentGPALocalService getStudentGPALocalService() {
		return studentGPALocalService;
	}

	/**
	 * Sets the student g p a local service.
	 *
	 * @param studentGPALocalService the student g p a local service
	 */
	public void setStudentGPALocalService(
		StudentGPALocalService studentGPALocalService) {
		this.studentGPALocalService = studentGPALocalService;
	}

	/**
	 * Returns the student g p a persistence.
	 *
	 * @return the student g p a persistence
	 */
	public StudentGPAPersistence getStudentGPAPersistence() {
		return studentGPAPersistence;
	}

	/**
	 * Sets the student g p a persistence.
	 *
	 * @param studentGPAPersistence the student g p a persistence
	 */
	public void setStudentGPAPersistence(
		StudentGPAPersistence studentGPAPersistence) {
		this.studentGPAPersistence = studentGPAPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.liferay.live.sb.demo.model.Course",
			courseLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.live.sb.demo.model.Course");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return Course.class;
	}

	protected String getModelClassName() {
		return Course.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = coursePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = CourseLocalService.class)
	protected CourseLocalService courseLocalService;
	@BeanReference(type = CoursePersistence.class)
	protected CoursePersistence coursePersistence;
	@BeanReference(type = CourseCatalogLocalService.class)
	protected CourseCatalogLocalService courseCatalogLocalService;
	@BeanReference(type = CourseCatalogPersistence.class)
	protected CourseCatalogPersistence courseCatalogPersistence;
	@BeanReference(type = CourseStudentLocalService.class)
	protected CourseStudentLocalService courseStudentLocalService;
	@BeanReference(type = CourseStudentPersistence.class)
	protected CourseStudentPersistence courseStudentPersistence;
	@BeanReference(type = InstructorLocalService.class)
	protected InstructorLocalService instructorLocalService;
	@BeanReference(type = InstructorPersistence.class)
	protected InstructorPersistence instructorPersistence;
	@BeanReference(type = StudentLocalService.class)
	protected StudentLocalService studentLocalService;
	@BeanReference(type = StudentPersistence.class)
	protected StudentPersistence studentPersistence;
	@BeanReference(type = StudentGPALocalService.class)
	protected StudentGPALocalService studentGPALocalService;
	@BeanReference(type = StudentGPAPersistence.class)
	protected StudentGPAPersistence studentGPAPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private CourseLocalServiceClpInvoker _clpInvoker = new CourseLocalServiceClpInvoker();
}