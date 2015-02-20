package com.vambeco.stockmanager.model;

import com.vambeco.stockmanager.model.Itemdescription;
import com.vambeco.stockmanager.model.Site;
import com.vambeco.stockmanager.model.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-10T00:45:31")
@StaticMetamodel(Stockout.class)
public class Stockout_ { 

    public static volatile SingularAttribute<Stockout, String> deliveryNoteNumber;
    public static volatile SingularAttribute<Stockout, Date> autostamp;
    public static volatile SingularAttribute<Stockout, Site> takentositeId;
    public static volatile SingularAttribute<Stockout, Itemdescription> itemdescriptionId;
    public static volatile SingularAttribute<Stockout, User> despatchedbyuserId;
    public static volatile SingularAttribute<Stockout, Integer> stockOutId;
    public static volatile SingularAttribute<Stockout, Integer> quantity;
    public static volatile SingularAttribute<Stockout, String> remarks;
    public static volatile SingularAttribute<Stockout, User> issuedbyuserId;
    public static volatile SingularAttribute<Stockout, String> vehicleNumber;

}