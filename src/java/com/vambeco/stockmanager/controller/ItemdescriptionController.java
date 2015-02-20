package com.vambeco.stockmanager.controller;

import com.vambeco.stockmanager.model.Itemdescription;
import com.vambeco.stockmanager.controller.util.JsfUtil;
import com.vambeco.stockmanager.controller.util.JsfUtil.PersistAction;
import com.vambeco.stockmanager.facade.ItemdescriptionFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;

@Named("itemdescriptionController")
@ViewScoped
public class ItemdescriptionController implements Serializable {

    @EJB
    private com.vambeco.stockmanager.facade.ItemdescriptionFacade ejbFacade;
    private List<Itemdescription> items = null;
    private Itemdescription selected;

    public ItemdescriptionController() {
    }

    public Itemdescription getSelected() {
        return selected;
    }

    public void setSelected(Itemdescription selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ItemdescriptionFacade getFacade() {
        return ejbFacade;
    }

    public Itemdescription prepareCreate() {
        selected = new Itemdescription();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ItemdescriptionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ItemdescriptionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ItemdescriptionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Itemdescription> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public int increamentStockBalance(Itemdescription itemdescription, int stockIn) {
        int newStockBalanceValue = 0;
        try {
            //get the item we wish to update
            Itemdescription itemToUpdate = ejbFacade.find(itemdescription.getItemdescriptionId());

            //increment stock balance
            newStockBalanceValue = itemToUpdate.getBalance() + stockIn;
            
            //set the new stock balance
            itemToUpdate.setBalance(newStockBalanceValue);

            //update the database
            ejbFacade.edit(itemToUpdate);
        } catch (Exception ex) {
            //return -1 if the is an exception
            newStockBalanceValue = -1;
        }

        //get the available stock and increment by the value from incoming stock
        return newStockBalanceValue;
    }

    public int decrementStockBalance(Itemdescription itemdescription, int stockOut) {
        int newStockBalanceValue = 0;
        try {
            //get the item we wish to update
            Itemdescription itemToUpdate = ejbFacade.find(itemdescription.getItemdescriptionId());

            //check whether stock being taken out is less than available stock
            if (itemToUpdate.getBalance() >= stockOut) {
                //decrement stock balance
                newStockBalanceValue = itemToUpdate.getBalance() - stockOut;

                //set the new stock balance value
                itemToUpdate.setBalance(newStockBalanceValue);
                
                //update the database
                ejbFacade.edit(itemToUpdate);
            } else {
                //return -1 if stock being taken out is greater than available stock
                newStockBalanceValue = 0;
            }
        } catch (Exception ex) {
            //return -1 if an exception occurs
            newStockBalanceValue = -1;
        }

        return newStockBalanceValue;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Itemdescription getItemdescription(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Itemdescription> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Itemdescription> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Itemdescription.class)
    public static class ItemdescriptionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ItemdescriptionController controller = (ItemdescriptionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "itemdescriptionController");
            return controller.getItemdescription(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Itemdescription) {
                Itemdescription o = (Itemdescription) object;
                return getStringKey(o.getItemdescriptionId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Itemdescription.class.getName()});
                return null;
            }
        }

    }

}
