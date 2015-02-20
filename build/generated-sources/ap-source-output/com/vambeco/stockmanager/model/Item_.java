package com.vambeco.stockmanager.model;

import com.vambeco.stockmanager.model.Itemdescription;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-10T00:45:31")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, Date> autostamp;
    public static volatile SingularAttribute<Item, String> itemName;
    public static volatile CollectionAttribute<Item, Itemdescription> itemdescriptionCollection;
    public static volatile SingularAttribute<Item, Integer> itemId;

}