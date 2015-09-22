/**
 * Revenue Settlement and Sharing System GE
 * Copyright (C) 2011-2014,  Javier Lucio - lucio@tid.es
 * Telefonica Investigacion y Desarrollo, S.A.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package es.tid.fiware.rss.model;

// Generated 24-abr-2012 17:09:13 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BmProductVsOb generated by hbm2java.
 */
@Entity
@Table(name = "bm_product_vs_ob")
public class BmProductVsOb implements java.io.Serializable {

    private BmProductVsObId id;
    private BmProduct bmProduct;
    private BmServiceDeployment bmServiceDeployment;
    private BigDecimal nuPrice;

    /**
     * Constructor.
     */
    public BmProductVsOb() {
    }

    /**
     * Constructor.
     * 
     * @param id
     * @param bmProduct
     * @param bmServiceDeployment
     */
    public BmProductVsOb(BmProductVsObId id, BmProduct bmProduct, BmServiceDeployment bmServiceDeployment) {
        this.id = id;
        this.bmProduct = bmProduct;
        this.bmServiceDeployment = bmServiceDeployment;
    }

    /**
     * Constructor.
     * 
     * @param id
     * @param bmProduct
     * @param bmServiceDeployment
     * @param nuPrice
     */
    public BmProductVsOb(BmProductVsObId id, BmProduct bmProduct, BmServiceDeployment bmServiceDeployment,
        BigDecimal nuPrice) {
        this.id = id;
        this.bmProduct = bmProduct;
        this.bmServiceDeployment = bmServiceDeployment;
        this.nuPrice = nuPrice;
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "nuProductId", column = @Column(name = "NU_PRODUCT_ID", nullable = false,
            precision = 10, scale = 0)),
        @AttributeOverride(name = "nuDeploymentId", column = @Column(name = "NU_DEPLOYMENT_ID", nullable = false,
            precision = 10, scale = 0))
    })
    public BmProductVsObId getId() {
        return this.id;
    }

    public void setId(BmProductVsObId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NU_PRODUCT_ID", nullable = false, insertable = false, updatable = false)
    public BmProduct getBmProduct() {
        return this.bmProduct;
    }

    public void setBmProduct(BmProduct bmProduct) {
        this.bmProduct = bmProduct;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NU_DEPLOYMENT_ID", nullable = false, insertable = false, updatable = false)
    public BmServiceDeployment getBmServiceDeployment() {
        return this.bmServiceDeployment;
    }

    public void setBmServiceDeployment(BmServiceDeployment bmServiceDeployment) {
        this.bmServiceDeployment = bmServiceDeployment;
    }

    @Column(name = "NU_PRICE", precision = 10, scale = 4)
    public BigDecimal getNuPrice() {
        return this.nuPrice;
    }

    public void setNuPrice(BigDecimal nuPrice) {
        this.nuPrice = nuPrice;
    }

}