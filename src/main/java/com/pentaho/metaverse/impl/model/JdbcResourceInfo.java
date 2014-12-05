/*
 * PENTAHO CORPORATION PROPRIETARY AND CONFIDENTIAL
 *
 * Copyright 2002 - 2014 Pentaho Corporation (Pentaho). All rights reserved.
 *
 * NOTICE: All information including source code contained herein is, and
 * remains the sole property of Pentaho and its licensors. The intellectual
 * and technical concepts contained herein are proprietary and confidential
 * to, and are trade secrets of Pentaho and may be covered by U.S. and foreign
 * patents, or patents in process, and are protected by trade secret and
 * copyright laws. The receipt or possession of this source code and/or related
 * information does not convey or imply any rights to reproduce, disclose or
 * distribute its contents, or to manufacture, use, or sell anything that it
 * may describe, in whole or in part. Any reproduction, modification, distribution,
 * or public display of this information without the express written authorization
 * from Pentaho is strictly prohibited and in violation of applicable laws and
 * international treaties. Access to the source code contained herein is strictly
 * prohibited to anyone except those individuals and entities who have executed
 * confidentiality and non-disclosure agreements or other agreements with Pentaho,
 * explicitly covering such access.
 */

package com.pentaho.metaverse.impl.model;

import com.pentaho.metaverse.api.model.IExternalResourceInfo;
import org.pentaho.di.core.database.DatabaseMeta;

public class JdbcResourceInfo extends BaseDatabaseResourceInfo implements IExternalResourceInfo {

  public static final String JDBC = "JDBC";

  private Integer port;
  private String server;
  private String username;
  private String password;
  private String databaseName;

  @Override
  public String getType() {
    return JDBC;
  }

  public JdbcResourceInfo() {
  }

  public JdbcResourceInfo( DatabaseMeta databaseMeta ) {
    super( databaseMeta );
    if ( "Native".equals( databaseMeta.getAccessTypeDesc() ) ) {
      setServer( databaseMeta.getHostname() );
      String portString = databaseMeta.getDatabasePortNumberString();
      if ( portString != null ) {
        setPort( Integer.valueOf( portString ) );
      }
      setUsername( databaseMeta.getUsername() );
      setPassword( databaseMeta.getPassword() );
      setDatabaseName( databaseMeta.getDatabaseName() );
    } else {
      throw new IllegalArgumentException( "DatabaseMeta is not JDBC, it is " + databaseMeta.getAccessTypeDesc() );
    }
  }

  public JdbcResourceInfo( String server, String databaseName, Integer port, String username, String password ) {
    this.server = server;
    this.databaseName = databaseName;
    this.port = port;
    this.username = username;
    this.password = password;
  }

  public Integer getPort() {
    return port;
  }

  public void setPort( Integer port ) {
    this.port = port;
  }

  public String getServer() {
    return server;
  }

  public void setServer( String server ) {
    this.server = server;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername( String username ) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword( String password ) {
    this.password = password;
  }

  public String getDatabaseName() {
    return databaseName;
  }

  public void setDatabaseName( String databaseName ) {
    this.databaseName = databaseName;
  }

}
