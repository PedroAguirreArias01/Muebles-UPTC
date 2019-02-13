/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author PEDRO
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.edu.uptc.sw2.servicios.ServicioClienteFactura.class);
        resources.add(co.edu.uptc.sw2.servicios.ServicioDetalleFactura.class);
        resources.add(co.edu.uptc.sw2.servicios.ServicioFactura.class);
        resources.add(co.edu.uptc.sw2.servicios.ServicioProducto.class);
        resources.add(co.edu.uptc.sw2.servicios.banco.ServicioClienteBanco.class);
        resources.add(co.edu.uptc.sw2.servicios.banco.ServicoTarjeta.class);
    }
}
