package com.vambeco.stockmanager.model;

import com.vambeco.stockmanager.model.Item;
import com.vambeco.stockmanager.model.Stockin;
import com.vambeco.stockmanager.model.Stockout;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-10T00:45:31")
@StaticMetamodel(Itemdescription.class)
public class Itemdescription_ { 

    public static volatile SingularAttribute<Itemdescription, Integer> balance;
    public static volatile SingularAttribute<Itemdescription, Date> autostamp;
    public static volatile SingularAttribute<Itemdescription, String> itemSize;
    public static volatile SingularAttribute<Itemdescription, Integer> itemdescriptionId;
    public static volatile CollectionAttribute<Itemdescription, Stockin> stockinCollection;
    public static volatile SingularAttribute<Itemdescription, String> remarks;
    public static volatile SingularAttribute<Itemdescription, Item> itemId;
    public static volatile CollectionAttribute<Itemdescription, Stockout> stockoutCollection;

}