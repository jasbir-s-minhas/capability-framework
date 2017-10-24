package com.sdm.hw.store.services;

import com.sdm.hw.store.dto.SubEHealthConfigConstants;
import com.sdm.hw.exception.services.HwBaseAppException;

public class HwStoreServiceImpl {
    @Deprecated
    public boolean isSubEHealthEnabled(String capabilityName)
            throws HwBaseAppException {
        /// New Code
        return SubEHealthConfigConstants.getConstantObj(capabilityName).isEnabled();
        /// End of new Code
    }
}
