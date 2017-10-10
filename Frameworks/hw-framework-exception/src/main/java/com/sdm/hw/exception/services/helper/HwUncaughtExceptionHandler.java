package com.sdm.hw.exception.services.helper;

import java.awt.Component;

import javax.swing.JOptionPane;

import com.sdm.hw.exception.util.HwExceptionUtil;

/**
 * This class is used for handling uncaught exception. This will implement
 * UncaughtExceptionHandler interface of Thread class.
 * 
 * @author TCS
 * 
 */
public class HwUncaughtExceptionHandler implements
        Thread.UncaughtExceptionHandler {

    private static final String HW_APP = "HW";
    private static final String ERROR_LOG = "ERROR";
    private static final String ERROR_TEXT_COLOLN = "Error :";
    private static final String ERROR_TEXT = "Error";
    private static final String GLOBAL_ERROR_MSG = "hw.global.error.msg";

    /**
     * handle un-checked exception thrown by Thread
     */
    public void uncaughtException(final Thread thread, final Throwable exp) {
        handle(exp);
    }

    /**
     * Handle runtime exception as Throwable object
     * 
     * @param throwable
     */
    public void handle(final Throwable throwable) {
        try {
            final Component parent = null;
            // Log Unchecked Exception
            HwExceptionUtil.logException(this.getClass(), throwable, HW_APP,
                    ERROR_LOG);
            // Show Global Error to User
            JOptionPane.showMessageDialog(parent, ERROR_TEXT_COLOLN
                    + GLOBAL_ERROR_MSG, ERROR_TEXT, JOptionPane.ERROR_MESSAGE);
        }
        catch (final Exception ex) {
            // Log Exception into a file
            HwExceptionUtil
                    .logException(this.getClass(), ex, HW_APP, ERROR_LOG);

        }
    }

    /**
     * Used to register uncaught exception handler
     */
    public static void registerUncaughtExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(new HwUncaughtExceptionHandler());
    }

}
