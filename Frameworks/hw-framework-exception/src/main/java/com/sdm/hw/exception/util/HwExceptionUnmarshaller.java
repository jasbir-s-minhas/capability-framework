package com.sdm.hw.exception.util;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.StringUtils;

import com.sdm.hw.exception.dto.HwException;
import com.sdm.hw.exception.dto.HwExceptionInfo;
import com.sdm.hw.logging.intf.HwLogger;
import com.sdm.hw.logging.services.LogManager;

/**
 * This class is used to parse exception info file
 * 
 * @author TCS
 * 
 */
@SuppressWarnings("restriction")
public class HwExceptionUnmarshaller {
    private final String HW_EXP_FILE = "/hw-exception-info.xml";
    private static final String HW_XML_UNMARSHAL_MSG = " Exception Configuration file can not be parsed.";
    private static final String HW_EXCEPTION_MSG = "Below Exception occured while parsing configuration file :";
    private HwExceptionInfo hwExceptionInfo = null;
    private static final HwLogger logger = LogManager
            .getLogger(HwExceptionUnmarshaller.class);

    /**
     * Parse hw-exp-info.xml or module based info xml. Module specific xml name
     * will be hw-<modulename>-exp-info.xml format
     * 
     * @param filePath
     * @return List<HwException> @see HwException
     */
    public List<HwException> parseExceptionXml(final String filePath) {

        try {
            final JAXBContext context = JAXBContext.newInstance(
                    HwExceptionInfo.class, HwException.class);
            final Unmarshaller unmarshaller = context.createUnmarshaller();
            if (StringUtils.isNotEmpty(filePath)) {
                hwExceptionInfo = (HwExceptionInfo) unmarshaller
                        .unmarshal(HwExceptionUnmarshaller.class
                                .getResourceAsStream(filePath));

            }
            else {
                hwExceptionInfo = (HwExceptionInfo) unmarshaller
                        .unmarshal(HwExceptionUnmarshaller.class
                                .getResourceAsStream(this.HW_EXP_FILE));

            }
        }
        catch (final JAXBException jaxbException) {
            logger.logError(filePath + HW_XML_UNMARSHAL_MSG, jaxbException);
            hwExceptionInfo = new HwExceptionInfo();
        }
        catch (final Exception exp) {
            logger.logError(HW_EXCEPTION_MSG + filePath, exp);
            hwExceptionInfo = new HwExceptionInfo();
        }

        return hwExceptionInfo.getListException();
    }

}
