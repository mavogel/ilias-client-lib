package com.github.mavogel.ilias.lib.wrapper;/*
 *  The MIT License (MIT)
 *
 *  Copyright (c) 2017 Manuel Vogel
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 *
 *  https://opensource.org/licenses/MIT
 */

import com.github.mavogel.ilias.lib.model.GroupUserModelFull;
import com.github.mavogel.ilias.lib.model.IliasNode;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by mavogel on 6/25/17.
 * <p>
 * General wrapper for the Ilias endpoint. Atm only SOAP but maybe REST in the future.
 */
public interface IliasEndpoint {

    /**
     * Logs out the user.
     *
     * @param caller the details about the caller to be logged.
     * @return true if the user has been successfully logged out, false otherwise
     */
    boolean logout(final String caller);

    /**
     * Retrieves the courses for the user he has the given status in.<br>
     *
     * @param status the status
     * @return the courses
     * @throws Exception in case of a failure. Detailed logs are written.
     * @see DisplayStatus for more details.
     */
    List<IliasNode> getCoursesForUser(final DisplayStatus... status) throws Exception;

    /**
     * Retrieves the groups of a given course by serching until a maximum folder depth.
     *
     * @param course the course
     * @return the groups
     * @throws Exception in case of a failure. Detailed logs are written.
     */
    List<IliasNode> getGroupsFromCourse(final IliasNode course) throws Exception;

    /**
     * Grants file upload permission to the users of a group.
     *
     * @param groups the groups
     * @throws Exception in case of a failure. Detailed logs are written.
     */
    void grantFileUploadPermissionForMembers(final List<IliasNode> groups) throws Exception;

    /**
     * Retrieves the users for groups.
     *
     * @param groups the groups
     * @return the users
     * @throws Exception in case of a failure. Detailed logs are written.
     */
    List<GroupUserModelFull> getUsersForGroups(final List<IliasNode> groups) throws Exception;

    /**
     * Retrieves the file nodes from the given groups.
     *
     * @param groups the groups
     * @return the file nodes
     * @throws Exception in case of a failure. Detailed logs are written.
     */
    List<IliasNode> getFilesFromGroups(final List<IliasNode> groups) throws Exception;

    /**
     * Deletes the given files.
     *
     * @param files the files to delete
     * @throws Exception in case of a failure. Detailed logs are written.
     */
    void deleteObjectNodes(final List<IliasNode> files) throws Exception;

    /**
     * Removes all members from the given groups.
     *
     * @param groups the groups
     * @throws Exception in case of a failure. Detailed logs are written.
     */
    void removeAllMembersFromGroups(final List<IliasNode> groups) throws Exception;

    /**
     * Set a maximum amount of members for the given groups.
     *
     * @param groups          the groups.
     * @param maxGroupMembers the maximum amount of group members to set
     * @throws Exception in case of a failure. Detailed logs are written.
     */
    void setMaxMembersOnGroups(final List<IliasNode> groups, final int maxGroupMembers) throws Exception;

    /**
     * Sets the registration start and end date for the given groups.<br>
     * Activates the registration for a group if it's not yet activated.
     *
     * @param groups the groups
     * @param start  the start date
     * @param end    the end data of the registration.
     * @throws Exception in case of a failure. Detailed logs are written.
     */
    void setRegistrationDatesOnGroups(final List<IliasNode> groups, final LocalDateTime start, final LocalDateTime end) throws Exception;

    /**
     * Creates a new group within the given course.
     *
     * @param course    The course the group shall be created in
     * @param groupName The name of the group
     * @return True iff the group has been created successfully
     */
    boolean addGroup(IliasNode course, String groupName);

    /**
     * Checks, if a group with the given name already exists.
     * Unfortunately the exist mechanism of the WSDL searches in all
     * courses of the user and not just in the given one. Right now this cannot be restricted.
     *
     * @param groupName The name to check
     * @return True, if the group with the given name already exists in a course of the user
     * @throws Exception in case of a failure.
     */
    boolean groupExists(String groupName) throws Exception;
}
