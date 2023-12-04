package com.bm.ws.core.bdmysql;

public class ConsExamen {
	
    /**
     * 
     */
    //Desarrollo
  	public static final String FILE_XML_LOG = "examenLog4j.xml";


	/********************************************************************************
	 ********************************  Base de Datos  *******************************
	 ********************************************************************************/
  	
	/**
	 * 
	 */
	public static final String IP_MySQL_GIS = "127.0.0.1";

	/**
	 * 
	 */
	public static final String PUERTO_MySQL_GIS = "3306";
	
	/**
	 * 
	 */
	public static final String BD_MySQL_GIS = "examen";
	
	/**
	 * 
	 */
	public static final String USER_MySQL_GIS = "root";
	
	/**
	 * 
	 */
	public static final String PWD_MySQL_GIS = "PswC0vich0#00";
	
	/**
	 * 
	 */
	public static final String URL_MySQL_GIS = "jdbc:mysql://" + IP_MySQL_GIS + ":" + PUERTO_MySQL_GIS +"/" + BD_MySQL_GIS + "?user=" + USER_MySQL_GIS + "&password=" + PWD_MySQL_GIS;

	/**
	 * 
	 */
	public static final String DRIVE_MySQL = "com.mysql.jdbc.Drive";	
	

	
}