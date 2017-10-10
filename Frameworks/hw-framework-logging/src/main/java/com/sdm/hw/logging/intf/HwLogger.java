package com.sdm.hw.logging.intf;
//Testing Commit and push
/**
 * This interface will declare various method for different error level i.e.
 * Fatal,Info,Debug,Error. ApplicationLogger class will implement this interface
 * and define all the method.
 * 
 * @author TCS
 */

public interface HwLogger {

    /**
     * It will log fatal level error.
     * 
     * @param paramString
     *            in string form
     * @param paramThrowable
     *            object of Throwable
     */
    public void logFatal(String paramString, Throwable paramThrowable);

    /**
     * It will log fatal level error.
     * 
     * @param paramString
     *            in string form
     * @param paramObject
     *            object of Object type
     * @param paramThrowable
     *            object of Throwable
     */
    public void logFatal(String paramString, Object paramObject,
        Throwable paramThrowable);

    /**
     * It will log fatal level error.
     * 
     * @param paramString
     *            in string form
     * @param paramArrayOfObject
     *            array of Object type
     * @param paramThrowable
     *            object of Throwable
     */
    public void logFatal(String paramString, Object[] parArrObj,
        Throwable paramThrowable);

    /**
     * It will log INFO level error.
     * 
     * @param paramString
     *            in string form
     */
    public void logInfo(String paramString);

    /**
     * It will log INFO level error.
     * 
     * @param paramString
     *            in string form
     * @param paramObject
     *            object of Throwable
     */

    public void logInfo(String paramString, Object paramObject);

    /**
     * It will log INFO level error.
     * 
     * @param paramString
     *            in string form
     * @param paramArrayOfObject
     *            array of Object type
     */

    public void logInfo(String paramString, Object[] parArrObj);

    /**
     * It will log DEBUG level error.
     * 
     * @param paramString
     *            in string form
     */
    public void logDebug(String paramString);

    /**
     * It will log DEBUG level error.
     * 
     * @param paramString
     *            in string form
     * @param paramObject
     *            object of Object
     */
    public void logDebug(String paramString, Object paramObject);

    /**
     * It will log DEBUG level error.
     * 
     * @param paramString
     *            in string form
     * @param paramArrayOfObject
     *            array of Object type
     */
    public void logDebug(String paramString, Object[] parArrObj);

    /**
     * It will log ERROR level error.
     * 
     * @param paramString
     *            in string form
     */
    public void logError(String paramString);

    /**
     * It will log ERROR level error.
     * 
     * @param paramString
     *            in string form
     * @param paramThrowable
     *            object of Throwable
     */
    public void logError(String paramString, Throwable paramThrowable);

    /**
     * It will log ERROR level error.
     * 
     * @param paramString
     *            in string form
     * @param paramObject
     *            object of Object
     * @param paramThrowable
     *            object of Throwable
     */
    public void logError(String paramString, Object paramObject,
        Throwable paramThrowable);

    /**
     * It will log ERROR level error.
     * 
     * @param paramString
     *            in string form
     * @param paramArrayOfObject
     *            array of Object type
     * @param paramThrowable
     *            object of Throwable
     */
    public void logError(String paramString, Object[] parArrObj,
        Throwable paramThrowable);

    /**
     * It will log WARN level error.
     * 
     * @param paramString
     *            in string form
     */
    public void logWarn(String paramString);

    /**
     * It will log WARN level error.
     * 
     * @param paramString
     *            in string form
     * @param paramObject
     *            object of Object
     */
    public void logWarn(String paramString, Object paramObject);

    /**
     * It will log WARN level error.
     * 
     * @param paramString
     *            in string form
     * @param paramArrayOfObject
     *            array of Object type
     */
    public void logWarn(String paramString, Object[] parArrObj);
    
    /**
     * 
     * @param paramString
     * 			   in string form
     * @param paramArrayOfObject
     *            array of Object type
     * @param paramThrowable
     *             object of Throwable
     */
    public void logWarn(String paramString, Object[] parArrObj,
            Throwable paramThrowable);
    /**
     * 
     * @param paramString
     * @param paramObject
     * @param paramThrowable
     */
    public void logWarn(String paramString, Object paramObject,
            Throwable paramThrowable);
}
