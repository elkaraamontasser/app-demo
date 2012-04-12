/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/main/java/project/manager/ManagerImpl.e.vm.java
 */
package com.app.demo.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.demo.dao.support.GenericDao;
import com.app.demo.service.support.GenericEntityServiceImpl;
import com.app.demo.domain.Role;
import com.app.demo.dao.RoleDao;

/**
 *
 * Default implementation of the {@link RoleService} interface
 * @see RoleService
 */
@Service("roleService")
public class RoleServiceImpl extends GenericEntityServiceImpl<Role, Integer> implements RoleService {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(RoleServiceImpl.class);

    protected RoleDao roleDao;

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    /**
     * Dao getter used by the {@link GenericEntityServiceImpl}.
     */
    @Override
    public GenericDao<Role, Integer> getDao() {
        return roleDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Role getNew() {
        return new Role();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Role getNewWithDefaults() {
        Role result = getNew();
        result.initDefaultValues();
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Role get(Role model) {
        if (model == null) {
            return null;
        }

        if (model.isIdSet()) {
            return super.get(model);
        }

        if (model.getRoleName() != null && !model.getRoleName().isEmpty()) {
            Role result = getByRoleName(model.getRoleName());
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Role getByRoleName(String _roleName) {
        Role role = new Role();
        role.setRoleName(_roleName);
        return findUniqueOrNone(role);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteByRoleName(String roleName) {
        delete(getByRoleName(roleName));
    }
}