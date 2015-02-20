package com.vambeco.stockmanager.controller;

import com.vambeco.stockmanager.controller.util.DateUtility;
import com.vambeco.stockmanager.model.Stockout;
import com.vambeco.stockmanager.controller.util.JsfUtil;
import com.vambeco.stockmanager.controller.util.JsfUtil.PersistAction;
import com.vambeco.stockmanager.facade.StockoutFacade;

import java.io.Serializable;
import java.util.Date;
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
import javax.inject.Inject;

@Named("stockoutController")
@ViewScoped
public class StockoutController implements Serializable {

    @EJB
    private com.vambeco.stockmanager.facade.StockoutFacade ejbFacade;
    private List<Stockout> items = null;
    private Stockout selected;
    @Inject
    private ItemdescriptionController itemdescriptionController;
    public StockoutController() {
    }

    public Stockout getSelected() {
        return selected;
    }

    public void setSelected(Stockout selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private StockoutFacade getFacade() {
        return ejbFacade;
    }

    public Stockout prepareCreate() {
        selected = new Stockout();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        //Only allow stock out if stock balance can be updated and if there is stock to take out
        if(itemdescriptionController.decrementStockBalance(selected.getItemdescriptionId(), selected.getQuantity())==-1){
            JsfUtil.addErrorMessage("Not allowed to take out stock. Stock Balance not updated!");
        }
        else if(itemdescriptionController.decrementStockBalance(selected.getItemdescriptionId(), selected.getQuantity())==0){
            JsfUtil.addErrorMessage("There is no stock for "+selected.getItemdescriptionId().getItemId().getItemName().concat(" - ").concat(selected.getItemdescriptionId().getItemSize()) +". Stock Balance not updated!");
        }
        else{
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("StockoutCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("StockoutUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("StockoutDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Stockout> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
    
    public Date getCurrentDateTime(){
        return DateUtility.getCurrentDateTime();
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

    public Stockout getStockout(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Stockout> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Stockout> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Stockout.class)
    public static class StockoutControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            StockoutController controller = (StockoutController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "stockoutController");
            return controller.getStockout(getKey(value));
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
            if (object instanceof Stockout) {
                Stockout o = (Stockout) object;
                return getStringKey(o.getStockOutId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Stockout.class.getName()});
                return null;
            }
        }

    }

}
