package com.bidzyyys.signchain

import scala.concurrent.Future
import tendermint.abci.types.{
  ABCIApplicationGrpc,
  RequestApplySnapshotChunk,
  RequestBeginBlock,
  RequestCheckTx,
  RequestCommit,
  RequestDeliverTx,
  RequestEcho,
  RequestEndBlock,
  RequestFlush,
  RequestInfo,
  RequestInitChain,
  RequestListSnapshots,
  RequestLoadSnapshotChunk,
  RequestOfferSnapshot,
  RequestQuery,
  RequestSetOption,
  ResponseApplySnapshotChunk,
  ResponseBeginBlock,
  ResponseCheckTx,
  ResponseCommit,
  ResponseDeliverTx,
  ResponseEcho,
  ResponseEndBlock,
  ResponseFlush,
  ResponseInfo,
  ResponseInitChain,
  ResponseListSnapshots,
  ResponseLoadSnapshotChunk,
  ResponseOfferSnapshot,
  ResponseQuery,
  ResponseSetOption
}

class ABCIServerImpl extends ABCIApplicationGrpc.ABCIApplication {

  override def echo(request: RequestEcho): Future[ResponseEcho] = {
    Future.successful(new ResponseEcho(request.message))
  }

  override def flush(request: RequestFlush): Future[ResponseFlush] = ???

  override def info(request: RequestInfo): Future[ResponseInfo] = {
    Future.successful(new ResponseInfo())
  }

  override def setOption(
      request: RequestSetOption
  ): Future[ResponseSetOption] =
    ???

  override def deliverTx(
      request: RequestDeliverTx
  ): Future[ResponseDeliverTx] =
    ???

  override def checkTx(request: RequestCheckTx): Future[ResponseCheckTx] = ???

  override def query(request: RequestQuery): Future[ResponseQuery] = ???

  override def commit(request: RequestCommit): Future[ResponseCommit] = {
    Future.successful(new ResponseCommit())
  }

  override def initChain(
      request: RequestInitChain
  ): Future[ResponseInitChain] = {
    Future.successful(new ResponseInitChain())
  }

  override def beginBlock(
      request: RequestBeginBlock
  ): Future[ResponseBeginBlock] = {
    Future.successful(new ResponseBeginBlock())
  }

  override def endBlock(
      request: RequestEndBlock
  ): Future[ResponseEndBlock] = {
    Future.successful(new ResponseEndBlock())
  }

  override def listSnapshots(
      request: RequestListSnapshots
  ): Future[ResponseListSnapshots] = ???

  override def offerSnapshot(
      request: RequestOfferSnapshot
  ): Future[ResponseOfferSnapshot] = ???

  override def loadSnapshotChunk(
      request: RequestLoadSnapshotChunk
  ): Future[ResponseLoadSnapshotChunk] = ???

  override def applySnapshotChunk(
      request: RequestApplySnapshotChunk
  ): Future[ResponseApplySnapshotChunk] = ???
}
