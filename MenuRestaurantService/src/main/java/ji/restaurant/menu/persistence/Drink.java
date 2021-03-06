package ji.restaurant.menu.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




/**
 * <b>REVISION 1.0</b>
 * <br>
 * <b>Fecha:</b>10/01/2015</b>
 * <b>representación en memoria de la tabla que define las bebidas que ofrecera el restaurante</b>
 * @author Ivan 
 * @version 1.0
 */
@Entity
@Table(name="Bebida")
public class Drink implements Serializable {

	/**
	 * Serial implementado por el IDE
	 */
	private static final long serialVersionUID = -8623709093664754871L;

	/**
	 * Identificador único de la entidad
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idBebida")
	private int idDrink;
	
	/**
	 * Etiqueta que define a la bebida
	 */
	@Column(name="bebida",nullable = false )
	private String drink;
	
	/**
	 * Codigo unica que cada bebida tiene
	 */
	@Column(name="codigoBebida",nullable = false )
	private int drinkCode;
	/**
	 * Enlace con el tipo de bebida que define en que categoria pertenece
	 */
	@ManyToOne(targetEntity=DrinkType.class,fetch = FetchType.EAGER)
	@JoinColumn(name="tipoDeBebida",referencedColumnName="idTipoBebida",nullable=false)
	private DrinkType drinkType;
	
	/**
	 * Define el precio de la bebida
	 */
	@Column(name="precioBebida",nullable = false )
	private BigDecimal drinkPrice;
	/**
	 * Relacion a la tabla intermedia entre <code>Drink</code>
	 * y <code>OrderDetail</code> siendo la primera subordinada a  <code>OrderDetail</code> 
	 */
	@ManyToMany(mappedBy="drinks",fetch = FetchType.EAGER,cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},targetEntity=OrderDetail.class)
	private Set<OrderDetail>orderDetails;  

	/**
	 * Alamcena el url de la imagen 
	 */
	@Column(name="imagenUrl" )
	private String imageUrl;
	
	/**
	 *Devuleve 
	 * @return the idDrink
	 */
	public int getIdDrink() {
		return idDrink;
	}
	/**
	 * Establece idDrink con  idBebida
	   @param idDrinkP 
	 */
	public void setIdDrink(int idDrinkP) {
		this.idDrink = idDrinkP;
	}
	/**
	 *Devuleve 
	 * @return the drink
	 */
	public String getDrink() {
		return drink;
	}
	/**
	 * Establece drink con  drinkP
	   @param drinkP 
	 */
	public void setDrink(String drinkP) {
		this.drink = drinkP;
	}
	/**
	 *Devuleve 
	 * @return the drinkCode
	 */
	public int getDrinkCode() {
		return drinkCode;
	}
	/**
	 * Establece drinkCode con  drinkCodeP
	   @param drinkCodeP 
	 */
	public void setDrinkCode(int drinkCodeP) {
		this.drinkCode = drinkCodeP;
	}
	/**
	 *Devuleve 
	 * @return the drinkType
	 */
	public DrinkType getDrinkType() {
		return drinkType;
	}
	/**
	 * Establece drinkType con  drinkTypeP
	   @param drinkTypeP 
	 */
	public void setDrinkType(DrinkType drinkTypeP) {
		this.drinkType = drinkTypeP;
	}
	/**
	 * Devuelve el valor de: orderDetails
	 * @return  orderDetails
	 */
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}
	/**
	 *Establece el valor de orderDetails 
	 * con @param orderDetailsP 
	 */
	public void setOrderDetails(Set<OrderDetail> orderDetailsP) {
		this.orderDetails = orderDetailsP;
	}
	
	/**
	 * Devuelve el valor de: imageUrl
	 * @return  imageUrl
	 */
	public String getImageUrl() {
		return this.imageUrl;
	}

	/**
	 *Establece el valor de imageUrl 
	 * con @param imageUrlP 
	 */
	public void setImageUrl(String imageUrlP) {
		this.imageUrl = imageUrlP;
	}
	/**
	 * Devuelve el valor de: drinkPrice
	 * @return  drinkPrice
	 */
	public BigDecimal getDrinkPrice() {
		return this.drinkPrice;
	}
	/**
	 *Establece el valor de drinkPrice 
	 * con @param drinkPriceP 
	 */
	public void setDrinkPrice(BigDecimal drinkPriceP) {
		this.drinkPrice = drinkPriceP;
	}
	
}
