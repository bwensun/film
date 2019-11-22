package com.bowensun.film.web;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name="lsd")
public class BwLsdxx implements Cloneable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6653695031951236675L;

	private String id;

    private String cfid;

    private String hbid;
    
    private String fpid;

    private String lsdbh;

    private String pch;

    private Date czrq;

    private Date djrq;

    private String ghdwmc;

    private String ghdwdm;

    private String ghdwdzdh;

    private String ghdwyhzh;

    private String xhdwmc;

    private String xhdwdm;

    private String xhdwdzdh;

    private String xhdwyhzh;

    private BigDecimal hjje;

    private BigDecimal hjse;

    private BigDecimal jshj;

    private String qdbz;

    private String kplx;

    private String hsbz;

    private String bbh;

    private String fplxdm;

    private String zsfs;

    private String tspz;

    private String sblx;

    private String jqbh;

    private String hzxxb;

    private String tzdh;

    private Long zzBm;

    private String zzName;

    private Long zhBm;

    private String yfpdm;

    private String yfphm;

    private BigDecimal kce;

    private String yx;

    private String dh;

    private String lybz;

    private String yzbz;

    private String czbz;

    private String ztbz;

    private String bz;

    private String skr;

    private String fhr;

    private String kpr;

    private String by1;

    private String by2;

    private String by3;

    private String by4;

    private String lyxtbs;




    /**
     * 申请人账号
     */
    private String sqrzh;

    /**
     * 申请人名称
     */
    private String sqrmc;

    /**
     * 销货单位代码
     */
    private String xhdwcode;

    /**
     * 合同号
     */
    private String hth;

    /**
     * 冲销流水单编号
     */
    private String cxlsdbh;

    /**
     * 产品组
     */
    private String cpz;

    /**
     * 物料大类
     */
    private String wldl;

    /**
     * 销货单位简称
     */
    private String xhdwjc;

    /**
     * MRO发票开具回传ID
     */
    private String transId;

    public String getSqrzh() {
        return sqrzh;
    }

    public void setSqrzh(String sqrzh) {
        this.sqrzh = sqrzh;
    }

    public String getSqrmc() {
        return sqrmc;
    }

    public void setSqrmc(String sqrmc) {
        this.sqrmc = sqrmc;
    }

    public String getXhdwcode() {
        return xhdwcode;
    }

    public void setXhdwcode(String xhdwcode) {
        this.xhdwcode = xhdwcode;
    }

    public String getHth() {
        return hth == null ? "" : hth;
    }

    public void setHth(String hth) {
        this.hth = hth;
    }

    public String getCxlsdbh() {
        return cxlsdbh;
    }

    public void setCxlsdbh(String cxlsdbh) {
        this.cxlsdbh = cxlsdbh;
    }

    public String getCpz() {
        return cpz == null ? "" : cpz;
    }

    public void setCpz(String cpz) {
        this.cpz = cpz;
    }

    public String getWldl() {
        return wldl == null ? "" : wldl;
    }

    public void setWldl(String wldl) {
        this.wldl = wldl;
    }

    /***** Add by panchw 20181008 END ***/

    public BwLsdxx() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCfid() {
        return cfid;
    }

    public void setCfid(String cfid) {
        this.cfid = cfid == null ? null : cfid.trim();
    }

    public String getHbid() {
        return hbid;
    }

    public void setHbid(String hbid) {
        this.hbid = hbid == null ? null : hbid.trim();
    }

    @XmlElement(name="lsdbh")
    public String getLsdbh() {
        return lsdbh;
    }

    public void setLsdbh(String lsdbh) {
        this.lsdbh = lsdbh == null ? null : lsdbh.trim();
    }

    public String getPch() {
        return pch;
    }

    public void setPch(String pch) {
        this.pch = pch == null ? null : pch.trim();
    }

    public Date getCzrq() {
        return czrq;
    }

    public void setCzrq(Date czrq) {
        this.czrq = czrq;
    }

    @XmlElement(name="djrq")
    public Date getDjrq() {
        return djrq;
    }

    public void setDjrq(Date djrq) {
        this.djrq = djrq;
    }

    @XmlElement(name="ghdwmc")
    public String getGhdwmc() {
        return ghdwmc;
    }

    public void setGhdwmc(String ghdwmc) {
        this.ghdwmc = ghdwmc == null ? null : ghdwmc.trim();
    }

    @XmlElement(name="ghdwdm")
    public String getGhdwdm() {
        return ghdwdm;
    }

    public void setGhdwdm(String ghdwdm) {
        this.ghdwdm = ghdwdm == null ? null : ghdwdm.trim();
    }

    @XmlElement(name="ghdwdzdh")
    public String getGhdwdzdh() {
        return ghdwdzdh;
    }

    public void setGhdwdzdh(String ghdwdzdh) {
        this.ghdwdzdh = ghdwdzdh == null ? null : ghdwdzdh.trim();
    }

    @XmlElement(name="ghdwyhzh")
    public String getGhdwyhzh() {
        return ghdwyhzh;
    }

    public void setGhdwyhzh(String ghdwyhzh) {
        this.ghdwyhzh = ghdwyhzh == null ? null : ghdwyhzh.trim();
    }

    public String getXhdwmc() {
        return xhdwmc;
    }

    public void setXhdwmc(String xhdwmc) {
        this.xhdwmc = xhdwmc == null ? null : xhdwmc.trim();
    }

    public String getXhdwdm() {
        return xhdwdm;
    }

    public void setXhdwdm(String xhdwdm) {
        this.xhdwdm = xhdwdm == null ? null : xhdwdm.trim();
    }

    public String getXhdwdzdh() {
        return xhdwdzdh;
    }

    public void setXhdwdzdh(String xhdwdzdh) {
        this.xhdwdzdh = xhdwdzdh == null ? null : xhdwdzdh.trim();
    }

    public String getXhdwyhzh() {
        return xhdwyhzh;
    }

    public void setXhdwyhzh(String xhdwyhzh) {
        this.xhdwyhzh = xhdwyhzh == null ? null : xhdwyhzh.trim();
    }

    @XmlElement(name="hjje")
    public BigDecimal getHjje() {
        return hjje;
    }

    public void setHjje(BigDecimal hjje) {
        this.hjje = hjje;
    }

    @XmlElement(name="hjse")
    public BigDecimal getHjse() {
        return hjse;
    }

    public void setHjse(BigDecimal hjse) {
        this.hjse = hjse;
    }

    @XmlElement(name="jshj")
    public BigDecimal getJshj() {
        return jshj;
    }

    public void setJshj(BigDecimal jshj) {
        this.jshj = jshj;
    }

    public String getQdbz() {
        return qdbz;
    }

    public void setQdbz(String qdbz) {
        this.qdbz = qdbz == null ? null : qdbz.trim();
    }

    public String getKplx() {
        return kplx;
    }

    public void setKplx(String kplx) {
        this.kplx = kplx == null ? null : kplx.trim();
    }

    @XmlElement(name="hsbz")
    public String getHsbz() {
        return hsbz;
    }

    public void setHsbz(String hsbz) {
        this.hsbz = hsbz == null ? null : hsbz.trim();
    }

    public String getBbh() {
        return bbh;
    }

    public void setBbh(String bbh) {
        this.bbh = bbh == null ? null : bbh.trim();
    }

    @XmlElement(name="fplxdm")
    public String getFplxdm() {
        return fplxdm;
    }

    public void setFplxdm(String fplxdm) {
        this.fplxdm = fplxdm == null ? null : fplxdm.trim();
    }

    public String getZsfs() {
        return zsfs;
    }

    public void setZsfs(String zsfs) {
        this.zsfs = zsfs == null ? null : zsfs.trim();
    }

    public String getTspz() {
        return tspz;
    }

    public void setTspz(String tspz) {
        this.tspz = tspz == null ? null : tspz.trim();
    }

    public String getSblx() {
        return sblx;
    }

    public void setSblx(String sblx) {
        this.sblx = sblx == null ? null : sblx.trim();
    }

    public String getJqbh() {
        return jqbh;
    }

    public void setJqbh(String jqbh) {
        this.jqbh = jqbh == null ? null : jqbh.trim();
    }

    public String getHzxxb() {
        return hzxxb;
    }

    public void setHzxxb(String hzxxb) {
        this.hzxxb = hzxxb == null ? null : hzxxb.trim();
    }

    public String getTzdh() {
        return tzdh;
    }

    public void setTzdh(String tzdh) {
        this.tzdh = tzdh == null ? null : tzdh.trim();
    }

    public Long getZzBm() {
        return zzBm;
    }

    public void setZzBm(Long zzBm) {
        this.zzBm = zzBm;
    }

    public void setZzName(String zzName) {
        this.zzName = zzName;
    }


    public Long getZhBm() {
        return zhBm;
    }

    public void setZhBm(Long zhBm) {
        this.zhBm = zhBm;
    }

    public String getYfpdm() {
        return yfpdm;
    }

    public void setYfpdm(String yfpdm) {
        this.yfpdm = yfpdm == null ? null : yfpdm.trim();
    }

    public String getYfphm() {
        return yfphm;
    }

    public void setYfphm(String yfphm) {
        this.yfphm = yfphm == null ? null : yfphm.trim();
    }

    public BigDecimal getKce() {
        return kce;
    }

    public void setKce(BigDecimal kce) {
        this.kce = kce;
    }

    @XmlElement(name="yx")
    public String getYx() {
        return yx;
    }

    public void setYx(String yx) {
        this.yx = yx == null ? null : yx.trim();
    }

    @XmlElement(name="dh")
    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh == null ? null : dh.trim();
    }

    public String getLybz() {
        return lybz;
    }

    public void setLybz(String lybz) {
        this.lybz = lybz == null ? null : lybz.trim();
    }

    public String getYzbz() {
        return yzbz;
    }

    public void setYzbz(String yzbz) {
        this.yzbz = yzbz == null ? null : yzbz.trim();
    }

    public String getCzbz() {
        return czbz;
    }

    public void setCzbz(String czbz) {
        this.czbz = czbz == null ? null : czbz.trim();
    }

    public String getZtbz() {
        return ztbz;
    }

    public void setZtbz(String ztbz) {
        this.ztbz = ztbz == null ? null : ztbz.trim();
    }



    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    @XmlElement(name="skr")
    public String getSkr() {
        return skr;
    }

    public String getXhdwjc() {
        return xhdwjc;
    }

    public void setXhdwjc(String xhdwjc) {
        this.xhdwjc = xhdwjc;
    }

    public void setSkr(String skr) {
        this.skr = skr == null ? null : skr.trim();
    }

    @XmlElement(name="fhr")
    public String getFhr() {
        return fhr;
    }

    public void setFhr(String fhr) {
        this.fhr = fhr == null ? null : fhr.trim();
    }

    public String getKpr() {
        return kpr;
    }

    public void setKpr(String kpr) {
        this.kpr = kpr == null ? null : kpr.trim();
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1 == null ? null : by1.trim();
    }

    public String getBy2() {
        return by2;
    }

    public void setBy2(String by2) {
        this.by2 = by2 == null ? null : by2.trim();
    }

    public String getBy3() {
        return by3;
    }

    public void setBy3(String by3) {
        this.by3 = by3 == null ? null : by3.trim();
    }

    public String getBy4() {
        return by4;
    }

    public void setBy4(String by4) {
        this.by4 = by4 == null ? null : by4.trim();
    }
    public String getLyxtbs() { return lyxtbs; }

    public void setLyxtbs(String lyxtbs) { this.lyxtbs = lyxtbs == null ? null : lyxtbs.trim(); }


	
	@Override  
    public Object clone() {  
		BwLsdxx lsdxx = null;  
        try{  
        	lsdxx = (BwLsdxx)super.clone();  
        }catch(CloneNotSupportedException e) {
            System.out.println("111111111111111");
        }  
        return lsdxx;  
    }

	public String getFpid() {
		return fpid;
	}

	public void setFpid(String fpid) {
		this.fpid = fpid;
	}
	

}