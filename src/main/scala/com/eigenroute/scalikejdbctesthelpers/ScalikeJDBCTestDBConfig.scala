package com.eigenroute.scalikejdbctesthelpers

import com.eigenroute.scalikejdbchelpers.DBConfig
import com.google.inject.Singleton
import com.typesafe.config.ConfigFactory
import scalikejdbc.config.DBs

@Singleton
class ScalikeJDBCTestDBConfig extends DBConfig {

  val conf = ConfigFactory.load

  override val driver = conf.getString("db.test.driver")
  override val url = conf.getString("db.test.url")
  override val dBName = url.substring(url.lastIndexOf("/") + 1)
  override val username = conf.getString("db.test.username")
  override val password = conf.getString("db.test.password")

  val configParams = Map[String, String]()

  override def setUpAllDB(): Unit = setUp("db.test", configParams)

  override def closeAll(): Unit = DBs.closeAll()

}

object ScalikeJDBCTestDBConfig {

  def apply() = new ScalikeJDBCTestDBConfig()

}