package com.hosp.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RecipeDrugs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "RECIPE_DRUGS", schema = "HOSPITAL")
public class RecipeDrugs implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private Drugs drugs;
	private Recipe recipe;
	private BigDecimal quantity;
	private Date recipestartdate;
	private Date recipeenddate;
	private BigDecimal quantityperdose;
	private BigDecimal quantityperday;

	// Constructors

	/** default constructor */
	public RecipeDrugs() {
	}

	/** minimal constructor */
	public RecipeDrugs(BigDecimal id) {
		this.id = id;
	}

	/** full constructor */
	public RecipeDrugs(BigDecimal id, Drugs drugs, Recipe recipe, BigDecimal quantity, Date recipestartdate, Date recipeenddate, BigDecimal quantityperdose,
			BigDecimal quantityperday) {
		this.id = id;
		this.drugs = drugs;
		this.recipe = recipe;
		this.quantity = quantity;
		this.recipestartdate = recipestartdate;
		this.recipeenddate = recipeenddate;
		this.quantityperdose = quantityperdose;
		this.quantityperday = quantityperday;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DRUGID")
	public Drugs getDrugs() {
		return this.drugs;
	}

	public void setDrugs(Drugs drugs) {
		this.drugs = drugs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RECIPEID")
	public Recipe getRecipe() {
		return this.recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	@Column(name = "QUANTITY", precision = 22, scale = 0)
	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RECIPESTARTDATE", length = 7)
	public Date getRecipestartdate() {
		return this.recipestartdate;
	}

	public void setRecipestartdate(Date recipestartdate) {
		this.recipestartdate = recipestartdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RECIPEENDDATE", length = 7)
	public Date getRecipeenddate() {
		return this.recipeenddate;
	}

	public void setRecipeenddate(Date recipeenddate) {
		this.recipeenddate = recipeenddate;
	}

	@Column(name = "QUANTITYPERDOSE", precision = 22, scale = 0)
	public BigDecimal getQuantityperdose() {
		return this.quantityperdose;
	}

	public void setQuantityperdose(BigDecimal quantityperdose) {
		this.quantityperdose = quantityperdose;
	}

	@Column(name = "QUANTITYPERDAY", precision = 22, scale = 0)
	public BigDecimal getQuantityperday() {
		return this.quantityperday;
	}

	public void setQuantityperday(BigDecimal quantityperday) {
		this.quantityperday = quantityperday;
	}

}