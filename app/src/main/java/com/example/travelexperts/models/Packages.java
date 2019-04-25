package com.example.travelexperts.models;

public class Packages {
    private String PackageId;
    private String PkgName;
    private String PkgStartDate;
    private String PkgEnddate;
    private String PkgDesc;
    private String BasePrice;
    private String PkgAgencyCommission;

    public Packages() {
    }

    public Packages(String packageId, String pkgName, String pkgStartDate, String pkgEnddate, String pkgDesc, String basePrice, String pkgAgencyCommission) {
        PackageId = packageId;
        PkgName = pkgName;
        PkgStartDate = pkgStartDate;
        PkgEnddate = pkgEnddate;
        PkgDesc = pkgDesc;
        BasePrice = basePrice;
        PkgAgencyCommission = pkgAgencyCommission;
    }

    public String getPackageId() {
        return PackageId;
    }

    public void setPackageId(String packageId) {
        PackageId = packageId;
    }

    public String getPkgName() {
        return PkgName;
    }

    public void setPkgName(String pkgName) {
        PkgName = pkgName;
    }

    public String getPkgStartDate() {
        return PkgStartDate;
    }

    public void setPkgStartDate(String pkgStartDate) {
        PkgStartDate = pkgStartDate;
    }

    public String getPkgEnddate() {
        return PkgEnddate;
    }

    public void setPkgEnddate(String pkgEnddate) {
        PkgEnddate = pkgEnddate;
    }

    public String getPkgDesc() {
        return PkgDesc;
    }

    public void setPkgDesc(String pkgDesc) {
        PkgDesc = pkgDesc;
    }

    public String getBasePrice() {
        return BasePrice;
    }

    public void setBasePrice(String basePrice) {
        BasePrice = basePrice;
    }

    public String getPkgAgencyCommission() {
        return PkgAgencyCommission;
    }

    public void setPkgAgencyCommission(String pkgAgencyCommission) {
        PkgAgencyCommission = pkgAgencyCommission;
    }
}
