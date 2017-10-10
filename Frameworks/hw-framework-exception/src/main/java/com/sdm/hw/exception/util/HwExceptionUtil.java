package com.sdm.hw.exception.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.util.StringUtils;

import com.sdm.hw.exception.dto.HwException;
import com.sdm.hw.exception.dto.HwExceptionDTO;
import com.sdm.hw.exception.intf.IHwExceptionHandler;
import com.sdm.hw.exception.services.HwBaseAppException;
import com.sdm.hw.exception.services.helper.HwExceptionHandlerFactory;
import com.sdm.hw.exception.services.helper.HwExceptionInfoProvider;
import com.sdm.hw.logging.services.LogManager;

/**
 * A Utility class which is used for various utility methods for exception
 * framework.
 * 
 * @author TCS
 * 
 */
public class HwExceptionUtil {

    private static final String NEW_LINE = "\n";
    private static final String DOT = ".";
    private static final int INIT_BUFFER_SIZE = 1024;
    public static final String LOG_ERROR = "ERROR";
    public static final String LOG_FATAL = "FATAL";
    public static final String LOG_OFF = "OFF";

    /**
     * Used to get Exception message text
     * 
     * @param businessComponent
     *            a message in string form
     * @param hwexp
     *            object of HwBaseAppException
     * @return exception message in string form
     */
    public String getExceptionMessage(final String businessComponent,
        final HwBaseAppException hwexp, final String businessCmpAttribute) {

        final IHwExceptionHandler hwExpHandler = HwExceptionHandlerFactory
                .getInstance().getExceptionHandler();
        final HwExceptionDTO exDTO = hwExpHandler.handleException(
                businessComponent, hwexp, businessCmpAttribute);
        return exDTO.getExceptionMessage();

    }

    /**
     * Used to get exception details as HwExceptionDTO
     * 
     * @param moduleContext
     * @param exp
     *            an object of Throwable class
     * @return DTO object @see HwExceptionDTO
     */
    public static HwExceptionDTO getExceptionDetails(
        final String moduleContext, final Throwable exp,
        final String moduleCtxAttribute) {
        final HwExceptionDTO exDTO = new HwExceptionDTO();
        // Fetch exception details from exception cache
        HwException expInfo = null;
        expInfo = HwExceptionInfoProvider.fetchExceptionInfo(moduleContext,
                HwExceptionUtil.getClassName(exp));

        if (null != expInfo) {
            if (LOG_ERROR.equalsIgnoreCase(expInfo.getLoggingType())) {
                exDTO.setLoggingType(LOG_ERROR);
            }
            else if (LOG_FATAL.equalsIgnoreCase(expInfo.getLoggingType())) {
                exDTO.setLoggingType(LOG_FATAL);
            }
            else {
                exDTO.setLoggingType(LOG_OFF);
            }
            String messageCode = expInfo.getMessageCode();
            if (expInfo.isContextReq()) {
                final StringBuffer contextMsg = new StringBuffer();

                contextMsg.append(messageCode);
                contextMsg.append(DOT);
                contextMsg.append(moduleContext);
                // If an Exception has different attribute then
                // moduleCtxAttribute would be append

                if (!StringUtils.isEmpty(moduleCtxAttribute)) {
                    contextMsg.append(DOT);
                    contextMsg.append(moduleCtxAttribute);
                }

                messageCode = contextMsg.toString();
            }
            final String expmessage = messageCode;
            // TODO Needs to be updated on integration with Internationalisation
            // framework for the message in a preferred language.
            exDTO.setExceptionMessage(expmessage);
            exDTO.setShowToUI(expInfo.isShowToUI());// Show exp to GUI or
                                                    // application monitoring
                                                    // tool
            exDTO.setMessagePropFile(moduleContext+"_messages");

        }
        return exDTO;
    }

    /**
     * Logs the exception using logBack logger.
     * 
     * @param exp
     *            object of Throwable
     * @param moduleContext
     *            business component in string form
     * @param loggingType
     *            in string form
     * 
     */

    public static void logException(final Class<?> clazz, final Throwable exp,
        final String moduleContext, final String loggingType) {
        // Log Exception depends upon Logger
        if (LOG_ERROR.equalsIgnoreCase(loggingType)) {
            LogManager.getLogger(clazz).logError(
                    HwExceptionUtil.getExceptionLog(exp, moduleContext));
        }
        else if (LOG_FATAL.equalsIgnoreCase(loggingType)) {
            LogManager.getLogger(clazz).logFatal(
                    HwExceptionUtil.getExceptionLog(exp, moduleContext), exp);
        }

    }

