package com.vambeco.stockmanager.model;

import com.vambeco.stockmanager.model.Stockout;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-10T00:45:31")
@StaticMetamodel(Site.class)
public class Site_ { 

    public static volatile SingularAttribute<Site, Date> autostamp;
    public static volatile SingularAttribute<Site, Integer> siteId;
    public static volatile SingularAttribute<Site, String> address;
    public static volatile SingularAttribute<Site, String> otherInfo;
    public static volatile SingularAttribute<Site, String> siteName;
    public static volatile CollectionAttribute<Site, Stockout> stockoutCollection;

}