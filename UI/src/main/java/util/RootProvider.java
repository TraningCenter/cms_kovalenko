package util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class RootProvider {

    public static String getRoot() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        return String.format("%s://%s:%d",
                context.getRequestScheme(),
                context.getRequestServerName(),
                context.getRequestServerPort());
    }

    public static String getFullRoot() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        return String.format("%s://%s:%d%s",
                context.getRequestScheme(),
                context.getRequestServerName(),
                context.getRequestServerPort(),
                context.getRequestContextPath());
    }
}
