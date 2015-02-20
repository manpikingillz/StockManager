package com.vambeco.stockmanager.controller;

import com.vambeco.stockmanager.controller.util.DateUtility;
import com.vambeco.stockmanager.controller.util.JsfUtil;
import com.vambeco.stockmanager.controller.util.JsfUtil.PersistAction;
import com.vambeco.stockmanager.facade.StockinFacade;
import com.vambeco.stockmanager.model.Stockin;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("stockinController")
@ViewScoped
public class StockinController implements Serializable {

    @EJB
    private com.vambeco.stockmanager.facade.StockinFacade ejbFacade;
    private List<Stockin> items = null;
    private Stockin selected;
    private List<Stockin> filteredIncomingStock;
    @Inject
    private ItemdescriptionController itemdescriptionController;

    public StockinController() {
    }

    public Stockin getSelected() {
        return selected;
    }

    public void setSelected(Stockin selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private StockinFacade getFacade() {
        return ejbFacade;
    }

    public Stockin prepareCreate() {
        selected = new Stockin();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {

        //Only record new stock if stock balance can be updated.
        if (itemdescriptionController.increamentStockBalance(selected.getItemdescriptionId(), selected.getQuantity()) == -1) {
            JsfUtil.addErrorMessage("New Stock not recorded. Stock Balance not updated!");
        }
        else {
            
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("StockinCreated"));
            if (!JsfUtil.isValidationFailed()) {
                items = null;    // Invalidate list of items to trigger re-query.
            }
//            JsfUtil.addSuccessMessage("Stock Balance Updated.");
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("StockinUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("StockinDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Stockin> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public Date getCurrentDateTime() {
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

    public Stockin getStockin(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Stockin> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Stockin> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public List<Stockin> getFilteredIncomingStock() {
        return filteredIncomingStock;
    }

    public void setFilteredIncomingStock(List<Stockin> filteredIncomingStock) {
        this.filteredIncomingStock = filteredIncomingStock;
    }

    @FacesConverter(forClass = Stockin.class)
    public static class StockinControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            StockinController controller = (StockinController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "stockinController");
            return controller.getStockin(getKey(value));
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
            if (object instanceof Stockin) {
                Stockin o = (Stockin) object;
                return getStringKey(o.getStockInId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Stockin.class.getName()});
                return null;
            }
        }

    }

}
