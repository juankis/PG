package Controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modelo.Colchon;
import Modelo.Deposito;
import Modelo.Esponja;
import Modelo.Medidas;
import Modelo.Entrada;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author juanki
 */
public class Conexion {
    
    private Session session;
    private Query query;
    private Validacion validacion; 
    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public Conexion(){
        //validacion=new Validacion();
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void guardar(Object objeto){
        session = sessionFactory.openSession();
	session.beginTransaction();
	session.save(objeto);
	session.getTransaction().commit();
	session.close();
    }
    
    public void modificar(Object objeto){
        session = sessionFactory.openSession();
	session.beginTransaction();
	session.update(objeto);
	session.getTransaction().commit();
	session.close();
    }
    
    public void eliminar(Object objeto){
        session = sessionFactory.openSession();
	session.beginTransaction();
	session.delete(objeto);
        session.getTransaction().commit();
	session.close();
    }
    
    public void getListaMedidas(ArrayList<Medidas> listaMedidas ) {
        session = sessionFactory.openSession();
        query = session.createQuery("SELECT m FROM Medidas m");
        listaMedidas.addAll(query.list());
        session.close();
    }

    public void getListaEsponjas(ArrayList<Esponja> listaEsponja) {
        session = sessionFactory.openSession();
        query = session.createQuery("SELECT e FROM Esponja e");
        listaEsponja.addAll(query.list());
        session.close();
    }

    void getListaColchones(ArrayList<Colchon> listaColchones) {
        session = sessionFactory.openSession();
        query = session.createQuery("SELECT c FROM Colchon c");
        listaColchones.addAll(query.list());
        session.close();
    }

    boolean consultarDependencia(String sql, Object objecto) {
       boolean res=true;
       session = sessionFactory.openSession();
       query = session.createQuery(sql+objecto);
       if(query.list().isEmpty())
           res=false;
       session.close();
       return res;
    }

    Object getObject(Object objeto) {
       Object res=session.merge(objeto);
       return res;
    }
    
    Object getObjectSql(String sql) {
       Object res=null;
       session = sessionFactory.openSession();
       query = session.createQuery(sql);
       try{
           res = query.uniqueResult();
       }catch(Exception e){
           validacion.mostrarMensaje("ha ocurrido un error al recuperar el objeto");
       }finally{
           session.close();
           return res;
       }
       
    }
    
    void cerrar() {
        session.close();
    }
    void abrir() {
        session = sessionFactory.openSession();
    }

    void getListaTransacciones(ArrayList<Entrada> entradas) {
        session = sessionFactory.openSession();
        query = session.createQuery("SELECT d FROM Entrada d");
        entradas.addAll(query.list());
        session.close();
    }

    void getListaDepositos(ArrayList<Deposito> listaDepositos) {
        session = sessionFactory.openSession();
        query = session.createQuery("SELECT d FROM Deposito d");
        listaDepositos.addAll(query.list());
        session.close();
    }

    
}
