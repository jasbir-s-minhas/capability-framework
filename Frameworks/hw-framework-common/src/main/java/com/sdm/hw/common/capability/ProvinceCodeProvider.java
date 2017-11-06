package com.sdm.hw.common.capability;

/**
 * This class provides the current province
 */
public final class ProvinceCodeProvider {

    private static final ProvinceCodeProvider provinceCodeProvider = new ProvinceCodeProvider();

    private ProvinceCode provinceCode = ProvinceCode.NOVA_SCOTIA;

    /**
     * Private constructor implementing singleton
     */
    private ProvinceCodeProvider() {
    }

    public static ProvinceCodeProvider getInstance() {
        return provinceCodeProvider;
    }

    /**
     * @return provinceCode for the current province
     */
    ProvinceCode getCurrentProvinceCode() {

        //TODO: Note for 17.1 team...please implement logic to read current province from
        //TODO: "STORE_PREFERENCE" table and the corresponding provincial code.
        return provinceCode;
    }

    void setCurrentProvinceCode(ProvinceCode provinceCode){
        this.provinceCode = provinceCode;
    }
}
