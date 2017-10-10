package com.sdm.hw.logging.services;

import org.aspectj.lang.JoinPoint;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * This class define various tracing method.
 * 
 * @author TCS
 * 
 */
public class HwTracingAspect {
    private static final Marker MARKER = MarkerFactory
            .getMarker(LogManager.TRACE_MSG);

    /**
     * Used for Before advice
     * 
     * @param joinPoint
     *            to apply advice
     */
    public void traceBefore(final JoinPoint joinPoint) {
    	
    	String params=null;
    	Object[] argsList=joinPoint.getArgs();
    	for(Object param:argsList)
    	{
    		params=param.toString()+":";
    	}
        LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName())
                .info(MARKER, "\nBefore execution of Method {} having arguments {} ",
                		new Object[] { joinPoint.getSignature().toLongString(),
                        params });
    }

    /**
     * Used for AfterReturning advice
     * 
     * @param joinPoint
     *            to apply advice
     * @param result
     */
    public void traceAfterReturning(final JoinPoint joinPoint,
        final Object result) {
        LoggerFactory
                .getLogger(joinPoint.getTarget().getClass())
                .info(MARKER,
                        "\nAfter execution of Method {} and return value is : {}",
                        new Object[] { joinPoint.getSignature().toLongString(),
                                result });
    }

    /**
     * This is used for any exception occured during joint point execution
     * 
     * @param joinPoint
     *            to apply advice
     * @param error
     *            an object of Throwable
     */
    public void traceAfterThrowing(final JoinPoint joinPoint,
        final Throwable error) {
        LoggerFactory.getLogger(joinPoint.getTarget().getClass()).info(MARKER,
                "Exception occured during the execution of method : {}.",
                joinPoint.getSignature().getName(), error);
    }

}
