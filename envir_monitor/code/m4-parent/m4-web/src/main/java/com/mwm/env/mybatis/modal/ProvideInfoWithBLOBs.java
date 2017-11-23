package com.mwm.env.mybatis.modal;

public class ProvideInfoWithBLOBs extends ProvideInfo {
    private String measurecerurl;

    private String detectioncapabilityurl;

    private String annexsseturl;

    public String getMeasurecerurl() {
        return measurecerurl;
    }

    public void setMeasurecerurl(String measurecerurl) {
        this.measurecerurl = measurecerurl == null ? null : measurecerurl.trim();
    }

    public String getDetectioncapabilityurl() {
        return detectioncapabilityurl;
    }

    public void setDetectioncapabilityurl(String detectioncapabilityurl) {
        this.detectioncapabilityurl = detectioncapabilityurl == null ? null : detectioncapabilityurl.trim();
    }

    public String getAnnexsseturl() {
        return annexsseturl;
    }

    public void setAnnexsseturl(String annexsseturl) {
        this.annexsseturl = annexsseturl == null ? null : annexsseturl.trim();
    }
}