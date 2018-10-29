/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package sga.eis.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the usuario table.
 */
public class UsuarioPk implements Serializable
{
	protected int idUsuario;

	/** 
	 * This attribute represents whether the primitive attribute idUsuario is null.
	 */
	protected boolean idUsuarioNull;

	/** 
	 * Sets the value of idUsuario
	 */
	public void setIdUsuario(int idUsuario)
	{
		this.idUsuario = idUsuario;
	}

	/** 
	 * Gets the value of idUsuario
	 */
	public int getIdUsuario()
	{
		return idUsuario;
	}

	/**
	 * Method 'UsuarioPk'
	 * 
	 */
	public UsuarioPk()
	{
	}

	/**
	 * Method 'UsuarioPk'
	 * 
	 * @param idUsuario
	 */
	public UsuarioPk(final int idUsuario)
	{
		this.idUsuario = idUsuario;
	}

	/** 
	 * Sets the value of idUsuarioNull
	 */
	public void setIdUsuarioNull(boolean idUsuarioNull)
	{
		this.idUsuarioNull = idUsuarioNull;
	}

	/** 
	 * Gets the value of idUsuarioNull
	 */
	public boolean isIdUsuarioNull()
	{
		return idUsuarioNull;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof UsuarioPk)) {
			return false;
		}
		
		final UsuarioPk _cast = (UsuarioPk) _other;
		if (idUsuario != _cast.idUsuario) {
			return false;
		}
		
		if (idUsuarioNull != _cast.idUsuarioNull) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + idUsuario;
		_hashCode = 29 * _hashCode + (idUsuarioNull ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "sga.eis.dto.UsuarioPk: " );
		ret.append( "idUsuario=" + idUsuario );
		return ret.toString();
	}

}
