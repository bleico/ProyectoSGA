/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package sga.eis.jdbc;

import sga.eis.dao.*;
import sga.eis.factory.*;
import sga.eis.dto.*;
import sga.eis.exceptions.*;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class UsuarioDaoImpl extends AbstractDAO implements UsuarioDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT id_usuario, id_persona, username, password FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( id_usuario, id_persona, username, password ) VALUES ( ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET id_usuario = ?, id_persona = ?, username = ?, password = ? WHERE id_usuario = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE id_usuario = ?";

	/** 
	 * Index of column id_usuario
	 */
	protected static final int COLUMN_ID_USUARIO = 1;

	/** 
	 * Index of column id_persona
	 */
	protected static final int COLUMN_ID_PERSONA = 2;

	/** 
	 * Index of column username
	 */
	protected static final int COLUMN_USERNAME = 3;

	/** 
	 * Index of column password
	 */
	protected static final int COLUMN_PASSWORD = 4;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 4;

	/** 
	 * Index of primary-key column id_usuario
	 */
	protected static final int PK_COLUMN_ID_USUARIO = 1;

	/** 
	 * Inserts a new row in the usuario table.
	 */
	public UsuarioPk insert(Usuario dto) throws UsuarioDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_INSERT, Statement.RETURN_GENERATED_KEYS );
			int index = 1;
			stmt.setInt( index++, dto.getIdUsuario() );
			if (dto.isIdPersonaNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getIdPersona() );
			}
		
			stmt.setString( index++, dto.getUsername() );
			stmt.setString( index++, dto.getPassword() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setIdUsuario( rs.getInt( 1 ) );
			}
		
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new UsuarioDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the usuario table.
	 */
	public void update(UsuarioPk pk, Usuario dto) throws UsuarioDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + dto );
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index=1;
			stmt.setInt( index++, dto.getIdUsuario() );
			if (dto.isIdPersonaNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getIdPersona() );
			}
		
			stmt.setString( index++, dto.getUsername() );
			stmt.setString( index++, dto.getPassword() );
			stmt.setInt( 5, pk.getIdUsuario() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new UsuarioDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the usuario table.
	 */
	public void delete(UsuarioPk pk) throws UsuarioDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_DELETE + " with PK: " + pk );
			stmt = conn.prepareStatement( SQL_DELETE );
			stmt.setInt( 1, pk.getIdUsuario() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new UsuarioDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the usuario table that matches the specified primary-key value.
	 */
	public Usuario findByPrimaryKey(UsuarioPk pk) throws UsuarioDaoException
	{
		return findByPrimaryKey( pk.getIdUsuario() );
	}

	/** 
	 * Returns all rows from the usuario table that match the criteria 'id_usuario = :idUsuario'.
	 */
	public Usuario findByPrimaryKey(int idUsuario) throws UsuarioDaoException
	{
		Usuario ret[] = findByDynamicSelect( SQL_SELECT + " WHERE id_usuario = ?", new Object[] {  new Integer(idUsuario) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the usuario table that match the criteria ''.
	 */
	public Usuario[] findAll() throws UsuarioDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY id_usuario", null );
	}

	/** 
	 * Returns all rows from the usuario table that match the criteria 'id_persona = :idPersona'.
	 */
	public Usuario[] findByPersona(int idPersona) throws UsuarioDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE id_persona = ?", new Object[] {  new Integer(idPersona) } );
	}

	/** 
	 * Returns all rows from the usuario table that match the criteria 'id_usuario = :idUsuario'.
	 */
	public Usuario[] findWhereIdUsuarioEquals(int idUsuario) throws UsuarioDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE id_usuario = ? ORDER BY id_usuario", new Object[] {  new Integer(idUsuario) } );
	}

	/** 
	 * Returns all rows from the usuario table that match the criteria 'id_persona = :idPersona'.
	 */
	public Usuario[] findWhereIdPersonaEquals(int idPersona) throws UsuarioDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE id_persona = ? ORDER BY id_persona", new Object[] {  new Integer(idPersona) } );
	}

	/** 
	 * Returns all rows from the usuario table that match the criteria 'username = :username'.
	 */
	public Usuario[] findWhereUsernameEquals(String username) throws UsuarioDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE username = ? ORDER BY username", new Object[] { username } );
	}

	/** 
	 * Returns all rows from the usuario table that match the criteria 'password = :password'.
	 */
	public Usuario[] findWherePasswordEquals(String password) throws UsuarioDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE password = ? ORDER BY password", new Object[] { password } );
	}

	/**
	 * Method 'UsuarioDaoImpl'
	 * 
	 */
	public UsuarioDaoImpl()
	{
	}

	/**
	 * Method 'UsuarioDaoImpl'
	 * 
	 * @param userConn
	 */
	public UsuarioDaoImpl(final java.sql.Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "sga.usuario";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Usuario fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Usuario dto = new Usuario();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Usuario[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Usuario dto = new Usuario();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Usuario ret[] = new Usuario[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Usuario dto, ResultSet rs) throws SQLException
	{
		dto.setIdUsuario( rs.getInt( COLUMN_ID_USUARIO ) );
		dto.setIdPersona( rs.getInt( COLUMN_ID_PERSONA ) );
		if (rs.wasNull()) {
			dto.setIdPersonaNull( true );
		}
		
		dto.setUsername( rs.getString( COLUMN_USERNAME ) );
		dto.setPassword( rs.getString( COLUMN_PASSWORD ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Usuario dto)
	{
	}

	/** 
	 * Returns all rows from the usuario table that match the specified arbitrary SQL statement
	 */
	public Usuario[] findByDynamicSelect(String sql, Object[] sqlParams) throws UsuarioDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new UsuarioDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the usuario table that match the specified arbitrary SQL statement
	 */
	public Usuario[] findByDynamicWhere(String sql, Object[] sqlParams) throws UsuarioDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new UsuarioDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

}
