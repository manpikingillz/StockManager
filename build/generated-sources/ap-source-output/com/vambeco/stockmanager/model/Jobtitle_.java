package com.vambeco.stockmanager.model;

import com.vambeco.stockmanager.model.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-10T00:45:31")
@StaticMetamodel(Jobtitle.class)
public class Jobtitle_ { 

    public static volatile SingularAttribute<Jobtitle, String> jobtitleName;
    public static volatile SingularAttribute<Jobtitle, Integer> jobtitleId;
    public static volatile CollectionAttribute<Jobtitle, User> userCollection;

}