package com.vambeco.stockmanager.model;

import com.vambeco.stockmanager.model.Itemdescription;
import com.vambeco.stockmanager.model.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-10T00:45:31")
@StaticMetamodel(Stockin.class)
public class Stockin_ { 

    public static volatile SingularAttribute<Stockin, Date> autostamp;
    public static volatile SingularAttribute<Stockin, User> receivedbyuserId;
    public static volatile SingularAttribute<Stockin, String> goodsReceivedNoteNumber;
    public static volatile SingularAttribute<Stockin, Itemdescription> itemdescriptionId;
    public static volatile SingularAttribute<Stockin, Integer> quantity;
    public static volatile SingularAttribute<Stockin, String> remarks;
    public static volatile SingularAttribute<Stockin, Integer> stockInId;
    public static volatile SingularAttribute<Stockin, User> deliveredbyuserId;

}