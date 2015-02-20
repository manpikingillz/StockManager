package com.vambeco.stockmanager.model;

import com.vambeco.stockmanager.model.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-10T00:45:31")
@StaticMetamodel(Department.class)
public class Department_ { 

    public static volatile SingularAttribute<Department, Integer> departmentId;
    public static volatile SingularAttribute<Department, String> departmentName;
    public static volatile CollectionAttribute<Department, User> userCollection;

}