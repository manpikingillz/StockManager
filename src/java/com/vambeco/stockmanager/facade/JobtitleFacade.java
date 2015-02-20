/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vambeco.stockmanager.facade;

import com.vambeco.stockmanager.model.Jobtitle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Allen
 */
@Stateless
public class JobtitleFacade extends AbstractFacade<Jobtitle> {
    @PersistenceContext(unitName = "StockManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JobtitleFacade() {
        super(Jobtitle.class);
    }
    
}
