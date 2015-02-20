package com.vambeco.stockmanager.model;

import com.vambeco.stockmanager.model.Department;
import com.vambeco.stockmanager.model.Jobtitle;
import com.vambeco.stockmanager.model.Role;
import com.vambeco.stockmanager.model.Stockin;
import com.vambeco.stockmanager.model.Stockout;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-10T00:45:31")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> lastName;
    public static volatile CollectionAttribute<User, Stockout> stockoutCollection1;
    public static volatile SingularAttribute<User, String> phone2;
    public static volatile SingularAttribute<User, Jobtitle> jobtitleId;
    public static volatile SingularAttribute<User, String> phone1;
    public static volatile SingularAttribute<User, String> password;
    public static volatile CollectionAttribute<User, Role> roleCollection;
    public static volatile CollectionAttribute<User, Stockout> stockoutCollection;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, Integer> userId;
    public static volatile CollectionAttribute<User, Stockin> stockinCollection;
    public static volatile CollectionAttribute<User, Stockin> stockinCollection1;
    public static volatile SingularAttribute<User, Department> departmentId;
    public static volatile SingularAttribute<User, String> firstName;

}