    /**
     * Gets the stack trace of a HwBaseAppException in String form.
     * 
     * @param exception
     *            HwBaseAppException object
     * @return Returns the detailed message.
     * 
     */
    public static String getDetailedMessage(final HwBaseAppException exception) {
        final StringBuffer msg = new StringBuffer(INIT_BUFFER_SIZE);

        final String message = exception.getMessage();
        if (!StringUtils.isEmpty(message)) {
            msg.append("Message : ");
            msg.append(message);
            msg.append(NEW_LINE);
        }

        msg.append("Exception Stack Trace\n");
        appendStackTrace(exception, msg);
        final Throwable rootCause = exception.getCause();
        if (null != rootCause) {
            msg.append("\n Root Exception Stack Trace : ");
            msg.append(rootCause.toString());
            msg.append(NEW_LINE);
            appendStackTrace(rootCause, msg);
        }
        return msg.toString();
    }

    private static void appendStackTrace(final Throwable exception,
        final StringBuffer msg) {
        try {
            final StringWriter sWriter = new StringWriter(INIT_BUFFER_SIZE);
            final PrintWriter pWriter = new PrintWriter(sWriter);
            LogManager.getLogger(HwExceptionUtil.class).logError(exception.getMessage(),exception);//Sonar Fix S1148 24/02/2017
            msg.append(sWriter.toString());
            sWriter.close();
        }
        catch (final Exception exp) {
            msg.append(exception.toString());
        }
    }

    /**
     * Gets the stack trace of a Throwable in String form.
     * 
     * @param throwable
     *            Throwable object.
     * @return Returns the message as String.
     * 
     */
    public static String getDetailedMessage(final Throwable throwable) {
        final StringBuffer msg = new StringBuffer(INIT_BUFFER_SIZE);

        msg.append("Message : ");
        msg.append(throwable.getMessage());
        msg.append(NEW_LINE);
        msg.append("Exception Stack Trace\n");
        try {
            final StringWriter sWriter = new StringWriter();
            final PrintWriter pWriter = new PrintWriter(sWriter);
            LogManager.getLogger(HwExceptionUtil.class).logError(throwable.getMessage(),throwable);//Sonar Fix S1148 24/02/2017
            msg.append(sWriter.toString());
            sWriter.close();
        }
        catch (final Exception e) {
            msg.append(throwable.toString());
        }
        return msg.toString();
    }

    /**
     * Gets the name of class based on passed Throwable instance.
     * 
     * @param throwable
     *            Throwable object to get class name
     * @return the name of the class.
     * 
     */
    public static String getClassName(final Throwable throwable) {
        final String className = throwable.getClass().getName();
        String errId = className;

        if (throwable instanceof HwBaseAppException) {
            final int index = errId.lastIndexOf('.');
            errId = className.substring(index + 1);
        }
        return errId;
    }

    /**
     * Gets the detailed message of a HwBaseAppException including stack trace,
     * moduleContext and errorId information in String form. This detailed
     * message is used as a stack trace for log file as well as database.
     * 
     * @param exp
     *            HwBaseAppException object
     * @param ModuleContext
     *            the Module for which exception occured.
     * @return the detailed message.
     * 
     */
    private static String getExceptionLog(final Throwable exp,
        final String moduleContext) {
        final String errorId = getClassName(exp);
        String detailedMessage;
        if (exp instanceof HwBaseAppException) {
            final HwBaseAppException hwException = (HwBaseAppException) exp;
            detailedMessage = getDetailedMessage(hwException);
        }
        else {
            detailedMessage = getDetailedMessage(exp);
        }

        final StringBuffer lBuffer = new StringBuffer(INIT_BUFFER_SIZE);
        String msg;
        lBuffer.append(NEW_LINE);
        lBuffer.append("ERRORID :");
        lBuffer.append(errorId);
        lBuffer.append(NEW_LINE);

        lBuffer.append("MODULE : ");
        lBuffer.append(moduleContext);
        lBuffer.append(NEW_LINE);

        lBuffer.append("EXCEPTION MESSAGE :");
        lBuffer.append(detailedMessage);
        lBuffer.append(NEW_LINE);

        msg = lBuffer.toString();
        return msg;
    }

}