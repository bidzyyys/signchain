package com.bidzyyys.signchain

import tendermint.abci.types.types.ABCIApplicationGrpc;
import tendermint.abci.types.types.{RequestCommit, ResponseCommit}
import tendermint.abci.types.types.{RequestFlush, ResponseFlush}
import tendermint.abci.types.types.{RequestInfo, ResponseInfo}
import tendermint.abci.types.types.{RequestEndBlock, ResponseEndBlock}
import tendermint.abci.types.types.{RequestInitChain, ResponseInitChain}
import tendermint.abci.types.types.{RequestSetOption, ResponseSetOption}
import tendermint.abci.types.types.{RequestCheckTx, ResponseCheckTx}
import tendermint.abci.types.types.{RequestEcho, ResponseEcho}
import tendermint.abci.types.types.{RequestDeliverTx, ResponseDeliverTx}
import tendermint.abci.types.types.{RequestBeginBlock, ResponseBeginBlock}
import tendermint.abci.types.types.{RequestQuery, ResponseQuery}

import scala.concurrent.Future

object ABCI extends ABCIApplicationGrpc.ABCIApplication {

  override def echo(request: RequestEcho): Future[ResponseEcho] = ???

  override def flush(request: RequestFlush): Future[ResponseFlush] = ???

  override def info(request: RequestInfo): Future[ResponseInfo] = ???

  override def setOption(request: RequestSetOption): Future[ResponseSetOption] =
    ???

  override def deliverTx(request: RequestDeliverTx): Future[ResponseDeliverTx] =
    ???

  override def checkTx(request: RequestCheckTx): Future[ResponseCheckTx] = ???

  override def query(request: RequestQuery): Future[ResponseQuery] = ???

  override def commit(request: RequestCommit): Future[ResponseCommit] = ???

  override def initChain(request: RequestInitChain): Future[ResponseInitChain] =
    ???

  override def beginBlock(
      request: RequestBeginBlock
  ): Future[ResponseBeginBlock] = ???

  override def endBlock(request: RequestEndBlock): Future[ResponseEndBlock] =
    ???

  def main(args: Array[String]) = {
    println("Hello, world")
  }
}
