package com.cskaoyan.erp.model;

public class Product {
    private String pid;

    private String pname;

    private Double estoreprice;

    private Double markprice;

    private Integer pnum;

    private Integer cid;

    private String imgurl;

    private String desc;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Double getEstoreprice() {
        return estoreprice;
    }

    public void setEstoreprice(Double estoreprice) {
        this.estoreprice = estoreprice;
    }

    public Double getMarkprice() {
        return markprice;
    }

    public void setMarkprice(Double markprice) {
        this.markprice = markprice;
    }

    public Integer getPnum() {
        return pnum;
    }

    public void setPnum(Integer pnum) {
        this.pnum = pnum;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}