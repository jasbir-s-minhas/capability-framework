package com.sdm.hw.logging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

import com.sdm.hw.logging.intf.HwLogger;

/**
 * This class define methods of HwLogger interface and log errors to logger
 * according to their level.
 * 
 * @author TCS
 * 
 */
public final class ApplicationLogger implements HwLogger {
    private Logger logger = null;

    /**
     * Argument type Constructor.
     * 
     * @param clazz
     *            reference of this class
     */
    public ApplicationLogger(final Class<?> clazz) {
        this.setLogger(LoggerFactory.getLogger(clazz));
    }

    /**
     * Method will log FATAL level message and declared in HwLogger
     * interface.Overloaded on argument type.
     */
    public void logFatal(final String paramString,
        final Throwable paramThrowable) {
        this.logger.error(MarkerFactory.getMarker(LogManager.FATAL_MSG),
                paramString, paramThrowable);
    }
    
    /**
     * @see #logKPI(String)
     */
    public void logKPI(final String paramString,
        final Object[] parArrObj) {
        this.logger.info(paramString, parArrObj);
      
    }
    /**
     * @see #logKPI(String)
     */
    public void logKPI(final String paramString,
        final Object parArrObj) {
        this.logger.info(paramString, parArrObj);
    }
  
    /**
     * @see #logFatal(String, Throwable)
     */
    public void logFatal(final String paramString, final Object paramObject,
        final Throwable paramThrowable) {
        this.logger.error(MarkerFactory.getMarker(LogManager.FATAL_MSG),
                paramString, paramObject, paramThrowable);
    }

    /**
     * @see #logFatal(String, Throwable)
     */
    public void logFatal(final String paramString,
        final Object[] parArrObj, final Throwable paramThrowable) {
        this.logger.error(MarkerFactory.getMarker(LogManager.FATAL_MSG),
                paramString, parArrObj);
    }

    /**
     * Method will log INFO level message and declared in HwLogger
     * interface.Overloaded on argument type.
     */
    public void logInfo(final String paramString) {
        this.logger.info(paramString);
    }

    /**
     * @see #logInfo(String)
     */
    public void logInfo(final String paramString, final Object paramObject) {
        this.logger.info(paramString,paramObject);
    }

    /**
     * @see #logInfo(String)
     */
    public void logInfo(final String paramString,
        final Object[] parArrObj) {
        this.logger.info(paramString, parArrObj);
    }

    /**
     * Method will log DEBUG level message and declared in HwLogger
     * interface.Overloaded on argument type.
     */
    public void logDebug(final String paramString) {
        this.logger.debug(paramString);
    }

    /**
     * @see #logDebug(String)
     */
    public void logDebug(final String paramString, final Object paramObject) {
        this.logger.debug(paramString, paramObject);
    }

    /**
     * @see #logDebug(String)
     */
    public void logDebug(final String paramString,
        final Object[] parArrObj) {
        this.logger.debug(paramString, parArrObj);
    }

    /**
     * Method will log ERROR level message and declared in HwLogger
     * interface.Overloaded on argument type.
     */

    public void logError(final String paramString) {
        this.logger.error(paramString);
    }

    /**
     * @see #logError(String)
     */
    public void logError(final String paramString,
        final Throwable paramThrowable) {
        this.logger.error(paramString, paramThrowable);
    }

    /**
     * @see #logError(String)
     */
    public void logError(final String paramString, final Object paramObject,
        final Throwable paramThrowable) {
        this.logger.error(paramString, paramObject, paramThrowable);
    }

    /**
     * @see #logError(String)
     */
    public void logError(final String paramString,
        final Object[] parArrObj, final Throwable paramThrowable) {
        this.logger.error(paramString, parArrObj, paramThrowable);
    }

    /**
     * Method will log WARN level message and declared in HwLogger
     * interface.Overloaded on argument type.
     */
    public void logWarn(final String paramString) {
        this.logger.warn(paramString);
    }

    /**
     * @see #logWarn(String)
     */
    public void logWarn(final String paramString, final Object paramObject) {
        this.logger.warn(paramString, paramObject);
    }

    /**
     * @see #logWarn(String)
     */
    public void logWarn(final String paramString,
        final Object[] paramArrayOfObject) {
        this.logger.warn(paramString, paramArrayOfObject);
    }
    
    /**
     *      
     * @see #logWarn(String)
     */
    public void logWarn(final String paramString,
            final Object[] parArrObj, final Throwable paramThrowable) {
            this.logger.warn(paramString, parArrObj, paramThrowable);
    	
    }
    
    public void logWarn(final String paramString, final Object paramObject,
            final Throwable paramThrowable) {
            this.logger.warn(paramString, paramObject, paramThrowable);
        }

    /**
     * @param logger
     *            the logger to set
     */
    public void setLogger(final Logger logger) {
        this.logger = logger;
    }

}
